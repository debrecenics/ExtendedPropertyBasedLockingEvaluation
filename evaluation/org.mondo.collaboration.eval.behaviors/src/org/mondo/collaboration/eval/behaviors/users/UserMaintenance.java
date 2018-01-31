package org.mondo.collaboration.eval.behaviors.users;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.queries.UserMMatch;
import org.mondo.collaboration.queries.UserMMatcher;

import com.google.common.collect.Lists;

public class UserMaintenance extends BaseUser {

	private static final Collection<String> lockClasses = 
			Lists.newArrayList("org.mondo.collaboration.queries.util.UserM[id]QuerySpecification");
	
	public UserMaintenance(String id) {
		super(id);
	}

	@Override
	public EObject execute(EObject model) {
		try {
			IncQueryEngine engine = IncQueryEngine.on(new EMFScope(model));
			UserMMatcher matcher = UserMMatcher.on(engine);
			UserMMatch filter = matcher.newEmptyMatch();
			filter.setC(id);
			
			matcher.forEachMatch(filter, new IMatchProcessor<UserMMatch>() {

				@Override
				public void process(UserMMatch match) {
					if(direction == Direction.FORWARD)
						match.getSgn().setFrequency(match.getSgn().getFrequency() * 2);
					else
						match.getSgn().setFrequency(match.getSgn().getFrequency() / 2);					
				}
			});
		} catch (IncQueryException e) {
			e.printStackTrace();
		}
		return super.execute(model);
	}

	@Override
	protected Collection<String> getLockClasses() {
		return lockClasses;
	}

	@Override
	public UserType getUsertype() {
		return UserType.M;
	}

}
