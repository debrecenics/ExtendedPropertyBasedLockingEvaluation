package org.mondo.collaboration.queries.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.mondo.collaboration.queries.UserR1Match;
import wt.Composite;

/**
 * A match processor tailored for the org.mondo.collaboration.queries.userR1 pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class UserR1Processor implements IMatchProcessor<UserR1Match> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pVendor the value of pattern parameter vendor in the currently processed match
   * @param pObject the value of pattern parameter object in the currently processed match
   * @param pComposite the value of pattern parameter composite in the currently processed match
   * 
   */
  public abstract void process(final String pVendor, final Object pObject, final Composite pComposite);
  
  @Override
  public void process(final UserR1Match match) {
    process(match.getVendor(), match.getObject(), match.getComposite());
  }
}
