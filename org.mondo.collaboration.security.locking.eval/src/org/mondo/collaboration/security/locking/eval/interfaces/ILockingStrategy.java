package org.mondo.collaboration.security.locking.eval.interfaces;

public interface ILockingStrategy {

	public ILock createLock();

	public ILock getLock();

}
