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
package org.eclipse.viatra.dse.merge.iq.util;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.eclipse.viatra.dse.merge.iq.GoalPatternMatch;
import org.eclipse.viatra.dse.merge.iq.GoalPatternMatcher;
import org.eclipse.viatra.dse.merge.iqconflicts.util.ConflictHelperQuerySpecification;

import com.google.common.collect.Sets;

/**
 * A pattern-specific query specification that can instantiate
 * GoalPatternMatcher in a type-safe way.
 * 
 * @see GoalPatternMatcher
 * @see GoalPatternMatch
 * 
 */
@SuppressWarnings("all")
public final class GoalPatternQuerySpecification extends
		BaseGeneratedEMFQuerySpecification<GoalPatternMatcher> {
	private GoalPatternQuerySpecification(PQuery id2object, PQuery containment) {
		super(new GeneratedPQuery(id2object, containment));
	}

	/**
	 * @return the singleton instance of the query specification
	 * @throws IncQueryException
	 *             if the pattern definition could not be loaded
	 * 
	 */
	
	public static GoalPatternQuerySpecification instance()
			throws IncQueryException {
		return LazyHolder.INSTANCE;
	}
	
	public static GoalPatternQuerySpecification instance(
			PQuery id2object, PQuery containment) throws IncQueryException {
		try {
			return LazyHolder.make(id2object, containment);
		} catch (ExceptionInInitializerError err) {
			throw processInitializerError(err);
		}
	}

	@Override
	protected GoalPatternMatcher instantiate(final IncQueryEngine engine)
			throws IncQueryException {
		return GoalPatternMatcher.on(engine);
	}

	@Override
	public GoalPatternMatch newEmptyMatch() {
		return GoalPatternMatch.newEmptyMatch();
	}

	@Override
	public GoalPatternMatch newMatch(final Object... parameters) {
		return GoalPatternMatch.newMatch();
	}

	private static class LazyHolder {
		
		private static GoalPatternQuerySpecification INSTANCE;
		
		public static GoalPatternQuerySpecification make(
				PQuery id2object, PQuery containment) {
			return INSTANCE = new GoalPatternQuerySpecification(id2object, containment);
		}
	}

	private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {

		PQuery id2object;
		PQuery containment;

		public GeneratedPQuery(PQuery id2object, PQuery containment) {
			this.id2object = id2object;
			this.containment = containment;
		}

		@Override
		public String getFullyQualifiedName() {
			return "org.eclipse.viatra.dse.merge.iq.goalPattern";
		}

		@Override
		public List<String> getParameterNames() {
			return Arrays.asList();
		}

		@Override
		public List<PParameter> getParameters() {
			return Arrays.asList();
		}

		@Override
		public Set<PBody> doGetContainedBodies()
				throws QueryInitializationException {
			Set<PBody> bodies = Sets.newLinkedHashSet();
			try {
				{
					PBody body = new PBody(this);
					PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
					PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
					body.setExportedParameters(Arrays
							.<ExportedParameter> asList());
					new PositivePatternCall(body, new FlatTuple(var___0_,
							var___1_), CreateQuerySpecification.instance(id2object)
							.getInternalQueryRepresentation());
					bodies.add(body);
				}
				{
					PBody body = new PBody(this);
					PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
					PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
					body.setExportedParameters(Arrays
							.<ExportedParameter> asList());
					new PositivePatternCall(body, new FlatTuple(var___0_,
							var___1_), DeleteQuerySpecification.instance(id2object, containment).getInternalQueryRepresentation());
					bodies.add(body);
				}
				{
					PBody body = new PBody(this);
					PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
					PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
					PVariable var___2_ = body.getOrCreateVariableByName("_<2>");
					body.setExportedParameters(Arrays
							.<ExportedParameter> asList());
					new PositivePatternCall(body, new FlatTuple(var___0_,
							var___1_, var___2_), SetReferenceQuerySpecification
							.instance(id2object).getInternalQueryRepresentation());
					bodies.add(body);
				}
				{
					PBody body = new PBody(this);
					PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
					PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
					body.setExportedParameters(Arrays
							.<ExportedParameter> asList());
					new PositivePatternCall(body, new FlatTuple(var___0_,
							var___1_), UnsetReferenceQuerySpecification
							.instance(id2object).getInternalQueryRepresentation());
					bodies.add(body);
				}
				{
					PBody body = new PBody(this);
					PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
					PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
					PVariable var___2_ = body.getOrCreateVariableByName("_<2>");
					body.setExportedParameters(Arrays
							.<ExportedParameter> asList());
					new PositivePatternCall(body, new FlatTuple(var___0_,
							var___1_, var___2_), AddReferenceQuerySpecification
							.instance(id2object).getInternalQueryRepresentation());
					bodies.add(body);
				}
				{
					PBody body = new PBody(this);
					PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
					PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
					PVariable var___2_ = body.getOrCreateVariableByName("_<2>");
					body.setExportedParameters(Arrays
							.<ExportedParameter> asList());
					new PositivePatternCall(body, new FlatTuple(var___0_,
							var___1_, var___2_),
							RemoveReferenceQuerySpecification.instance(id2object)
									.getInternalQueryRepresentation());
					bodies.add(body);
				}
				{
					PBody body = new PBody(this);
					PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
					PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
					body.setExportedParameters(Arrays
							.<ExportedParameter> asList());
					new PositivePatternCall(body, new FlatTuple(var___0_,
							var___1_), SetAttributeQuerySpecification
							.instance(id2object).getInternalQueryRepresentation());
					bodies.add(body);
				}
				{
					PBody body = new PBody(this);
					PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
					PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
					body.setExportedParameters(Arrays
							.<ExportedParameter> asList());
					new PositivePatternCall(body, new FlatTuple(var___0_,
							var___1_), AddAttributeQuerySpecification
							.instance(id2object).getInternalQueryRepresentation());
					bodies.add(body);
				}
				{
					PBody body = new PBody(this);
					PVariable var___0_ = body.getOrCreateVariableByName("_<0>");
					PVariable var___1_ = body.getOrCreateVariableByName("_<1>");
					body.setExportedParameters(Arrays
							.<ExportedParameter> asList());
					new PositivePatternCall(body, new FlatTuple(var___0_,
							var___1_), RemoveAttributeQuerySpecification
							.instance(id2object).getInternalQueryRepresentation());
					bodies.add(body);
				}
				// to silence compiler error
				if (false)
					throw new IncQueryException("Never", "happens");
			} catch (IncQueryException ex) {
				throw processDependencyException(ex);
			}
			return bodies;
		}
	}
}
