package org.mondo.collaboration.queries.util;

import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.BinaryTransitiveClosure;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.mondo.collaboration.queries.UserR0ControlConsumeMatch;
import org.mondo.collaboration.queries.UserR0ControlConsumeMatcher;
import org.mondo.collaboration.queries.util.ContainedByQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate UserR0ControlConsumeMatcher in a type-safe way.
 * 
 * @see UserR0ControlConsumeMatcher
 * @see UserR0ControlConsumeMatch
 * 
 */
@SuppressWarnings("all")
public final class UserR0ControlConsumeQuerySpecification extends BaseGeneratedEMFQuerySpecification<UserR0ControlConsumeMatcher> {
  private UserR0ControlConsumeQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static UserR0ControlConsumeQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected UserR0ControlConsumeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return UserR0ControlConsumeMatcher.on(engine);
  }
  
  @Override
  public UserR0ControlConsumeMatch newEmptyMatch() {
    return UserR0ControlConsumeMatch.newEmptyMatch();
  }
  
  @Override
  public UserR0ControlConsumeMatch newMatch(final Object... parameters) {
    return UserR0ControlConsumeMatch.newMatch((java.lang.String) parameters[0], (wt.Control) parameters[1], (wt.Signal) parameters[2], (wt.Composite) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static UserR0ControlConsumeQuerySpecification INSTANCE = make();
    
    public static UserR0ControlConsumeQuerySpecification make() {
      return new UserR0ControlConsumeQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static UserR0ControlConsumeQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.mondo.collaboration.queries.userR0ControlConsume";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("vendor","object","signal","composite");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("vendor", "java.lang.String"),new PParameter("object", "wt.Control"),new PParameter("signal", "wt.Signal"),new PParameter("composite", "wt.Composite"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_vendor = body.getOrCreateVariableByName("vendor");
      	PVariable var_object = body.getOrCreateVariableByName("object");
      	PVariable var_signal = body.getOrCreateVariableByName("signal");
      	PVariable var_composite = body.getOrCreateVariableByName("composite");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_vendor, "vendor"),
      				
      		new ExportedParameter(body, var_object, "object"),
      				
      		new ExportedParameter(body, var_signal, "signal"),
      				
      		new ExportedParameter(body, var_composite, "composite")
      	));
      	new TypeConstraint(body, new FlatTuple(var_signal), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var_composite), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      	new TypeConstraint(body, new FlatTuple(var_composite), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      	new TypeConstraint(body, new FlatTuple(var_composite, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Composite", "vendor")));
      	new Equality(body, var__virtual_0_, var_vendor);
      	new ConstantValue(body, var__virtual_1_, "0");
      	new TypeConstraint(body, new FlatTuple(var_composite), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      	new TypeConstraint(body, new FlatTuple(var_composite, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Composite", "vendor")));
      	new Equality(body, var__virtual_2_, var__virtual_1_);
      	new BinaryTransitiveClosure(body, new FlatTuple(var_composite, var_object), ContainedByQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_object), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      	new TypeConstraint(body, new FlatTuple(var_object, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Module", "consumes")));
      	new Equality(body, var__virtual_3_, var_signal);
      	bodies.add(body);
      }
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
