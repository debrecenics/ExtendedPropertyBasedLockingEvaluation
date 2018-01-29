package org.mondo.collaboration.eval.behaviors.server;

import org.mondo.collaboration.eval.behaviors.IStatemachine;

public interface IServerStatemachine extends IStatemachine {

	public interface SCInterface {
	
		public void raiseCommit();
		
		public void raiseSuccess();
		
		public void raiseLockFailure();
		
		public void raiseMergeFailure();
		
		public void raiseRequest();
		
		public void raiseRelease();
		
		public void setSCInterfaceOperationCallback(SCInterfaceOperationCallback operationCallback);
	
	}
	
	public interface SCInterfaceOperationCallback {
	
		public void lockRelease();
		
		public void lockRequest();
		
		public void conflict();
		
		public void violation();
		
		public void accepted();
		
		public void checkCommit();
		
	}
	
	public SCInterface getSCInterface();
	
}
