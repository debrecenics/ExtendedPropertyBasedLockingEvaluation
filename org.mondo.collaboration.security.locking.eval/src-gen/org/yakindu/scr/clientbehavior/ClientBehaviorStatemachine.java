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
		main_region_MODIFY_WITH_LOCK,
		main_region_MODIFY_WITH_LOCK_region_Locking,
		main_region_MODIFY_WITH_LOCK_region_Modifying,
		main_region_MODIFY_WITH_LOCK_region_Unlocking,
		main_region_MODIFY_WITH_LOCK_region_Resolving,
		main_region_MODIFY_WITHOUT_LOCK,
		main_region_MODIFY_WITHOUT_LOCK_region_Modifying,
		main_region_MODIFY_WITHOUT_LOCK_region_Resolving,
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
		case main_region_MODIFY_WITH_LOCK:
			return stateVector[0].ordinal() >= State.
					main_region_MODIFY_WITH_LOCK.ordinal()&& stateVector[0].ordinal() <= State.main_region_MODIFY_WITH_LOCK_region_Resolving.ordinal();
		case main_region_MODIFY_WITH_LOCK_region_Locking:
			return stateVector[0] == State.main_region_MODIFY_WITH_LOCK_region_Locking;
		case main_region_MODIFY_WITH_LOCK_region_Modifying:
			return stateVector[0] == State.main_region_MODIFY_WITH_LOCK_region_Modifying;
		case main_region_MODIFY_WITH_LOCK_region_Unlocking:
			return stateVector[0] == State.main_region_MODIFY_WITH_LOCK_region_Unlocking;
		case main_region_MODIFY_WITH_LOCK_region_Resolving:
			return stateVector[0] == State.main_region_MODIFY_WITH_LOCK_region_Resolving;
		case main_region_MODIFY_WITHOUT_LOCK:
			return stateVector[0].ordinal() >= State.
					main_region_MODIFY_WITHOUT_LOCK.ordinal()&& stateVector[0].ordinal() <= State.main_region_MODIFY_WITHOUT_LOCK_region_Resolving.ordinal();
		case main_region_MODIFY_WITHOUT_LOCK_region_Modifying:
			return stateVector[0] == State.main_region_MODIFY_WITHOUT_LOCK_region_Modifying;
		case main_region_MODIFY_WITHOUT_LOCK_region_Resolving:
			return stateVector[0] == State.main_region_MODIFY_WITHOUT_LOCK_region_Resolving;
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
	
	private boolean check_main_region_MODIFY_WITH_LOCK_region_Locking_tr0_tr0() {
		return sCInterface.rejected;
	}
	
	private boolean check_main_region_MODIFY_WITH_LOCK_region_Locking_tr1_tr1() {
		return sCInterface.locked;
	}
	
	private boolean check_main_region_MODIFY_WITH_LOCK_region_Modifying_tr0_tr0() {
		return sCInterface.finishedUnlocked;
	}
	
	private boolean check_main_region_MODIFY_WITH_LOCK_region_Modifying_tr1_tr1() {
		return sCInterface.finishedConflict;
	}
	
	private boolean check_main_region_MODIFY_WITH_LOCK_region_Unlocking_tr0_tr0() {
		return sCInterface.unlockedSuccess;
	}
	
	private boolean check_main_region_MODIFY_WITH_LOCK_region_Unlocking_tr1_tr1() {
		return sCInterface.unlockedFailure;
	}
	
	private boolean check_main_region_MODIFY_WITH_LOCK_region_Resolving_tr0_tr0() {
		return sCInterface.resolved;
	}
	
	private boolean check_main_region_MODIFY_WITHOUT_LOCK_region_Modifying_tr0_tr0() {
		return sCInterface.finishedSuccess;
	}
	
	private boolean check_main_region_MODIFY_WITHOUT_LOCK_region_Modifying_tr1_tr1() {
		return sCInterface.finishedConflict;
	}
	
	private boolean check_main_region_MODIFY_WITHOUT_LOCK_region_Resolving_tr0_tr0() {
		return sCInterface.resolved;
	}
	
	private void effect_main_region_Idle_tr0() {
		exitSequence_main_region_Idle();
		enterSequence_main_region_MODIFY_WITH_LOCK_region_Locking_default();
	}
	
	private void effect_main_region_Idle_tr1() {
		exitSequence_main_region_Idle();
		enterSequence_main_region_MODIFY_WITHOUT_LOCK_region_Modifying_default();
	}
	
	private void effect_main_region_MODIFY_WITH_LOCK_region_Locking_tr0() {
		exitSequence_main_region_MODIFY_WITH_LOCK();
		sCInterface.operationCallback.failure();
		
		enterSequence_main_region_Idle_default();
	}
	
	private void effect_main_region_MODIFY_WITH_LOCK_region_Locking_tr1() {
		exitSequence_main_region_MODIFY_WITH_LOCK_region_Locking();
		enterSequence_main_region_MODIFY_WITH_LOCK_region_Modifying_default();
	}
	
	private void effect_main_region_MODIFY_WITH_LOCK_region_Modifying_tr0() {
		exitSequence_main_region_MODIFY_WITH_LOCK_region_Modifying();
		enterSequence_main_region_MODIFY_WITH_LOCK_region_Unlocking_default();
	}
	
	private void effect_main_region_MODIFY_WITH_LOCK_region_Modifying_tr1() {
		exitSequence_main_region_MODIFY_WITH_LOCK_region_Modifying();
		sCInterface.operationCallback.conflict();
		
		enterSequence_main_region_MODIFY_WITH_LOCK_region_Resolving_default();
	}
	
	private void effect_main_region_MODIFY_WITH_LOCK_region_Unlocking_tr0() {
		exitSequence_main_region_MODIFY_WITH_LOCK();
		sCInterface.operationCallback.success();
		
		enterSequence_main_region_Idle_default();
	}
	
	private void effect_main_region_MODIFY_WITH_LOCK_region_Unlocking_tr1() {
		exitSequence_main_region_MODIFY_WITH_LOCK();
		sCInterface.operationCallback.failure();
		
		enterSequence_main_region_Idle_default();
	}
	
	private void effect_main_region_MODIFY_WITH_LOCK_region_Resolving_tr0() {
		exitSequence_main_region_MODIFY_WITH_LOCK_region_Resolving();
		enterSequence_main_region_MODIFY_WITH_LOCK_region_Modifying_default();
	}
	
	private void effect_main_region_MODIFY_WITHOUT_LOCK_region_Modifying_tr0() {
		exitSequence_main_region_MODIFY_WITHOUT_LOCK();
		sCInterface.operationCallback.success();
		
		enterSequence_main_region_Idle_default();
	}
	
	private void effect_main_region_MODIFY_WITHOUT_LOCK_region_Modifying_tr1() {
		exitSequence_main_region_MODIFY_WITHOUT_LOCK_region_Modifying();
		sCInterface.operationCallback.conflict();
		
		enterSequence_main_region_MODIFY_WITHOUT_LOCK_region_Resolving_default();
	}
	
	private void effect_main_region_MODIFY_WITHOUT_LOCK_region_Resolving_tr0() {
		exitSequence_main_region_MODIFY_WITHOUT_LOCK_region_Resolving();
		enterSequence_main_region_MODIFY_WITHOUT_LOCK_region_Modifying_default();
	}
	
	/* Entry action for state 'Locking'. */
	private void entryAction_main_region_MODIFY_WITH_LOCK_region_Locking() {
		sCInterface.operationCallback.lock();
	}
	
	/* Entry action for state 'Modifying'. */
	private void entryAction_main_region_MODIFY_WITH_LOCK_region_Modifying() {
		sCInterface.operationCallback.executeModification();
	}
	
	/* Entry action for state 'Resolving'. */
	private void entryAction_main_region_MODIFY_WITH_LOCK_region_Resolving() {
		sCInterface.operationCallback.resolve();
	}
	
	/* Entry action for state 'Modifying'. */
	private void entryAction_main_region_MODIFY_WITHOUT_LOCK_region_Modifying() {
		sCInterface.operationCallback.executeModification();
	}
	
	/* Entry action for state 'Resolving'. */
	private void entryAction_main_region_MODIFY_WITHOUT_LOCK_region_Resolving() {
		sCInterface.operationCallback.resolve();
	}
	
	/* Exit action for state 'Idle'. */
	private void exitAction_main_region_Idle() {
		sCInterface.operationCallback.update();
	}
	
	/* Exit action for state 'Unlocking'. */
	private void exitAction_main_region_MODIFY_WITH_LOCK_region_Unlocking() {
		sCInterface.operationCallback.unlock();
	}
	
	/* 'default' enter sequence for state Idle */
	private void enterSequence_main_region_Idle_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Idle;
	}
	
	/* 'default' enter sequence for state Locking */
	private void enterSequence_main_region_MODIFY_WITH_LOCK_region_Locking_default() {
		entryAction_main_region_MODIFY_WITH_LOCK_region_Locking();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_MODIFY_WITH_LOCK_region_Locking;
	}
	
	/* 'default' enter sequence for state Modifying */
	private void enterSequence_main_region_MODIFY_WITH_LOCK_region_Modifying_default() {
		entryAction_main_region_MODIFY_WITH_LOCK_region_Modifying();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_MODIFY_WITH_LOCK_region_Modifying;
	}
	
	/* 'default' enter sequence for state Unlocking */
	private void enterSequence_main_region_MODIFY_WITH_LOCK_region_Unlocking_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_MODIFY_WITH_LOCK_region_Unlocking;
	}
	
	/* 'default' enter sequence for state Resolving */
	private void enterSequence_main_region_MODIFY_WITH_LOCK_region_Resolving_default() {
		entryAction_main_region_MODIFY_WITH_LOCK_region_Resolving();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_MODIFY_WITH_LOCK_region_Resolving;
	}
	
	/* 'default' enter sequence for state Modifying */
	private void enterSequence_main_region_MODIFY_WITHOUT_LOCK_region_Modifying_default() {
		entryAction_main_region_MODIFY_WITHOUT_LOCK_region_Modifying();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_MODIFY_WITHOUT_LOCK_region_Modifying;
	}
	
	/* 'default' enter sequence for state Resolving */
	private void enterSequence_main_region_MODIFY_WITHOUT_LOCK_region_Resolving_default() {
		entryAction_main_region_MODIFY_WITHOUT_LOCK_region_Resolving();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_MODIFY_WITHOUT_LOCK_region_Resolving;
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
	
	/* Default exit sequence for state MODIFY-WITH-LOCK */
	private void exitSequence_main_region_MODIFY_WITH_LOCK() {
		exitSequence_main_region_MODIFY_WITH_LOCK_region();
	}
	
	/* Default exit sequence for state Locking */
	private void exitSequence_main_region_MODIFY_WITH_LOCK_region_Locking() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Modifying */
	private void exitSequence_main_region_MODIFY_WITH_LOCK_region_Modifying() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Unlocking */
	private void exitSequence_main_region_MODIFY_WITH_LOCK_region_Unlocking() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
		
		exitAction_main_region_MODIFY_WITH_LOCK_region_Unlocking();
	}
	
	/* Default exit sequence for state Resolving */
	private void exitSequence_main_region_MODIFY_WITH_LOCK_region_Resolving() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state MODIFY-WITHOUT-LOCK */
	private void exitSequence_main_region_MODIFY_WITHOUT_LOCK() {
		exitSequence_main_region_MODIFY_WITHOUT_LOCK_region();
	}
	
	/* Default exit sequence for state Modifying */
	private void exitSequence_main_region_MODIFY_WITHOUT_LOCK_region_Modifying() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Resolving */
	private void exitSequence_main_region_MODIFY_WITHOUT_LOCK_region_Resolving() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Idle:
			exitSequence_main_region_Idle();
			break;
		case main_region_MODIFY_WITH_LOCK_region_Locking:
			exitSequence_main_region_MODIFY_WITH_LOCK_region_Locking();
			break;
		case main_region_MODIFY_WITH_LOCK_region_Modifying:
			exitSequence_main_region_MODIFY_WITH_LOCK_region_Modifying();
			break;
		case main_region_MODIFY_WITH_LOCK_region_Unlocking:
			exitSequence_main_region_MODIFY_WITH_LOCK_region_Unlocking();
			break;
		case main_region_MODIFY_WITH_LOCK_region_Resolving:
			exitSequence_main_region_MODIFY_WITH_LOCK_region_Resolving();
			break;
		case main_region_MODIFY_WITHOUT_LOCK_region_Modifying:
			exitSequence_main_region_MODIFY_WITHOUT_LOCK_region_Modifying();
			break;
		case main_region_MODIFY_WITHOUT_LOCK_region_Resolving:
			exitSequence_main_region_MODIFY_WITHOUT_LOCK_region_Resolving();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region region */
	private void exitSequence_main_region_MODIFY_WITH_LOCK_region() {
		switch (stateVector[0]) {
		case main_region_MODIFY_WITH_LOCK_region_Locking:
			exitSequence_main_region_MODIFY_WITH_LOCK_region_Locking();
			break;
		case main_region_MODIFY_WITH_LOCK_region_Modifying:
			exitSequence_main_region_MODIFY_WITH_LOCK_region_Modifying();
			break;
		case main_region_MODIFY_WITH_LOCK_region_Unlocking:
			exitSequence_main_region_MODIFY_WITH_LOCK_region_Unlocking();
			break;
		case main_region_MODIFY_WITH_LOCK_region_Resolving:
			exitSequence_main_region_MODIFY_WITH_LOCK_region_Resolving();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region region */
	private void exitSequence_main_region_MODIFY_WITHOUT_LOCK_region() {
		switch (stateVector[0]) {
		case main_region_MODIFY_WITHOUT_LOCK_region_Modifying:
			exitSequence_main_region_MODIFY_WITHOUT_LOCK_region_Modifying();
			break;
		case main_region_MODIFY_WITHOUT_LOCK_region_Resolving:
			exitSequence_main_region_MODIFY_WITHOUT_LOCK_region_Resolving();
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
	private void react_main_region_MODIFY_WITH_LOCK_region_Locking() {
		if (check_main_region_MODIFY_WITH_LOCK_region_Locking_tr0_tr0()) {
			effect_main_region_MODIFY_WITH_LOCK_region_Locking_tr0();
		} else {
			if (check_main_region_MODIFY_WITH_LOCK_region_Locking_tr1_tr1()) {
				effect_main_region_MODIFY_WITH_LOCK_region_Locking_tr1();
			}
		}
	}
	
	/* The reactions of state Modifying. */
	private void react_main_region_MODIFY_WITH_LOCK_region_Modifying() {
		if (check_main_region_MODIFY_WITH_LOCK_region_Modifying_tr0_tr0()) {
			effect_main_region_MODIFY_WITH_LOCK_region_Modifying_tr0();
		} else {
			if (check_main_region_MODIFY_WITH_LOCK_region_Modifying_tr1_tr1()) {
				effect_main_region_MODIFY_WITH_LOCK_region_Modifying_tr1();
			}
		}
	}
	
	/* The reactions of state Unlocking. */
	private void react_main_region_MODIFY_WITH_LOCK_region_Unlocking() {
		if (check_main_region_MODIFY_WITH_LOCK_region_Unlocking_tr0_tr0()) {
			effect_main_region_MODIFY_WITH_LOCK_region_Unlocking_tr0();
		} else {
			if (check_main_region_MODIFY_WITH_LOCK_region_Unlocking_tr1_tr1()) {
				effect_main_region_MODIFY_WITH_LOCK_region_Unlocking_tr1();
			}
		}
	}
	
	/* The reactions of state Resolving. */
	private void react_main_region_MODIFY_WITH_LOCK_region_Resolving() {
		if (check_main_region_MODIFY_WITH_LOCK_region_Resolving_tr0_tr0()) {
			effect_main_region_MODIFY_WITH_LOCK_region_Resolving_tr0();
		}
	}
	
	/* The reactions of state Modifying. */
	private void react_main_region_MODIFY_WITHOUT_LOCK_region_Modifying() {
		if (check_main_region_MODIFY_WITHOUT_LOCK_region_Modifying_tr0_tr0()) {
			effect_main_region_MODIFY_WITHOUT_LOCK_region_Modifying_tr0();
		} else {
			if (check_main_region_MODIFY_WITHOUT_LOCK_region_Modifying_tr1_tr1()) {
				effect_main_region_MODIFY_WITHOUT_LOCK_region_Modifying_tr1();
			}
		}
	}
	
	/* The reactions of state Resolving. */
	private void react_main_region_MODIFY_WITHOUT_LOCK_region_Resolving() {
		if (check_main_region_MODIFY_WITHOUT_LOCK_region_Resolving_tr0_tr0()) {
			effect_main_region_MODIFY_WITHOUT_LOCK_region_Resolving_tr0();
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
			case main_region_MODIFY_WITH_LOCK_region_Locking:
				react_main_region_MODIFY_WITH_LOCK_region_Locking();
				break;
			case main_region_MODIFY_WITH_LOCK_region_Modifying:
				react_main_region_MODIFY_WITH_LOCK_region_Modifying();
				break;
			case main_region_MODIFY_WITH_LOCK_region_Unlocking:
				react_main_region_MODIFY_WITH_LOCK_region_Unlocking();
				break;
			case main_region_MODIFY_WITH_LOCK_region_Resolving:
				react_main_region_MODIFY_WITH_LOCK_region_Resolving();
				break;
			case main_region_MODIFY_WITHOUT_LOCK_region_Modifying:
				react_main_region_MODIFY_WITHOUT_LOCK_region_Modifying();
				break;
			case main_region_MODIFY_WITHOUT_LOCK_region_Resolving:
				react_main_region_MODIFY_WITHOUT_LOCK_region_Resolving();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
