/*******************************************************************************
 * Copyright (c) 2010-2015, Csaba Debreceni, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Csaba Debreceni - initial API and implementation
 ********************************************************************************/
package org.eclipse.viatra.dse.merge;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.DSETransformationRule;
import org.eclipse.viatra.dse.merge.iq.AddAttributeMatch;
import org.eclipse.viatra.dse.merge.iq.AddAttributeMatcher;
import org.eclipse.viatra.dse.merge.iq.AddReferenceMatch;
import org.eclipse.viatra.dse.merge.iq.AddReferenceMatcher;
import org.eclipse.viatra.dse.merge.iq.CreateMatch;
import org.eclipse.viatra.dse.merge.iq.CreateMatcher;
import org.eclipse.viatra.dse.merge.iq.DeleteMatch;
import org.eclipse.viatra.dse.merge.iq.DeleteMatcher;
import org.eclipse.viatra.dse.merge.iq.RemoveAttributeMatch;
import org.eclipse.viatra.dse.merge.iq.RemoveAttributeMatcher;
import org.eclipse.viatra.dse.merge.iq.RemoveReferenceMatch;
import org.eclipse.viatra.dse.merge.iq.RemoveReferenceMatcher;
import org.eclipse.viatra.dse.merge.iq.SetAttributeMatch;
import org.eclipse.viatra.dse.merge.iq.SetAttributeMatcher;
import org.eclipse.viatra.dse.merge.iq.SetReferenceMatch;
import org.eclipse.viatra.dse.merge.iq.SetReferenceMatcher;
import org.eclipse.viatra.dse.merge.iq.UnsetReferenceMatch;
import org.eclipse.viatra.dse.merge.iq.UnsetReferenceMatcher;
import org.eclipse.viatra.dse.merge.iq.util.AddAttributeQuerySpecification;
import org.eclipse.viatra.dse.merge.iq.util.AddReferenceQuerySpecification;
import org.eclipse.viatra.dse.merge.iq.util.CreateQuerySpecification;
import org.eclipse.viatra.dse.merge.iq.util.DeleteQuerySpecification;
import org.eclipse.viatra.dse.merge.iq.util.GoalPatternQuerySpecification;
import org.eclipse.viatra.dse.merge.iq.util.RemoveAttributeQuerySpecification;
import org.eclipse.viatra.dse.merge.iq.util.RemoveReferenceQuerySpecification;
import org.eclipse.viatra.dse.merge.iq.util.SetAttributeQuerySpecification;
import org.eclipse.viatra.dse.merge.iq.util.SetReferenceQuerySpecification;
import org.eclipse.viatra.dse.merge.iq.util.UnsetReferenceQuerySpecification;
import org.eclipse.viatra.dse.merge.operations.DefaultAddAttributeOperation;
import org.eclipse.viatra.dse.merge.operations.DefaultAddReferenceOperation;
import org.eclipse.viatra.dse.merge.operations.DefaultCreateOperation;
import org.eclipse.viatra.dse.merge.operations.DefaultDeleteOperation;
import org.eclipse.viatra.dse.merge.operations.DefaultRemoveAttributeOperation;
import org.eclipse.viatra.dse.merge.operations.DefaultRemoveReferenceOperation;
import org.eclipse.viatra.dse.merge.operations.DefaultSetAttributeOperation;
import org.eclipse.viatra.dse.merge.operations.DefaultSetReferenceOperation;
import org.eclipse.viatra.dse.merge.operations.DefaultUnsetReferenceOperation;

import com.google.common.collect.Sets;

/**
 * This class is responsible for configuring the DSE Merge. It requires to implement the following methods:
 * <ul>
 * <li>{@link #getMetamodel() getMetamodel} returns the meta-model of the instances</li>
 * <li>{@link #getId2EObject() getId2EObject} maps the identifiers and objects</li>
 * <ul>
 * 
 * @author Csaba Debreceni
 */
public abstract class DSEMergeConfigurator {

    private DSETransformationRule<UnsetReferenceMatch, UnsetReferenceMatcher> unsetReference;
    private DSETransformationRule<SetReferenceMatch, SetReferenceMatcher> setReference;
    private DSETransformationRule<SetAttributeMatch, SetAttributeMatcher> setAttribute;
    private DSETransformationRule<RemoveReferenceMatch, RemoveReferenceMatcher> removeReference;
    private DSETransformationRule<RemoveAttributeMatch, RemoveAttributeMatcher> removeAttribute;
    private DSETransformationRule<AddReferenceMatch, AddReferenceMatcher> addReference;
    private DSETransformationRule<AddAttributeMatch, AddAttributeMatcher> addAttribute;
    private DSETransformationRule<CreateMatch, CreateMatcher> create;
    private DSETransformationRule<DeleteMatch, DeleteMatcher> delete;

    /**
     * Returns the meta-model of the instances
     * 
     * @return the meta-model of the instances
     */
    public abstract EPackage getMetamodel();

    /**
     * Maps the identifiers and objects. It has two parameter: the first one is the object while the second one is the
     * identifier. An example pattern can be the following
     * 
     * <pre>
     * pattern id2object(obj : YourEClass, id) { 
     *   YourEClass.id(obj, id); 
     * }
     * </pre>
     * 
     * @return a query for mapping
     * @throws IncQueryException
     */
    public abstract IQuerySpecification<?> getId2EObject() throws IncQueryException;

    /**
     * Returns id mapper implementation. An example (but not safe) implementation can be the following:
     * 
     * <pre>
     * public DSEMergeIdMapper getIdMapper() {
     *     return new DSEMergeIdMapper() {
     *         public Object getId(EObject object) {
     *             EClass eClass = object.eClass();
     *             EStructuralFeature id = eClass.getEStructuralFeature(&quot;id&quot;);
     *             return object.eGet(id);
     *         }
     *     };
     * }
     * </pre>
     * 
     * If it returns <i>null</i> it will generate a runtime exception.
     * 
     * @return the identifier attribute of the {@link EClass}.
     */
    public abstract DSEMergeIdMapper getIdMapper();

    /**
     * Collects all the containment references in the model to ensure about the parent children relationships.
     * 
     * <pre>
     * pattern containmentPattern(parent:EObject,child:EObject) { 
     *   YourEClass.containmentReference(parent, child); 
     * }
     * </pre>
     *      
     * @return a query describing the containments
     * @throws IncQueryException
     */
    public abstract IQuerySpecification<?> getContainmentPattern() throws IncQueryException;
    
    /**
     * Returns a union of default and additional objectives to be satisfied at the end of the merge process. <i>This
     * method is intend to be override when the default objectives are not required.</i>
     * 
     * @return a union of default and additional objectives to be satisfied at the end of the merge process.
     * @throws IncQueryException
     */
    public Collection<IQuerySpecification<?>> getObjectives() throws IncQueryException {
        return Sets.union(defaultObjectives(), additionalObjectives());
    }

    /**
     * Clients have to override this method to provide additional objectives for the merge process.
     * 
     * @return the additional objectives to be satisfied at the end of the merge process
     * @throws IncQueryException
     */
    public Set<IQuerySpecification<?>> additionalObjectives() throws IncQueryException {
        return Collections.emptySet();
    }

    /**
     * Returns a union of default and additional rules that can be executed during the merge process. <i>This method is
     * intend to be override when the default rules are not required.</i>
     * 
     * @return a union of default and additional rules that can be executed during the merge process
     * @throws IncQueryException
     */
    public Set<DSETransformationRule<?, ?>> getRules() throws IncQueryException {
        return Sets.union(defaultRules(), additionalRules());
    }

    /**
     * Clients have to override this method to provide additional rules for the merge process.
     * 
     * @return the additional rules that can be executed during the merge process
     * @throws IncQueryException
     */
    public Set<DSETransformationRule<?, ?>> additionalRules() throws IncQueryException {
        return Collections.emptySet();
    }

    /**
     * Returns the default objectives. Currently, the following objectives are the defaults:
     * <ul>
     * <li>All the executable operations have to be executed</li>
     * </ul>
     * 
     * @return default objectives
     * @throws IncQueryException
     */
    public final Set<IQuerySpecification<?>> defaultObjectives() throws IncQueryException {
        return Sets.<IQuerySpecification<?>> newHashSet(
                GoalPatternQuerySpecification.instance(
                getId2EObject().getInternalQueryRepresentation(),
                getContainmentPattern().getInternalQueryRepresentation()));
//                SetAttributeQuerySpecification.instance(getId2EObject().getInternalQueryRepresentation()));
    }

    /**
     * Returns the default rules. Currently, the following rules are the defaults: <br>
     * <i>Create</i>, <i>Delete</i>,<br>
     * <i>AddReference</i>, <i>SetReference</i>, <i>RemoveReference</i>, <i>UnsetReference</i>, <br>
     * <i>AddAttribute</i>, <i>SetAttribute</i>, <i>RemoveAttribute</i>
     * 
     * <p>
     * <i>This collection is mutable. To remove a default rule from the collection, feel free to us the following
     * code</i>
     * 
     * <pre>
     * defaultRules().remove(defaultXXX());
     * </pre>
     * 
     * </p>
     * 
     * @return default rules
     * @throws IncQueryException
     */
    public final Set<DSETransformationRule<?, ?>> defaultRules() throws IncQueryException {
        return Sets.<DSETransformationRule<?, ?>> newHashSet(defaultCreate(), defaultDelete(), defaultAddAttribute(),
                defaultRemoveAttribute(), defaultSetAttribute(), defaultAddReference(), defaultRemoveReference(),
                defaultSetReference(), defaultUnsetReference());
    }

    public final DSETransformationRule<UnsetReferenceMatch, UnsetReferenceMatcher> defaultUnsetReference()
            throws IncQueryException {
        return unsetReference == null ? unsetReference = new DSETransformationRule<UnsetReferenceMatch, UnsetReferenceMatcher>(
                UnsetReferenceQuerySpecification.instance(getId2EObject().getInternalQueryRepresentation()),
                new DefaultUnsetReferenceOperation()) : unsetReference;
    }

    public final DSETransformationRule<SetReferenceMatch, SetReferenceMatcher> defaultSetReference()
            throws IncQueryException {
        return setReference == null ? setReference = new DSETransformationRule<SetReferenceMatch, SetReferenceMatcher>(
                SetReferenceQuerySpecification.instance(getId2EObject().getInternalQueryRepresentation()),
                new DefaultSetReferenceOperation()) : setReference;
    }

    public final DSETransformationRule<SetAttributeMatch, SetAttributeMatcher> defaultSetAttribute()
            throws IncQueryException {
        return setAttribute == null ? setAttribute = new DSETransformationRule<SetAttributeMatch, SetAttributeMatcher>(
                SetAttributeQuerySpecification.instance(getId2EObject().getInternalQueryRepresentation()),
                new DefaultSetAttributeOperation()) : setAttribute;
    }

    public final DSETransformationRule<RemoveReferenceMatch, RemoveReferenceMatcher> defaultRemoveReference()
            throws IncQueryException {
        return removeReference == null ? removeReference = new DSETransformationRule<RemoveReferenceMatch, RemoveReferenceMatcher>(
                RemoveReferenceQuerySpecification.instance(getId2EObject().getInternalQueryRepresentation()),
                new DefaultRemoveReferenceOperation()) : removeReference;
    }

    public final DSETransformationRule<RemoveAttributeMatch, RemoveAttributeMatcher> defaultRemoveAttribute()
            throws IncQueryException {
        return removeAttribute == null ? removeAttribute = new DSETransformationRule<RemoveAttributeMatch, RemoveAttributeMatcher>(
                RemoveAttributeQuerySpecification.instance(getId2EObject().getInternalQueryRepresentation()),
                new DefaultRemoveAttributeOperation()) : removeAttribute;
    }

    public final DSETransformationRule<DeleteMatch, DeleteMatcher> defaultDelete() throws IncQueryException {
        return delete == null ? delete = new DSETransformationRule<DeleteMatch, DeleteMatcher>(
                DeleteQuerySpecification.instance(getId2EObject().getInternalQueryRepresentation(), 
                        getContainmentPattern().getInternalQueryRepresentation()),
                new DefaultDeleteOperation()) : delete;
    }

    public final DSETransformationRule<CreateMatch, CreateMatcher> defaultCreate() throws IncQueryException {
        return create == null ? create = new DSETransformationRule<CreateMatch, CreateMatcher>(
                CreateQuerySpecification.instance(getId2EObject().getInternalQueryRepresentation()),
                new DefaultCreateOperation(getIdMapper())) : create;
    }

    public final DSETransformationRule<AddReferenceMatch, AddReferenceMatcher> defaultAddReference()
            throws IncQueryException {
        return addReference == null ? addReference = new DSETransformationRule<AddReferenceMatch, AddReferenceMatcher>(
                AddReferenceQuerySpecification.instance(getId2EObject().getInternalQueryRepresentation()),
                new DefaultAddReferenceOperation()) : addReference;
    }

    public final DSETransformationRule<AddAttributeMatch, AddAttributeMatcher> defaultAddAttribute()
            throws IncQueryException {
        return addAttribute == null ? addAttribute = new DSETransformationRule<AddAttributeMatch, AddAttributeMatcher>(
                AddAttributeQuerySpecification.instance(getId2EObject().getInternalQueryRepresentation()),
                new DefaultAddAttributeOperation()) : addAttribute;
    }
}
