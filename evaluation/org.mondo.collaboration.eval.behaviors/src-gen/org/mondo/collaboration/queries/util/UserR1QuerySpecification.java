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
import org.mondo.collaboration.queries.UserR1Match;
import org.mondo.collaboration.queries.UserR1Matcher;
import org.mondo.collaboration.queries.util.ContainedByQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate UserR1Matcher in a type-safe way.
 * 
 * @see UserR1Matcher
 * @see UserR1Match
 * 
 */
@SuppressWarnings("all")
public final class UserR1QuerySpecification extends BaseGeneratedEMFQuerySpecification<UserR1Matcher> {
  private UserR1QuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static UserR1QuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected UserR1Matcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return UserR1Matcher.on(engine);
  }
  
  @Override
  public UserR1Match newEmptyMatch() {
    return UserR1Match.newEmptyMatch();
  }
  
  @Override
  public UserR1Match newMatch(final Object... parameters) {
    return UserR1Match.newMatch((java.lang.String) parameters[0], (java.lang.Object) parameters[1], (wt.Composite) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static UserR1QuerySpecification INSTANCE = make();
    
    public static UserR1QuerySpecification make() {
      return new UserR1QuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static UserR1QuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.mondo.collaboration.queries.userR1";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("vendor","object","composite");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("vendor", "java.lang.String"),new PParameter("object", "java.lang.Object"),new PParameter("composite", "wt.Composite"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_vendor = body.getOrCreateVariableByName("vendor");
      	PVariable var_object = body.getOrCreateVariableByName("object");
      	PVariable var_composite = body.getOrCreateVariableByName("composite");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_vendor, "vendor"),
      				
      		new ExportedParameter(body, var_object, "object"),
      				
      		new ExportedParameter(body, var_composite, "composite")
      	));
      	new TypeConstraint(body, new FlatTuple(var_composite), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      	new TypeConstraint(body, new FlatTuple(var_composite), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      	new TypeConstraint(body, new FlatTuple(var_composite, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Composite", "vendor")));
      	new Equality(body, var__virtual_0_, var_vendor);
      	new ConstantValue(body, var__virtual_1_, "1");
      	new TypeConstraint(body, new FlatTuple(var_composite), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      	new TypeConstraint(body, new FlatTuple(var_composite, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Composite", "vendor")));
      	new Equality(body, var__virtual_2_, var__virtual_1_);
      	new BinaryTransitiveClosure(body, new FlatTuple(var_composite, var_object), ContainedByQuerySpecification.instance().getInternalQueryRepresentation());
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
