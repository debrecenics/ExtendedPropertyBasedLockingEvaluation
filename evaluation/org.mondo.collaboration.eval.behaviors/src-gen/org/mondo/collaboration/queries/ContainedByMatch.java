package org.mondo.collaboration.queries;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.queries.util.ContainedByQuerySpecification;
import wt.Module;

/**
 * Pattern-specific match representation of the org.mondo.collaboration.queries.containedBy pattern,
 * to be used in conjunction with {@link ContainedByMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see ContainedByMatcher
 * @see ContainedByProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class ContainedByMatch extends BasePatternMatch {
  private Module fParent;
  
  private Object fChild;
  
  private static List<String> parameterNames = makeImmutableList("parent", "child");
  
  private ContainedByMatch(final Module pParent, final Object pChild) {
    this.fParent = pParent;
    this.fChild = pChild;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("parent".equals(parameterName)) return this.fParent;
    if ("child".equals(parameterName)) return this.fChild;
    return null;
  }
  
  public Module getParent() {
    return this.fParent;
  }
  
  public Object getChild() {
    return this.fChild;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("parent".equals(parameterName) ) {
    	this.fParent = (wt.Module) newValue;
    	return true;
    }
    if ("child".equals(parameterName) && newValue instanceof java.lang.Object) {
    	this.fChild = (java.lang.Object) newValue;
    	return true;
    }
    return false;
  }
  
  public void setParent(final Module pParent) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fParent = pParent;
  }
  
  public void setChild(final Object pChild) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fChild = pChild;
  }
  
  @Override
  public String patternName() {
    return "org.mondo.collaboration.queries.containedBy";
  }
  
  @Override
  public List<String> parameterNames() {
    return ContainedByMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fParent, fChild};
  }
  
  @Override
  public ContainedByMatch toImmutable() {
    return isMutable() ? newMatch(fParent, fChild) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"parent\"=" + prettyPrintValue(fParent) + ", ");
    
    result.append("\"child\"=" + prettyPrintValue(fChild)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fParent == null) ? 0 : fParent.hashCode());
    result = prime * result + ((fChild == null) ? 0 : fChild.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof ContainedByMatch)) { // this should be infrequent
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
    ContainedByMatch other = (ContainedByMatch) obj;
    if (fParent == null) {if (other.fParent != null) return false;}
    else if (!fParent.equals(other.fParent)) return false;
    if (fChild == null) {if (other.fChild != null) return false;}
    else if (!fChild.equals(other.fChild)) return false;
    return true;
  }
  
  @Override
  public ContainedByQuerySpecification specification() {
    try {
    	return ContainedByQuerySpecification.instance();
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
  public static ContainedByMatch newEmptyMatch() {
    return new Mutable(null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static ContainedByMatch newMutableMatch(final Module pParent, final Object pChild) {
    return new Mutable(pParent, pChild);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pParent the fixed value of pattern parameter parent, or null if not bound.
   * @param pChild the fixed value of pattern parameter child, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static ContainedByMatch newMatch(final Module pParent, final Object pChild) {
    return new Immutable(pParent, pChild);
  }
  
  private static final class Mutable extends ContainedByMatch {
    Mutable(final Module pParent, final Object pChild) {
      super(pParent, pChild);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends ContainedByMatch {
    Immutable(final Module pParent, final Object pChild) {
      super(pParent, pChild);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
