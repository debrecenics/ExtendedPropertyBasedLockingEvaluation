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

import java.util.Arrays;
import java.util.List;

import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.merge.iq.util.AddReferenceQuerySpecification;
import org.eclipse.viatra.dse.merge.model.Reference;

/**
 * Pattern-specific match representation of the org.eclipse.viatra.dse.merge.iq.addReference pattern,
 * to be used in conjunction with {@link AddReferenceMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see AddReferenceMatcher
 * @see AddReferenceProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class AddReferenceMatch extends BasePatternMatch {
  private org.eclipse.emf.ecore.EObject fSrc;
  
  private org.eclipse.emf.ecore.EObject fTrg;
  
  private Reference fChange;
  
  private static List<String> parameterNames = makeImmutableList("src", "trg", "change");
  
  private AddReferenceMatch(final org.eclipse.emf.ecore.EObject pSrc, final org.eclipse.emf.ecore.EObject pTrg, final Reference pChange) {
    this.fSrc = pSrc;
    this.fTrg = pTrg;
    this.fChange = pChange;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("src".equals(parameterName)) return this.fSrc;
    if ("trg".equals(parameterName)) return this.fTrg;
    if ("change".equals(parameterName)) return this.fChange;
    return null;
  }
  
  public org.eclipse.emf.ecore.EObject getSrc() {
    return this.fSrc;
  }
  
  public org.eclipse.emf.ecore.EObject getTrg() {
    return this.fTrg;
  }
  
  public Reference getChange() {
    return this.fChange;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("src".equals(parameterName) ) {
    	this.fSrc = (org.eclipse.emf.ecore.EObject) newValue;
    	return true;
    }
    if ("trg".equals(parameterName) ) {
    	this.fTrg = (org.eclipse.emf.ecore.EObject) newValue;
    	return true;
    }
    if ("change".equals(parameterName) ) {
    	this.fChange = (org.eclipse.viatra.dse.merge.model.Reference) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSrc(final org.eclipse.emf.ecore.EObject pSrc) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSrc = pSrc;
  }
  
  public void setTrg(final org.eclipse.emf.ecore.EObject pTrg) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fTrg = pTrg;
  }
  
  public void setChange(final Reference pChange) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fChange = pChange;
  }
  
  @Override
  public String patternName() {
    return "org.eclipse.viatra.dse.merge.iq.addReference";
  }
  
  @Override
  public List<String> parameterNames() {
    return AddReferenceMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSrc, fTrg, fChange};
  }
  
  @Override
  public AddReferenceMatch toImmutable() {
    return isMutable() ? newMatch(fSrc, fTrg, fChange) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"src\"=" + prettyPrintValue(fSrc) + ", ");
    
    result.append("\"trg\"=" + prettyPrintValue(fTrg) + ", ");
    
    result.append("\"change\"=" + prettyPrintValue(fChange)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSrc == null) ? 0 : fSrc.hashCode());
    result = prime * result + ((fTrg == null) ? 0 : fTrg.hashCode());
    result = prime * result + ((fChange == null) ? 0 : fChange.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof AddReferenceMatch)) { // this should be infrequent
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
    AddReferenceMatch other = (AddReferenceMatch) obj;
    if (fSrc == null) {if (other.fSrc != null) return false;}
    else if (!fSrc.equals(other.fSrc)) return false;
    if (fTrg == null) {if (other.fTrg != null) return false;}
    else if (!fTrg.equals(other.fTrg)) return false;
    if (fChange == null) {if (other.fChange != null) return false;}
    else if (!fChange.equals(other.fChange)) return false;
    return true;
  }
  
  @Override
  public AddReferenceQuerySpecification specification() {
    try {
    	return AddReferenceQuerySpecification.instance();
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
  public static AddReferenceMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTrg the fixed value of pattern parameter trg, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static AddReferenceMatch newMutableMatch(final org.eclipse.emf.ecore.EObject pSrc, final org.eclipse.emf.ecore.EObject pTrg, final Reference pChange) {
    return new Mutable(pSrc, pTrg, pChange);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTrg the fixed value of pattern parameter trg, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static AddReferenceMatch newMatch(final org.eclipse.emf.ecore.EObject pSrc, final org.eclipse.emf.ecore.EObject pTrg, final Reference pChange) {
    return new Immutable(pSrc, pTrg, pChange);
  }
  
  private static final class Mutable extends AddReferenceMatch {
    Mutable(final org.eclipse.emf.ecore.EObject pSrc, final org.eclipse.emf.ecore.EObject pTrg, final Reference pChange) {
      super(pSrc, pTrg, pChange);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends AddReferenceMatch {
    Immutable(final org.eclipse.emf.ecore.EObject pSrc, final org.eclipse.emf.ecore.EObject pTrg, final Reference pChange) {
      super(pSrc, pTrg, pChange);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
