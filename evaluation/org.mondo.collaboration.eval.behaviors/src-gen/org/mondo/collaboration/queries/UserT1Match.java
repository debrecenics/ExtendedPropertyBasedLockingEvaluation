package org.mondo.collaboration.queries;

import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.queries.util.UserT1QuerySpecification;
import wt.Control;
import wt.Signal;

/**
 * Pattern-specific match representation of the org.mondo.collaboration.queries.userT1 pattern,
 * to be used in conjunction with {@link UserT1Matcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see UserT1Matcher
 * @see UserT1Processor
 * 
 */
@SuppressWarnings("all")
public abstract class UserT1Match extends BasePatternMatch {
  private Control fCtrl;
  
  private Signal fSgn;
  
  private String fC;
  
  private String fT;
  
  private static List<String> parameterNames = makeImmutableList("ctrl", "sgn", "c", "t");
  
  private UserT1Match(final Control pCtrl, final Signal pSgn, final String pC, final String pT) {
    this.fCtrl = pCtrl;
    this.fSgn = pSgn;
    this.fC = pC;
    this.fT = pT;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("ctrl".equals(parameterName)) return this.fCtrl;
    if ("sgn".equals(parameterName)) return this.fSgn;
    if ("c".equals(parameterName)) return this.fC;
    if ("t".equals(parameterName)) return this.fT;
    return null;
  }
  
  public Control getCtrl() {
    return this.fCtrl;
  }
  
  public Signal getSgn() {
    return this.fSgn;
  }
  
  public String getC() {
    return this.fC;
  }
  
  public String getT() {
    return this.fT;
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
    if ("c".equals(parameterName) ) {
    	this.fC = (java.lang.String) newValue;
    	return true;
    }
    if ("t".equals(parameterName) ) {
    	this.fT = (java.lang.String) newValue;
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
  
  public void setC(final String pC) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fC = pC;
  }
  
  public void setT(final String pT) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fT = pT;
  }
  
  @Override
  public String patternName() {
    return "org.mondo.collaboration.queries.userT1";
  }
  
  @Override
  public List<String> parameterNames() {
    return UserT1Match.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fCtrl, fSgn, fC, fT};
  }
  
  @Override
  public UserT1Match toImmutable() {
    return isMutable() ? newMatch(fCtrl, fSgn, fC, fT) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"ctrl\"=" + prettyPrintValue(fCtrl) + ", ");
    
    result.append("\"sgn\"=" + prettyPrintValue(fSgn) + ", ");
    
    result.append("\"c\"=" + prettyPrintValue(fC) + ", ");
    
    result.append("\"t\"=" + prettyPrintValue(fT)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fCtrl == null) ? 0 : fCtrl.hashCode());
    result = prime * result + ((fSgn == null) ? 0 : fSgn.hashCode());
    result = prime * result + ((fC == null) ? 0 : fC.hashCode());
    result = prime * result + ((fT == null) ? 0 : fT.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof UserT1Match)) { // this should be infrequent
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
    UserT1Match other = (UserT1Match) obj;
    if (fCtrl == null) {if (other.fCtrl != null) return false;}
    else if (!fCtrl.equals(other.fCtrl)) return false;
    if (fSgn == null) {if (other.fSgn != null) return false;}
    else if (!fSgn.equals(other.fSgn)) return false;
    if (fC == null) {if (other.fC != null) return false;}
    else if (!fC.equals(other.fC)) return false;
    if (fT == null) {if (other.fT != null) return false;}
    else if (!fT.equals(other.fT)) return false;
    return true;
  }
  
  @Override
  public UserT1QuerySpecification specification() {
    try {
    	return UserT1QuerySpecification.instance();
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
  public static UserT1Match newEmptyMatch() {
    return new Mutable(null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pSgn the fixed value of pattern parameter sgn, or null if not bound.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static UserT1Match newMutableMatch(final Control pCtrl, final Signal pSgn, final String pC, final String pT) {
    return new Mutable(pCtrl, pSgn, pC, pT);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pSgn the fixed value of pattern parameter sgn, or null if not bound.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static UserT1Match newMatch(final Control pCtrl, final Signal pSgn, final String pC, final String pT) {
    return new Immutable(pCtrl, pSgn, pC, pT);
  }
  
  private static final class Mutable extends UserT1Match {
    Mutable(final Control pCtrl, final Signal pSgn, final String pC, final String pT) {
      super(pCtrl, pSgn, pC, pT);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends UserT1Match {
    Immutable(final Control pCtrl, final Signal pSgn, final String pC, final String pT) {
      super(pCtrl, pSgn, pC, pT);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
