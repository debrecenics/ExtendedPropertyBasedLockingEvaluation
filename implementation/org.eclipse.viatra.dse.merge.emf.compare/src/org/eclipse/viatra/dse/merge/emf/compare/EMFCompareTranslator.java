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
package org.eclipse.viatra.dse.merge.emf.compare;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.internal.spec.AttributeChangeSpec;
import org.eclipse.emf.compare.internal.spec.ReferenceChangeSpec;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.viatra.dse.merge.DSEMergeIdMapper;
import org.eclipse.viatra.dse.merge.model.Attribute;
import org.eclipse.viatra.dse.merge.model.Change;
import org.eclipse.viatra.dse.merge.model.ChangeSet;
import org.eclipse.viatra.dse.merge.model.Create;
import org.eclipse.viatra.dse.merge.model.Delete;
import org.eclipse.viatra.dse.merge.model.Feature;
import org.eclipse.viatra.dse.merge.model.Id;
import org.eclipse.viatra.dse.merge.model.IdType;
import org.eclipse.viatra.dse.merge.model.Kind;
import org.eclipse.viatra.dse.merge.model.ModelFactory;
import org.eclipse.viatra.dse.merge.model.Reference;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * This class is responsible for translating {@link Comparison} to {@link ChangeSet}
 * 
 * @author Csaba Debreceni
 *
 */
@SuppressWarnings("restriction")
public class EMFCompareTranslator {

    private DSEMergeIdMapper mapper;
    private Map<Object, Create> created = Maps.newHashMap();
    private Map<Object, Delete> deleted = Maps.newHashMap();
    private Map<Change, EObject> mapToObject = Maps.newHashMap();
    
    /**
     * Executes the translation
     * @param compare - comparison result of EMF Compare
     * @param mapper - ID mapper for selecting id of objects
     * @return the translated change set
     */
    public ChangeSet translate(Comparison compare, DSEMergeIdMapper mapper) {
        this.mapper = mapper;
        ChangeSet changeSet = ModelFactory.eINSTANCE.createChangeSet();
        processFeatureChangeSpec(compare, changeSet);

        Collection<Change> toDelete = Lists.newArrayList();
        for(Object key : created.keySet()) {
            if(deleted.containsKey(key)) {
                compareAttributes(created.get(key), deleted.get(key), changeSet);
                toDelete.add(created.get(key));
                toDelete.add(deleted.get(key));
            }
        }
        
        Iterator<Change> iterator = toDelete.iterator();
        while(iterator.hasNext()) {
            Change change = iterator.next();
            if(change instanceof Create) {
                Create create = (Create) change;
                EList<Feature> features = create.getFeatures();
                while(!features.isEmpty()) {
                    EcoreUtil.delete(features.get(0));
                }
            }
            EcoreUtil.delete(change);
        }
        
        return changeSet;
    }

    private void compareAttributes(Create create, Delete delete, ChangeSet changeSet) {
        EObject newObject = mapToObject.get(create);
        EObject oldObject = mapToObject.get(delete);
        
        if(newObject.eClass() == oldObject.eClass()) {
            EList<EAttribute> attributes = newObject.eClass().getEAllAttributes();
            for (EAttribute attribute : attributes) {
                Object newValue = newObject.eGet(attribute);
                Object oldValue = oldObject.eGet(attribute);
                if((newValue == null && oldValue != null ) || (newValue != null && !newValue.equals(oldValue))) {
                    insertAttribute(null, attribute, newObject, newValue, changeSet, Kind.SET);
                }
            }
        }
    }

    private void processFeatureChangeSpec(Comparison compare, ChangeSet changeSet) {

        EList<Diff> list = compare.getDifferences();
        for (Diff diff : list) {
            if (diff instanceof ReferenceChangeSpec) {
                processReferenceChangeSpec((ReferenceChangeSpec) diff, changeSet);
            }
            if (diff instanceof AttributeChangeSpec) {
                processAttributeChangeSpec((AttributeChangeSpec) diff, changeSet);
            }
        }
    }

    private void processAttributeChangeSpec(AttributeChangeSpec diff, ChangeSet changeSet) {

        EObject original = diff.getMatch().getRight();
        if (original == null) {
            return; // A create operation will come
        }
        EObject src = diff.getMatch().getLeft();
        EObject object = src;
        if (object == null)
            return; // A delete operation will come

        EAttribute feature = diff.getAttribute();
        Object newValue = diff.getValue();
        if (mapper.isDeterminativeFeature(feature)) {
            EObject o = diff.getMatch().getLeft();
            createChange(changeSet, (EReference) o.eContainingFeature(), o);
            deleteChange(changeSet, diff.getMatch().getRight().eGet(feature));
            return;
        }

        Attribute attribute = ModelFactory.eINSTANCE.createAttribute();
        attribute.setFeature(feature);
        attribute.setValue(newValue);
        attribute.setExecutable(true);
        attribute.setSrc(createFromEObject(src));

        switch (diff.getKind()) {
        case ADD:
            attribute.setKind(Kind.ADD);
            break;
        case CHANGE:
            attribute.setKind(Kind.SET);
            attribute.setOldValue(diff.getMatch().getRight().eGet(feature));
            break;
        case DELETE:
            attribute.setKind(Kind.REMOVE);
            break;
        default:
            break;
        }

        changeSet.getChanges().add(attribute);
    }

    private void processReferenceChangeSpec(ReferenceChangeSpec diff, ChangeSet changeSet) {

        if (processIfDelete(diff, changeSet))
            return;

        if (processIfCreate(diff, changeSet))
            return;

        EObject original = diff.getMatch().getRight();
        if (original == null) {
            return; // A create operation will come
        }
        EObject object = diff.getMatch().getLeft();

        if (object == null) {
            return; // A delete operation will come
        }

        Reference reference = ModelFactory.eINSTANCE.createReference();
        reference.setFeature(diff.getReference());
        reference.setSrc(createFromEObject(diff.getMatch().getLeft()));

        Object target = object.eGet(diff.getReference());
        if (target != null) {
            if (diff.getMatch().getComparison().getMatch(diff.getValue()) != null && diff.getMatch().getComparison().getMatch(diff.getValue()).getLeft() == null)
                return;
            reference.setTrg(createFromEObject((EObject) diff.getValue()));
        }
        reference.setExecutable(true);

        switch (diff.getKind()) {
        case ADD:
            reference.setKind(Kind.ADD);
            break;
        case CHANGE:
            if (target == null) {
                reference.setKind(Kind.UNSET);
                reference.setOldTrg(createFromEObject((EObject) diff.getMatch().getRight().eGet(diff.getReference())));
            } else {
                reference.setKind(Kind.SET);
                reference.setOldTrg(createFromEObject((EObject) diff.getMatch().getRight().eGet(diff.getReference())));
            }
            break;
        case DELETE:
            reference.setKind(Kind.REMOVE);
            break;
        case MOVE:
            if (diff.getReference().isMany()) {
                reference.setKind(Kind.ADD);
            } else {
                reference.setKind(Kind.SET);
            }
            break;
        default:
            break;
        }
        changeSet.getChanges().add(reference);
    }

    @SuppressWarnings("unchecked")
    private boolean processIfCreate(ReferenceChangeSpec diff, ChangeSet changeSet) {
        EReference reference = diff.getReference();
        if (reference.isContainment() && diff.getKind() != DifferenceKind.DELETE && diff.getKind() != DifferenceKind.MOVE) {

            EObject object = diff.getValue();
            createChange(changeSet, reference, object);
            return true;
        }
        return false;
    }

    private void createChange(ChangeSet changeSet, EReference reference, EObject object) {
        Create create = ModelFactory.eINSTANCE.createCreate();
        create.setExecutable(true);
        create.setSrc(createFromEObject(object));
        create.setFeature(reference);
        create.setClazz(object.eClass());
        create.setContainer(createFromEObject(object.eContainer()));
        changeSet.getChanges().add(create);

        for (EStructuralFeature f : object.eClass().getEAllStructuralFeatures()) {
            // If this feature is determinative in calculating the identifier we miss it 'cause we will set it at
            // the object creation.
            if (mapper.isDeterminativeFeature(f)) {
                continue;
            }
            if (f instanceof EReference) {
                Object result = object.eGet(f);
                if (result instanceof EList<?>) {
                    for (EObject trg : (EList<EObject>) result) {
                        insertReference(create, f, object, trg, changeSet, Kind.ADD);
                    }
                } else if (result != null) {
                    EObject trg = (EObject) result;
                    insertReference(create, f, object, trg, changeSet, Kind.SET);
                }

            }
            if (f instanceof EAttribute) {
                Object result = object.eGet(f);
                if (result instanceof EList<?>) {
                    for (Object trg : (EList<Object>) result) {
                        insertAttribute(create, f, object, trg, changeSet, Kind.ADD);
                    }
                } else {
                    Object trg = (Object) result;
                    insertAttribute(create, f, object, trg, changeSet, Kind.SET);
                }
            }
        }
        created.put(mapper.getId(object), create);
        mapToObject.put(create, object);
    }

    private void deleteChange(ChangeSet changeSet, Object id) {
        Delete delete = ModelFactory.eINSTANCE.createDelete();
        delete.setExecutable(true);
        delete.setSrc(create(id));
        changeSet.getChanges().add(delete);
        deleted.put(id, delete);
//        mapToObject.put(delete, object);
    }
    
    private boolean processIfDelete(ReferenceChangeSpec diff, ChangeSet changeSet) {
        if (diff.getKind() == DifferenceKind.DELETE && diff.getReference().isContainment()) {

            EObject object = diff.getValue();
            Delete delete = ModelFactory.eINSTANCE.createDelete();
            delete.setExecutable(true);
            delete.setSrc(createFromEObject(object));
            changeSet.getChanges().add(delete);
            deleted.put(mapper.getId(object), delete);
            mapToObject.put(delete, object);
            return true;
        }
        return false;
    }

    private void insertReference(Create create, EStructuralFeature feature, EObject src, EObject trg, ChangeSet set,
            Kind kind) {
        Reference reference = ModelFactory.eINSTANCE.createReference();
        reference.setFeature(feature);
        reference.setSrc(createFromEObject(src));
        reference.setTrg(createFromEObject(trg));
        reference.setExecutable(true);
        reference.setKind(kind);
        set.getChanges().add(reference);
        create.getFeatures().add(reference);
    }

    private void insertAttribute(Create create, EStructuralFeature feature, EObject src, Object trg, ChangeSet set, Kind kind) {
        Attribute attribute = ModelFactory.eINSTANCE.createAttribute();
        attribute.setFeature(feature);
        attribute.setSrc(createFromEObject(src));
        attribute.setValue(trg);
        attribute.setExecutable(true);
        attribute.setKind(kind);
        set.getChanges().add(attribute);
        if(create != null)
            create.getFeatures().add(attribute);
    }

    private Id create(int value) {
        Id id = ModelFactory.eINSTANCE.createId();
        id.setEInt(value);
        id.setType(IdType.EINT);
        return id;
    }

    private Id create(long value) {
        Id id = ModelFactory.eINSTANCE.createId();
        id.setELong(value);
        id.setType(IdType.ELONG);
        return id;
    }

    private Id create(String value) {
        Id id = ModelFactory.eINSTANCE.createId();
        id.setEString(value);
        id.setType(IdType.ESTRING);
        return id;
    }

    private Id create(Object value) {
        if (value instanceof Integer) {
            return create((int) value);
        }
        if (value instanceof Long) {
            return create((long) value);
        }
        if (value instanceof String) {
            return create((String) value);
        }
        return null;
    }
    
    private Id createFromEObject(EObject object) {
        Object value = mapper.getId(object);
        return create(value);
    }    
}
