package org.eclipse.viatra.dse.merge.emf.compare;

import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.viatra.dse.merge.DSEMergeIdMapper;

public class EMFCompareMatchEngineRegistry extends MatchEngineFactoryRegistryImpl {

	public static IMatchEngine.Factory.Registry createDSEMergeSpecificRegistry(DSEMergeIdMapper mapper) {
		final IMatchEngine.Factory.Registry registry = new MatchEngineFactoryRegistryImpl();

		final EMFCompareMatchEngineFactoryImpl matchEngineFactory = new EMFCompareMatchEngineFactoryImpl(mapper);
		matchEngineFactory.setRanking(10);
		registry.add(matchEngineFactory);

		return registry;
	}
	
}
