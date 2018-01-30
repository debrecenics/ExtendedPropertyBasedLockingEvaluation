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
import org.mondo.collaboration.queries.UserT2Match;
import org.mondo.collaboration.queries.UserT2Matcher;

/**
 * A pattern-specific query specification that can instantiate UserT2Matcher in a type-safe way.
 * 
 * @see UserT2Matcher
 * @see UserT2Match
 * 
 */
@SuppressWarnings("all")
public final class UserT2QuerySpecification extends BaseGeneratedEMFQuerySpecification<UserT2Matcher> {
  private UserT2QuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static UserT2QuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected UserT2Matcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return UserT2Matcher.on(engine);
  }
  
  @Override
  public UserT2Match newEmptyMatch() {
    return UserT2Match.newEmptyMatch();
  }
  
  @Override
  public UserT2Match newMatch(final Object... parameters) {
    return UserT2Match.newMatch((wt.Control) parameters[0], (wt.Signal) parameters[1], (java.lang.String) parameters[2], (java.lang.String) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static UserT2QuerySpecification INSTANCE = make();
    
    public static UserT2QuerySpecification make() {
      return new UserT2QuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static UserT2QuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "org.mondo.collaboration.queries.userT2";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("ctrl","sgn","c","t");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("ctrl", "wt.Control"),new PParameter("sgn", "wt.Signal"),new PParameter("c", "java.lang.String"),new PParameter("t", "java.lang.String"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_ctrl = body.getOrCreateVariableByName("ctrl");
      	PVariable var_sgn = body.getOrCreateVariableByName("sgn");
      	PVariable var_c = body.getOrCreateVariableByName("c");
      	PVariable var_t = body.getOrCreateVariableByName("t");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      	PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_ctrl, "ctrl"),
      				
      		new ExportedParameter(body, var_sgn, "sgn"),
      				
      		new ExportedParameter(body, var_c, "c"),
      				
      		new ExportedParameter(body, var_t, "t")
      	));
      	new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      	new TypeConstraint(body, new FlatTuple(var_sgn), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      	new TypeConstraint(body, new FlatTuple(var_ctrl, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Control", "type")));
      	new Equality(body, var__virtual_0_, var_t);
      	new ConstantValue(body, var__virtual_1_, "2");
      	new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      	new TypeConstraint(body, new FlatTuple(var_ctrl, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Control", "type")));
      	new Equality(body, var__virtual_2_, var__virtual_1_);
      	new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      	new TypeConstraint(body, new FlatTuple(var_ctrl, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Control", "cycle")));
      	new Equality(body, var__virtual_3_, var_c);
      	new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      	new TypeConstraint(body, new FlatTuple(var_ctrl, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Module", "provides")));
      	new Equality(body, var__virtual_4_, var_sgn);
      	bodies.add(body);
      }
      {
      	PBody body = new PBody(this);
      	PVariable var_ctrl = body.getOrCreateVariableByName("ctrl");
      	PVariable var_sgn = body.getOrCreateVariableByName("sgn");
      	PVariable var_c = body.getOrCreateVariableByName("c");
      	PVariable var_t = body.getOrCreateVariableByName("t");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      	PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_ctrl, "ctrl"),
      				
      		new ExportedParameter(body, var_sgn, "sgn"),
      				
      		new ExportedParameter(body, var_c, "c"),
      				
      		new ExportedParameter(body, var_t, "t")
      	));
      	new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      	new TypeConstraint(body, new FlatTuple(var_sgn), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Signal")));
      	new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      	new TypeConstraint(body, new FlatTuple(var_ctrl, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Control", "type")));
      	new Equality(body, var__virtual_0_, var_t);
      	new ConstantValue(body, var__virtual_1_, "2");
      	new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      	new TypeConstraint(body, new FlatTuple(var_ctrl, var__virtual_2_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Control", "type")));
      	new Equality(body, var__virtual_2_, var__virtual_1_);
      	new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      	new TypeConstraint(body, new FlatTuple(var_ctrl, var__virtual_3_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Control", "cycle")));
      	new Equality(body, var__virtual_3_, var_c);
      	new TypeConstraint(body, new FlatTuple(var_ctrl), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("http://wt/access-control", "Control")));
      	new TypeConstraint(body, new FlatTuple(var_ctrl, var__virtual_4_), new EStructuralFeatureInstancesKey(getFeatureLiteral("http://wt/access-control", "Module", "consumes")));
      	new Equality(body, var__virtual_4_, var_sgn);
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
