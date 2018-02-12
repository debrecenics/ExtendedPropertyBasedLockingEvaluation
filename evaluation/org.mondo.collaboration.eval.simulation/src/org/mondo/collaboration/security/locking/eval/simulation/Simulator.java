package org.mondo.collaboration.security.locking.eval.simulation;

import static org.mondo.collaboration.security.locking.eval.simulation.Setup.DEEP;
import static org.mondo.collaboration.security.locking.eval.simulation.Setup.FRAGMENT;
import static org.mondo.collaboration.security.locking.eval.simulation.Setup.LOG_FILE;
import static org.mondo.collaboration.security.locking.eval.simulation.Setup.MAX_USERS;
import static org.mondo.collaboration.security.locking.eval.simulation.Setup.MODEL_PATH;
import static org.mondo.collaboration.security.locking.eval.simulation.Setup.USERS;
import static org.mondo.collaboration.security.locking.eval.simulation.Setup.USER_SIZE;
import static org.mondo.collaboration.security.locking.eval.simulation.Setup.initLoggers;
import static org.mondo.collaboration.security.locking.eval.simulation.Setup.parseArgs;
import static org.mondo.collaboration.security.locking.eval.simulation.Setup.save;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.viatra.dse.merge.model.ModelFactory;
import org.eclipse.viatra.dse.merge.model.ModelPackage;
import org.eclipse.viatra.dse.merge.scope.ScopeFactory;
import org.eclipse.viatra.dse.merge.scope.ScopePackage;
import org.mondo.collaboration.eval.behaviors.LockingClientBehavior;
import org.mondo.collaboration.eval.behaviors.MergingClientBehavior;
import org.mondo.collaboration.eval.behaviors.ServerBehavior;
import org.mondo.collaboration.eval.behaviors.users.BaseUser;
import org.mondo.collaboration.eval.behaviors.users.BaseUser.UserType;
import org.mondo.collaboration.eval.behaviors.users.UserMaintenance;
import org.mondo.collaboration.eval.behaviors.users.UserReplacement;
import org.mondo.collaboration.eval.behaviors.users.UserTesting;
import org.mondo.collaboration.security.locking.eval.simulation.Configuration.TimeType;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import wt.WtFactory;
import wt.WtPackage;

public class Simulator {

	private static enum Behavior {
		Locker, Merger
	}
	
	List<Event> queue = Lists.newArrayList();
	public static final Map<UserType,Behavior> behaviors = ImmutableMap.<UserType,Behavior>builder()
			.put(UserType.M, Behavior.Merger)
			.put(UserType.R, Behavior.Merger)
			.put(UserType.T, Behavior.Locker)
			.build();
	
	ServerBehavior server;
	
	public static final Logger LOGGER = Logger.getLogger(Simulator.class);
	public static final List<MergingClientBehavior> mergingUsers = Lists.newArrayList();
	public static final List<LockingClientBehavior> lockingUsers = Lists.newArrayList();
	
	public static void main(String[] args) {
		parseArgs(args);
		initLoggers();
		
		ScopeFactory.eINSTANCE.eClass();
		ScopePackage.eINSTANCE.eClass();
		ModelFactory.eINSTANCE.eClass();
		ModelPackage.eINSTANCE.eClass();
		WtFactory.eINSTANCE.eClass();
		WtPackage.eINSTANCE.eClass();
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		
		Simulator simulation = new Simulator();
		simulation.setup();		
		simulation.simulate();
		
		prettyPrintResults();
	}

	public static void prettyPrintResults() {
		String mergeTime = aggregateMergeTime();
		String retryTime = aggregateRetryTime();
		String waitTime = aggregateWaitTime();
		
		String result = String.format("%s;\t%s;\t%s;\t%s;\t%s;\t%s;\t%s;\t%s;\t%s;\t%s;", 
				waitTime, mergeTime, retryTime,
				behaviors.get(UserType.M), 
				behaviors.get(UserType.R),
				behaviors.get(UserType.T),
				FRAGMENT(), DEEP(), MAX_USERS(), USERS());
		save(LOG_FILE(), result);
	}

	private static String aggregateMergeTime() {
		return mergingUsers.stream().map(x -> x.getMergeTime()).reduce(0l, Long::sum).toString();
	}

	private static String aggregateRetryTime() {
		return mergingUsers.stream().map(x -> x.getRetryTime()).reduce(0d, Double::sum).toString();
	}
	
	private static String aggregateWaitTime() {
		return lockingUsers.stream().map(x -> x.getWaitTime()).reduce(0d, Double::sum).toString();
	}
	
	private void setup() {
		ResourceSet rset = new ResourceSetImpl();
		Resource resource = rset.getResource(URI.createFileURI(String.format(MODEL_PATH, FRAGMENT(),DEEP(),MAX_USERS())),true);
		
		server = new ServerBehavior(resource.getContents().get(0));
		server.init();
		server.enter();
		for (int i = 0; i < USER_SIZE(); i++) {
			createUser(i, UserType.M);
			createUser(i, UserType.R);
			createUser(i, UserType.T);
		}
	}

	private void createUser(int i, UserType type) {
		BaseUser user = null;
		if(type == UserType.M) user = new UserMaintenance(String.valueOf(i));
		if(type == UserType.R) user = new UserReplacement(String.valueOf(i));
		if(type == UserType.T) user = new UserTesting(String.valueOf(i));
		if(behaviors.get(type) == Behavior.Merger) {			
			MergingClientBehavior behavior = new MergingClientBehavior(user, server);
			behavior.init();			
			behavior.enter();
			addEvent(new Event.UploadEvent(Configuration.nextTime(type, TimeType.WAIT) + 
			          					   Configuration.nextTime(type, TimeType.EXEC), behavior));
			mergingUsers.add(behavior);
		}
		if(behaviors.get(type) == Behavior.Locker) {			
			LockingClientBehavior behavior = new LockingClientBehavior(user, server);
			behavior.init();			
			behavior.enter();
			addEvent(new Event.RequestEvent(Configuration.nextTime(type, TimeType.WAIT), behavior));
			lockingUsers.add(behavior);
		}
	}

	public void addEvent(Event event) {
		if(checkTimeLimit(event)) return;			

		LOGGER.info(server.getCurrentTime() + ": Adding new event: " +event.toString());
		queue.add(event);
	}

	private boolean checkTimeLimit(Event event) {
		if(event.getTime() > Configuration.TimeLimit) {
			if(event.getClient().isActive())
				event.getClient().exit();
			return true;
		}
		return false;
	}
	
	public void addEvents(Collection<Event> events) {
		for (Event event : events) {
			addEvent(event);
		}
		sortQueue();
	}

	public void clear() {
		queue.clear();
	}

	public void simulate() {
		LOGGER.info(server.getCurrentTime() + ": Simulation Started");		
		sortQueue();
		LOGGER.info(server.getCurrentTime() + ": Events Ordered");		
		while (!queue.isEmpty()) {
			Event event = queue.get(0);
			server.setCurrentTime(event.getTime());
			LOGGER.info(server.getCurrentTime() + ": Executing " + event.toString());
			event.execute();
			LOGGER.info(server.getCurrentTime() + ": Executed " + event.toString());
			queue.remove(event);
			addEvents(event.nextEvents());
		}
	}

	private void sortQueue() {
		queue.sort(new Comparator<Event>() {

			@Override
			public int compare(Event o1, Event o2) {
				if (o1.getTime() < o2.getTime())
					return -1;
				if (o1.getTime() > o2.getTime())
					return 1;
				return 0;

			}
		});
	}
}
