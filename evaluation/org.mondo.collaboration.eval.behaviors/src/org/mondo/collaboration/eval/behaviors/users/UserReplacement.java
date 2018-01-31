package org.mondo.collaboration.eval.behaviors.users;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.queries.UserRMatch;
import org.mondo.collaboration.queries.UserRMatcher;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import wt.Composite;
import wt.Control;
import wt.Signal;

public class UserReplacement extends BaseUser {

	private static final Collection<String> lockClasses = 
			Lists.newArrayList(
					"org.mondo.collaboration.queries.util.UserR[id]QuerySpecification",
					"org.mondo.collaboration.queries.util.UserR[id]ControlCycleQuerySpecification",
					"org.mondo.collaboration.queries.util.UserR[id]ControlTypeQuerySpecification",
					"org.mondo.collaboration.queries.util.UserR[id]ControlProvideQuerySpecification",
					"org.mondo.collaboration.queries.util.UserR[id]ControlConsumeQuerySpecification",
					"org.mondo.collaboration.queries.util.UserR[id]SignalFrequencyQuerySpecification"
					);
	
	protected List<Composite> list = Lists.newArrayList();
	protected Map<Signal,Control> map = Maps.newHashMap();
	
	public UserReplacement(String id) {
		super(id);
	}

	@Override
	public EObject execute(EObject model) {
		try {
			IncQueryEngine engine = IncQueryEngine.on(new EMFScope(model));
			UserRMatcher matcher = UserRMatcher.on(engine);
			UserRMatch filter = matcher.newEmptyMatch();
			filter.setVendor(id);
			
			if(direction == Direction.FORWARD) {
				matcher.forEachMatch(filter, new IMatchProcessor<UserRMatch>() {
					@Override
					public void process(UserRMatch match) {
						Composite composite = match.getComposite();
						list.add(composite);
						for(TreeIterator<EObject> iterator = composite.eAllContents(); iterator.hasNext();) {
							EObject eObject = iterator.next();
							if(eObject instanceof Control) {
								Control control = (Control) eObject;
								for (Signal signal : control.getProvides()) {
									signal.setFrequency(signal.getFrequency() * 2);
									if(control.getConsumes().contains(signal)) {
										control.getConsumes().remove(signal);
									} else {
										control.getConsumes().add(signal);
									}
									map.put(signal, control);
								}
							}
						}
					}
				});
			} else {
				for(Signal signal : map.keySet()) {
					signal.setFrequency(signal.getFrequency() * 2);
					
					Control control = map.get(signal);
					if(control.getConsumes().contains(signal)) {
						control.getConsumes().remove(signal);
					} else {
						control.getConsumes().add(signal);
					}
				}
				list.clear();
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
		return UserType.R;
	}

}
