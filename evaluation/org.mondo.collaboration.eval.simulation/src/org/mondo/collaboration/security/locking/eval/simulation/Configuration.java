package org.mondo.collaboration.security.locking.eval.simulation;

import org.mondo.collaboration.eval.behaviors.users.BaseUser.UserType;
import org.mondo.collaboration.security.locking.eval.simulation.Distribution.Exponential;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Configuration {

	enum TimeType {
		WAIT, EXEC, RETRY
	}

	public static final String EXEC = "exec";
	public static final String WAIT = "wait";

	public static int Days = 7;

	public static int WaitMeanR = 24; // h
	public static int WaitMeanT = 12; // h
	public static int WaitMeanM = 4; // h

	public static int ExecMeanR = 3; // h
	public static int ExecMeanT = 2; // h
	public static int ExecMeanM = 1; // h

	public static int RetryMeanR = 3; // h
	public static int RetryMeanT = 2; // h
	public static int RetryMeanM = 1; // h

	public static Table<UserType, TimeType, Distribution> distributionTable = HashBasedTable.create();

	static {
		distributionTable.put(UserType.T, TimeType.EXEC, new Exponential(ExecMeanT));
		distributionTable.put(UserType.M, TimeType.EXEC, new Exponential(ExecMeanM));
		distributionTable.put(UserType.R, TimeType.EXEC, new Exponential(ExecMeanR));
		distributionTable.put(UserType.T, TimeType.RETRY, new Exponential(RetryMeanT));
		distributionTable.put(UserType.M, TimeType.RETRY, new Exponential(RetryMeanM));
		distributionTable.put(UserType.R, TimeType.RETRY, new Exponential(RetryMeanR));
		distributionTable.put(UserType.T, TimeType.WAIT, new Exponential(WaitMeanT));
		distributionTable.put(UserType.M, TimeType.WAIT, new Exponential(WaitMeanM));
		distributionTable.put(UserType.R, TimeType.WAIT, new Exponential(WaitMeanR));
	}

	public static double nextTime(UserType user, TimeType time) {
		return distributionTable.get(user, time).getNext();
	}

}
