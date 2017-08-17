package org.mondo.collaboration.security.locking.eval.interfaces;

import org.eclipse.emf.ecore.EObject;

public interface IClientOperation {

	public EObject resolve();

	public EObject executeModification(EObject original);
	
}
