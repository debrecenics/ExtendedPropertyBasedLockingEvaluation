package org.mondo.collaboration.eval.behaviors;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.mondo.collaboration.eval.behaviors.lockingclient.LockingClientStatemachine;
import org.mondo.collaboration.eval.behaviors.users.BaseUser;
import org.mondo.collaboration.eval.behaviors.util.Channel;
import org.mondo.collaboration.eval.behaviors.util.Channel.LockingBasedChannel;
import org.mondo.collaboration.eval.behaviors.util.IRaiseFunction;
import org.mondo.collaboration.eval.behaviors.util.Revision;

import com.google.common.collect.Lists;

public class LockingClientBehavior extends LockingClientStatemachine {

	BaseUser user;
	EObject localModel;
	Revision ancestorRevision;
	LockingBasedChannel channel;
	
	IRaiseFunction nextCall = null;
	
	List<Double> waitTime = Lists.newArrayList();

	public LockingClientBehavior(BaseUser user, ServerBehavior server) {
		this.user = user;

		getSCInterface().setSCInterfaceOperationCallback(new OperationCallback());
		channel = Channel.createLockBasedChannel(server, this);
		update();
	}

	public void setNextCall(IRaiseFunction nextCall) {
		this.nextCall = nextCall;
	}
	
	public IRaiseFunction getNextCall() {
		return nextCall;
	}
	
	public String getUsername() {
		return user.getUsername();
	}

	public void execute(EObject model) {
		localModel = user.execute(model);
	}

	public Revision getAncestorRevision() {
		return ancestorRevision;
	}

	public EObject getLocalModel() {
		return localModel;
	}
	
	public double getWaitTime() {
		return waitTime.stream().reduce(0d, Double::sum);
	}
	
	public final class OperationCallback implements SCInterfaceOperationCallback {
		
		private double waitStart;

		@Override
		public void violationStart() {
			localModel = ancestorRevision.getModel();
			waitStart = channel.getServerTime();
		}

		@Override
		public void violationEnd() {
			double waitEnd = channel.getServerTime();	
			waitTime.add(waitEnd - waitStart);
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
			localModel = user.execute(localModel);
			
		}

		@Override
		public void commit() {
			channel.sendCommitFromClient();			
		}
		
		@Override
		public void store() {
			update();
		}
	}

	public Collection<IQuerySpecification<?>> getLocks() {
		return user.getLocks();
	}
	
	public BaseUser getUser() {
		return user;
	}
	
	public double getServerTime() {
		return channel.getServerTime();
	}
	
	private void update() {
		ancestorRevision = new Revision(EcoreUtil.copy(channel.getRemoteRevision().getModel()), channel.getRemoteRevision().getRevision());
		localModel = EcoreUtil.copy(ancestorRevision.getModel());
	}
}
