package org.mondo.collaboration.security.locking.eval.simulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.viatra.dse.merge.DSEMergeStrategy;
import org.eclipse.viatra.dse.monitor.PerformanceMonitorManager;
import org.mondo.collaboration.eval.behaviors.LockingClientBehavior;
import org.mondo.collaboration.eval.behaviors.MergingClientBehavior;
import org.mondo.collaboration.eval.behaviors.ServerBehavior;

import com.google.common.collect.Maps;

public class Setup {

	public static final String MODEL_PATH = System.getProperty("user.dir") + "/../instances/model-%04d-%04d-%04d.xmi".replace('/', File.separatorChar);
	
	private static final String USER_OPTION = "-U";
	private static final String MAX_USER_OPTION = "-MU";
	private static final String DEEP_OPTION = "-D";
	private static final String FRAGMENT_OPTION = "-F";
	private static final String LOG_OPTION = "-L";
	public static final Map<String, String> args = Maps.newHashMap();
	
	public static void parseArgs(String[] args) {
		for (int i = 0; i < args.length; i++) {
			if (args[i].trim().startsWith(FRAGMENT_OPTION))
				Setup.args.put(FRAGMENT_OPTION, args[i + 1]);
			if (args[i].trim().startsWith(DEEP_OPTION))
				Setup.args.put(DEEP_OPTION, args[i + 1]);
			if (args[i].trim().startsWith(MAX_USER_OPTION))
				Setup.args.put(MAX_USER_OPTION, args[i + 1]);
			if (args[i].trim().startsWith(USER_OPTION))
				Setup.args.put(USER_OPTION, args[i + 1]);
			if (args[i].trim().startsWith(LOG_OPTION))
				Setup.args.put(LOG_OPTION, args[i + 1]);
		}
	}
	
	public static String LOG_FILE() {
		return args.get(LOG_OPTION); 
	}
	
	public static String USERS() {
		return args.get(USER_OPTION); 
	}
	
	public static int USER_SIZE() {
		return Integer.valueOf(args.get(USER_OPTION)); 
	}
	
	public static String MAX_USERS() {
		return args.get(MAX_USER_OPTION); 
	}
	
	public static String DEEP() {
		return args.get(DEEP_OPTION); 
	}
	
	public static String FRAGMENT() {
		return args.get(FRAGMENT_OPTION); 
	}
	
	public static void initLoggers() {
		Logger.getLogger(EMFCompare.class).setLevel(Level.ERROR);
		Logger.getLogger(Simulator.class).setLevel(Level.ERROR);
		Logger.getLogger(DSEMergeStrategy.class).setLevel(Level.ERROR);
		Logger.getLogger(ServerBehavior.class).setLevel(Level.ERROR);
		Logger.getLogger(LockingClientBehavior.class).setLevel(Level.ERROR);
		Logger.getLogger(MergingClientBehavior.class).setLevel(Level.ERROR);
		Logger.getLogger(PerformanceMonitorManager.class).setLevel(Level.ERROR);
	}
	
	public static void save(String path, String content) {
		try(  PrintWriter out = new PrintWriter( new FileOutputStream(new File(path), true) )  ){
		    out.println( content );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
