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
package org.eclipse.viatra.dse.merge;

import org.eclipse.viatra.dse.statecode.IStateCoder;
import org.eclipse.viatra.dse.statecode.IStateCoderFactory;

/**
 * State Coder Factory for DSE Merge
 * @author Csaba Debreceni
 *
 */
public class DSEMergeSerializerFactory implements IStateCoderFactory {

	private DSEMergeIdMapper idMapper;

    public DSEMergeSerializerFactory(DSEMergeIdMapper idMapper) {
	    this.idMapper = idMapper;
    }

    @Override
	public IStateCoder createStateCoder() {
		return new DSEMergeSerializer(idMapper);
	}

}
