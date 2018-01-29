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
import org.eclipse.viatra.dse.merge.iq.SetReferenceMatcher;
import org.eclipse.viatra.dse.merge.iq.util.SetReferenceProcessor;

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
import org.eclipse.viatra.dse.merge.iq.SetReferenceMatch;
import org.eclipse.viatra.dse.merge.iq.util.SetReferenceQuerySpecification;
import org.eclipse.viatra.dse.merge.model.Reference;

/**
 * Generated pattern matcher API of the org.eclipse.viatra.dse.merge.iq.setReference pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link SetReferenceMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern setReference(src : EObject, trg : EObject, change : Reference) {
 * 	EObject.id(src, src_id);
 * 	Reference.src.eString(change, src_id);
 * 
 * 	EObject.id(trg, trg_id);
 * 	Reference.trg.eString(change, trg_id);
 * 
 * 	Reference.kind(change, ::set);
 * 	Change.executable(change, true);
 * 
 * 	neg find inCemetery(src);
 * 	neg find inCemetery(trg);
 * }
 * </pre></code>
 * 
 * @see SetReferenceMatch
 * @see SetReferenceProcessor
 * @see SetReferenceQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class SetReferenceMatcher extends BaseMatcher<SetReferenceMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static SetReferenceMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    SetReferenceMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new SetReferenceMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_SRC = 0;
  
  private final static int POSITION_TRG = 1;
  
  private final static int POSITION_CHANGE = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(SetReferenceMatcher.class);
  
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
  public SetReferenceMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public SetReferenceMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTrg the fixed value of pattern parameter trg, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return matches represented as a SetReferenceMatch object.
   * 
   */
  public Collection<SetReferenceMatch> getAllMatches(final EObject pSrc, final EObject pTrg, final Reference pChange) {
    return rawGetAllMatches(new Object[]{pSrc, pTrg, pChange});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTrg the fixed value of pattern parameter trg, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return a match represented as a SetReferenceMatch object, or null if no match is found.
   * 
   */
  public SetReferenceMatch getOneArbitraryMatch(final EObject pSrc, final EObject pTrg, final Reference pChange) {
    return rawGetOneArbitraryMatch(new Object[]{pSrc, pTrg, pChange});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTrg the fixed value of pattern parameter trg, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final EObject pSrc, final EObject pTrg, final Reference pChange) {
    return rawHasMatch(new Object[]{pSrc, pTrg, pChange});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTrg the fixed value of pattern parameter trg, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final EObject pSrc, final EObject pTrg, final Reference pChange) {
    return rawCountMatches(new Object[]{pSrc, pTrg, pChange});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTrg the fixed value of pattern parameter trg, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final EObject pSrc, final EObject pTrg, final Reference pChange, final IMatchProcessor<? super SetReferenceMatch> processor) {
    rawForEachMatch(new Object[]{pSrc, pTrg, pChange}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pSrc the fixed value of pattern parameter src, or null if not bound.
   * @param pTrg the fixed value of pattern parameter trg, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final EObject pSrc, final EObject pTrg, final Reference pChange, final IMatchProcessor<? super SetReferenceMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pSrc, pTrg, pChange}, processor);
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
  public SetReferenceMatch newMatch(final EObject pSrc, final EObject pTrg, final Reference pChange) {
    return SetReferenceMatch.newMatch(pSrc, pTrg, pChange);
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
  public Set<EObject> getAllValuesOfsrc(final SetReferenceMatch partialMatch) {
    return rawAccumulateAllValuesOfsrc(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for src.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfsrc(final EObject pTrg, final Reference pChange) {
    return rawAccumulateAllValuesOfsrc(new Object[]{
    null, 
    pTrg, 
    pChange
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for trg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<EObject> rawAccumulateAllValuesOftrg(final Object[] parameters) {
    Set<EObject> results = new HashSet<EObject>();
    rawAccumulateAllValues(POSITION_TRG, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for trg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOftrg() {
    return rawAccumulateAllValuesOftrg(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for trg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOftrg(final SetReferenceMatch partialMatch) {
    return rawAccumulateAllValuesOftrg(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for trg.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOftrg(final EObject pSrc, final Reference pChange) {
    return rawAccumulateAllValuesOftrg(new Object[]{
    pSrc, 
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
  public Set<Reference> getAllValuesOfchange(final SetReferenceMatch partialMatch) {
    return rawAccumulateAllValuesOfchange(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for change.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Reference> getAllValuesOfchange(final EObject pSrc, final EObject pTrg) {
    return rawAccumulateAllValuesOfchange(new Object[]{
    pSrc, 
    pTrg, 
    null
    });
  }
  
  @Override
  protected SetReferenceMatch tupleToMatch(final Tuple t) {
    try {
    	return SetReferenceMatch.newMatch((org.eclipse.emf.ecore.EObject) t.get(POSITION_SRC), (org.eclipse.emf.ecore.EObject) t.get(POSITION_TRG), (org.eclipse.viatra.dse.merge.model.Reference) t.get(POSITION_CHANGE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SetReferenceMatch arrayToMatch(final Object[] match) {
    try {
    	return SetReferenceMatch.newMatch((org.eclipse.emf.ecore.EObject) match[POSITION_SRC], (org.eclipse.emf.ecore.EObject) match[POSITION_TRG], (org.eclipse.viatra.dse.merge.model.Reference) match[POSITION_CHANGE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected SetReferenceMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return SetReferenceMatch.newMutableMatch((org.eclipse.emf.ecore.EObject) match[POSITION_SRC], (org.eclipse.emf.ecore.EObject) match[POSITION_TRG], (org.eclipse.viatra.dse.merge.model.Reference) match[POSITION_CHANGE]);
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
  public static IQuerySpecification<SetReferenceMatcher> querySpecification() throws IncQueryException {
    return SetReferenceQuerySpecification.instance();
  }
}
