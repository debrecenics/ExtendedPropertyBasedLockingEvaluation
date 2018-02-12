package org.eclipse.viatra.dse.merge.emf.compare;

import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.match.IMatchEngine.Factory.Registry;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.dse.merge.DSEMergeIdMapper;
import org.eclipse.viatra.dse.merge.model.ChangeSet;

public class EMFCompareHelper {

	public static ChangeSet calculateChanges(EObject modified, EObject original, DSEMergeIdMapper mapper) {
		Registry registry = EMFCompareMatchEngineRegistry.createDSEMergeSpecificRegistry(mapper);
		IComparisonScope scope = new DefaultComparisonScope(modified, original, original);
		Comparison comparison = EMFCompare.builder().setMatchEngineFactoryRegistry(registry).build().compare(scope);
		EMFCompareTranslator translator = new EMFCompareTranslator(comparison,mapper);
		return translator.translate();
	}
	
}
