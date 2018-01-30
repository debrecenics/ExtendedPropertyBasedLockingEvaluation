package org.mondo.collaboration.queries.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.mondo.collaboration.queries.UserT0Match;
import wt.Control;
import wt.Signal;

/**
 * A match processor tailored for the org.mondo.collaboration.queries.userT0 pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class UserT0Processor implements IMatchProcessor<UserT0Match> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pCtrl the value of pattern parameter ctrl in the currently processed match
   * @param pSgn the value of pattern parameter sgn in the currently processed match
   * @param pC the value of pattern parameter c in the currently processed match
   * @param pT the value of pattern parameter t in the currently processed match
   * 
   */
  public abstract void process(final Control pCtrl, final Signal pSgn, final String pC, final String pT);
  
  @Override
  public void process(final UserT0Match match) {
    process(match.getCtrl(), match.getSgn(), match.getC(), match.getT());
  }
}
