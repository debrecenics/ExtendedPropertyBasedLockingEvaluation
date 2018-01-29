package org.mondo.collaboration.eval.behaviors.server;

public class ServerStatemachine implements IServerStatemachine {

	protected class SCInterfaceImpl implements SCInterface {
	
		private SCInterfaceOperationCallback operationCallback;
		
		public void setSCInterfaceOperationCallback(
				SCInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean commit;
		
		public void raiseCommit() {
			commit = true;
		}
		
		private boolean mergeSuccess;
		
		public void raiseMergeSuccess() {
			mergeSuccess = true;
		}
		
		private boolean mergeFailure;
		
		public void raiseMergeFailure() {
			mergeFailure = true;
		}
		
		private boolean lockSuccess;
		
		public void raiseLockSuccess() {
			lockSuccess = true;
		}
		
		private boolean lockFailure;
		
		public void raiseLockFailure() {
			lockFailure = true;
		}
		
		protected void clearEvents() {
			commit = false;
			mergeSuccess = false;
			mergeFailure = false;
			lockSuccess = false;
			lockFailure = false;
		}
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_Idle,
		main_region_Accepting,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	
	
	public ServerStatemachine() {
		sCInterface = new SCInterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		
		if (this.sCInterface.operationCallback == null) {
			throw new IllegalStateException("Operation callback for interface sCInterface must be set.");
		}
		
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
		case main_region_Accepting:
			return stateVector[0] == State.main_region_Accepting;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public void raiseCommit() {
		sCInterface.raiseCommit();
	}
	
	public void raiseMergeSuccess() {
		sCInterface.raiseMergeSuccess();
	}
	
	public void raiseMergeFailure() {
		sCInterface.raiseMergeFailure();
	}
	
	public void raiseLockSuccess() {
		sCInterface.raiseLockSuccess();
	}
	
	public void raiseLockFailure() {
		sCInterface.raiseLockFailure();
	}
	
	private boolean check_main_region_Idle_tr0_tr0() {
		return sCInterface.commit;
	}
	
	private boolean check_main_region_Accepting_tr0_tr0() {
		return sCInterface.lockSuccess;
	}
	
	private boolean check_main_region_Accepting_tr1_tr1() {
		return sCInterface.mergeSuccess;
	}
	
	private boolean check_main_region_Accepting_tr2_tr2() {
		return sCInterface.lockFailure;
	}
	
	private boolean check_main_region_Accepting_tr3_tr3() {
		return sCInterface.mergeFailure;
	}
	
	private void effect_main_region_Idle_tr0() {
		exitSequence_main_region_Idle();
		enterSequence_main_region_Accepting_default();
	}
	
	private void effect_main_region_Accepting_tr0() {
		exitSequence_main_region_Accepting();
		sCInterface.operationCallback.accepted();
		
		enterSequence_main_region_Idle_default();
	}
	
	private void effect_main_region_Accepting_tr1() {
		exitSequence_main_region_Accepting();
		sCInterface.operationCallback.accepted();
		
		enterSequence_main_region_Idle_default();
	}
	
	private void effect_main_region_Accepting_tr2() {
		exitSequence_main_region_Accepting();
		sCInterface.operationCallback.violation();
		
		enterSequence_main_region_Idle_default();
	}
	
	private void effect_main_region_Accepting_tr3() {
		exitSequence_main_region_Accepting();
		sCInterface.operationCallback.conflict();
		
		enterSequence_main_region_Idle_default();
	}
	
	/* Entry action for state 'Accepting'. */
	private void entryAction_main_region_Accepting() {
		sCInterface.operationCallback.checkLockAndConflict();
	}
	
	/* 'default' enter sequence for state Idle */
	private void enterSequence_main_region_Idle_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Idle;
	}
	
	/* 'default' enter sequence for state Accepting */
	private void enterSequence_main_region_Accepting_default() {
		entryAction_main_region_Accepting();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Accepting;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state Idle */
	private void exitSequence_main_region_Idle() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Accepting */
	private void exitSequence_main_region_Accepting() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Idle:
			exitSequence_main_region_Idle();
			break;
		case main_region_Accepting:
			exitSequence_main_region_Accepting();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state Idle. */
	private void react_main_region_Idle() {
		if (check_main_region_Idle_tr0_tr0()) {
			effect_main_region_Idle_tr0();
		}
	}
	
	/* The reactions of state Accepting. */
	private void react_main_region_Accepting() {
		if (check_main_region_Accepting_tr0_tr0()) {
			effect_main_region_Accepting_tr0();
		} else {
			if (check_main_region_Accepting_tr1_tr1()) {
				effect_main_region_Accepting_tr1();
			} else {
				if (check_main_region_Accepting_tr2_tr2()) {
					effect_main_region_Accepting_tr2();
				} else {
					if (check_main_region_Accepting_tr3_tr3()) {
						effect_main_region_Accepting_tr3();
					}
				}
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
			case main_region_Accepting:
				react_main_region_Accepting();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
