/*******************************************************************************
 * Copyright (c) 2010-2015, Csaba Debreceni, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Csaba Debreceni - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.merge.operations;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.viatra.dse.merge.DSEMergeStrategy;
import org.eclipse.viatra.dse.merge.iq.util.UnsetReferenceProcessor;
import org.eclipse.viatra.dse.merge.model.Change;
import org.eclipse.viatra.dse.merge.model.Delete;
import org.eclipse.viatra.dse.merge.model.Feature;
import org.eclipse.viatra.dse.merge.model.Reference;
import org.eclipse.viatra.dse.merge.scope.DSEMergeScope;
import org.eclipse.viatra.dse.merge.util.DSEMergeUtil;

public class DefaultUnsetReferenceOperation extends UnsetReferenceProcessor {

	public static void process(EObject pSrc, Reference pChange) {
		pSrc.eSet(pChange.getFeature(), null);
	
		DSEMergeScope pScope = (DSEMergeScope) pChange.eContainer().eContainer();
		update(pScope, pChange, pSrc);
		
		EcoreUtil.delete(pChange);
	}

	private static void update(DSEMergeScope pScope, Reference pChange, EObject pSrc) {
		for(Delete d : DSEMergeStrategy.deleteDependencies.get(DSEMergeUtil.getId(pChange.getSrc()))) {
			d.setExecutable(false);;
		}
		
		if (pScope.getRemote().getChanges().contains(pChange)) {
			for (Change change : pScope.getLocal().getChanges()) {
				setToFalse(pChange, change);
				if(change instanceof Feature && ((Feature) change).getFeature() == getIdFeature(pSrc)) {
					change.setExecutable(false);
				}
			}
		}

		if (pScope.getLocal().getChanges().contains(pChange)) {
			for (Change change : pScope.getRemote().getChanges()) {
				setToFalse(pChange, change);
				if(change instanceof Feature && ((Feature) change).getFeature() == getIdFeature(pSrc)) {
					change.setExecutable(false);
				}
			}
		}
	}

	private static void setToFalse(Reference pChange, Change change) {
		if (change instanceof Reference) {
			Reference _change = (Reference) change;
			if (DSEMergeUtil.getId(_change.getSrc()) == DSEMergeUtil.getId(pChange.getSrc()) && _change.getFeature() == pChange.getFeature())
				_change.setExecutable(false);
		}
	}
	
	private static EStructuralFeature getIdFeature(EObject pSrc) {
		return pSrc.eClass().getEStructuralFeature("id");
	}

	@Override
	public void _process(EObject pSrc, Reference pChange) {
		process(pSrc, pChange);
	}
}
