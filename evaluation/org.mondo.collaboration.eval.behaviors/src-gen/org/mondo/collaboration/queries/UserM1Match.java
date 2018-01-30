package org.mondo.collaboration.queries;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.queries.util.UserM1QuerySpecification;
import wt.Control;
import wt.Signal;

/**
 * Pattern-specific match representation of the org.mondo.collaboration.queries.userM1 pattern,
 * to be used in conjunction with {@link UserM1Matcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see UserM1Matcher
 * @see UserM1Processor
 * 
 */
@SuppressWarnings("all")
public abstract class UserM1Match extends BasePatternMatch {
  private Control fCtrl;
  
  private Signal fSgn;
  
  private Integer fF;
  
  private static List<String> parameterNames = makeImmutableList("ctrl", "sgn", "f");
  
  private UserM1Match(final Control pCtrl, final Signal pSgn, final Integer pF) {
    this.fCtrl = pCtrl;
    this.fSgn = pSgn;
    this.fF = pF;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("ctrl".equals(parameterName)) return this.fCtrl;
    if ("sgn".equals(parameterName)) return this.fSgn;
    if ("f".equals(parameterName)) return this.fF;
    return null;
  }
  
  public Control getCtrl() {
    return this.fCtrl;
  }
  
  public Signal getSgn() {
    return this.fSgn;
  }
  
  public Integer getF() {
    return this.fF;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("ctrl".equals(parameterName) ) {
    	this.fCtrl = (wt.Control) newValue;
    	return true;
    }
    if ("sgn".equals(parameterName) ) {
    	this.fSgn = (wt.Signal) newValue;
    	return true;
    }
    if ("f".equals(parameterName) ) {
    	this.fF = (java.lang.Integer) newValue;
    	return true;
    }
    return false;
  }
  
  public void setCtrl(final Control pCtrl) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fCtrl = pCtrl;
  }
  
  public void setSgn(final Signal pSgn) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSgn = pSgn;
  }
  
  public void setF(final Integer pF) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fF = pF;
  }
  
  @Override
  public String patternName() {
    return "org.mondo.collaboration.queries.userM1";
  }
  
  @Override
  public List<String> parameterNames() {
    return UserM1Match.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCtrl, fSgn, fF};
  }
  
  @Override
  public UserM1Match toImmutable() {
    return isMutable() ? newMatch(fCtrl, fSgn, fF) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"ctrl\"=" + prettyPrintValue(fCtrl) + ", ");
    
    result.append("\"sgn\"=" + prettyPrintValue(fSgn) + ", ");
    
    result.append("\"f\"=" + prettyPrintValue(fF)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCtrl == null) ? 0 : fCtrl.hashCode());
    result = prime * result + ((fSgn == null) ? 0 : fSgn.hashCode());
    result = prime * result + ((fF == null) ? 0 : fF.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof UserM1Match)) { // this should be infrequent
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
    UserM1Match other = (UserM1Match) obj;
    if (fCtrl == null) {if (other.fCtrl != null) return false;}
    else if (!fCtrl.equals(other.fCtrl)) return false;
    if (fSgn == null) {if (other.fSgn != null) return false;}
    else if (!fSgn.equals(other.fSgn)) return false;
    if (fF == null) {if (other.fF != null) return false;}
    else if (!fF.equals(other.fF)) return false;
    return true;
  }
  
  @Override
  public UserM1QuerySpecification specification() {
    try {
    	return UserM1QuerySpecification.instance();
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
  public static UserM1Match newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pSgn the fixed value of pattern parameter sgn, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static UserM1Match newMutableMatch(final Control pCtrl, final Signal pSgn, final Integer pF) {
    return new Mutable(pCtrl, pSgn, pF);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pSgn the fixed value of pattern parameter sgn, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static UserM1Match newMatch(final Control pCtrl, final Signal pSgn, final Integer pF) {
    return new Immutable(pCtrl, pSgn, pF);
  }
  
  private static final class Mutable extends UserM1Match {
    Mutable(final Control pCtrl, final Signal pSgn, final Integer pF) {
      super(pCtrl, pSgn, pF);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends UserM1Match {
    Immutable(final Control pCtrl, final Signal pSgn, final Integer pF) {
      super(pCtrl, pSgn, pF);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
