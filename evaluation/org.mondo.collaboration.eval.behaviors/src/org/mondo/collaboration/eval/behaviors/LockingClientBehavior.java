package org.mondo.collaboration.eval.behaviors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.mondo.collaboration.eval.behaviors.lockingclient.LockingClientStatemachine;
import org.mondo.collaboration.eval.behaviors.util.Channel;
import org.mondo.collaboration.eval.behaviors.util.Channel.LockingBasedChannel;
import org.mondo.collaboration.eval.behaviors.util.IModelManipulator;

public class LockingClientBehavior extends LockingClientStatemachine {

	String user;
	EObject localModel;
	EObject ancestorModel;
	IModelManipulator manipulator;
	IQuerySpecification<?> lock;
	private LockingBasedChannel channel;

	public LockingClientBehavior(String user, IModelManipulator manipulator, IQuerySpecification<?> lock, ServerBehavior server) {
		this.user = user;
		this.manipulator = manipulator;
		this.lock = lock;

		getSCInterface().setSCInterfaceOperationCallback(new OperationCallback());
		channel = Channel.createLockBasedChannel(server, this);
	}

	public String getUser() {
		return user;
	}

	public void execute(EObject model) {
		localModel = manipulator.execute(model);
	}

	public EObject getAncestorModel() {
		return ancestorModel;
	}

	public EObject getLocalModel() {
		return localModel;
	}
	
	private final class OperationCallback implements SCInterfaceOperationCallback {
		
		@Override
		public void revert() {
			localModel = ancestorModel;
		}

		@Override
		public void release() {
			channel.sendReleaseFromClient();
			
		}

		@Override
		public void lock() {
			channel.sendRequestFromClient();
		}

		@Override
		public void execute() {
			localModel = manipulator.execute(localModel);
			
		}

		@Override
		public void commit() {
			channel.sendCommitFromClient();			
		}
	}

	public IQuerySpecification<?> getLock() {
		return null;
	}
}
