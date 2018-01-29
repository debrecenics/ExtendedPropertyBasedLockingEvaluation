package org.mondo.collaboration.eval.behaviors.lockingclient;

public class LockingClientStatemachine implements ILockingClientStatemachine {

	protected class SCInterfaceImpl implements SCInterface {
	
		private SCInterfaceOperationCallback operationCallback;
		
		public void setSCInterfaceOperationCallback(
				SCInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean request;
		
		public void raiseRequest() {
			request = true;
		}
		
		private boolean success;
		
		public void raiseSuccess() {
			success = true;
		}
		
		private boolean failure;
		
		public void raiseFailure() {
			failure = true;
		}
		
		private boolean finish;
		
		public void raiseFinish() {
			finish = true;
		}
		
		protected void clearEvents() {
			request = false;
			success = false;
			failure = false;
			finish = false;
		}
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_IDLE,
		main_region_Execute,
		main_region_Violation,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	
	
	public LockingClientStatemachine() {
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
		case main_region_IDLE:
			return stateVector[0] == State.main_region_IDLE;
		case main_region_Execute:
			return stateVector[0] == State.main_region_Execute;
		case main_region_Violation:
			return stateVector[0] == State.main_region_Violation;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public void raiseRequest() {
		sCInterface.raiseRequest();
	}
	
	public void raiseSuccess() {
		sCInterface.raiseSuccess();
	}
	
	public void raiseFailure() {
		sCInterface.raiseFailure();
	}
	
	public void raiseFinish() {
		sCInterface.raiseFinish();
	}
	
	private boolean check_main_region_IDLE_tr0_tr0() {
		return sCInterface.request;
	}
	
	private boolean check_main_region_Execute_tr0_tr0() {
		return sCInterface.failure;
	}
	
	private boolean check_main_region_Execute_tr1_tr1() {
		return sCInterface.success;
	}
	
	private boolean check_main_region_Execute_tr2_tr2() {
		return sCInterface.finish;
	}
	
	private boolean check_main_region_Violation_tr0_tr0() {
		return sCInterface.request;
	}
	
	private void effect_main_region_IDLE_tr0() {
		exitSequence_main_region_IDLE();
		sCInterface.operationCallback.lock();
		
		enterSequence_main_region_Execute_default();
	}
	
	private void effect_main_region_Execute_tr0() {
		exitSequence_main_region_Execute();
		sCInterface.operationCallback.release();
		
		enterSequence_main_region_Violation_default();
	}
	
	private void effect_main_region_Execute_tr1() {
		exitSequence_main_region_Execute();
		sCInterface.operationCallback.release();
		
		enterSequence_main_region_IDLE_default();
	}
	
	private void effect_main_region_Execute_tr2() {
		exitSequence_main_region_Execute();
		sCInterface.operationCallback.commit();
		
		enterSequence_main_region_Execute_default();
	}
	
	private void effect_main_region_Violation_tr0() {
		exitSequence_main_region_Violation();
		sCInterface.operationCallback.lock();
		
		enterSequence_main_region_Execute_default();
	}
	
	/* Entry action for state 'Execute'. */
	private void entryAction_main_region_Execute() {
		sCInterface.operationCallback.execute();
	}
	
	/* Entry action for state 'Violation'. */
	private void entryAction_main_region_Violation() {
		sCInterface.operationCallback.revert();
	}
	
	/* 'default' enter sequence for state IDLE */
	private void enterSequence_main_region_IDLE_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_IDLE;
	}
	
	/* 'default' enter sequence for state Execute */
	private void enterSequence_main_region_Execute_default() {
		entryAction_main_region_Execute();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Execute;
	}
	
	/* 'default' enter sequence for state Violation */
	private void enterSequence_main_region_Violation_default() {
		entryAction_main_region_Violation();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Violation;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state IDLE */
	private void exitSequence_main_region_IDLE() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Execute */
	private void exitSequence_main_region_Execute() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Violation */
	private void exitSequence_main_region_Violation() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_IDLE:
			exitSequence_main_region_IDLE();
			break;
		case main_region_Execute:
			exitSequence_main_region_Execute();
			break;
		case main_region_Violation:
			exitSequence_main_region_Violation();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state IDLE. */
	private void react_main_region_IDLE() {
		if (check_main_region_IDLE_tr0_tr0()) {
			effect_main_region_IDLE_tr0();
		}
	}
	
	/* The reactions of state Execute. */
	private void react_main_region_Execute() {
		if (check_main_region_Execute_tr0_tr0()) {
			effect_main_region_Execute_tr0();
		} else {
			if (check_main_region_Execute_tr1_tr1()) {
				effect_main_region_Execute_tr1();
			} else {
				if (check_main_region_Execute_tr2_tr2()) {
					effect_main_region_Execute_tr2();
				}
			}
		}
	}
	
	/* The reactions of state Violation. */
	private void react_main_region_Violation() {
		if (check_main_region_Violation_tr0_tr0()) {
			effect_main_region_Violation_tr0();
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_IDLE_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_IDLE:
				react_main_region_IDLE();
				break;
			case main_region_Execute:
				react_main_region_Execute();
				break;
			case main_region_Violation:
				react_main_region_Violation();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
