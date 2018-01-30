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
import org.mondo.collaboration.queries.UserR0Match;
import org.mondo.collaboration.queries.util.UserR0QuerySpecification;
import wt.Composite;

/**
 * Generated pattern matcher API of the org.mondo.collaboration.queries.userR0 pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link UserR0Match}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern userR0(vendor, object, composite : Composite) {
 * 	Composite.vendor(composite,vendor);
 * 	Composite.vendor(composite,"0");
 * 	find containedBy+(composite,object);
 * }
 * </pre></code>
 * 
 * @see UserR0Match
 * @see UserR0Processor
 * @see UserR0QuerySpecification
 * 
 */
@SuppressWarnings("all")
public class UserR0Matcher extends BaseMatcher<UserR0Match> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static UserR0Matcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    UserR0Matcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new UserR0Matcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_VENDOR = 0;
  
  private final static int POSITION_OBJECT = 1;
  
  private final static int POSITION_COMPOSITE = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(UserR0Matcher.class);
  
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
  public UserR0Matcher(final Notifier emfRoot) throws IncQueryException {
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
  public UserR0Matcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @return matches represented as a UserR0Match object.
   * 
   */
  public Collection<UserR0Match> getAllMatches(final String pVendor, final Object pObject, final Composite pComposite) {
    return rawGetAllMatches(new Object[]{pVendor, pObject, pComposite});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @return a match represented as a UserR0Match object, or null if no match is found.
   * 
   */
  public UserR0Match getOneArbitraryMatch(final String pVendor, final Object pObject, final Composite pComposite) {
    return rawGetOneArbitraryMatch(new Object[]{pVendor, pObject, pComposite});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final String pVendor, final Object pObject, final Composite pComposite) {
    return rawHasMatch(new Object[]{pVendor, pObject, pComposite});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final String pVendor, final Object pObject, final Composite pComposite) {
    return rawCountMatches(new Object[]{pVendor, pObject, pComposite});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final String pVendor, final Object pObject, final Composite pComposite, final IMatchProcessor<? super UserR0Match> processor) {
    rawForEachMatch(new Object[]{pVendor, pObject, pComposite}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final String pVendor, final Object pObject, final Composite pComposite, final IMatchProcessor<? super UserR0Match> processor) {
    return rawForOneArbitraryMatch(new Object[]{pVendor, pObject, pComposite}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pVendor the fixed value of pattern parameter vendor, or null if not bound.
   * @param pObject the fixed value of pattern parameter object, or null if not bound.
   * @param pComposite the fixed value of pattern parameter composite, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public UserR0Match newMatch(final String pVendor, final Object pObject, final Composite pComposite) {
    return UserR0Match.newMatch(pVendor, pObject, pComposite);
  }
  
  /**
   * Retrieve the set of values that occur in matches for vendor.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<String> rawAccumulateAllValuesOfvendor(final Object[] parameters) {
    Set<String> results = new HashSet<String>();
    rawAccumulateAllValues(POSITION_VENDOR, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for vendor.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfvendor() {
    return rawAccumulateAllValuesOfvendor(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for vendor.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfvendor(final UserR0Match partialMatch) {
    return rawAccumulateAllValuesOfvendor(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for vendor.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<String> getAllValuesOfvendor(final Object pObject, final Composite pComposite) {
    return rawAccumulateAllValuesOfvendor(new Object[]{
    null, 
    pObject, 
    pComposite
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for object.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Object> rawAccumulateAllValuesOfobject(final Object[] parameters) {
    Set<Object> results = new HashSet<Object>();
    rawAccumulateAllValues(POSITION_OBJECT, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for object.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfobject() {
    return rawAccumulateAllValuesOfobject(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for object.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfobject(final UserR0Match partialMatch) {
    return rawAccumulateAllValuesOfobject(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for object.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Object> getAllValuesOfobject(final String pVendor, final Composite pComposite) {
    return rawAccumulateAllValuesOfobject(new Object[]{
    pVendor, 
    null, 
    pComposite
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for composite.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Composite> rawAccumulateAllValuesOfcomposite(final Object[] parameters) {
    Set<Composite> results = new HashSet<Composite>();
    rawAccumulateAllValues(POSITION_COMPOSITE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for composite.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Composite> getAllValuesOfcomposite() {
    return rawAccumulateAllValuesOfcomposite(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for composite.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Composite> getAllValuesOfcomposite(final UserR0Match partialMatch) {
    return rawAccumulateAllValuesOfcomposite(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for composite.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Composite> getAllValuesOfcomposite(final String pVendor, final Object pObject) {
    return rawAccumulateAllValuesOfcomposite(new Object[]{
    pVendor, 
    pObject, 
    null
    });
  }
  
  @Override
  protected UserR0Match tupleToMatch(final Tuple t) {
    try {
    	return UserR0Match.newMatch((java.lang.String) t.get(POSITION_VENDOR), (java.lang.Object) t.get(POSITION_OBJECT), (wt.Composite) t.get(POSITION_COMPOSITE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected UserR0Match arrayToMatch(final Object[] match) {
    try {
    	return UserR0Match.newMatch((java.lang.String) match[POSITION_VENDOR], (java.lang.Object) match[POSITION_OBJECT], (wt.Composite) match[POSITION_COMPOSITE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected UserR0Match arrayToMatchMutable(final Object[] match) {
    try {
    	return UserR0Match.newMutableMatch((java.lang.String) match[POSITION_VENDOR], (java.lang.Object) match[POSITION_OBJECT], (wt.Composite) match[POSITION_COMPOSITE]);
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
  public static IQuerySpecification<UserR0Matcher> querySpecification() throws IncQueryException {
    return UserR0QuerySpecification.instance();
  }
}
