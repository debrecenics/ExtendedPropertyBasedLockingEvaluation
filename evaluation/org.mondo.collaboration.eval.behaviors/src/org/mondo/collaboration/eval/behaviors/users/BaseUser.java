package org.mondo.collaboration.eval.behaviors.users;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.mondo.collaboration.eval.behaviors.util.IModelManipulator;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;

public abstract class BaseUser implements IModelManipulator {

	enum Direction { FORWARD, BACKWARD }
	
	protected Direction direction = Direction.FORWARD;
	protected final String id;
	private ImmutableSet<IQuerySpecification<?>> locks;
	
	public BaseUser(String id) {
		this.id = id;

		// Load Lock Classes
		Builder<IQuerySpecification<?>> builder = ImmutableSet.<IQuerySpecification<?>> builder();
		for (String clazz : getLockClasses()) {
			builder.add(instantiateQuerySpecification(clazz.replace("[id]", id)));
		}
		this.locks = builder.build();
	}

	@Override
	public EObject execute(EObject model) {
		
		switch (direction) {
		case BACKWARD: direction = Direction.FORWARD; break;
		case FORWARD: direction = Direction.BACKWARD; break;
		}
		
		return model;	
	}
	
	public String getUsername() {
		return "user" + id;
	}

	public final Collection<IQuerySpecification<?>> getLocks() {
		return locks;
	}

	protected abstract Collection<String> getLockClasses();

	private static IQuerySpecification<?> instantiateQuerySpecification(final String className) {
		try {
			return (IQuerySpecification<?>) Class.forName(className).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new IllegalStateException(e);
		}
	}

}
