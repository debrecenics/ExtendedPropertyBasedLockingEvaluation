package org.mondo.collaboration.security.locking.eval.locks;

import org.mondo.collaboration.security.locking.eval.interfaces.ILock;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.Lock;

public class PropertyLock implements ILock {

	private Lock lock;

	public PropertyLock(Lock lock) {
		this.lock = lock;
	}
	
	public Lock getLock() {
		return lock;
	}
	
	public String getUser() {
		return lock.getOwner().getName();
	}
	
}
