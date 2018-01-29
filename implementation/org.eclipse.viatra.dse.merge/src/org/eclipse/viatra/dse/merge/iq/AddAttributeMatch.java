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

import java.util.Arrays;
import java.util.List;

import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.merge.iq.util.AddAttributeQuerySpecification;
import org.eclipse.viatra.dse.merge.model.Attribute;

/**
 * Pattern-specific match representation of the org.eclipse.viatra.dse.merge.iq.addAttribute pattern,
 * to be used in conjunction with {@link AddAttributeMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AddAttributeMatcher
 * @see AddAttributeProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AddAttributeMatch extends BasePatternMatch {
  private org.eclipse.emf.ecore.EObject fSrc;
  
  private Attribute fChange;
  
  private static List<String> parameterNames = makeImmutableList("src", "change");
  
  private AddAttributeMatch(final org.eclipse.emf.ecore.EObject pSrc, final Attribute pChange) {
    this.fSrc = pSrc;
    this.fChange = pChange;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("src".equals(parameterName)) return this.fSrc;
    if ("change".equals(parameterName)) return this.fChange;
    return null;
  }
  
  public org.eclipse.emf.ecore.EObject getSrc() {
    return this.fSrc;
  }
  
  public Attribute getChange() {
    return this.fChange;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("src".equals(parameterName) ) {
    	this.fSrc = (org.eclipse.emf.ecore.EObject) newValue;
    	return true;
    }
    if ("change".equals(parameterName) ) {
    	this.fChange = (org.eclipse.viatra.dse.merge.model.Attribute) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSrc(final org.eclipse.emf.ecore.EObject pSrc) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSrc = pSrc;
  }
  
  public void setChange(final Attribute pChange) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fChange = pChange;
  }
  
  @Override
  public String patternName() {
    return "org.eclipse.viatra.dse.merge.iq.addAttribute";
  }
  
  @Override
  public List<String> parameterNames() {
    return AddAttributeMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSrc, fChange};
  }
  
  @Override
  public AddAttributeMatch toImmutable() {
    return isMutable() ? newMatch(fSrc, fChange) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"src\"=" + prettyPrintValue(fSrc) + ", ");
    
    result.append("\"change\"=" + prettyPrintValue(fChange)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSrc == null) ? 0 : fSrc.hashCode());
    result = prime * result + ((fChange == null) ? 0 : fChange.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AddAttributeMatch)) { // this should be infrequent
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
    AddAttributeMatch other = (AddAttributeMatch) obj;
    if (fSrc == null) {if (other.fSrc != null) return false;}
    else if (!fSrc.equals(other.fSrc)) return false;
    if (fChange == null) {if (other.fChange != null) return false;}
    else if (!fChange.equals(other.fChange)) return false;
    return true;
  }
  
  @Override
  public AddAttributeQuerySpecification specification() {
    try {
    	return AddAttributeQuerySpecification.instance();
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
  public static AddAttributeMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AddAttributeMatch newMutableMatch(final org.eclipse.emf.ecore.EObject pSrc, final Attribute pChange) {
    return new Mutable(pSrc, pChange);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AddAttributeMatch newMatch(final org.eclipse.emf.ecore.EObject pSrc, final Attribute pChange) {
    return new Immutable(pSrc, pChange);
  }
  
  private static final class Mutable extends AddAttributeMatch {
    Mutable(final org.eclipse.emf.ecore.EObject pSrc, final Attribute pChange) {
      super(pSrc, pChange);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AddAttributeMatch {
    Immutable(final org.eclipse.emf.ecore.EObject pSrc, final Attribute pChange) {
      super(pSrc, pChange);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
