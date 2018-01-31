package org.mondo.collaboration.security.locking.eval.simulation;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.mondo.collaboration.eval.behaviors.LockingClientBehavior;
import org.mondo.collaboration.eval.behaviors.ServerBehavior;
import org.mondo.collaboration.eval.behaviors.users.BaseUser.UserType;
import org.mondo.collaboration.security.locking.eval.simulation.Configuration.TimeType;
import org.mondo.collaboration.eval.behaviors.users.UserMaintenance;
import org.mondo.collaboration.eval.behaviors.users.UserReplacement;
import org.mondo.collaboration.eval.behaviors.users.UserTesting;

import com.google.common.collect.Lists;

import wt.WtFactory;
import wt.WtPackage;

public class Simulator {

	List<Event> queue = Lists.newArrayList();
	public static final int USER_SIZE = 3;
	public static final String MODEL_PATH = "todo";

	ServerBehavior server;
	
	public static void main(String[] args) {
		
		WtFactory.eINSTANCE.eClass();
		WtPackage.eINSTANCE.eClass();
		
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		ResourceSet rset = new ResourceSetImpl();
		Resource resource = rset.getResource(URI.createFileURI(MODEL_PATH),true);
		
		Simulator simulation = new Simulator();
		simulation.setup(resource);		
		simulation.simulate();
	}

	private void setup(Resource resource) {
		server = new ServerBehavior(resource.getContents().get(0));
		for (int i = 0; i < USER_SIZE; i++) {
			LockingClientBehavior userM = new LockingClientBehavior(new UserMaintenance(String.valueOf(i)), server);
			LockingClientBehavior userT = new LockingClientBehavior(new UserTesting(String.valueOf(i)), server);
			LockingClientBehavior userR = new LockingClientBehavior(new UserReplacement(String.valueOf(i)), server);
			
			userM.init();
			userT.init();
			userR.init();
			
			addEvent(new Event.RequestEvent(Configuration.nextTime(UserType.M, TimeType.WAIT), userM));
			addEvent(new Event.RequestEvent(Configuration.nextTime(UserType.T, TimeType.WAIT), userT));
			addEvent(new Event.RequestEvent(Configuration.nextTime(UserType.R, TimeType.WAIT), userR));
		}
	}

	public void addEvent(Event event) {
		queue.add(event);
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
		sortQueue();
		while (!queue.isEmpty()) {
			Event event = queue.get(0);
			server.setCurrentTime(event.getTime());
			event.execute();
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
