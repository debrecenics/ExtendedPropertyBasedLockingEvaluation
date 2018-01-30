package org.mondo.collaboration.security.locking.eval.simulation;

import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;

public class Simulator {

	List<Event> queue = Lists.newArrayList();
	
	public void addEvent(Event event) {
		queue.add(event);
	}
	
	public void clear() {
		queue.clear();
	}
	
	public void simulate() {
		sortQueue();
		for (Event event : queue) {
			event.execute();
		}
	}
	
	private void sortQueue() {
		queue.sort(new Comparator<Event>() {

			@Override
			public int compare(Event o1, Event o2) {
				if (o1.getTime() < o2.getTime())
					return -1;
				if (o1.getTime() > o2.getTime())
					return 1;
				return 0;
				
			}
		});
	}
	
	public abstract static class Event {
		
		private long time;

		public Event(long time) {
			this.time = time;
		}
		
		public abstract void execute();
		
		public long getTime() {
			return time;
		}
		
	}
}
