package org.mondo.collaboration.eval.behaviors.util;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.mondo.collaboration.eval.behaviors.LockingClientBehavior;
import org.mondo.collaboration.eval.behaviors.MergingClientBehavior;
import org.mondo.collaboration.eval.behaviors.ServerBehavior;

public class Channel {

	protected ServerBehavior server = null;

	public static LockingBasedChannel createLockBasedChannel(ServerBehavior server, LockingClientBehavior client) {
		return new LockingBasedChannel(server, client);
	}

	public static MergeBasedChannel createMergeBasedChannel(ServerBehavior server, MergingClientBehavior client) {
		return new MergeBasedChannel(server, client);
	}

	public String getUser() {
		throw new UnsupportedOperationException();
	}

	public void sendCommitFromClient() {
		server.raiseCommit();
	}
	
	public void sendRequestFromClient() {
		throw new UnsupportedOperationException();
	}
	
	public void sendReleaseFromClient() {
		throw new UnsupportedOperationException();
	}
	
	public Notifier getRemoteModel() {
		return server.getLatestModel();
	}
	
	public void sendConflictFromServer() {
		throw new UnsupportedOperationException();
	}

	public void sendViolationFromServer() {
		throw new UnsupportedOperationException();
	}

	public void sendAcceptedFromServer() {
		throw new UnsupportedOperationException();
	}

	public IQuerySpecification<?> getRequestedLock() {
		throw new UnsupportedOperationException();
	}
	
	public IQuerySpecification<?> getReleasedLock() {
		throw new UnsupportedOperationException();
	}
	
	public void executeModelManipulation(EObject model) {
		throw new UnsupportedOperationException();
	}
	
	public EObject getAncestorModel() {
		throw new UnsupportedOperationException();
	}
	
	public EObject getLocalModel() {
		throw new UnsupportedOperationException();
	}
	
	public static class LockingBasedChannel extends Channel {
		LockingClientBehavior client = null;

		public LockingBasedChannel(ServerBehavior server, LockingClientBehavior client) {
			this.server = server;
			this.client = client;
		}

		@Override
		public String getUser() {
			return client.getUser();
		}

		@Override
		public void sendViolationFromServer() {
			client.raiseFailure();
		}

		@Override
		public void sendAcceptedFromServer() {
			client.raiseSuccess();
		}
		
		@Override
		public IQuerySpecification<?> getRequestedLock() {
			return client.getLock();
		}
		
		@Override
		public void sendReleaseFromClient() {
			server.raiseRelease();
		}
		
		@Override
		public void sendRequestFromClient() {
			server.raiseRequest();
		}
		
		@Override
		public IQuerySpecification<?> getReleasedLock() {
			return client.getLock();
		}
		
		@Override
		public void executeModelManipulation(EObject model) {
			client.execute(model);
		}
		
		@Override
		public EObject getAncestorModel() {
			return client.getAncestorModel();
		}
		
		@Override
		public EObject getLocalModel() {
			return client.getLocalModel();
		}
	}

	public static class MergeBasedChannel extends Channel {
		MergingClientBehavior client = null;

		public MergeBasedChannel(ServerBehavior server, MergingClientBehavior client) {
			this.server = server;
			this.client = client;
		}

		@Override
		public String getUser() {
			return client.getUser();
		}

		@Override
		public void sendConflictFromServer() {
			client.raiseConflict();
		}

		@Override
		public void sendAcceptedFromServer() {
			client.raiseSuccess();
		}
		
		@Override
		public void executeModelManipulation(EObject model) {
			client.execute(model);
		}
		
		@Override
		public EObject getAncestorModel() {
			return client.getAncestorModel();
		}
		
		@Override
		public EObject getLocalModel() {
			return client.getLocalModel();
		}		
	}
}
