package org.mondo.collaboration.eval.behaviors;

import java.util.List;

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

import com.google.common.collect.Lists;

import wt.merge.MergeConfigurator;

public class MergingClientBehavior extends MergingClientStatemachine {

	BaseUser user;
	EObject localModel;
	EObject ancestorModel;
	private MergeBasedChannel channel;
	List<Long> mergeTime = Lists.newArrayList();
	List<Double> retryTime = Lists.newArrayList();
	
	public MergingClientBehavior(BaseUser user, ServerBehavior server) {
		this.user = user;
		
		getSCInterface().setSCInterfaceOperationCallback(new OperationCallback());
		channel = Channel.createMergeBasedChannel(server, this);
	}

	public String getUsername() {
		return user.getUsername();
	}

	public void execute(EObject model) {
		localModel = user.execute(model);
	}

	public EObject getAncestorModel() {
		return ancestorModel;
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
		private double waitStart;

		@Override
		public void resolve() {
			long start = System.nanoTime();
			IComparisonScope scopeLO = new DefaultComparisonScope(
					channel.getLocalModel(), 
					channel.getAncestorModel(), null);			
			
			Comparison comparisonLO = EMFCompare.builder().build().compare(scopeLO);
			ChangeSet changeSetLO = new EMFCompareTranslator().translate(comparisonLO, new MergeConfigurator().getIdMapper());
			
			IComparisonScope scopeRO = new DefaultComparisonScope(
					channel.getLocalModel(), 
					channel.getAncestorModel(), null);			
			
			Comparison comparisonRO = EMFCompare.builder().build().compare(scopeRO);
			ChangeSet changeSetRO = new EMFCompareTranslator().translate(comparisonRO, new MergeConfigurator().getIdMapper());
			
			DSEMergeManager manager = DSEMergeManager.create(ancestorModel, changeSetLO, changeSetRO);
			Solution solution = manager.start().iterator().next();
			localModel = solution.getScope().getOrigin();
			long end = System.nanoTime();
			mergeTime.add(end-start);			
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
			localModel = channel.getRemoteModel();
			ancestorModel = channel.getRemoteModel();
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

}
