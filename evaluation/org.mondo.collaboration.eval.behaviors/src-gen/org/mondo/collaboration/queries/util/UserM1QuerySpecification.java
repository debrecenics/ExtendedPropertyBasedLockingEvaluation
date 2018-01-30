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
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.ConstantValue;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;
import org.mondo.collaboration.queries.UserM1Match;
import org.mondo.collaboration.queries.UserM1Matcher;

/**
 * A pattern-specific query specification that can instantiate UserM1Matcher in a type-safe way.
 * 
 * @see UserM1Matcher
 * @see UserM1Match
 * 
 */
@SuppressWarnings("all")
public final class UserM1QuerySpecification extends BaseGeneratedEMFQuerySpecification<UserM1Matcher> {
  private UserM1QuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static UserM1QuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected UserM1Matcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return UserM1Matcher.on(engine);
  }
  
  @Override
  public UserM1Match newEmptyMatch() {
    return UserM1Match.newEmptyMatch();
  }
  
  @Override
  public UserM1Match newMatch(final Object... parameters) {
    return UserM1Match.newMatch((wt.Control) parameters[0], (wt.Signal) parameters[1], (java.lang.Integer) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static UserM1QuerySpecification INSTANCE = make();
    
    public static UserM1QuerySpecification make() {
      return new UserM1QuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static UserM1QuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.mondo.collaboration.queries.userM1";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("ctrl","sgn","f");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("ctrl", "wt.Control"),new PParameter("sgn", "wt.Signal"),new PParameter("f", "java.lang.Integer"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_ctrl = body.getOrCreateVariableByName("ctrl");
      	PVariable var_sgn = body.getOrCreateVariableByName("sgn");
      	PVariable var_f = body.getOrCreateVariableByName("f");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_ctrl, "ctrl"),
      				
      		new ExportedParameter(body, var_sgn, "sgn"),
      				
      		new ExportedParameter(body, var_f, "f")
      	));
      	new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      	new TypeConstraint(body, new FlatTuple(var_sgn), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Signal")));
      	new ConstantValue(body, var__virtual_0_, "1");
      	new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      	new TypeConstraint(body, new FlatTuple(var_ctrl, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Control", "cycle")));
      	new Equality(body, var__virtual_1_, var__virtual_0_);
      	new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      	new TypeConstraint(body, new FlatTuple(var_ctrl, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Module", "provides")));
      	new Equality(body, var__virtual_2_, var_sgn);
      	new TypeConstraint(body, new FlatTuple(var_sgn), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var_sgn, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Signal", "frequency")));
      	new Equality(body, var__virtual_3_, var_f);
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
