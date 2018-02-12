package org.mondo.collaboration.eval.behaviors.users;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.mondo.collaboration.eval.behaviors.util.IModelManipulator;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;

public abstract class BaseUser implements IModelManipulator {

	enum Direction {
		FORWARD, BACKWARD
	}

	public enum UserType {
		R, T, M
	}

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
		case BACKWARD:
			direction = Direction.FORWARD;
			break;
		case FORWARD:
			direction = Direction.BACKWARD;
			break;
		}

		return model;
	}

	public abstract UserType getUsertype();

	public String getUsername() {
		return "user" + id + getUsertype();
	}

	public final Collection<IQuerySpecification<?>> getLocks() {
		return locks;
	}

	protected abstract Collection<String> getLockClasses();

	private static IQuerySpecification<?> instantiateQuerySpecification(final String className) {
		try {
			Class<?> loadClass = BaseUser.class.getClassLoader().loadClass(className);
			return (IQuerySpecification<?>) loadClass.getMethod("instance").invoke(null);
		} catch (IllegalAccessException | ClassNotFoundException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			throw new IllegalStateException(e);
		}
	}

}
