package org.mondo.collaboration.eval.generator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.common.collect.Lists;

import wt.Composite;
import wt.Control;
import wt.Module;
import wt.Signal;
import wt.WtFactory;

public class ModelGenerator {

	public static void main(String[] args) throws Exception {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		generateModels();
	}

	public static void generateModels() throws Exception {
		int[] users = { 3, 9, 15 };
		int[] fragments = { 3, 9, 15 };
		int[] depths = { 3, 9, 15 };

		for (int f = 0; f < fragments.length; f++)
			for (int d = 0; d < depths.length; d++) {
				ModelGenerator.preGenerateAttributes(depths[d], fragments[f], users[users.length-1]);
				for (int u = 0; u < users.length; u++)
					generateModel(fragments[f], depths[d], users[u]);
			}
	}
	
	private static void generateModel(int f, int d, int u) throws Exception {
		Composite model = ModelGenerator.generate(f,u,d);
		save(	String.format(System.getProperty("user.dir") + "/instances/model-%04d-%04d-%04d.xmi".replace('/', File.separatorChar), f,d,u), 
				model);
		
		CharSequence yed = calculateYed(model);
		save(	String.format(System.getProperty("user.dir") + "/instances/model-%04d-%04d-%04d.gml".replace('/', File.separatorChar), f,d,u), 
				yed);
	}
	
	private static CharSequence calculateYed(Composite model) {
		Model2Yed yed = new Model2Yed();
		List<EObject> objects = Lists.newArrayList(model.eAllContents());
		objects.add(model);
		CharSequence sequence = yed.transform(objects);
		return sequence;
	}
	
	private static void save(String path, Composite model) throws IOException {
		ResourceSet rset = new ResourceSetImpl();
		Resource resource = rset.createResource(URI.createFileURI(path));
		resource.getContents().add(model);
		TreeIterator<EObject> iterator = resource.getAllContents();
		int i = 0;
		while (iterator.hasNext()) {
			EObject eObject = (EObject) iterator.next();
			if(eObject instanceof Module) {
				Module module = (Module) eObject;
				if(module instanceof Control)
					module.setId("control"+String.valueOf(i++));
				else
					module.setId("composite"+String.valueOf(i++));
				
			} else if (eObject instanceof Signal) {
				Signal signal = (Signal) eObject;
				signal.setId("signal"+String.valueOf(i++));
			} else {
				throw new IllegalArgumentException();
			}
		}
		resource.save(null);
	}
	
	public static void save(String path, CharSequence sequence) throws Exception {
		try(  PrintWriter out = new PrintWriter( path )  ){
		    out.println( sequence.toString() );
		}
	}
	
	public static final String DUMMY = "Dummy";
	
	static Iterator<String> vendorIterator;// = vendorMap.iterator();
	static Iterator<String> cycleIterator;// = cycleMap.iterator();
	static Iterator<String> typeIterator;// = typeMap.iterator();
	
	public static Composite generate(int fragmentSize, int userSize, int deepSize) {
		Composite root = WtFactory.eINSTANCE.createComposite();
		root.setVendor("vendor.root");
		
		vendorIterator = vendorMap.iterator();
		cycleIterator = cycleMap.iterator();
		typeIterator = typeMap.iterator();
		
		
		for (int currentFragment = 0; currentFragment < fragmentSize; currentFragment++) {
			createfragment(root, currentFragment, userSize, deepSize, 0);
		}
		return root;
	}

	private static void createfragment(Composite root, int currentFragment, int userSize, int deepSize, int currentDeep) {
		
		Composite composite = WtFactory.eINSTANCE.createComposite();
		composite.setVendor(String.format("%s", vendorIterator.next()));

		createContainer(currentFragment, userSize, composite, 1, vendorIterator, cycleIterator, typeIterator);
		createContainer(currentFragment, userSize, composite, 2, vendorIterator, cycleIterator, typeIterator);
		createContainer(currentFragment, userSize, composite, 1, vendorIterator, cycleIterator, typeIterator);
		
		root.getSubmodules().add(composite);
		
		if(deepSize > currentDeep+1)
			createfragment(composite, currentFragment, userSize, deepSize, currentDeep+1);
	}

	private static void createContainer(int currentFragment, int userSize, Composite composite, int noControls, Iterator<String> vendorIterator, Iterator<String> cycleIterator, Iterator<String> typeIterator ) {
		Composite container = WtFactory.eINSTANCE.createComposite();
		container.setVendor(String.format("%s", vendorIterator.next()));
		for(int i = 0; i < noControls; i++)	createControlUnits(container, cycleIterator, typeIterator);
		composite.getSubmodules().add(container);
	}

	private static void createControlUnits(Composite container, Iterator<String> cycleIterator, Iterator<String> typeIterator) {
		Control control = WtFactory.eINSTANCE.createControl();
		control.setCycle(String.format("%s", cycleIterator.next()));
		control.setType(String.format("%s", typeIterator.next()));
		createSignals(container, control);
		container.getSubmodules().add(control);			
	}

	private static void createSignals(Composite container, Control control) {
		Signal signal = WtFactory.eINSTANCE.createSignal();
		signal.setFrequency(ThreadLocalRandom.current().nextInt(1, 11));
		
		control.getProvides().add(signal);
		container.getConsumes().add(signal);		
	}
    //	   Fragment  Deep  Structure
	static List<String> cycleMap = Lists.newArrayList();
	static List<String> typeMap = Lists.newArrayList();
	static List<String> vendorMap = Lists.newArrayList();
	
	public static void preGenerateAttributes(int maxD, int maxF, int maxU) {
		cycleMap.clear(); typeMap.clear();
		cycleMap = raffleValues(maxD, maxF, maxU,4);
		typeMap = raffleValues(maxD, maxF, maxU,4);
		vendorMap = raffleValues(maxD, maxF, maxU,4);
	}


	private static List<String> raffleValues(int maxD, int maxF, int maxU, int multiplier) {
		List<String> list = Lists.newArrayList();
		for(int u = 0; u < maxU; list.add(String.valueOf(u)), u++);
		for(int u = 0; u < maxU; list.add(String.valueOf(u)), u++);
		for(int u = 0; u < maxU; list.add(String.valueOf(u)), u++);
		for(int u = 0; u < maxU; list.add(String.valueOf(u)), u++);
		
		while(list.size() < maxD * maxF * multiplier) {
			list.add(DUMMY);
		}
		
		Collections.shuffle(list);
		return list;
	}
}
