package org.mondo.collaboration.queries.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.mondo.collaboration.queries.UserM1Match;
import wt.Control;
import wt.Signal;

/**
 * A match processor tailored for the org.mondo.collaboration.queries.userM1 pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class UserM1Processor implements IMatchProcessor<UserM1Match> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCtrl the value of pattern parameter ctrl in the currently processed match
   * @param pSgn the value of pattern parameter sgn in the currently processed match
   * @param pF the value of pattern parameter f in the currently processed match
   * 
   */
  public abstract void process(final Control pCtrl, final Signal pSgn, final Integer pF);
  
  @Override
  public void process(final UserM1Match match) {
    process(match.getCtrl(), match.getSgn(), match.getF());
  }
}
