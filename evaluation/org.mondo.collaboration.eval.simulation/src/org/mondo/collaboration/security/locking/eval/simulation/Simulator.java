package org.mondo.collaboration.security.locking.eval.simulation;

import java.io.File;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.EMFCompare;
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
import org.mondo.collaboration.eval.behaviors.users.BaseUser.UserType;
import org.mondo.collaboration.security.lens.emf.ModelFactInputKey;
import org.mondo.collaboration.security.locking.eval.simulation.Configuration.TimeType;
import org.mondo.collaboration.eval.behaviors.users.UserMaintenance;
import org.mondo.collaboration.eval.behaviors.users.UserReplacement;
import org.mondo.collaboration.eval.behaviors.users.UserTesting;

import com.google.common.collect.Lists;

import wt.WtFactory;
import wt.WtPackage;

public class Simulator {

	List<Event> queue = Lists.newArrayList();
	public static final int USER_SIZE = 9;
	public static final String MODEL_PATH = System.getProperty("user.dir") + "/../org.mondo.collaboration.eval.generator/instances/model-%04d-%04d-%04d.xmi".replace('/', File.separatorChar);

	ServerBehavior server;
	
	public static final Logger LOGGER = Logger.getLogger(Simulator.class);
	
	public static void main(String[] args) {
		
		Logger.getLogger(EMFCompare.class).setLevel(Level.ERROR);
		Logger.getLogger(Simulator.class).setLevel(Level.ERROR);
		Logger.getLogger(ServerBehavior.class).setLevel(Level.INFO);
		
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
	}

	private void setup() {
		ResourceSet rset = new ResourceSetImpl();
		Resource resource = rset.getResource(URI.createFileURI(String.format(MODEL_PATH, 3,3,3)),true);
		
		server = new ServerBehavior(resource.getContents().get(0));
		server.init();
		server.enter();
		for (int i = 0; i < USER_SIZE; i++) {
			MergingClientBehavior userM = new MergingClientBehavior(new UserMaintenance(String.valueOf(i)), server);
			
			userM.init();			
			userM.enter();
			
			addEvent(new Event.UploadEvent(Configuration.nextTime(UserType.M, TimeType.WAIT) + 
                      					   Configuration.nextTime(UserType.M, TimeType.EXEC), userM));
		}
	}

	public void addEvent(Event event) {
		queue.add(event);
		LOGGER.info(server.getCurrentTime() + ": Adding new event: " +event.toString());
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
