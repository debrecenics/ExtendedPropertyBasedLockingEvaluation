package org.mondo.collaboration.eval.behaviors;

import java.util.Collection;

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
	Collection<IQuerySpecification<?>> locks;
	private LockingBasedChannel channel;

	public LockingClientBehavior(String user, IModelManipulator manipulator, Collection<IQuerySpecification<?>> locks, ServerBehavior server) {
		this.user = user;
		this.manipulator = manipulator;
		this.locks = locks;

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

	public Collection<IQuerySpecification<?>> getLocks() {
		return locks;
	}
}
