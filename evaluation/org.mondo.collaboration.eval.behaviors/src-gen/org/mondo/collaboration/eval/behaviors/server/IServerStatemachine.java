package org.mondo.collaboration.eval.behaviors.server;

import org.mondo.collaboration.eval.behaviors.IStatemachine;

public interface IServerStatemachine extends IStatemachine {

	public interface SCInterface {
	
		public void raiseCommit();
		
		public void raiseMergeSuccess();
		
		public void raiseMergeFailure();
		
		public void raiseLockSuccess();
		
		public void raiseLockFailure();
		
		public void setSCInterfaceOperationCallback(SCInterfaceOperationCallback operationCallback);
	
	}
	
	public interface SCInterfaceOperationCallback {
	
		public void conflict();
		
		public void violation();
		
		public void accepted();
		
		public void checkLockAndConflict();
		
	}
	
	public SCInterface getSCInterface();
	
}
