package org.mondo.collaboration.security.locking.eval.locks;

import java.util.Collection;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceSource;
import org.eclipse.emf.ecore.EObject;
import org.mondo.collaboration.security.locking.eval.interfaces.ILock;
import org.mondo.collaboration.security.locking.eval.interfaces.ILockContainer;
import org.mondo.collaboration.security.locking.eval.utility.ComparisonUtility;
import org.mondo.collaboration.security.locking.eval.utility.DomainSpecificIdentification;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class ObjectLockContainer implements ILockContainer {

	Multimap<String,Object> lockedObjects = ArrayListMultimap.create();

	@Override
	public boolean evaluate(EObject local, EObject remote, String user) {
		Comparison comparison = ComparisonUtility.compare(local, remote);
		for (Diff diff : comparison.getDifferences()) {
			if(diff.getSource() == DifferenceSource.LEFT) {
				EObject origin = diff.getMatch().getOrigin();
				if(origin != null) {
					Object identifier = DomainSpecificIdentification.getIdentifier(origin);
					if(lockedObjects.containsValue(identifier))
						return false;
				}
			}
		}
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
