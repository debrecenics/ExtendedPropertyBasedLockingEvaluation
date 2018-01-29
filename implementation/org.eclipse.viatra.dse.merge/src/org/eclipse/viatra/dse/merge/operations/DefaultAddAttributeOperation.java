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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.dse.merge.iq.util.AddAttributeProcessor;
import org.eclipse.viatra.dse.merge.model.Attribute;
import org.eclipse.viatra.dse.merge.util.DSEMergeUtil;

public class DefaultAddAttributeOperation extends AddAttributeProcessor {

	public static void process(EObject pSrc, Attribute pChange) {
		
		@SuppressWarnings("unchecked")
		EList<Object> list = (EList<Object>) pSrc.eGet(pChange.getFeature());
		list.add(pChange.getValue());

		DSEMergeUtil.moveChangeToCompleted(pChange);
	}	

	@Override
	public void _process(EObject pSrc, Attribute pChange) {
		process(pSrc,pChange);
	}

}
