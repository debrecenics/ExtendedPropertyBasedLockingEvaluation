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
import org.mondo.collaboration.queries.UserM1Match;
import org.mondo.collaboration.queries.util.UserM1QuerySpecification;
import wt.Control;
import wt.Signal;

/**
 * Generated pattern matcher API of the org.mondo.collaboration.queries.userM1 pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link UserM1Match}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern userM1(ctrl: Control, sgn: Signal, f) {
 * 	Control.cycle(ctrl, "1");
 * 	Control.provides(ctrl,sgn);
 * 	Signal.frequency(sgn,f);
 * }
 * </pre></code>
 * 
 * @see UserM1Match
 * @see UserM1Processor
 * @see UserM1QuerySpecification
 * 
 */
@SuppressWarnings("all")
public class UserM1Matcher extends BaseMatcher<UserM1Match> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static UserM1Matcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    UserM1Matcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new UserM1Matcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CTRL = 0;
  
  private final static int POSITION_SGN = 1;
  
  private final static int POSITION_F = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(UserM1Matcher.class);
  
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
  public UserM1Matcher(final Notifier emfRoot) throws IncQueryException {
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
  public UserM1Matcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pSgn the fixed value of pattern parameter sgn, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return matches represented as a UserM1Match object.
   * 
   */
  public Collection<UserM1Match> getAllMatches(final Control pCtrl, final Signal pSgn, final Integer pF) {
    return rawGetAllMatches(new Object[]{pCtrl, pSgn, pF});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pSgn the fixed value of pattern parameter sgn, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return a match represented as a UserM1Match object, or null if no match is found.
   * 
   */
  public UserM1Match getOneArbitraryMatch(final Control pCtrl, final Signal pSgn, final Integer pF) {
    return rawGetOneArbitraryMatch(new Object[]{pCtrl, pSgn, pF});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pSgn the fixed value of pattern parameter sgn, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Control pCtrl, final Signal pSgn, final Integer pF) {
    return rawHasMatch(new Object[]{pCtrl, pSgn, pF});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pSgn the fixed value of pattern parameter sgn, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Control pCtrl, final Signal pSgn, final Integer pF) {
    return rawCountMatches(new Object[]{pCtrl, pSgn, pF});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pSgn the fixed value of pattern parameter sgn, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Control pCtrl, final Signal pSgn, final Integer pF, final IMatchProcessor<? super UserM1Match> processor) {
    rawForEachMatch(new Object[]{pCtrl, pSgn, pF}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pCtrl the fixed value of pattern parameter ctrl, or null if not bound.
   * @param pSgn the fixed value of pattern parameter sgn, or null if not bound.
   * @param pF the fixed value of pattern parameter f, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Control pCtrl, final Signal pSgn, final Integer pF, final IMatchProcessor<? super UserM1Match> processor) {
    return rawForOneArbitraryMatch(new Object[]{pCtrl, pSgn, pF}, processor);
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
  public UserM1Match newMatch(final Control pCtrl, final Signal pSgn, final Integer pF) {
    return UserM1Match.newMatch(pCtrl, pSgn, pF);
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
  public Set<Control> getAllValuesOfctrl(final UserM1Match partialMatch) {
    return rawAccumulateAllValuesOfctrl(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for ctrl.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Control> getAllValuesOfctrl(final Signal pSgn, final Integer pF) {
    return rawAccumulateAllValuesOfctrl(new Object[]{
    null, 
    pSgn, 
    pF
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
  public Set<Signal> getAllValuesOfsgn(final UserM1Match partialMatch) {
    return rawAccumulateAllValuesOfsgn(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for sgn.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Signal> getAllValuesOfsgn(final Control pCtrl, final Integer pF) {
    return rawAccumulateAllValuesOfsgn(new Object[]{
    pCtrl, 
    null, 
    pF
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for f.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Integer> rawAccumulateAllValuesOff(final Object[] parameters) {
    Set<Integer> results = new HashSet<Integer>();
    rawAccumulateAllValues(POSITION_F, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for f.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOff() {
    return rawAccumulateAllValuesOff(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for f.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOff(final UserM1Match partialMatch) {
    return rawAccumulateAllValuesOff(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for f.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Integer> getAllValuesOff(final Control pCtrl, final Signal pSgn) {
    return rawAccumulateAllValuesOff(new Object[]{
    pCtrl, 
    pSgn, 
    null
    });
  }
  
  @Override
  protected UserM1Match tupleToMatch(final Tuple t) {
    try {
    	return UserM1Match.newMatch((wt.Control) t.get(POSITION_CTRL), (wt.Signal) t.get(POSITION_SGN), (java.lang.Integer) t.get(POSITION_F));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected UserM1Match arrayToMatch(final Object[] match) {
    try {
    	return UserM1Match.newMatch((wt.Control) match[POSITION_CTRL], (wt.Signal) match[POSITION_SGN], (java.lang.Integer) match[POSITION_F]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected UserM1Match arrayToMatchMutable(final Object[] match) {
    try {
    	return UserM1Match.newMutableMatch((wt.Control) match[POSITION_CTRL], (wt.Signal) match[POSITION_SGN], (java.lang.Integer) match[POSITION_F]);
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
  public static IQuerySpecification<UserM1Matcher> querySpecification() throws IncQueryException {
    return UserM1QuerySpecification.instance();
  }
}
