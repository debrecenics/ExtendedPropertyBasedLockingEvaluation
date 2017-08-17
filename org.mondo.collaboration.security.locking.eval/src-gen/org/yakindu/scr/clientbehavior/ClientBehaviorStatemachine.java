package org.yakindu.scr.clientbehavior;

public class ClientBehaviorStatemachine implements IClientBehaviorStatemachine {

	protected class SCInterfaceImpl implements SCInterface {
	
		private SCInterfaceOperationCallback operationCallback;
		
		public void setSCInterfaceOperationCallback(
				SCInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean requestLock;
		
		public void raiseRequestLock() {
			requestLock = true;
		}
		
		private boolean modify;
		
		public void raiseModify() {
			modify = true;
		}
		
		private boolean rejected;
		
		public void raiseRejected() {
			rejected = true;
		}
		
		private boolean unlockedConflict;
		
		public void raiseUnlockedConflict() {
			unlockedConflict = true;
		}
		
		private boolean unlockedSuccess;
		
		public void raiseUnlockedSuccess() {
			unlockedSuccess = true;
		}
		
		private boolean unlockedFailure;
		
		public void raiseUnlockedFailure() {
			unlockedFailure = true;
		}
		
		private boolean resolved;
		
		public void raiseResolved() {
			resolved = true;
		}
		
		private boolean finishedUnlocked;
		
		public void raiseFinishedUnlocked() {
			finishedUnlocked = true;
		}
		
		private boolean finishedConflict;
		
		public void raiseFinishedConflict() {
			finishedConflict = true;
		}
		
		private boolean finishedSuccess;
		
		public void raiseFinishedSuccess() {
			finishedSuccess = true;
		}
		
		private boolean locked;
		
		public void raiseLocked() {
			locked = true;
		}
		
		protected void clearEvents() {
			requestLock = false;
			modify = false;
			rejected = false;
			unlockedConflict = false;
			unlockedSuccess = false;
			unlockedFailure = false;
			resolved = false;
			finishedUnlocked = false;
			finishedConflict = false;
			finishedSuccess = false;
			locked = false;
		}
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_Idle,
		main_region_Locking,
		main_region_ModifyingWithLock,
		main_region_Unlocking,
		main_region_ConflictResolution,
		main_region_ModifyingWithoutLock,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	
	
	public ClientBehaviorStatemachine() {
		sCInterface = new SCInterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		}
		enterSequence_main_region_default();
	}
	
	public void exit() {
		exitSequence_main_region();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
	}
	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
		sCInterface.clearEvents();
	}
	
	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
	}
	
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case main_region_Idle:
			return stateVector[0] == State.main_region_Idle;
		case main_region_Locking:
			return stateVector[0] == State.main_region_Locking;
		case main_region_ModifyingWithLock:
			return stateVector[0] == State.main_region_ModifyingWithLock;
		case main_region_Unlocking:
			return stateVector[0] == State.main_region_Unlocking;
		case main_region_ConflictResolution:
			return stateVector[0] == State.main_region_ConflictResolution;
		case main_region_ModifyingWithoutLock:
			return stateVector[0] == State.main_region_ModifyingWithoutLock;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public void raiseRequestLock() {
		sCInterface.raiseRequestLock();
	}
	
	public void raiseModify() {
		sCInterface.raiseModify();
	}
	
	public void raiseRejected() {
		sCInterface.raiseRejected();
	}
	
	public void raiseUnlockedConflict() {
		sCInterface.raiseUnlockedConflict();
	}
	
	public void raiseUnlockedSuccess() {
		sCInterface.raiseUnlockedSuccess();
	}
	
	public void raiseUnlockedFailure() {
		sCInterface.raiseUnlockedFailure();
	}
	
	public void raiseResolved() {
		sCInterface.raiseResolved();
	}
	
	public void raiseFinishedUnlocked() {
		sCInterface.raiseFinishedUnlocked();
	}
	
	public void raiseFinishedConflict() {
		sCInterface.raiseFinishedConflict();
	}
	
	public void raiseFinishedSuccess() {
		sCInterface.raiseFinishedSuccess();
	}
	
	public void raiseLocked() {
		sCInterface.raiseLocked();
	}
	
	private boolean check_main_region_Idle_tr0_tr0() {
		return sCInterface.requestLock;
	}
	
	private boolean check_main_region_Idle_tr1_tr1() {
		return sCInterface.modify;
	}
	
	private boolean check_main_region_Locking_tr0_tr0() {
		return sCInterface.locked;
	}
	
	private boolean check_main_region_Locking_tr1_tr1() {
		return sCInterface.rejected;
	}
	
	private boolean check_main_region_ModifyingWithLock_tr0_tr0() {
		return sCInterface.finishedUnlocked;
	}
	
	private boolean check_main_region_Unlocking_tr0_tr0() {
		return sCInterface.unlockedSuccess;
	}
	
	private boolean check_main_region_Unlocking_tr1_tr1() {
		return sCInterface.unlockedFailure;
	}
	
	private boolean check_main_region_Unlocking_tr2_tr2() {
		return sCInterface.unlockedConflict;
	}
	
	private boolean check_main_region_ConflictResolution_tr0_tr0() {
		return sCInterface.resolved;
	}
	
	private boolean check_main_region_ModifyingWithoutLock_tr0_tr0() {
		return sCInterface.finishedConflict;
	}
	
	private boolean check_main_region_ModifyingWithoutLock_tr1_tr1() {
		return sCInterface.finishedSuccess;
	}
	
	private void effect_main_region_Idle_tr0() {
		exitSequence_main_region_Idle();
		enterSequence_main_region_Locking_default();
	}
	
	private void effect_main_region_Idle_tr1() {
		exitSequence_main_region_Idle();
		enterSequence_main_region_ModifyingWithoutLock_default();
	}
	
	private void effect_main_region_Locking_tr0() {
		exitSequence_main_region_Locking();
		enterSequence_main_region_ModifyingWithLock_default();
	}
	
	private void effect_main_region_Locking_tr1() {
		exitSequence_main_region_Locking();
		sCInterface.operationCallback.failure();
		
		enterSequence_main_region_Idle_default();
	}
	
	private void effect_main_region_ModifyingWithLock_tr0() {
		exitSequence_main_region_ModifyingWithLock();
		enterSequence_main_region_Unlocking_default();
	}
	
	private void effect_main_region_Unlocking_tr0() {
		exitSequence_main_region_Unlocking();
		sCInterface.operationCallback.success();
		
		enterSequence_main_region_Idle_default();
	}
	
	private void effect_main_region_Unlocking_tr1() {
		exitSequence_main_region_Unlocking();
		sCInterface.operationCallback.failure();
		
		enterSequence_main_region_Idle_default();
	}
	
	private void effect_main_region_Unlocking_tr2() {
		exitSequence_main_region_Unlocking();
		sCInterface.operationCallback.conflict();
		
		enterSequence_main_region_ConflictResolution_default();
	}
	
	private void effect_main_region_ConflictResolution_tr0() {
		exitSequence_main_region_ConflictResolution();
		sCInterface.operationCallback.success();
		
		enterSequence_main_region_Idle_default();
	}
	
	private void effect_main_region_ModifyingWithoutLock_tr0() {
		exitSequence_main_region_ModifyingWithoutLock();
		sCInterface.operationCallback.conflict();
		
		enterSequence_main_region_ConflictResolution_default();
	}
	
	private void effect_main_region_ModifyingWithoutLock_tr1() {
		exitSequence_main_region_ModifyingWithoutLock();
		sCInterface.operationCallback.success();
		
		enterSequence_main_region_Idle_default();
	}
	
	/* Entry action for state 'Locking'. */
	private void entryAction_main_region_Locking() {
		sCInterface.operationCallback.lock();
	}
	
	/* Entry action for state 'ModifyingWithLock'. */
	private void entryAction_main_region_ModifyingWithLock() {
		sCInterface.operationCallback.executeModification();
	}
	
	/* Entry action for state 'Unlocking'. */
	private void entryAction_main_region_Unlocking() {
		sCInterface.operationCallback.unlock();
	}
	
	/* Entry action for state 'ConflictResolution'. */
	private void entryAction_main_region_ConflictResolution() {
		sCInterface.operationCallback.resolve();
	}
	
	/* Entry action for state 'ModifyingWithoutLock'. */
	private void entryAction_main_region_ModifyingWithoutLock() {
		sCInterface.operationCallback.executeModification();
	}
	
	/* Exit action for state 'Idle'. */
	private void exitAction_main_region_Idle() {
		sCInterface.operationCallback.update();
	}
	
	/* 'default' enter sequence for state Idle */
	private void enterSequence_main_region_Idle_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Idle;
	}
	
	/* 'default' enter sequence for state Locking */
	private void enterSequence_main_region_Locking_default() {
		entryAction_main_region_Locking();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Locking;
	}
	
	/* 'default' enter sequence for state ModifyingWithLock */
	private void enterSequence_main_region_ModifyingWithLock_default() {
		entryAction_main_region_ModifyingWithLock();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_ModifyingWithLock;
	}
	
	/* 'default' enter sequence for state Unlocking */
	private void enterSequence_main_region_Unlocking_default() {
		entryAction_main_region_Unlocking();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Unlocking;
	}
	
	/* 'default' enter sequence for state ConflictResolution */
	private void enterSequence_main_region_ConflictResolution_default() {
		entryAction_main_region_ConflictResolution();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_ConflictResolution;
	}
	
	/* 'default' enter sequence for state ModifyingWithoutLock */
	private void enterSequence_main_region_ModifyingWithoutLock_default() {
		entryAction_main_region_ModifyingWithoutLock();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_ModifyingWithoutLock;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state Idle */
	private void exitSequence_main_region_Idle() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_Idle();
	}
	
	/* Default exit sequence for state Locking */
	private void exitSequence_main_region_Locking() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ModifyingWithLock */
	private void exitSequence_main_region_ModifyingWithLock() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Unlocking */
	private void exitSequence_main_region_Unlocking() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ConflictResolution */
	private void exitSequence_main_region_ConflictResolution() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ModifyingWithoutLock */
	private void exitSequence_main_region_ModifyingWithoutLock() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Idle:
			exitSequence_main_region_Idle();
			break;
		case main_region_Locking:
			exitSequence_main_region_Locking();
			break;
		case main_region_ModifyingWithLock:
			exitSequence_main_region_ModifyingWithLock();
			break;
		case main_region_Unlocking:
			exitSequence_main_region_Unlocking();
			break;
		case main_region_ConflictResolution:
			exitSequence_main_region_ConflictResolution();
			break;
		case main_region_ModifyingWithoutLock:
			exitSequence_main_region_ModifyingWithoutLock();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state Idle. */
	private void react_main_region_Idle() {
		if (check_main_region_Idle_tr0_tr0()) {
			effect_main_region_Idle_tr0();
		} else {
			if (check_main_region_Idle_tr1_tr1()) {
				effect_main_region_Idle_tr1();
			}
		}
	}
	
	/* The reactions of state Locking. */
	private void react_main_region_Locking() {
		if (check_main_region_Locking_tr0_tr0()) {
			effect_main_region_Locking_tr0();
		} else {
			if (check_main_region_Locking_tr1_tr1()) {
				effect_main_region_Locking_tr1();
			}
		}
	}
	
	/* The reactions of state ModifyingWithLock. */
	private void react_main_region_ModifyingWithLock() {
		if (check_main_region_ModifyingWithLock_tr0_tr0()) {
			effect_main_region_ModifyingWithLock_tr0();
		}
	}
	
	/* The reactions of state Unlocking. */
	private void react_main_region_Unlocking() {
		if (check_main_region_Unlocking_tr0_tr0()) {
			effect_main_region_Unlocking_tr0();
		} else {
			if (check_main_region_Unlocking_tr1_tr1()) {
				effect_main_region_Unlocking_tr1();
			} else {
				if (check_main_region_Unlocking_tr2_tr2()) {
					effect_main_region_Unlocking_tr2();
				}
			}
		}
	}
	
	/* The reactions of state ConflictResolution. */
	private void react_main_region_ConflictResolution() {
		if (check_main_region_ConflictResolution_tr0_tr0()) {
			effect_main_region_ConflictResolution_tr0();
		}
	}
	
	/* The reactions of state ModifyingWithoutLock. */
	private void react_main_region_ModifyingWithoutLock() {
		if (check_main_region_ModifyingWithoutLock_tr0_tr0()) {
			effect_main_region_ModifyingWithoutLock_tr0();
		} else {
			if (check_main_region_ModifyingWithoutLock_tr1_tr1()) {
				effect_main_region_ModifyingWithoutLock_tr1();
			}
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Idle_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_Idle:
				react_main_region_Idle();
				break;
			case main_region_Locking:
				react_main_region_Locking();
				break;
			case main_region_ModifyingWithLock:
				react_main_region_ModifyingWithLock();
				break;
			case main_region_Unlocking:
				react_main_region_Unlocking();
				break;
			case main_region_ConflictResolution:
				react_main_region_ConflictResolution();
				break;
			case main_region_ModifyingWithoutLock:
				react_main_region_ModifyingWithoutLock();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
