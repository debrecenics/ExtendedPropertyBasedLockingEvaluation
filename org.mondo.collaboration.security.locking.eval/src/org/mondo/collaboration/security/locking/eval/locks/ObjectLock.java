package org.mondo.collaboration.security.locking.eval.locks;

import java.util.Collection;

import org.mondo.collaboration.security.locking.eval.interfaces.ILock;

public class ObjectLock implements ILock {

	Collection<Object> lockedObjects;
	String user;

	public ObjectLock(Collection<Object> lockedObjects, String user) {
		this.lockedObjects = lockedObjects;
		this.user = user;
	}
	
	public Collection<Object> getLockedObjects() {
		return lockedObjects;
	}	
	
	public String getUser() {
		return user;
	}
	
}
