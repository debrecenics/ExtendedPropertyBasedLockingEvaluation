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
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.viatra.dse.merge.DSEMergeIdMapper;
import org.eclipse.viatra.dse.merge.iq.util.CreateProcessor;
import org.eclipse.viatra.dse.merge.model.Attribute;
import org.eclipse.viatra.dse.merge.model.Create;
import org.eclipse.viatra.dse.merge.model.Feature;
import org.eclipse.viatra.dse.merge.scope.DSEMergeScope;
import org.eclipse.viatra.dse.merge.util.DSEMergeUtil;

import com.google.common.collect.Lists;

public class DefaultCreateOperation extends CreateProcessor {

	private DSEMergeIdMapper idMapper;

    public DefaultCreateOperation(DSEMergeIdMapper idMapper) {
        this.idMapper = idMapper;
    }

    public static void process(EObject pContainer, Create pChange, DSEMergeIdMapper mapper) {
		
        EObject element = (EObject) EcoreUtil.create(pChange.getClazz());
		EStructuralFeature feature = mapper.getIdFeature(element);
		element.eSet(feature, DSEMergeUtil.getId(pChange.getSrc()));

		if (pChange.getFeature().isMany()) {
			@SuppressWarnings("unchecked")
			EList<EObject> list = (EList<EObject>) pContainer.eGet(pChange.getFeature());
			list.add(element);
		} else {
			pContainer.eSet(pChange.getFeature(), element);
		}

		/*DSEMergeScope scope = (DSEMergeScope) pChange.eContainer().eContainer();
		for (Feature f : Lists.newArrayList(pChange.getFeatures())) {
		    if(scope.getCompleted().contains(f))
		        continue;
		    
			if(f instanceof Attribute) {
				Attribute attribute = (Attribute) f;
				switch (attribute.getKind()) {
				case ADD:
				    DefaultAddAttributeOperation.process(element, attribute);
					break;
				case REMOVE:
					DefaultRemoveAttributeOperation.process(element, attribute);
					break;
				case SET:
					DefaultSetAttributeOperation.process(element, attribute);
					break;
				case UNSET:
				default:
					break;
				}
			}
		}*/

		DSEMergeUtil.moveChangeToCompleted(pChange);
	}

	@Override
	public void _process(EObject pContainer, Create pChange) {
		process(pContainer, pChange, idMapper);
	}

}
