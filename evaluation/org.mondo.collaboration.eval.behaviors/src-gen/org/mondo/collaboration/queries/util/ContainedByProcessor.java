package org.mondo.collaboration.queries.util;

import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.mondo.collaboration.queries.ContainedByMatch;
import wt.Module;

/**
 * A match processor tailored for the org.mondo.collaboration.queries.containedBy pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class ContainedByProcessor implements IMatchProcessor<ContainedByMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pParent the value of pattern parameter parent in the currently processed match
   * @param pChild the value of pattern parameter child in the currently processed match
   * 
   */
  public abstract void process(final Module pParent, final Object pChild);
  
  @Override
  public void process(final ContainedByMatch match) {
    process(match.getParent(), match.getChild());
  }
}
