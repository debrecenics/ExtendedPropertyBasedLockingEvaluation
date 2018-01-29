package org.eclipse.viatra.dse.merge;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public interface DSEMergeIdMapper {

    /**
     * Returns the identifier of the {@link EObject}. An example (but not safe) implementation can be the following:
     * 
     * <pre>
     * public Object getId(EObject object) {
     *     EClass eClass = object.eClass();
     *     EStructuralFeature id = eClass.getEStructuralFeature(&quot;id&quot;);
     *     return object.eGet(id);
     * }
     * </pre>
     * 
     * If it returns <i>null</i> it will generate a runtime exception.
     * 
     * @return the identifier attribute of the {@link EObject}.
     */
    public Object getId(EObject object);

    /**
     * Returns <b>true</b> if the feature plays any kind of role in the identifier calculation. Otherwise, it returns
     * <b>false</b>. An example implemantation can be the following:
     * 
     * <pre>
     * public boolean isDeterminativeFeature(EStructuralFeature feature) {
     *     if (feature.getName().equals(&quot;id&quot;))
     *         return true;
     *     return false;
     * }
     * </pre>
     * 
     * @return <i>true</i> if it is determinative, otherwise, <i>false</i>
     */
    public boolean isDeterminativeFeature(EStructuralFeature feature);
    
    public EStructuralFeature getIdFeature(EObject object);
}
