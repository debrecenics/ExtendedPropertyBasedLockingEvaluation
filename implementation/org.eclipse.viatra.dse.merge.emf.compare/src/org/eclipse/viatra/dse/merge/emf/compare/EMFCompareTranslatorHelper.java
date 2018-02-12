package org.eclipse.viatra.dse.merge.emf.compare;

import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.DifferenceKind;
import org.eclipse.emf.compare.internal.spec.AttributeChangeSpec;
import org.eclipse.emf.compare.internal.spec.ReferenceChangeSpec;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.viatra.dse.merge.DSEMergeIdMapper;
import org.eclipse.viatra.dse.merge.model.Id;
import org.eclipse.viatra.dse.merge.model.IdType;
import org.eclipse.viatra.dse.merge.model.ModelFactory;

import com.google.common.collect.Lists;

@SuppressWarnings("restriction")
public class EMFCompareTranslatorHelper {

	@SuppressWarnings("unchecked")
	public static boolean checkPrecondition(AttributeChangeSpec diff){
		if(diff.getKind() == DifferenceKind.MOVE) {
			throw new IllegalArgumentException(diff.getKind() + "is not supported for Attributes");
		}
		
    	EObject original = getOriginal(diff);
		if(original == null) return false;
        EObject modified = getModified(diff);
        if(modified == null) return false;
        
        EAttribute attribute = diff.getAttribute();
        Object newValue = diff.getMatch().getLeft().eGet(attribute);
        Object oldValue = diff.getMatch().getRight().eGet(attribute);
        if(diff.getKind() == DifferenceKind.CHANGE) {
			if(newValue == null && oldValue == null) return false;
	        if(newValue != null && newValue.equals(oldValue)) return false;
        }
        if(diff.getKind() == DifferenceKind.ADD) {
            if(original != null) {
            	EList<Object> list = (EList<Object>)original.eGet(attribute);
				if(list.contains(newValue)) return false;
            }
        }
        if(diff.getKind() == DifferenceKind.DELETE) {
            if(modified != null) {
            	EList<Object> list = (EList<Object>)modified.eGet(attribute);
				if(list.contains(oldValue)) return false;
            }
        }
        return true;
    }

	@SuppressWarnings("unchecked")
	public static boolean checkPrecondition(ReferenceChangeSpec diff, DSEMergeIdMapper mapper){
		EObject original = getOriginal(diff);
		if(original == null) return false;
        EObject modified = getModified(diff);
        if(modified == null) return false;
        
        EReference reference = diff.getReference();
        EObject target = (EObject) diff.getValue();
        Id targetId = createIdFromEObject(target, mapper);
        
        if(diff.getKind() == DifferenceKind.CHANGE) {
        	EObject oldTarget = (EObject) diff.getMatch().getRight().eGet(reference);
        	Id oldTargetId = createIdFromEObject(oldTarget, mapper);
            if(targetId == null && oldTargetId == null) return false;
	        if(targetId != null && targetId.equals(oldTargetId)) return false;
        }  
        if(diff.getKind() == DifferenceKind.ADD) {
            if(original != null) {
            	EList<EObject> list = (EList<EObject>)original.eGet(reference);
				if(asIdList(list,mapper).contains(targetId)) return false;
            }
        }
        if(diff.getKind() == DifferenceKind.DELETE) {
            if(modified != null) {
            	EList<EObject> list = (EList<EObject>)modified.eGet(reference);
				if(asIdList(list,mapper).contains(targetId)) return false;
            }
        }
        if(diff.getKind() == DifferenceKind.MOVE) {
			EObject originalContainer = original.eContainer();
			EObject modifiedContainer = modified.eContainer();
			Id originalId = createIdFromEObject(originalContainer, mapper);
			Id modifiedId = createIdFromEObject(modifiedContainer, mapper);
			if(modifiedId.equals(originalId)) return false;				
		}
		
        return true;
    }
	
	private static List<Id> asIdList(EList<EObject> list, DSEMergeIdMapper mapper) {
		List<Id> idList = Lists.newArrayList();
		for (EObject obj : list) {
			idList.add(createIdFromEObject(obj, mapper));
		}
		return idList;
	}

	public static Id createIdFromEObject(EObject object, DSEMergeIdMapper mapper) {
        Object value = mapper.getId(object);
        return create(value);
    }
	
	private static Id create(Object value) {
		if (value == null) {
			return null;
		}
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
	
	private static Id create(int value) {
        Id id = ModelFactory.eINSTANCE.createId();
        id.setEInt(value);
        id.setType(IdType.EINT);
        return id;
    }

    private static Id create(long value) {
        Id id = ModelFactory.eINSTANCE.createId();
        id.setELong(value);
        id.setType(IdType.ELONG);
        return id;
    }

    private static Id create(String value) {
        Id id = ModelFactory.eINSTANCE.createId();
        id.setEString(value);
        id.setType(IdType.ESTRING);
        return id;
    }
    
    public static EObject getOriginal(Diff diff) {
    	return diff.getMatch().getOrigin();
    }
    
    public static EObject getModified(Diff diff) {
    	return diff.getMatch().getLeft();
    }
}
