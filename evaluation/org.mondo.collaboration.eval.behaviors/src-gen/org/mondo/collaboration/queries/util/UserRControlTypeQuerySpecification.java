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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.mondo.collaboration.queries.UserRControlTypeMatch;
import org.mondo.collaboration.queries.UserRControlTypeMatcher;
import org.mondo.collaboration.queries.util.ContainedByQuerySpecification;

/**
 * A pattern-specific query specification that can instantiate UserRControlTypeMatcher in a type-safe way.
 * 
 * @see UserRControlTypeMatcher
 * @see UserRControlTypeMatch
 * 
 */
@SuppressWarnings("all")
public final class UserRControlTypeQuerySpecification extends BaseGeneratedEMFQuerySpecification<UserRControlTypeMatcher> {
  private UserRControlTypeQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static UserRControlTypeQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected UserRControlTypeMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return UserRControlTypeMatcher.on(engine);
  }
  
  @Override
  public UserRControlTypeMatch newEmptyMatch() {
    return UserRControlTypeMatch.newEmptyMatch();
  }
  
  @Override
  public UserRControlTypeMatch newMatch(final Object... parameters) {
    return UserRControlTypeMatch.newMatch((java.lang.String) parameters[0], (wt.Control) parameters[1], (java.lang.String) parameters[2], (wt.Composite) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static UserRControlTypeQuerySpecification INSTANCE = make();
    
    public static UserRControlTypeQuerySpecification make() {
      return new UserRControlTypeQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static UserRControlTypeQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.mondo.collaboration.queries.userRControlType";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("vendor","object","type","composite");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("vendor", "java.lang.String"),new PParameter("object", "wt.Control"),new PParameter("type", "java.lang.String"),new PParameter("composite", "wt.Composite"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_vendor = body.getOrCreateVariableByName("vendor");
      	PVariable var_object = body.getOrCreateVariableByName("object");
      	PVariable var_type = body.getOrCreateVariableByName("type");
      	PVariable var_composite = body.getOrCreateVariableByName("composite");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_vendor, "vendor"),
      				
      		new ExportedParameter(body, var_object, "object"),
      				
      		new ExportedParameter(body, var_type, "type"),
      				
      		new ExportedParameter(body, var_composite, "composite")
      	));
      	new TypeConstraint(body, new FlatTuple(var_object), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      	new TypeConstraint(body, new FlatTuple(var_composite), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      	new TypeConstraint(body, new FlatTuple(var_composite), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Composite")));
      	new TypeConstraint(body, new FlatTuple(var_composite, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Composite", "vendor")));
      	new Equality(body, var__virtual_0_, var_vendor);
      	new BinaryTransitiveClosure(body, new FlatTuple(var_composite, var_object), ContainedByQuerySpecification.instance().getInternalQueryRepresentation());
      	new TypeConstraint(body, new FlatTuple(var_object), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      	new TypeConstraint(body, new FlatTuple(var_object, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Control", "type")));
      	new Equality(body, var__virtual_1_, var_type);
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
