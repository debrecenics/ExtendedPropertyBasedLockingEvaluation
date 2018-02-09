package org.eclipse.viatra.dse.merge.emf.compare;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.utils.EqualityHelper;
import org.eclipse.emf.compare.utils.IEqualityHelper;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.viatra.dse.merge.DSEMergeIdMapper;

import com.google.common.cache.LoadingCache;

public class EMFCompareEqualityHelperFactory extends DefaultEqualityHelperFactory{

	private DSEMergeIdMapper mapper;

	public EMFCompareEqualityHelperFactory(DSEMergeIdMapper mapper) {
		this.mapper = mapper;		
	}
	
	@Override
	public IEqualityHelper createEqualityHelper() {
		final LoadingCache<EObject, URI> cache = EqualityHelper.createDefaultCache(getCacheBuilder());
		return new EqualityHelper(cache) {
			@Override
			protected boolean matchingEObjects(EObject object1, EObject object2) {
				if(mapper.getId(object1).equals(mapper.getId(object2)))
						return true;
				return false;
			}
		};
	}
	
}
