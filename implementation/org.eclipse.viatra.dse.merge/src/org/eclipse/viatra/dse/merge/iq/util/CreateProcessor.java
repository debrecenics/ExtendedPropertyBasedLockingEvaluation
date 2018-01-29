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
import org.eclipse.viatra.dse.merge.iq.CreateMatch;
import org.eclipse.viatra.dse.merge.model.Create;

/**
 * A match processor tailored for the org.eclipse.viatra.dse.merge.iq.create pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class CreateProcessor implements IMatchProcessor<CreateMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pContainer the value of pattern parameter container in the currently processed match
   * @param pChange the value of pattern parameter change in the currently processed match
   * 
   */
  public abstract void _process(final EObject pContainer, final Create pChange);
  
  @Override
  public void process(final CreateMatch match) {
    _process(match.getContainer(), match.getChange());
  }
}
