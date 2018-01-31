package org.mondo.collaboration.eval.behaviors.users;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.queries.UserTMatch;
import org.mondo.collaboration.queries.UserTMatcher;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import wt.Control;
import wt.SgnlType;
import wt.Signal;
import wt.WtFactory;

public class UserTesting extends BaseUser {

	protected Map<Control,Signal> newSignals = Maps.newHashMap();
	protected Map<Control,Signal> consumeSignals = Maps.newHashMap();
	
	private static final Collection<String> lockClasses = 
			Lists.newArrayList("org.mondo.collaboration.queries.util.UserT[id]QuerySpecification");
	
	
	public UserTesting(String id) {
		super(id);
	}

	@Override
	public EObject execute(EObject model) {
		try {
			IncQueryEngine engine = IncQueryEngine.on(new EMFScope(model));
			UserTMatcher matcher = UserTMatcher.on(engine);
			UserTMatch filter = matcher.newEmptyMatch();
			filter.setT(id);
			
			List<Signal> signals = Lists.newArrayList();
			signals.addAll(matcher.getAllValuesOfsgn(filter));
			
			if(direction == Direction.FORWARD) {
				matcher.forEachMatch(filter, new IMatchProcessor<UserTMatch>() {
					@Override
					public void process(UserTMatch match) {
						Signal signal = WtFactory.eINSTANCE.createSignal();
						signal.setType(SgnlType.TEST);
						
						match.getCtrl().getProvides().add(signal);	
						match.getCtrl().getConsumes().add(match.getSgn());
						newSignals.put(match.getCtrl(), signal);
						consumeSignals.put(match.getCtrl(), match.getSgn());
					}
				});
			} else {
				for(Control control : newSignals.keySet()) {
					control.getConsumes().remove(consumeSignals.get(control));
					control.getProvides().remove(newSignals.get(control));
				}
				newSignals.clear();
				consumeSignals.clear();
			}
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
		return UserType.T;
	}

}
