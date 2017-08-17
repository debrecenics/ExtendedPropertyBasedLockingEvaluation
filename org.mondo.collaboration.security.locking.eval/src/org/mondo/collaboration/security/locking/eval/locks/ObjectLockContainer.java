package org.mondo.collaboration.security.locking.eval.locks;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.mondo.collaboration.security.locking.eval.interfaces.ILock;
import org.mondo.collaboration.security.locking.eval.interfaces.ILockContainer;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class ObjectLockContainer implements ILockContainer {

	Multimap<String,Object> lockedObjects = ArrayListMultimap.create();

	@Override
	public boolean evaluate(EObject newModel, EObject currentModel, String user) {
		//TODO: evaluate changes
		return true;
	}

	@Override
	public boolean addLock(ILock lock) {
		if(lock instanceof ObjectLock) {
			ObjectLock objectLock = (ObjectLock) lock;
			Collection<Object> objectsToLock = objectLock.getLockedObjects();
			for (Object object : objectsToLock) {
				if(lockedObjects.containsValue(object)) 
					return false;
			}
			lockedObjects.putAll(objectLock.getUser(), objectsToLock);
			return true;
		}
		throw new IllegalArgumentException();
	}

	@Override
	public void removeLock(ILock lock) {
		if(lock instanceof ObjectLock) {
			ObjectLock objectLock = (ObjectLock) lock;
			Collection<Object> objectsToLock = objectLock.getLockedObjects();
			lockedObjects.get(objectLock.getUser()).removeAll(objectsToLock);
		}
		throw new IllegalArgumentException();
	}
	
}
