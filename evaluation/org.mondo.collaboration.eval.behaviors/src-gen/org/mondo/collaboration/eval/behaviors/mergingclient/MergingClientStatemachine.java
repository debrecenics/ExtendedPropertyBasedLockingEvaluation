package org.mondo.collaboration.eval.behaviors.mergingclient;

public class MergingClientStatemachine implements IMergingClientStatemachine {

	protected class SCInterfaceImpl implements SCInterface {
	
		private SCInterfaceOperationCallback operationCallback;
		
		public void setSCInterfaceOperationCallback(
				SCInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private boolean upload;
		
		public void raiseUpload() {
			upload = true;
		}
		
		private boolean success;
		
		public void raiseSuccess() {
			success = true;
		}
		
		private boolean conflict;
		
		public void raiseConflict() {
			conflict = true;
		}
		
		protected void clearEvents() {
			upload = false;
			success = false;
			conflict = false;
		}
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_Idle,
		main_region_Commited,
		main_region_Merging,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	
	
	public MergingClientStatemachine() {
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
		case main_region_Commited:
			return stateVector[0] == State.main_region_Commited;
		case main_region_Merging:
			return stateVector[0] == State.main_region_Merging;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public void raiseUpload() {
		sCInterface.raiseUpload();
	}
	
	public void raiseSuccess() {
		sCInterface.raiseSuccess();
	}
	
	public void raiseConflict() {
		sCInterface.raiseConflict();
	}
	
	private boolean check_main_region_Idle_tr0_tr0() {
		return sCInterface.upload;
	}
	
	private boolean check_main_region_Commited_tr0_tr0() {
		return sCInterface.success;
	}
	
	private boolean check_main_region_Commited_tr1_tr1() {
		return sCInterface.conflict;
	}
	
	private boolean check_main_region_Merging_tr0_tr0() {
		return sCInterface.upload;
	}
	
	private void effect_main_region_Idle_tr0() {
		exitSequence_main_region_Idle();
		sCInterface.operationCallback.commit();
		
		enterSequence_main_region_Commited_default();
	}
	
	private void effect_main_region_Commited_tr0() {
		exitSequence_main_region_Commited();
		enterSequence_main_region_Idle_default();
	}
	
	private void effect_main_region_Commited_tr1() {
		exitSequence_main_region_Commited();
		enterSequence_main_region_Merging_default();
	}
	
	private void effect_main_region_Merging_tr0() {
		exitSequence_main_region_Merging();
		sCInterface.operationCallback.commit();
		
		enterSequence_main_region_Commited_default();
	}
	
	/* Entry action for state 'Merging'. */
	private void entryAction_main_region_Merging() {
		sCInterface.operationCallback.resolve();
	}
	
	/* Exit action for state 'Idle'. */
	private void exitAction_main_region_Idle() {
		sCInterface.operationCallback.execute();
	}
	
	/* 'default' enter sequence for state Idle */
	private void enterSequence_main_region_Idle_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Idle;
	}
	
	/* 'default' enter sequence for state Commited */
	private void enterSequence_main_region_Commited_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Commited;
	}
	
	/* 'default' enter sequence for state Merging */
	private void enterSequence_main_region_Merging_default() {
		entryAction_main_region_Merging();
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Merging;
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
	
	/* Default exit sequence for state Commited */
	private void exitSequence_main_region_Commited() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Merging */
	private void exitSequence_main_region_Merging() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Idle:
			exitSequence_main_region_Idle();
			break;
		case main_region_Commited:
			exitSequence_main_region_Commited();
			break;
		case main_region_Merging:
			exitSequence_main_region_Merging();
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
	
	/* The reactions of state Commited. */
	private void react_main_region_Commited() {
		if (check_main_region_Commited_tr0_tr0()) {
			effect_main_region_Commited_tr0();
		} else {
			if (check_main_region_Commited_tr1_tr1()) {
				effect_main_region_Commited_tr1();
			}
		}
	}
	
	/* The reactions of state Merging. */
	private void react_main_region_Merging() {
		if (check_main_region_Merging_tr0_tr0()) {
			effect_main_region_Merging_tr0();
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
			case main_region_Commited:
				react_main_region_Commited();
				break;
			case main_region_Merging:
				react_main_region_Merging();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
