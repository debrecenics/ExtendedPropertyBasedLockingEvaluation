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

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.viatra.dse.merge.iq.GoalPatternMatch;

/**
 * A match processor tailored for the org.eclipse.viatra.dse.merge.iq.goalPattern pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class GoalPatternProcessor implements IMatchProcessor<GoalPatternMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * 
   */
  public abstract void _process();
  
  @Override
  public void process(final GoalPatternMatch match) {
    _process();
  }
}
