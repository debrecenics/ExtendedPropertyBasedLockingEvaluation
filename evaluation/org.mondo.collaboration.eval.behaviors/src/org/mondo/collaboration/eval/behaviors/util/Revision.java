package org.mondo.collaboration.eval.behaviors.util;

import org.eclipse.emf.ecore.EObject;

public class Revision {

	EObject model;
	int revision;
	
	public Revision(EObject model, int revision) {
		this.model = model;
		this.revision = revision;
	}
	
	public EObject getModel() {
		return model;
	}
	
	public int getRevision() {
		return revision;
	}

}
