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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PQuery;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.eclipse.viatra.dse.merge.iq.RemoveReferenceMatch;
import org.eclipse.viatra.dse.merge.iq.RemoveReferenceMatcher;
import org.eclipse.viatra.dse.merge.iqconflicts.util.ConflictHelperQuerySpecification;
import org.eclipse.viatra.dse.merge.iqconflicts.util.ExecutedQuerySpecification;

import com.google.common.collect.Sets;

/**
 * A pattern-specific query specification that can instantiate
 * RemoveReferenceMatcher in a type-safe way.
 * 
 * @see RemoveReferenceMatcher
 * @see RemoveReferenceMatch
 * 
 */
@SuppressWarnings("all")
public final class RemoveReferenceQuerySpecification extends
		BaseGeneratedEMFQuerySpecification<RemoveReferenceMatcher> {
	private RemoveReferenceQuerySpecification(PQuery id2object) {
		super(new GeneratedPQuery(id2object));
	}

	/**
	 * @return the singleton instance of the query specification
	 * @throws IncQueryException
	 *             if the pattern definition could not be loaded
	 * 
	 */
	
	public static RemoveReferenceQuerySpecification instance()
			throws IncQueryException {
		return LazyHolder.INSTANCE;
	}
	
	public static RemoveReferenceQuerySpecification instance(
			PQuery id2object) throws IncQueryException {
		try {
			return LazyHolder.make(id2object);
		} catch (ExceptionInInitializerError err) {
			throw processInitializerError(err);
		}
	}

	@Override
	protected RemoveReferenceMatcher instantiate(final IncQueryEngine engine)
			throws IncQueryException {
		return RemoveReferenceMatcher.on(engine);
	}

	@Override
	public RemoveReferenceMatch newEmptyMatch() {
		return RemoveReferenceMatch.newEmptyMatch();
	}

	@Override
	public RemoveReferenceMatch newMatch(final Object... parameters) {
		return RemoveReferenceMatch.newMatch(
				(org.eclipse.emf.ecore.EObject) parameters[0],
				(org.eclipse.emf.ecore.EObject) parameters[1],
				(org.eclipse.viatra.dse.merge.model.Reference) parameters[2]);
	}

	private static class LazyHolder {
		private static RemoveReferenceQuerySpecification INSTANCE;

		public static RemoveReferenceQuerySpecification make(
				PQuery id2object) {
			return INSTANCE = new RemoveReferenceQuerySpecification(id2object);
		}
	}

	private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
		private PQuery id2object;

		public GeneratedPQuery(PQuery id2object) {
			this.id2object = id2object;
		}

		@Override
		public String getFullyQualifiedName() {
			return "org.eclipse.viatra.dse.merge.iq.removeReference";
		}

		@Override
		public List<String> getParameterNames() {
			return Arrays.asList("src", "trg", "change");
		}

		@Override
		public List<PParameter> getParameters() {
			return Arrays.asList(new PParameter("src",
					"org.eclipse.emf.ecore.EObject"), new PParameter("trg",
					"org.eclipse.emf.ecore.EObject"), new PParameter("change",
					"org.eclipse.viatra.dse.merge.model.Reference"));
		}

		@Override
		public Set<PBody> doGetContainedBodies()
				throws QueryInitializationException {
			Set<PBody> bodies = Sets.newLinkedHashSet();
			try {
				{
					PBody body = new PBody(this);
					PVariable var_src = body.getOrCreateVariableByName("src");
					PVariable var_trg = body.getOrCreateVariableByName("trg");
					PVariable var_change = body
							.getOrCreateVariableByName("change");
					PVariable var_src_id = body
							.getOrCreateVariableByName("src_id");
					PVariable var__virtual_0_ = body
							.getOrCreateVariableByName(".virtual{0}");
					PVariable var__virtual_1_ = body
							.getOrCreateVariableByName(".virtual{1}");
					PVariable var__virtual_2_ = body
							.getOrCreateVariableByName(".virtual{2}");
					PVariable var_trg_id = body
							.getOrCreateVariableByName("trg_id");
					PVariable var__virtual_3_ = body
							.getOrCreateVariableByName(".virtual{3}");
					PVariable var__virtual_4_ = body
							.getOrCreateVariableByName(".virtual{4}");
					PVariable var__virtual_5_ = body
							.getOrCreateVariableByName(".virtual{5}");
					PVariable var__virtual_6_ = body
							.getOrCreateVariableByName(".virtual{6}");
					PVariable var__virtual_7_ = body
							.getOrCreateVariableByName(".virtual{7}");
					body.setExportedParameters(Arrays
							.<ExportedParameter> asList(new ExportedParameter(
									body, var_src, "src"),

							new ExportedParameter(body, var_trg, "trg"),

							new ExportedParameter(body, var_change, "change")));
					new TypeConstraint(
							body,
							new FlatTuple(var_src),
							new EClassTransitiveInstancesKey(
									(EClass) getClassifierLiteral(
											"http://www.eclipse.org/emf/2002/Ecore",
											"EObject")));
					new TypeConstraint(
							body,
							new FlatTuple(var_trg),
							new EClassTransitiveInstancesKey(
									(EClass) getClassifierLiteral(
											"http://www.eclipse.org/emf/2002/Ecore",
											"EObject")));
					new TypeConstraint(
							body,
							new FlatTuple(var_change),
							new EClassTransitiveInstancesKey(
									(EClass) getClassifierLiteral(
											"http://org.eclipse.viatra.dse.merge/model",
											"Reference")));
					new PositivePatternCall(body, new FlatTuple(var_src,
							var_src_id), id2object);
					new TypeConstraint(
							body,
							new FlatTuple(var_change, var__virtual_1_),
							new EStructuralFeatureInstancesKey(
									getFeatureLiteral(
											"http://org.eclipse.viatra.dse.merge/model",
											"Change", "src")));
					new PositivePatternCall(body, new FlatTuple(var__virtual_1_, var__virtual_2_), 
                            IdValueQuerySpecification.instance().getInternalQueryRepresentation());
                    new Equality(body, var__virtual_2_, var_src_id);
					new PositivePatternCall(body, new FlatTuple(var_trg,
							var_trg_id), id2object);
					new TypeConstraint(
							body,
							new FlatTuple(var_change, var__virtual_4_),
							new EStructuralFeatureInstancesKey(
									getFeatureLiteral(
											"http://org.eclipse.viatra.dse.merge/model",
											"Reference", "trg")));
					new PositivePatternCall(body, new FlatTuple(var__virtual_4_, var__virtual_5_), 
                            IdValueQuerySpecification.instance().getInternalQueryRepresentation());
                    new Equality(body, var__virtual_5_, var_trg_id);
					new ConstantValue(body, var__virtual_6_, getEnumLiteral(
							"http://org.eclipse.viatra.dse.merge/model",
							"Kind", "remove").getInstance());
					new TypeConstraint(
							body,
							new FlatTuple(var_change, var__virtual_7_),
							new EStructuralFeatureInstancesKey(
									getFeatureLiteral(
											"http://org.eclipse.viatra.dse.merge/model",
											"Feature", "kind")));
					new Equality(body, var__virtual_7_, var__virtual_6_);
					new NegativePatternCall(body, new FlatTuple(var_change), ExecutedQuerySpecification.instance().getInternalQueryRepresentation());
                    PVariable var_conflict = body
                            .getOrCreateVariableByName(".virtual{conflict}");
                    new NegativePatternCall(body, new FlatTuple(var_change, var_conflict), ConflictHelperQuerySpecification.instance().getInternalQueryRepresentation());
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
