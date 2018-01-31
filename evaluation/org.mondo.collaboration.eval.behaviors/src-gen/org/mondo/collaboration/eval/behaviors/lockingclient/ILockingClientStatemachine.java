package org.mondo.collaboration.eval.behaviors.lockingclient;

import org.mondo.collaboration.eval.behaviors.IStatemachine;

public interface ILockingClientStatemachine extends IStatemachine {

	public interface SCInterface {
	
		public void raiseRequest();
		
		public void raiseSuccess();
		
		public void raiseFailure();
		
		public void raiseFinish();
		
		public void setSCInterfaceOperationCallback(SCInterfaceOperationCallback operationCallback);
	
	}
	
	public interface SCInterfaceOperationCallback {
	
		public void lock();
		
		public void execute();
		
		public void release();
		
		public void commit();
		
		public void store();
		
		public void violationStart();
		
		public void violationEnd();
		
	}
	
	public SCInterface getSCInterface();
	
}
