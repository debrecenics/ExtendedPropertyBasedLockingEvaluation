package org.mondo.collaboration.queries;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;
import org.mondo.collaboration.queries.UserT0Match;
import org.mondo.collaboration.queries.util.UserT0QuerySpecification;
import wt.Control;
import wt.Signal;

/**
 * Generated pattern matcher API of the org.mondo.collaboration.queries.userT0 pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link UserT0Match}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern userT0(ctrl: Control, sgn: Signal, c, t) {
 * 	Control.type(ctrl, t);
 * 	Control.type(ctrl, "0");
 * 	Control.cycle(ctrl, c);
 * 	Control.provides(ctrl,sgn);
 * } or {
 * 	Control.type(ctrl, t);
 * 	Control.type(ctrl, "0");
 * 	Control.cycle(ctrl, c);
 * 	Control.consumes(ctrl,sgn);
 * }
 * </pre></code>
 * 
 * @see UserT0Match
 * @see UserT0Processor
 * @see UserT0QuerySpecification
 * 
 */
@SuppressWarnings("all")
public class UserT0Matcher extends BaseMatcher<UserT0Match> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static UserT0Matcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    UserT0Matcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new UserT0Matcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CTRL = 0;
  
  private final static int POSITION_SGN = 1;
  
  private final static int POSITION_C = 2;
  
  private final static int POSITION_T = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(UserT0Matcher.class);
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet).
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public UserT0Matcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public UserT0Matcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pSgn the fixed value of pattern parameter sgn, or null if not bound.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @return matches represented as a UserT0Match object.
   * 
   */
  public Collection<UserT0Match> getAllMatches(final Control pCtrl, final Signal pSgn, final String pC, final String pT) {
    return rawGetAllMatches(new Object[]{pCtrl, pSgn, pC, pT});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pSgn the fixed value of pattern parameter sgn, or null if not bound.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @return a match represented as a UserT0Match object, or null if no match is found.
   * 
   */
  public UserT0Match getOneArbitraryMatch(final Control pCtrl, final Signal pSgn, final String pC, final String pT) {
    return rawGetOneArbitraryMatch(new Object[]{pCtrl, pSgn, pC, pT});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pSgn the fixed value of pattern parameter sgn, or null if not bound.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Control pCtrl, final Signal pSgn, final String pC, final String pT) {
    return rawHasMatch(new Object[]{pCtrl, pSgn, pC, pT});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pSgn the fixed value of pattern parameter sgn, or null if not bound.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Control pCtrl, final Signal pSgn, final String pC, final String pT) {
    return rawCountMatches(new Object[]{pCtrl, pSgn, pC, pT});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pSgn the fixed value of pattern parameter sgn, or null if not bound.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Control pCtrl, final Signal pSgn, final String pC, final String pT, final IMatchProcessor<? super UserT0Match> processor) {
    rawForEachMatch(new Object[]{pCtrl, pSgn, pC, pT}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pSgn the fixed value of pattern parameter sgn, or null if not bound.
   * @param pC the fixed value of pattern parameter c, or null if not bound.
   * @param pT the fixed value of pattern parameter t, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Control pCtrl, final Signal pSgn, final String pC, final String pT, final IMatchProcessor<? super UserT0Match> processor) {
    return rawForOneArbitraryMatch(new Object[]{pCtrl, pSgn, pC, pT}, processor);
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
  public UserT0Match newMatch(final Control pCtrl, final Signal pSgn, final String pC, final String pT) {
    return UserT0Match.newMatch(pCtrl, pSgn, pC, pT);
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Control> rawAccumulateAllValuesOfctrl(final Object[] parameters) {
    Set<Control> results = new HashSet<Control>();
    rawAccumulateAllValues(POSITION_CTRL, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfctrl() {
    return rawAccumulateAllValuesOfctrl(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfctrl(final UserT0Match partialMatch) {
    return rawAccumulateAllValuesOfctrl(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfctrl(final Signal pSgn, final String pC, final String pT) {
    return rawAccumulateAllValuesOfctrl(new Object[]{
    null, 
    pSgn, 
    pC, 
    pT
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for sgn.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Signal> rawAccumulateAllValuesOfsgn(final Object[] parameters) {
    Set<Signal> results = new HashSet<Signal>();
    rawAccumulateAllValues(POSITION_SGN, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for sgn.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsgn() {
    return rawAccumulateAllValuesOfsgn(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sgn.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsgn(final UserT0Match partialMatch) {
    return rawAccumulateAllValuesOfsgn(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sgn.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsgn(final Control pCtrl, final String pC, final String pT) {
    return rawAccumulateAllValuesOfsgn(new Object[]{
    pCtrl, 
    null, 
    pC, 
    pT
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for c.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfc(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_C, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for c.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfc() {
    return rawAccumulateAllValuesOfc(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for c.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfc(final UserT0Match partialMatch) {
    return rawAccumulateAllValuesOfc(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for c.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfc(final Control pCtrl, final Signal pSgn, final String pT) {
    return rawAccumulateAllValuesOfc(new Object[]{
    pCtrl, 
    pSgn, 
    null, 
    pT
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for t.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOft(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_T, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for t.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOft() {
    return rawAccumulateAllValuesOft(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for t.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOft(final UserT0Match partialMatch) {
    return rawAccumulateAllValuesOft(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for t.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOft(final Control pCtrl, final Signal pSgn, final String pC) {
    return rawAccumulateAllValuesOft(new Object[]{
    pCtrl, 
    pSgn, 
    pC, 
    null
    });
  }
  
  @Override
  protected UserT0Match tupleToMatch(final Tuple t) {
    try {
    	return UserT0Match.newMatch((wt.Control) t.get(POSITION_CTRL), (wt.Signal) t.get(POSITION_SGN), (java.lang.String) t.get(POSITION_C), (java.lang.String) t.get(POSITION_T));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected UserT0Match arrayToMatch(final Object[] match) {
    try {
    	return UserT0Match.newMatch((wt.Control) match[POSITION_CTRL], (wt.Signal) match[POSITION_SGN], (java.lang.String) match[POSITION_C], (java.lang.String) match[POSITION_T]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected UserT0Match arrayToMatchMutable(final Object[] match) {
    try {
    	return UserT0Match.newMutableMatch((wt.Control) match[POSITION_CTRL], (wt.Signal) match[POSITION_SGN], (java.lang.String) match[POSITION_C], (java.lang.String) match[POSITION_T]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<UserT0Matcher> querySpecification() throws IncQueryException {
    return UserT0QuerySpecification.instance();
  }
}
