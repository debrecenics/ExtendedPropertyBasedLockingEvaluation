package org.mondo.collaboration.security.locking.eval.locks;

import java.util.Collection;

import org.mondo.collaboration.security.locking.eval.interfaces.ILock;

public class ObjectLock implements ILock {

	Collection<Object> lockedObjects;

	public ObjectLock(Collection<Object> lockedObjects) {
		this.lockedObjects = lockedObjects;
	}
	
	public Collection<Object> getLockedObjects() {
		return lockedObjects;
	}	
	
}
