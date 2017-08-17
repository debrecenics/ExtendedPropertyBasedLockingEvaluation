package org.mondo.collaboration.security.locking.eval.utility;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

public class DomainSpecificIdentification {

	private static IDomainSpecificIdentifier identifier = new DefaultDomainSpecificIdentifier();
	
	public static void setDomainSpecificIdentifier(IDomainSpecificIdentifier identifier) {
		DomainSpecificIdentification.identifier = identifier;
	}
	
	public static Object getIdentifier(Object object) {
		return identifier.getIdentifier(object);
	}
	
	public interface IDomainSpecificIdentifier {
		public Object getIdentifier(Object object);
	}
	
	public static class DefaultDomainSpecificIdentifier implements IDomainSpecificIdentifier {

		@Override
		public Object getIdentifier(Object object) {
			if(object instanceof EObject) {
				EObject eObject = (EObject) object;
				EStructuralFeature idFeature = eObject.eClass().getEStructuralFeature("id");
				if(idFeature != null)
					return eObject.eGet(idFeature);
				
			}
			throw new IllegalArgumentException();
		}
		
	}
	
}
