package org.mondo.collaboration.security.locking.eval.locks;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.mondo.collaboration.security.locking.eval.interfaces.ILock;
import org.mondo.collaboration.security.locking.eval.interfaces.ILockContainer;

import com.google.common.collect.Lists;

public class ObjectLockContainers implements ILockContainer {

	Collection<Object> lockedObjects = Lists.newArrayList();

	@Override
	public boolean evaluate(EObject newModel, EObject currentModel) {
		return true;
	}

	@Override
	public boolean addLock(ILock lock) {
		if(lock instanceof ObjectLock) {
			ObjectLock objectLock = (ObjectLock) lock;
			Collection<Object> objectsToLock = objectLock.getLockedObjects();
			for (Object object : objectsToLock) {
				if(lockedObjects.contains(object)) 
					return false;
			}
			lockedObjects.addAll(objectsToLock);
			return true;
		}
		throw new IllegalArgumentException();
	}

	@Override
	public void removeLock(ILock lock) {
		if(lock instanceof ObjectLock) {
			ObjectLock objectLock = (ObjectLock) lock;
			Collection<Object> objectsToLock = objectLock.getLockedObjects();
			lockedObjects.removeAll(objectsToLock);
		}
		throw new IllegalArgumentException();
	}
	
}
