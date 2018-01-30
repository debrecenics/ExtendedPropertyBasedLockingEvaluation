package org.mondo.collaboration.eval.behaviors;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.api.IMatchUpdateListener;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.eval.behaviors.ServerBehavior.OperationCallback.MatchUpdateListener;
import org.mondo.collaboration.eval.behaviors.server.ServerStatemachine;
import org.mondo.collaboration.eval.behaviors.util.Channel;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

public class ServerBehavior extends ServerStatemachine {

	protected EObject latestModel;
	
	protected Multimap<String, IQuerySpecification<?>> lockMap = ArrayListMultimap.create();
	protected List<IQuerySpecification<?>> lockViolations = Lists.newArrayList();
	protected Map<IQuerySpecification<?>, MatchUpdateListener> listeners = Maps.newHashMap();

	protected Channel channel;
	private AdvancedIncQueryEngine engine;

	public ServerBehavior(EObject latestModel) {
		this.latestModel = latestModel;
		this.getSCInterface().setSCInterfaceOperationCallback(new OperationCallback());

		try {
			engine = (AdvancedIncQueryEngine) AdvancedIncQueryEngine.on(new EMFScope(latestModel));
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	public EObject getLatestModel() {
		return latestModel;
	}
	
	protected class OperationCallback implements SCInterfaceOperationCallback {

		@Override
		public void conflict() {
			channel.sendConflictFromServer();
		}

		@Override
		public void violation() {
			channel.sendViolationFromServer();
		}

		@Override
		public void accepted() {
			channel.sendAcceptedFromServer();
		}

		@Override
		public void checkCommit() {
			IComparisonScope scope = new DefaultComparisonScope(
					channel.getLocalModel(), latestModel,
					channel.getAncestorModel());
			Comparison comparison = EMFCompare.builder().build().compare(scope);

			if (!comparison.getConflicts().isEmpty()) {
				raiseMergeFailure();
			} else {
				lockViolations.clear();
				channel.executeModelManipulation(latestModel);
				for (IQuerySpecification<?> lock : lockViolations) {
					for(String user : lockMap.keySet()) {
						if(!user.equals(channel.getUser()) 
								&& lockMap.get(user).contains(lock)) {
							raiseLockFailure();
							return;
						}
					}
				}
				raiseSuccess();
			}
		}

		@Override
		public void lockRelease() {
			String user = channel.getUser();
			Collection<IQuerySpecification<?>> locks = channel.getReleasedLocks();
			for (IQuerySpecification<?> lock : locks) {
				lockMap.get(user).remove(lock);
				MatchUpdateListener listener = listeners.get(lock);
				try {
					engine.removeMatchUpdateListener((IncQueryMatcher<?>) engine.getMatcher(lock), listener);
					listeners.remove(lock, listener);
				} catch (IncQueryException e) {
					e.printStackTrace();
				}
			}
		}

		@Override
		public void lockRequest() {
			String user = channel.getUser();
			Collection<IQuerySpecification<?>> locks = channel.getRequestedLocks();
			for (IQuerySpecification<?> lock : locks) {
				lockMap.put(user, lock);
	
				try {
					IncQueryMatcher<?> matcher = lock.getMatcher(engine);
					MatchUpdateListener listener = new MatchUpdateListener(lock);
					engine.addMatchUpdateListener(matcher, listener, false);
					listeners.put(lock, listener);
				} catch (IncQueryException e) {
					e.printStackTrace();
				}
			}
		}

		protected final class MatchUpdateListener implements IMatchUpdateListener<IPatternMatch> {

			IQuerySpecification<?> lock;

			public MatchUpdateListener(IQuerySpecification<?> lock) {
				this.lock = lock;
			}

			@Override
			public void notifyAppearance(IPatternMatch match) {
				lockViolations.add(lock);
			}

			@Override
			public void notifyDisappearance(IPatternMatch match) {
				lockViolations.add(lock);
			}
		}

	}

}
