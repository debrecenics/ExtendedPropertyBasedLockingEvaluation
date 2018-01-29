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
package org.eclipse.viatra.dse.merge.iq.util;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.viatra.dse.merge.iq.RemoveReferenceMatch;
import org.eclipse.viatra.dse.merge.model.Reference;

/**
 * A match processor tailored for the org.eclipse.viatra.dse.merge.iq.removeReference pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class RemoveReferenceProcessor implements IMatchProcessor<RemoveReferenceMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSrc the value of pattern parameter src in the currently processed match
   * @param pTrg the value of pattern parameter trg in the currently processed match
   * @param pChange the value of pattern parameter change in the currently processed match
   * 
   */
  public abstract void _process(final EObject pSrc, final EObject pTrg, final Reference pChange);
  
  @Override
  public void process(final RemoveReferenceMatch match) {
    _process(match.getSrc(), match.getTrg(), match.getChange());
  }
}
