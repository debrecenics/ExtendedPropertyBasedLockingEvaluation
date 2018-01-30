package org.mondo.collaboration.queries.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.mondo.collaboration.queries.UserRSignalFrequencyMatch;
import wt.Composite;
import wt.Signal;

/**
 * A match processor tailored for the org.mondo.collaboration.queries.userRSignalFrequency pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class UserRSignalFrequencyProcessor implements IMatchProcessor<UserRSignalFrequencyMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pVendor the value of pattern parameter vendor in the currently processed match
   * @param pObject the value of pattern parameter object in the currently processed match
   * @param pFrequency the value of pattern parameter frequency in the currently processed match
   * @param pComposite the value of pattern parameter composite in the currently processed match
   * 
   */
  public abstract void process(final String pVendor, final Signal pObject, final Integer pFrequency, final Composite pComposite);
  
  @Override
  public void process(final UserRSignalFrequencyMatch match) {
    process(match.getVendor(), match.getObject(), match.getFrequency(), match.getComposite());
  }
}
