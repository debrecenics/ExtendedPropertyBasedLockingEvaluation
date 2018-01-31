package org.mondo.collaboration.security.locking.eval.simulation;

import java.util.Collection;

import org.mondo.collaboration.eval.behaviors.IStatemachine;
import org.mondo.collaboration.eval.behaviors.LockingClientBehavior;
import org.mondo.collaboration.eval.behaviors.MergingClientBehavior;
import org.mondo.collaboration.eval.behaviors.mergingclient.MergingClientStatemachine;
import org.mondo.collaboration.eval.behaviors.lockingclient.LockingClientStatemachine;
import org.mondo.collaboration.security.locking.eval.simulation.Configuration.TimeType;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;

public abstract class Event {

	private static final double CONVERTER = 1000000d*60d*60d;
	private double time;
	private IStatemachine client;

	public Event(double time, IStatemachine client) {
		this.time = time;
		this.client = client;
	}

	public void execute() {
		doExecute();
		client.runCycle();
	}

	public abstract void doExecute();
	
	public Collection<Event> nextEvents() {
		if(client instanceof MergingClientBehavior) {
			return nextEvents((MergingClientBehavior) client);
		} else {
			return nextEvents((LockingClientBehavior) client);
		}
	}

	private Collection<Event> nextEvents(MergingClientBehavior client) {
		Builder<Event> builder = ImmutableSet.builder();
		if(client.isStateActive(MergingClientStatemachine.State.main_region_Merging)) {
			double nextEventTime = (double)client.getLastMergeTime() / CONVERTER;
			builder.add(new UploadEvent(time + nextEventTime, client));
		}
		if(client.isStateActive(MergingClientStatemachine.State.main_region_Violation)) {
			builder.add(new UploadEvent(time + Configuration.nextTime(client.getUser().getUsertype(), TimeType.RETRY), client));
		}
		if(client.isStateActive(MergingClientStatemachine.State.main_region_Idle)) {
			builder.add(new UploadEvent(time + Configuration.nextTime(client.getUser().getUsertype(), TimeType.WAIT), client));
		}
		return builder.build();
	}
	
	
	private Collection<Event> nextEvents(LockingClientBehavior client) {
		Builder<Event> builder = ImmutableSet.builder();
		if(client.isStateActive(LockingClientStatemachine.State.main_region_Violation)) {
			builder.add(new RequestEvent(time + Configuration.nextTime(client.getUser().getUsertype(), TimeType.RETRY), client));
		}
		if(client.isStateActive(LockingClientStatemachine.State.main_region_Execute)) {
			builder.add(new FinishEvent(time + Configuration.nextTime(client.getUser().getUsertype(), TimeType.EXEC), client));
		}
		if(client.isStateActive(LockingClientStatemachine.State.main_region_Idle)) {
			builder.add(new RequestEvent(time + Configuration.nextTime(client.getUser().getUsertype(), TimeType.WAIT), client));
		}
		return builder.build();
	}
	
	public double getTime() {
		return time;
	}

	public static class UploadEvent extends Event {

		private MergingClientBehavior client;

		public UploadEvent(double time, MergingClientBehavior client) {
			super(time, client);
			this.client = client;
		}

		@Override
		public void doExecute() {
			client.raiseUpload();
		}

	}

	public static class RequestEvent extends Event {

		private LockingClientBehavior client;

		public RequestEvent(double time, LockingClientBehavior client) {
			super(time, client);
			this.client = client;
		}

		@Override
		public void doExecute() {
			client.raiseRequest();
		}

	}

	public static class FinishEvent extends Event {

		private LockingClientBehavior client;

		public FinishEvent(double time, LockingClientBehavior client) {
			super(time, client);
			this.client = client;
		}

		@Override
		public void doExecute() {
			client.raiseFinish();
		}

	}

}
