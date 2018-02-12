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
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.DifferenceSource;
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

import static org.eclipse.viatra.dse.merge.emf.compare.EMFCompareTranslatorHelper.*;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * This class is responsible for translating {@link Comparison} to {@link ChangeSet}
 * 
 * @author Csaba Debreceni
 *
 */
@SuppressWarnings("restriction")
public class EMFCompareTranslator {

    private DSEMergeIdMapper mapper;
    private Map<Id, Create> created = Maps.newHashMap();
    private Map<Id, Delete> deleted = Maps.newHashMap();
    private Set<Id> doNotTouch = Sets.newHashSet();
    private Map<Change, EObject> mapToObject = Maps.newHashMap();
	private ChangeSet changeSet;
	private Comparison compare;
    
    public EMFCompareTranslator(Comparison compare, DSEMergeIdMapper mapper) {
    	this.compare = compare;
		this.mapper = mapper;
        this.changeSet = ModelFactory.eINSTANCE.createChangeSet();
    }
    
    /**
     * Executes the translation
     * @param compare - comparison result of EMF Compare
     * @param mapper - ID mapper for selecting id of objects
     * @return the translated change set
     */
    public ChangeSet translate() {
        process();
        return changeSet;
    }

    private void process() {
        EList<Diff> list = compare.getDifferences();
        for (Diff diff : list) {
        	if(diff.getSource() == DifferenceSource.RIGHT) continue;
        	if (diff instanceof AttributeChangeSpec) {
                processAttributeChangeSpec((AttributeChangeSpec) diff);
            }
        	if (diff instanceof ReferenceChangeSpec) {
                processReferenceChangeSpec((ReferenceChangeSpec) diff);
            }
        }
    }
    
    private void processAttributeChangeSpec(AttributeChangeSpec diff) {
    	if(processDeletion(diff)) return;
    	if(processCreation(diff)) return;    	
    	if(!checkPrecondition(diff)) return;
    	
    	Id sourceId = createIdFromEObject(getModified(diff), mapper);
        Attribute attribute = ModelFactory.eINSTANCE.createAttribute();
        attribute.setFeature(diff.getAttribute());
        attribute.setValue(diff.getValue());
        attribute.setExecutable(true);
        attribute.setSrc(sourceId);

        if(diff.getKind() == DifferenceKind.ADD) {
        	attribute.setKind(Kind.ADD);
        } else if(diff.getKind() == DifferenceKind.DELETE) {
        	attribute.setKind(Kind.REMOVE);
        } else if(diff.getKind() == DifferenceKind.CHANGE) {
        	attribute.setKind(Kind.SET);
        }       
        changeSet.getChanges().add(attribute);
    }    
    
    private void processReferenceChangeSpec(ReferenceChangeSpec diff) {
    	if(processDeletion(diff)) return;
    	if(processCreation(diff)) return;
    	if(!checkPrecondition(diff,mapper)) return;
    	
    	if(diff.getKind() == DifferenceKind.MOVE) {
			throw new IllegalArgumentException(diff.getKind() + "is not supported for References");
		}
    	
        Id sourceId = createIdFromEObject(getModified(diff), mapper);
        Id targetId = createIdFromEObject(diff.getValue(), mapper);
        
        Reference reference = ModelFactory.eINSTANCE.createReference();
        reference.setFeature(diff.getReference());
        reference.setSrc(sourceId);
        reference.setTrg(targetId);
        reference.setExecutable(true);

        if(diff.getKind() == DifferenceKind.ADD) {
        	reference.setKind(Kind.ADD);
        } else if(diff.getKind() == DifferenceKind.DELETE) {
        	reference.setKind(Kind.REMOVE);
        } else if(diff.getKind() == DifferenceKind.CHANGE) {
        	reference.setKind(Kind.SET);
        }       
        changeSet.getChanges().add(reference);
    }
    
    private boolean processDeletion(Diff diff) {
    	
    	EObject original = getOriginal(diff);
		EObject modified = getModified(diff);
        if(original == null) return false;
        if(original != null && modified != null) return false;
    	
        Id deletedId = createIdFromEObject(original, mapper);
        if(doNotTouch.contains(deletedId)) {
        	return true;
        }
        
        if(created.containsKey(deletedId)) {
        	Create change = created.get(deletedId);
        	changeSet.getChanges().remove(change);
        	created.remove(deletedId);
        	doNotTouch.add(deletedId);
        }       
        
        Delete delete = ModelFactory.eINSTANCE.createDelete();
        delete.setExecutable(true);
        delete.setSrc(deletedId);
        changeSet.getChanges().add(delete);
        deleted.put(deletedId, delete);
        
    	return true;
    }
    
    private boolean processCreation(Diff diff) {
    	
    	EObject original = getOriginal(diff);
		EObject modified = getModified(diff);
        if(modified == null) return false;
        if(modified != null && original != null) return false;
    	
        Id createdId = createIdFromEObject(modified, mapper);
        if(doNotTouch.contains(createdId)) {
        	return true;
        }
        
        if(deleted.containsKey(createdId)) {
        	Delete change = deleted.get(createdId);
        	changeSet.getChanges().remove(change);
        	deleted.remove(createdId);
        	doNotTouch.add(createdId);
        }
        
        Create create = ModelFactory.eINSTANCE.createCreate();
        create.setExecutable(true);
        create.setSrc(createdId);
        instertAllAttributes(modified, createdId, create);
        instertAllReferences(modified, createdId, create);
        changeSet.getChanges().add(create);
        created.put(createdId, create);
        
    	return false;
    }

    @SuppressWarnings("unchecked")
	private void instertAllAttributes(EObject modified, Id createdId, Create create) {
		for (EAttribute attribute : modified.eClass().getEAllAttributes()) {
        	if(attribute.isMany()) {
        		EList<Object> list = (EList<Object>) modified.eGet(attribute);
        		for (Object value : list) {
        			insertAttribute(create, attribute, createdId, value, Kind.ADD);
                }
        	} else {
        		Object value = modified.eGet(attribute);
        		insertAttribute(create, attribute, createdId, value, Kind.SET);                
        	}
		}
	}

    @SuppressWarnings("unchecked")
	private void instertAllReferences(EObject modified, Id createdId, Create create) {
		for (EReference reference : modified.eClass().getEAllReferences()) {
        	if(reference.isMany()) {
        		EList<EObject> list = (EList<EObject>) modified.eGet(reference);
        		for (EObject target : list) {
        			Id targetId = createIdFromEObject(target, mapper);
        			insertReference(create, reference, createdId, targetId, Kind.ADD);
                }
        	} else {
        		EObject target = (EObject) modified.eGet(reference);
        		Id targetId = createIdFromEObject(target, mapper);
    			insertReference(create, reference, createdId, targetId, Kind.SET);                
        	}
		}
	}
    
	private void insertReference(Create create, EReference feature, Id src, Id trg, Kind kind) {
        Reference reference = ModelFactory.eINSTANCE.createReference();
        reference.setFeature(feature);
        reference.setSrc(src);
        reference.setTrg(src);
        reference.setExecutable(true);
        reference.setKind(kind);
        create.getFeatures().add(reference);
        changeSet.getChanges().add(reference);
    }

    private void insertAttribute(Create create, EAttribute feature, Id src, Object value, Kind kind) {
    	if(mapper.isDeterminativeFeature(feature)) return;
    	
        Attribute attribute = ModelFactory.eINSTANCE.createAttribute();
        attribute.setFeature(feature);
        attribute.setSrc(src);
        attribute.setValue(value);
        attribute.setExecutable(true);
        attribute.setKind(kind);
        create.getFeatures().add(attribute);
        changeSet.getChanges().add(attribute);
    }    
}
