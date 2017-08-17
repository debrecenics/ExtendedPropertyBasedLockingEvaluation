package org.mondo.collaboration.security.locking.eval.interfaces;

import org.eclipse.emf.ecore.EObject;

public interface ILockContainer {

	public boolean evaluate(EObject newModel, EObject currentModel, String activeUser);
	
	public boolean addLock(ILock lock);
	
	public void removeLock(ILock lock);
}
