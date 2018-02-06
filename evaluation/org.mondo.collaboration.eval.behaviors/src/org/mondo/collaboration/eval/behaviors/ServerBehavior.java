package org.mondo.collaboration.eval.behaviors;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
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
import org.mondo.collaboration.eval.behaviors.util.Revision;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

public class ServerBehavior extends ServerStatemachine {

	protected Revision latestRevision;
	
	protected Multimap<String, IQuerySpecification<?>> lockMap = ArrayListMultimap.create();
	protected List<IQuerySpecification<?>> lockViolations = Lists.newArrayList();
	protected Map<IQuerySpecification<?>, MatchUpdateListener> listeners = Maps.newHashMap();

	public static final Logger LOGGER = Logger.getLogger(ServerBehavior.class);
	
	private double currentTime = 0d;
	
	private VoidFunction nextCall = null;
	
	protected Channel channel;
	private AdvancedIncQueryEngine engine;

	public ServerBehavior(EObject latestModel) {
		this.latestRevision = new Revision(latestModel,0);
		this.getSCInterface().setSCInterfaceOperationCallback(new OperationCallback());

		try {
			engine = (AdvancedIncQueryEngine) AdvancedIncQueryEngine.on(new EMFScope(latestModel));
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
	}

	public VoidFunction getNextCall() {
		return nextCall;
	}
	
	public Revision getLatestRevision() {
		return latestRevision;
	}
	
	public double getCurrentTime() {
		return currentTime;
	}
	
	protected class OperationCallback implements SCInterfaceOperationCallback {

		@Override
		public void conflict() {
			LOGGER.info(currentTime + ": Conflict message is sent from server to " + channel.getUser());
			channel.sendConflictFromServer();
		}

		@Override
		public void violation() {
			LOGGER.info(currentTime + ": Violation message is sent from server to " + channel.getUser());
			channel.sendViolationFromServer();
		}

		@Override
		public void accepted() {
			LOGGER.info(currentTime + ": Accepted message is sent from server to " + channel.getUser());
			channel.sendAcceptedFromServer();
		}

		@Override
		public void checkCommit() {
			if (channel.getAncestorRevision().getRevision() != latestRevision.getRevision()) {
				nextCall = new VoidFunction() {
					
					@Override
					public void apply() {
						LOGGER.info(currentTime + ": Merge failure event is raised when " + channel.getUser() + "propagated their changes");
						raiseMergeFailure();
						runCycle();
					}
				};
			} else {
				lockViolations.clear();
				channel.executeModelManipulation(latestRevision.getModel());
				for (IQuerySpecification<?> lock : lockViolations) {
					for(String user : lockMap.keySet()) {
						if(!user.equals(channel.getUser()) 
								&& lockMap.get(user).contains(lock)) {
							nextCall = new VoidFunction() {

								@Override
								public void apply() {
									LOGGER.info(currentTime + ": Lock failure event is raised when " + channel.getUser() + "propagated their changes");
									raiseLockFailure();
									runCycle();
								}
							};
							return;
						}
					}
				}
				latestRevision = new Revision(channel.getLocalModel(), latestRevision.getRevision()+1);
				nextCall = new VoidFunction() {

					@Override
					public void apply() {
						LOGGER.info(currentTime + ": Success event is raised when " + channel.getUser() + "propagated their changes");
						raiseSuccess();
						runCycle();
					}
				};
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
	
	public void setCurrentChannel(Channel channel) {
		this.channel = channel;
	}
	
	public void setCurrentTime(double time) {
		this.currentTime = time;
	}
	
	public void executeNextCall() {
		if(nextCall == null) return;
		nextCall.apply();
		nextCall = null;
	}
	
	public static interface VoidFunction {
		public void apply();
	}

}
