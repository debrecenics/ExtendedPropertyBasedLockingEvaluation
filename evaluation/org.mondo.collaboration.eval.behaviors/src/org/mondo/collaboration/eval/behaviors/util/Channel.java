package org.mondo.collaboration.eval.behaviors.util;

import java.util.Collection;

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
		server.setCurrentChannel(this);
		server.raiseCommit();
		server.runCycle();
		server.executeNextCall();
	}

	public void sendRequestFromClient() {
		throw new UnsupportedOperationException();
	}

	public void sendReleaseFromClient() {
		throw new UnsupportedOperationException();
	}

	public Revision getRemoteRevision() {
		return server.getLatestRevision();
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

	public Collection<IQuerySpecification<?>> getRequestedLocks() {
		throw new UnsupportedOperationException();
	}

	public Collection<IQuerySpecification<?>> getReleasedLocks() {
		throw new UnsupportedOperationException();
	}

	public void executeModelManipulation(EObject model) {
		throw new UnsupportedOperationException();
	}

	public Revision getAncestorRevision() {
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
			return client.getUsername();
		}

		@Override
		public void sendViolationFromServer() {
			client.setNextCall(new IRaiseFunction() {

				@Override
				public void apply() {
					client.raiseFailure();
				}
			});
		}

		@Override
		public void sendAcceptedFromServer() {
			client.setNextCall(new IRaiseFunction() {

				@Override
				public void apply() {
					client.raiseSuccess();
				}
			});
		}

		@Override
		public Collection<IQuerySpecification<?>> getRequestedLocks() {
			return client.getLocks();
		}

		@Override
		public void sendReleaseFromClient() {
			server.setCurrentChannel(this);
			server.raiseRelease();
			server.runCycle();
			server.executeNextCall();
		}

		@Override
		public void sendRequestFromClient() {
			server.setCurrentChannel(this);
			server.raiseRequest();
			server.runCycle();
			server.executeNextCall();
		}

		@Override
		public Collection<IQuerySpecification<?>> getReleasedLocks() {
			return client.getLocks();
		}

		@Override
		public void executeModelManipulation(EObject model) {
			client.execute(model);
		}

		@Override
		public Revision getAncestorRevision() {
			return client.getAncestorRevision();
		}

		@Override
		public EObject getLocalModel() {
			return client.getLocalModel();
		}

		public double getServerTime() {
			return server.getCurrentTime();
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
			return client.getUsername();
		}

		@Override
		public void sendConflictFromServer() {
			client.setNextCall(new IRaiseFunction() {

				@Override
				public void apply() {
					client.raiseConflict();
				}
			});

		}

		@Override
		public void sendAcceptedFromServer() {
			client.setNextCall(new IRaiseFunction() {

				@Override
				public void apply() {
					client.raiseSuccess();
				}
			});
		}

		@Override
		public void sendViolationFromServer() {
			client.setNextCall(new IRaiseFunction() {

				@Override
				public void apply() {
					client.raiseViolation();
				}
			});
		}

		@Override
		public void executeModelManipulation(EObject model) {
			client.execute(model);
		}

		@Override
		public Revision getAncestorRevision() {
			return client.getAncestorRevision();
		}

		@Override
		public EObject getLocalModel() {
			return client.getLocalModel();
		}

		public double getServerTime() {
			return server.getCurrentTime();
		}
	}
}
