package org.eclipse.viatra.dse.merge.emf.compare;

import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.viatra.dse.merge.DSEMergeIdMapper;

public class EMFCompareMatchEngineFactoryImpl extends MatchEngineFactoryImpl {

	public EMFCompareMatchEngineFactoryImpl(DSEMergeIdMapper mapper) {
		EMFCompareEqualityHelperFactory helperFactory = new EMFCompareEqualityHelperFactory(mapper);
		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(helperFactory);
		IEObjectMatcher eobjectMatcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.WHEN_AVAILABLE);
		
		this.matchEngine = new DefaultMatchEngine(eobjectMatcher, comparisonFactory);
	}
}
