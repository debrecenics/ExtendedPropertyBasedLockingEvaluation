package org.mondo.collaboration.eval.behaviors;

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
import org.mondo.collaboration.eval.behaviors.util.Channel;
import org.mondo.collaboration.eval.behaviors.util.Channel.MergeBasedChannel;
import org.mondo.collaboration.eval.behaviors.util.IModelManipulator;

import wt.merge.MergeConfigurator;

public class MergingClientBehavior extends MergingClientStatemachine {

	String user;
	EObject localModel;
	EObject ancestorModel;
	IModelManipulator manipulator;
	private MergeBasedChannel channel;

	public MergingClientBehavior(String user, IModelManipulator manipulator, ServerBehavior server) {
		this.user = user;
		this.manipulator = manipulator;

		getSCInterface().setSCInterfaceOperationCallback(new OperationCallback());
		channel = Channel.createMergeBasedChannel(server, this);
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
		public void resolve() {
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

}
