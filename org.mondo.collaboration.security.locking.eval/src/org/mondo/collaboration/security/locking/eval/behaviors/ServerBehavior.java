package org.mondo.collaboration.security.locking.eval.behaviors;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.mondo.collaboration.security.locking.eval.interfaces.ILock;
import org.mondo.collaboration.security.locking.eval.interfaces.ILockContainer;

public class ServerBehavior {

	EObject remote;
	EObject local;
	EObject original;
	ILockContainer locks;
	
	public Response lock(ILock lock) {
		if(locks.addLock(lock))
			return Response.SUCCESS;
		return Response.FAILURE;
	}
	
	public Response unlock(ILock lock) {
		Response response = Response.SUCCESS;
		if(!locks.evaluate(local, remote))
			response = Response.FAILURE;
		
		if(hasConflict())
			response = Response.CONFLICT;
		locks.removeLock(lock);
		return response;
	}

	public final boolean hasConflict() {
		IComparisonScope scope = new DefaultComparisonScope(local, remote, original);
		Comparison comparison = EMFCompare.builder().build().compare(scope);
		if(comparison.getConflicts().isEmpty())	
			return false;
		return true;
	}
	
	public void executeModification(EObject local, EObject original) {
		this.local = local;
		this.original = original;
	}
	
	public EObject getCopyOfCurrentModel() {
		Copier copier = new EcoreUtil.Copier();
		return copier.copy(remote);
	}
	
	enum Response {
		CONFLICT, SUCCESS, FAILURE
	}
	
}
