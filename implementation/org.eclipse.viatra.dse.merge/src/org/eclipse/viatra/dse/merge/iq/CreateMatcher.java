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
import org.eclipse.viatra.dse.merge.iq.CreateMatcher;
import org.eclipse.viatra.dse.merge.iq.util.CreateProcessor;

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
import org.eclipse.viatra.dse.merge.iq.CreateMatch;
import org.eclipse.viatra.dse.merge.iq.util.CreateQuerySpecification;
import org.eclipse.viatra.dse.merge.model.Create;

/**
 * Generated pattern matcher API of the org.eclipse.viatra.dse.merge.iq.create pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link CreateMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * pattern create(container : EObject, change : Create) {
 * 	EObject.id(container, c_id);
 * 	Create.container.eString(change, c_id);
 * 	Change.executable(change, true);
 * }
 * </pre></code>
 * 
 * @see CreateMatch
 * @see CreateProcessor
 * @see CreateQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class CreateMatcher extends BaseMatcher<CreateMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static CreateMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    CreateMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new CreateMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_CONTAINER = 0;
  
  private final static int POSITION_CHANGE = 1;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(CreateMatcher.class);
  
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
  public CreateMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public CreateMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pContainer the fixed value of pattern parameter container, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return matches represented as a CreateMatch object.
   * 
   */
  public Collection<CreateMatch> getAllMatches(final EObject pContainer, final Create pChange) {
    return rawGetAllMatches(new Object[]{pContainer, pChange});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pContainer the fixed value of pattern parameter container, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return a match represented as a CreateMatch object, or null if no match is found.
   * 
   */
  public CreateMatch getOneArbitraryMatch(final EObject pContainer, final Create pChange) {
    return rawGetOneArbitraryMatch(new Object[]{pContainer, pChange});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pContainer the fixed value of pattern parameter container, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final EObject pContainer, final Create pChange) {
    return rawHasMatch(new Object[]{pContainer, pChange});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pContainer the fixed value of pattern parameter container, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final EObject pContainer, final Create pChange) {
    return rawCountMatches(new Object[]{pContainer, pChange});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pContainer the fixed value of pattern parameter container, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final EObject pContainer, final Create pChange, final IMatchProcessor<? super CreateMatch> processor) {
    rawForEachMatch(new Object[]{pContainer, pChange}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pContainer the fixed value of pattern parameter container, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final EObject pContainer, final Create pChange, final IMatchProcessor<? super CreateMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pContainer, pChange}, processor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pContainer the fixed value of pattern parameter container, or null if not bound.
   * @param pChange the fixed value of pattern parameter change, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public CreateMatch newMatch(final EObject pContainer, final Create pChange) {
    return CreateMatch.newMatch(pContainer, pChange);
  }
  
  /**
   * Retrieve the set of values that occur in matches for container.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<EObject> rawAccumulateAllValuesOfcontainer(final Object[] parameters) {
    Set<EObject> results = new HashSet<EObject>();
    rawAccumulateAllValues(POSITION_CONTAINER, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for container.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfcontainer() {
    return rawAccumulateAllValuesOfcontainer(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for container.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfcontainer(final CreateMatch partialMatch) {
    return rawAccumulateAllValuesOfcontainer(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for container.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<EObject> getAllValuesOfcontainer(final Create pChange) {
    return rawAccumulateAllValuesOfcontainer(new Object[]{
    null, 
    pChange
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for change.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Create> rawAccumulateAllValuesOfchange(final Object[] parameters) {
    Set<Create> results = new HashSet<Create>();
    rawAccumulateAllValues(POSITION_CHANGE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for change.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Create> getAllValuesOfchange() {
    return rawAccumulateAllValuesOfchange(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for change.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Create> getAllValuesOfchange(final CreateMatch partialMatch) {
    return rawAccumulateAllValuesOfchange(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for change.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Create> getAllValuesOfchange(final EObject pContainer) {
    return rawAccumulateAllValuesOfchange(new Object[]{
    pContainer, 
    null
    });
  }
  
  @Override
  protected CreateMatch tupleToMatch(final Tuple t) {
    try {
    	return CreateMatch.newMatch((org.eclipse.emf.ecore.EObject) t.get(POSITION_CONTAINER), (org.eclipse.viatra.dse.merge.model.Create) t.get(POSITION_CHANGE));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected CreateMatch arrayToMatch(final Object[] match) {
    try {
    	return CreateMatch.newMatch((org.eclipse.emf.ecore.EObject) match[POSITION_CONTAINER], (org.eclipse.viatra.dse.merge.model.Create) match[POSITION_CHANGE]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected CreateMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return CreateMatch.newMutableMatch((org.eclipse.emf.ecore.EObject) match[POSITION_CONTAINER], (org.eclipse.viatra.dse.merge.model.Create) match[POSITION_CHANGE]);
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
  public static IQuerySpecification<CreateMatcher> querySpecification() throws IncQueryException {
    return CreateQuerySpecification.instance();
  }
}
