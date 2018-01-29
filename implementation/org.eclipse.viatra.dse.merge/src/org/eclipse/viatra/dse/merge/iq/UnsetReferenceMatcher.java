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
import org.eclipse.viatra.dse.merge.iq.UnsetReferenceMatcher;
import org.eclipse.viatra.dse.merge.iq.util.UnsetReferenceProcessor;

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
import org.eclipse.viatra.dse.merge.iq.UnsetReferenceMatch;
import org.eclipse.viatra.dse.merge.iq.util.UnsetReferenceQuerySpecification;
import org.eclipse.viatra.dse.merge.model.Reference;

/**
 * Generated pattern matcher API of the org.eclipse.viatra.dse.merge.iq.unsetReference pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link UnsetReferenceMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern unsetReference(src : EObject, change : Reference) {
 * 	EObject.id(src, src_id);
 * 	Reference.src.eString(change, src_id);
 * 
 * 	Reference.kind(change, ::unset);
 * 	Change.executable(change, true);
 * 
 * 	neg find inCemetery(src);
 * }
 * </pre></code>
 * 
 * @see UnsetReferenceMatch
 * @see UnsetReferenceProcessor
 * @see UnsetReferenceQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class UnsetReferenceMatcher extends BaseMatcher<UnsetReferenceMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static UnsetReferenceMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    UnsetReferenceMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new UnsetReferenceMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SRC = 0;
  
  private final static int POSITION_CHANGE = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(UnsetReferenceMatcher.class);
  
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
  public UnsetReferenceMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public UnsetReferenceMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return matches represented as a UnsetReferenceMatch object.
   * 
   */
  public Collection<UnsetReferenceMatch> getAllMatches(final EObject pSrc, final Reference pChange) {
    return rawGetAllMatches(new Object[]{pSrc, pChange});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return a match represented as a UnsetReferenceMatch object, or null if no match is found.
   * 
   */
  public UnsetReferenceMatch getOneArbitraryMatch(final EObject pSrc, final Reference pChange) {
    return rawGetOneArbitraryMatch(new Object[]{pSrc, pChange});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final EObject pSrc, final Reference pChange) {
    return rawHasMatch(new Object[]{pSrc, pChange});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final EObject pSrc, final Reference pChange) {
    return rawCountMatches(new Object[]{pSrc, pChange});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final EObject pSrc, final Reference pChange, final IMatchProcessor<? super UnsetReferenceMatch> processor) {
    rawForEachMatch(new Object[]{pSrc, pChange}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final EObject pSrc, final Reference pChange, final IMatchProcessor<? super UnsetReferenceMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSrc, pChange}, processor);
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
  public UnsetReferenceMatch newMatch(final EObject pSrc, final Reference pChange) {
    return UnsetReferenceMatch.newMatch(pSrc, pChange);
  }
  
  /**
   * Retrieve the set of values that occur in matches for src.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<EObject> rawAccumulateAllValuesOfsrc(final Object[] parameters) {
    Set<EObject> results = new HashSet<EObject>();
    rawAccumulateAllValues(POSITION_SRC, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for src.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfsrc() {
    return rawAccumulateAllValuesOfsrc(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for src.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfsrc(final UnsetReferenceMatch partialMatch) {
    return rawAccumulateAllValuesOfsrc(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for src.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfsrc(final Reference pChange) {
    return rawAccumulateAllValuesOfsrc(new Object[]{
    null, 
    pChange
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for change.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Reference> rawAccumulateAllValuesOfchange(final Object[] parameters) {
    Set<Reference> results = new HashSet<Reference>();
    rawAccumulateAllValues(POSITION_CHANGE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for change.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Reference> getAllValuesOfchange() {
    return rawAccumulateAllValuesOfchange(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for change.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Reference> getAllValuesOfchange(final UnsetReferenceMatch partialMatch) {
    return rawAccumulateAllValuesOfchange(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for change.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Reference> getAllValuesOfchange(final EObject pSrc) {
    return rawAccumulateAllValuesOfchange(new Object[]{
    pSrc, 
    null
    });
  }
  
  @Override
  protected UnsetReferenceMatch tupleToMatch(final Tuple t) {
    try {
    	return UnsetReferenceMatch.newMatch((org.eclipse.emf.ecore.EObject) t.get(POSITION_SRC), (org.eclipse.viatra.dse.merge.model.Reference) t.get(POSITION_CHANGE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected UnsetReferenceMatch arrayToMatch(final Object[] match) {
    try {
    	return UnsetReferenceMatch.newMatch((org.eclipse.emf.ecore.EObject) match[POSITION_SRC], (org.eclipse.viatra.dse.merge.model.Reference) match[POSITION_CHANGE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected UnsetReferenceMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return UnsetReferenceMatch.newMutableMatch((org.eclipse.emf.ecore.EObject) match[POSITION_SRC], (org.eclipse.viatra.dse.merge.model.Reference) match[POSITION_CHANGE]);
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
  public static IQuerySpecification<UnsetReferenceMatcher> querySpecification() throws IncQueryException {
    return UnsetReferenceQuerySpecification.instance();
  }
}
