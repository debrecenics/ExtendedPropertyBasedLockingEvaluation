package org.mondo.collaboration.eval.behaviors;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.dse.merge.DSEMergeManager;
import org.eclipse.viatra.dse.merge.DSEMergeManager.Solution;
import org.eclipse.viatra.dse.merge.emf.compare.EMFCompareTranslator;
import org.eclipse.viatra.dse.merge.model.ChangeSet;
import org.mondo.collaboration.eval.behaviors.mergingclient.MergingClientStatemachine;
import org.mondo.collaboration.eval.behaviors.users.BaseUser;
import org.mondo.collaboration.eval.behaviors.util.Channel;
import org.mondo.collaboration.eval.behaviors.util.Channel.MergeBasedChannel;
import org.mondo.collaboration.eval.behaviors.util.IRaiseFunction;
import org.mondo.collaboration.eval.behaviors.util.Revision;

import com.google.common.collect.Lists;

import wt.merge.MergeConfigurator;

public class MergingClientBehavior extends MergingClientStatemachine {

	BaseUser user;
	EObject localModel;
	Revision ancestorRevision;
	private MergeBasedChannel channel;
	List<Long> mergeTime = Lists.newArrayList();
	List<Double> retryTime = Lists.newArrayList();
	
	IRaiseFunction nextCall = null;
	
	Logger LOGGER = Logger.getLogger(MergingClientBehavior.class);
	
	public MergingClientBehavior(BaseUser user, ServerBehavior server) {
		this.user = user;
		
		ancestorRevision = server.getLatestRevision();
		localModel = ancestorRevision.getModel();
		
		getSCInterface().setSCInterfaceOperationCallback(new OperationCallback());
		channel = Channel.createMergeBasedChannel(server, this);
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

	public long getLastMergeTime() {
		return mergeTime.get(mergeTime.size()-1);
	}
	
	public long getMergeTime() {
		return mergeTime.stream().reduce(0l, Long::sum);
	}
	
	public double getRetryTime() {
		return retryTime.stream().reduce(0d, Double::sum);
	}
	
	private final class OperationCallback implements SCInterfaceOperationCallback {
		private final MergeConfigurator MERGE_CONFIGURATOR = new MergeConfigurator();
		private double waitStart;

		@Override
		public void resolve() {
			LOGGER.info(user.getUsername() + " is resolving the merge");
			long start = System.nanoTime();
			IComparisonScope scopeLO = new DefaultComparisonScope(
					channel.getLocalModel(), 
					channel.getAncestorRevision().getModel(), null);			
			
			Comparison comparisonLO = EMFCompare.builder().build().compare(scopeLO);
			ChangeSet changeSetLO = new EMFCompareTranslator().translate(comparisonLO, MERGE_CONFIGURATOR.getIdMapper());
			
			IComparisonScope scopeRO = new DefaultComparisonScope(
					channel.getRemoteRevision().getModel(), 
					channel.getAncestorRevision().getModel(), null);			
			
			Comparison comparisonRO = EMFCompare.builder().build().compare(scopeRO);
			ChangeSet changeSetRO = new EMFCompareTranslator().translate(comparisonRO, MERGE_CONFIGURATOR.getIdMapper());
			
			DSEMergeManager manager = DSEMergeManager.create(channel.getAncestorRevision().getModel(), changeSetLO, changeSetRO, MERGE_CONFIGURATOR);
			Solution solution = manager.start().iterator().next();
			localModel = solution.getScope().getOrigin();
			long end = System.nanoTime();
			mergeTime.add(end-start);			
		}

		@Override
		public void execute() {
			localModel = user.execute(localModel);
			LOGGER.info(user.getUsername() + " has modified the model");
		}

		@Override
		public void commit() {
			channel.sendCommitFromClient();
			LOGGER.info(user.getUsername() + " has commited the changes");
		}

		@Override
		public void store() {
			ancestorRevision = channel.getRemoteRevision();
			localModel = ancestorRevision.getModel();
		}

		@Override
		public void violationStart() {
			waitStart = channel.getServerTime();
		}

		@Override
		public void violationEnd() {
			double waitEnd = channel.getServerTime();
			retryTime.add(waitEnd - waitStart);
		}
	}

	public BaseUser getUser() {
		return user;
	}
	
	public double getServerTime() {
		return channel.getServerTime();
	}
}
