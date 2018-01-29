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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.viatra.dse.merge.iq.util.DeleteProcessor;
import org.eclipse.viatra.dse.merge.model.Delete;
import org.eclipse.viatra.dse.merge.scope.DSEMergeScope;
import org.eclipse.viatra.dse.merge.util.DSEMergeUtil;

public class DefaultDeleteOperation extends DeleteProcessor {

	public static void process(EObject pSrc, Delete pChange) {
		DSEMergeScope pScope = (DSEMergeScope) pChange.eContainer().eContainer();
		DSEMergeUtil.moveChangeToCompleted(pChange);		
		EcoreUtil.delete(pSrc);
		pScope.getCemetery().getObjects().add(pSrc);
	}

	@Override
	public void _process(EObject pSrc, Delete pChange) {
		process(pSrc, pChange);
	}

}
