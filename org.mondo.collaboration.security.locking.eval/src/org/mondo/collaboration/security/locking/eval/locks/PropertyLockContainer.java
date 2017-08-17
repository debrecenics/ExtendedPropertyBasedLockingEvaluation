package org.mondo.collaboration.security.locking.eval.locks;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.incquery.patternlanguage.emf.specification.SpecificationBuilder;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.base.api.BaseIndexOptions;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.security.lens.arbiter.LockArbiter;
import org.mondo.collaboration.security.lens.arbiter.LockArbiter.LockMonitoringSession;
import org.mondo.collaboration.security.lens.arbiter.SecurityArbiter;
import org.mondo.collaboration.security.locking.eval.interfaces.ILock;
import org.mondo.collaboration.security.locking.eval.interfaces.ILockContainer;
import org.mondo.collaboration.security.macl.xtext.mondoAccessControlLanguage.Policy;
import org.mondo.collaboration.security.mpbl.xtext.mondoPropertyBasedLocking.PropertyBasedLockingModel;

public class PropertyLockContainer implements ILockContainer {

	private PropertyBasedLockingModel lockingModel;
	public PropertyLockContainer(PropertyBasedLockingModel lockingModel) {
		this.lockingModel = lockingModel;
	}
	
	@Override
	public boolean evaluate(EObject newModel, EObject currentModel, String user) {
		try {
			ResourceSetImpl rSet = new ResourceSetImpl();
			Resource modelResource = rSet.createResource(URI.createURI("gold.xmi"));
			modelResource.getContents().add(currentModel);
			SecurityArbiter secArbiter = new DummySecurityArbiter(modelResource);
			LockArbiter lockArbiter = new LockArbiter(secArbiter, lockingModel);
			LockMonitoringSession session = lockArbiter.openSession(user);
			modelResource.getContents().remove(currentModel);
			modelResource.getContents().add(newModel);
			return session.getAnyLockViolation() == null;			
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean addLock(ILock lock) {
		if(lock instanceof PropertyLock) {
			PropertyLock propertyLock = (PropertyLock) lock;
			lockingModel.getLocks().add(propertyLock.getLock());
			return true;
		}
		throw new IllegalArgumentException();
	}

	@Override
	public void removeLock(ILock lock) {
		if(lock instanceof PropertyLock) {
			PropertyLock propertyLock = (PropertyLock) lock;
			lockingModel.getLocks().remove(propertyLock.getLock());
		}
		throw new IllegalArgumentException();
	}	
	
	private static class DummySecurityArbiter extends SecurityArbiter {
		
		private AdvancedIncQueryEngine policyQueryEngine;
		private Resource model;
		private BaseIndexOptions indexOptions;
		private SpecificationBuilder specBuilder;
		
		public DummySecurityArbiter(Resource model) throws IncQueryException {
			super(null, null, null, null);
			this.model = model;
			this.indexOptions = new BaseIndexOptions();
			reinitialize();
		}
		
		@Override
		public void reinitializeWith(Policy policy) throws IncQueryException {
			if(model != null)
				reinitialize();
		}
		
		@Override
		public void reinitializeWith(Resource policy) throws IncQueryException {
			if(model != null)
				reinitialize();
		}

		private void reinitialize() throws IncQueryException {
			if (policyQueryEngine != null) 
				policyQueryEngine.wipe();
			else 
				policyQueryEngine = AdvancedIncQueryEngine.createUnmanagedEngine(
						new EMFScope(this.model, this.indexOptions));
			this.specBuilder = new SpecificationBuilder();
		}
		
		@Override
		public AdvancedIncQueryEngine getPolicyQueryEngine() {
			return policyQueryEngine;
		}
		
		@Override
		public SpecificationBuilder getSpecBuilder() {
			return specBuilder;
		}
	
	}

}
