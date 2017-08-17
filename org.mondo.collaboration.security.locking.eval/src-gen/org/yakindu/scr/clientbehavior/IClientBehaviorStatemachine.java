package org.yakindu.scr.clientbehavior;

import org.yakindu.scr.IStatemachine;

public interface IClientBehaviorStatemachine extends IStatemachine {

	public interface SCInterface {
	
		public void raiseRequestLock();
		
		public void raiseModify();
		
		public void raiseRejected();
		
		public void raiseUnlockedConflict();
		
		public void raiseUnlockedSuccess();
		
		public void raiseUnlockedFailure();
		
		public void raiseResolved();
		
		public void raiseFinishedUnlocked();
		
		public void raiseFinishedConflict();
		
		public void raiseFinishedSuccess();
		
		public void raiseLocked();
		
		public void setSCInterfaceOperationCallback(SCInterfaceOperationCallback operationCallback);
	
	}
	
	public interface SCInterfaceOperationCallback {
	
		public void update();
		
		public void success();
		
		public void failure();
		
		public void conflict();
		
		public void lock();
		
		public void unlock();
		
		public void resolve();
		
		public void executeModification();
		
	}
	
	public SCInterface getSCInterface();
	
}
