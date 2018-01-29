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
package org.eclipse.viatra.dse.merge.iq;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.dse.merge.iq.CreateMatch;
import org.eclipse.viatra.dse.merge.iq.CreateMatcher;
import org.eclipse.viatra.dse.merge.iq.util.CreateProcessor;

import java.util.Arrays;
import java.util.List;

import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.merge.iq.util.CreateQuerySpecification;
import org.eclipse.viatra.dse.merge.model.Create;

/**
 * Pattern-specific match representation of the org.eclipse.viatra.dse.merge.iq.create pattern,
 * to be used in conjunction with {@link CreateMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see CreateMatcher
 * @see CreateProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class CreateMatch extends BasePatternMatch {
  private EObject fContainer;
  
  private Create fChange;
  
  private static List<String> parameterNames = makeImmutableList("container", "change");
  
  private CreateMatch(final EObject pContainer, final Create pChange) {
    this.fContainer = pContainer;
    this.fChange = pChange;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("container".equals(parameterName)) return this.fContainer;
    if ("change".equals(parameterName)) return this.fChange;
    return null;
  }
  
  public EObject getContainer() {
    return this.fContainer;
  }
  
  public Create getChange() {
    return this.fChange;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("container".equals(parameterName) ) {
    	this.fContainer = (org.eclipse.emf.ecore.EObject) newValue;
    	return true;
    }
    if ("change".equals(parameterName) ) {
    	this.fChange = (org.eclipse.viatra.dse.merge.model.Create) newValue;
    	return true;
    }
    return false;
  }
  
  public void setContainer(final EObject pContainer) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fContainer = pContainer;
  }
  
  public void setChange(final Create pChange) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fChange = pChange;
  }
  
  @Override
  public String patternName() {
    return "org.eclipse.viatra.dse.merge.iq.create";
  }
  
  @Override
  public List<String> parameterNames() {
    return CreateMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fContainer, fChange};
  }
  
  @Override
  public CreateMatch toImmutable() {
    return isMutable() ? newMatch(fContainer, fChange) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"container\"=" + prettyPrintValue(fContainer) + ", ");
    
    result.append("\"change\"=" + prettyPrintValue(fChange)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fContainer == null) ? 0 : fContainer.hashCode());
    result = prime * result + ((fChange == null) ? 0 : fChange.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof CreateMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    CreateMatch other = (CreateMatch) obj;
    if (fContainer == null) {if (other.fContainer != null) return false;}
    else if (!fContainer.equals(other.fContainer)) return false;
    if (fChange == null) {if (other.fChange != null) return false;}
    else if (!fChange.equals(other.fChange)) return false;
    return true;
  }
  
  @Override
  public CreateQuerySpecification specification() {
    try {
    	return CreateQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static CreateMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pContainer the fixed value of pattern parameter container, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static CreateMatch newMutableMatch(final EObject pContainer, final Create pChange) {
    return new Mutable(pContainer, pChange);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pContainer the fixed value of pattern parameter container, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static CreateMatch newMatch(final EObject pContainer, final Create pChange) {
    return new Immutable(pContainer, pChange);
  }
  
  private static final class Mutable extends CreateMatch {
    Mutable(final EObject pContainer, final Create pChange) {
      super(pContainer, pChange);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends CreateMatch {
    Immutable(final EObject pContainer, final Create pChange) {
      super(pContainer, pChange);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
