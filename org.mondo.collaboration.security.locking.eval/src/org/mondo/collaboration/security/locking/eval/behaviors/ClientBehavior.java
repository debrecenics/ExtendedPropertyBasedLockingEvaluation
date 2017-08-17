package org.mondo.collaboration.security.locking.eval.behaviors;

import org.eclipse.emf.ecore.EObject;
import org.mondo.collaboration.security.locking.eval.behaviors.ServerBehavior.Response;
import org.mondo.collaboration.security.locking.eval.interfaces.IClientOperation;
import org.mondo.collaboration.security.locking.eval.interfaces.ILock;
import org.mondo.collaboration.security.locking.eval.interfaces.ILockingStrategy;
import org.yakindu.scr.clientbehavior.ClientBehaviorStatemachine;
import org.yakindu.scr.clientbehavior.IClientBehaviorStatemachine;

public class ClientBehavior extends ClientBehaviorStatemachine implements Runnable {

	int successCounter = 0, failureCounter = 0, conflictCounter = 0;
	private ILockingStrategy locking;
	private IClientOperation operation;
	private ServerBehavior server;
	private Event nextEvent;
	private EObject origin;

	public ClientBehavior(ILockingStrategy locking, IClientOperation operation, ServerBehavior server,
			boolean useLock) {
		this.locking = locking;
		this.operation = operation;
		this.server = server;

		if (useLock) {
			nextEvent = Event.RequestLock;
		} else {
			nextEvent = Event.Modify;
		}
	}

	private enum Event {
		RequestLock, Locked, UnlockedConflict, UnlockedSuccess, UnlockedFailure, FinishedUnlock, FinishedConflict, FinishedSuccess, Rejected, Modify, Resolved
	}

	@Override
	public void run() {
		init();
		runCycle();
	}

	public void executeNextStep() {
		switch (nextEvent) {
		case Locked:
			raiseLocked();
			break;
		case RequestLock:
			raiseRequestLock();
			break;
		case Modify:
			raiseModify();
			break;
		case Rejected:
			raiseRejected();
			break;
		case Resolved:
			raiseResolved();
			break;
		case FinishedConflict:
			raiseFinishedConflict();
			break;
		case FinishedSuccess:
			raiseFinishedSuccess();
			break;
		case FinishedUnlock:
			raiseFinishedUnlocked();
			break;
		case UnlockedConflict:
			raiseUnlockedConflict();
			break;
		case UnlockedFailure:
			raiseUnlockedFailure();
			break;
		case UnlockedSuccess:
			raiseUnlockedSuccess();
			break;
		default:
			break;
		}
	}

	public class Callback implements IClientBehaviorStatemachine.SCInterfaceOperationCallback {

		@Override
		public void success() {
			successCounter++;
		}

		@Override
		public void failure() {
			failureCounter++;
		}

		@Override
		public void conflict() {
			conflictCounter++;
		}

		@Override
		public void lock() {
			ILock lock = locking.createLock();
			Response response = server.lock(lock);
			switch (response) {
			case FAILURE:
				nextEvent = Event.Rejected;
				break;
			case SUCCESS:
				nextEvent = Event.Locked;
				break;
			default:
				throw new IllegalArgumentException();
			}
		}

		@Override
		public void unlock() {
			ILock lock = locking.getLock();
			Response response = server.unlock(lock);
			switch (response) {
			case CONFLICT:
				nextEvent = Event.UnlockedConflict;
				break;
			case FAILURE:
				nextEvent = Event.UnlockedFailure;
				break;
			case SUCCESS:
				nextEvent = Event.UnlockedSuccess;
				break;
			}
		}

		@Override
		public void resolve() {
			operation.resolve();
			nextEvent = Event.Resolved;
		}

		@Override
		public void executeModification() {
			EObject local = operation.executeModification(origin);
			server.executeModification(local, origin);
			
			if(isStateActive(State.main_region_ModifingWithoutLock)) {
				if(server.hasConflict())
					nextEvent = Event.FinishedConflict;
				else
					nextEvent = Event.FinishedSuccess;				
			} else {
				nextEvent = Event.FinishedUnlock;
			}			
		}

		@Override
		public void update() {
			origin = server.getCopyOfCurrentModel();
		}
	}
}
