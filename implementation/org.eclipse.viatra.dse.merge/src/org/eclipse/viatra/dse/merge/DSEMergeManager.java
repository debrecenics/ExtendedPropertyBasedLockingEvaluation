/*******************************************************************************
 * Copyright (c) 2010-2015, Csaba Debreceni, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Csaba Debreceni - initial API and implementation
 *******************************************************************************/
package org.eclipse.viatra.dse.merge;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.dse.api.DSETransformationRule;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.viatra.dse.api.SolutionTrajectory;
import org.eclipse.viatra.dse.merge.iqconflicts.util.ConflictsQuerySpecification;
import org.eclipse.viatra.dse.merge.model.ChangeSet;
import org.eclipse.viatra.dse.merge.model.ModelPackage;
import org.eclipse.viatra.dse.merge.scope.DSEMergeScope;
import org.eclipse.viatra.dse.merge.scope.ScopeFactory;
import org.eclipse.viatra.dse.merge.scope.ScopePackage;
import org.eclipse.viatra.dse.objectives.impl.ModelQueriesGlobalConstraint;
import org.eclipse.viatra.dse.objectives.impl.ModelQueriesHardObjective;
import org.eclipse.viatra.dse.objectives.impl.ModelQueryType;
import org.eclipse.viatra.dse.util.EMFHelper;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * This class is responsible for managing the merge process. For the instantiation, use the static
 * {@link #create(EObject, ChangeSet, ChangeSet) create} method.
 * 
 * @author Csaba Debreceni
 *
 */
public class DSEMergeManager {

    private static Map<String, DSEMergeConfigurator> configuratorMapping;
    public static String CONFIGURATION_POINT = "org.eclipse.viatra.dse.merge.configuration";
    public static String GENERATED_POINT = "org.eclipse.viatra.dse.merge.generated";
    public static String URI_ATTRIBUTE = "epackageURI";
    public static String CLASS_ATTRIBUTE = "class";

    private DSEMergeScope scope;
    private DesignSpaceExplorer dse;
    private EPackage metamodel;

    private Collection<DSETransformationRule<?, ?>> rules;
    private Collection<IQuerySpecification<?>> objectives;

    static Logger logger = Logger.getLogger(DSEMergeManager.class);

    private IQuerySpecification<IncQueryMatcher<IPatternMatch>> id2eobject;
    private DSEMergeIdMapper idMapper;

    /**
     * Private constructor of the manager.
     * 
     * @param original
     * @param local
     * @param remote
     */
    
    private DSEMergeManager(EObject original, ChangeSet local, ChangeSet remote) {
        buildScope(original, local, remote);
        configureMerge(original);

        dse = new DesignSpaceExplorer();
    }

    private DSEMergeManager(EObject original, ChangeSet local, ChangeSet remote, DSEMergeConfigurator config) {
        buildScope(original, local, remote);
        configureMerge(config);

        dse = new DesignSpaceExplorer();
    }
    
    /**
     * Static method for initializing the merge manager object.
     * 
     * @param original
     * @param local
     * @param remote
     * @return
     */
    public static DSEMergeManager create(EObject original, ChangeSet local, ChangeSet remote) {
        if (configuratorMapping == null)
            initializeConfiguration();
        return new DSEMergeManager(original, local, remote);
    }

    public static DSEMergeManager create(EObject original, ChangeSet local, ChangeSet remote, DSEMergeConfigurator config) {
        return new DSEMergeManager(original, local, remote, config);
    }
    
    /**
     * Based on the original model, configures the fields.
     * 
     * @param original
     */
    private void configureMerge(EObject original) {
        DSEMergeConfigurator configurator = configuratorMapping.get(original.eClass().getEPackage().getNsURI());
        if (configurator != null) {
            configureMerge(configurator);
        } else {
            logger.error("Missing required configuration for " + original.eClass().getEPackage().getNsURI());                
        }
    }

    @SuppressWarnings("unchecked")
    private void configureMerge(DSEMergeConfigurator configurator) {
        try {
            metamodel = configurator.getMetamodel();
            objectives = configurator.getObjectives();
            rules = configurator.getRules();
            id2eobject = (IQuerySpecification<IncQueryMatcher<IPatternMatch>>) configurator.getId2EObject();
            idMapper = configurator.getIdMapper();
        } catch (IncQueryException e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Creates the scope of the merge.
     * 
     * @param original
     * @param local
     * @param remote
     */
    private void buildScope(EObject original, ChangeSet local, ChangeSet remote) {
        scope = ScopeFactory.eINSTANCE.createDSEMergeScope();
        scope.setRemote(remote);
        scope.setLocal(local);
        scope.setOrigin(EMFHelper.clone(original));
        scope.setCemetery(ScopeFactory.eINSTANCE.createCemetery());
    }

    /**
     * Read up the extension point and store the available merge configurations
     * @return 
     */
    public static Map<String, DSEMergeConfigurator> initializeConfiguration() {
        try {
            configuratorMapping = Maps.newHashMap();
            IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(CONFIGURATION_POINT);
            for (IExtension ext : extensionPoint.getExtensions()) {

                for (IConfigurationElement conf : ext.getConfigurationElements()) {
                    String uri = conf.getAttribute(URI_ATTRIBUTE);
                    DSEMergeConfigurator configurator;
                    configurator = (DSEMergeConfigurator) conf.createExecutableExtension(CLASS_ATTRIBUTE);
                    if (uri != null && configurator != null)
                        configuratorMapping.put(uri, configurator);
                }
            }
        } catch (InvalidRegistryObjectException | CoreException e) {
            logger.error(e.getMessage(),e);
        }
        return configuratorMapping;
    }

    /**
     * This method starts the design space exploration based merge process. Returns a collection of possible solutions.
     * 
     * @return the collection of possible solutions
     */
    public Collection<Solution> start() {
        //Configure DSE
        configureDSE();

        //Create strategy
        Logger.getLogger(DSEMergeStrategy.class).setLevel(Level.DEBUG);
        DSEMergeStrategy strategy = new DSEMergeStrategy();
        
        //Start Exploration
        dse.startExploration(strategy);

        return buildSolutions(dse.getSolutions());
    }

    /**
     * Configure the Design Space Exploration
     */
    private void configureDSE() {
        dse.addMetaModelPackage(metamodel);
        dse.addMetaModelPackage(ScopePackage.eINSTANCE);
        dse.addMetaModelPackage(ModelPackage.eINSTANCE);

        dse.setInitialModel(scope);
        dse.setStateCoderFactory(new DSEMergeSerializerFactory(idMapper));
        
        ModelQueriesHardObjective modelQueriesHardObjective = new ModelQueriesHardObjective();
        for (IQuerySpecification<?> objective : objectives) {
            modelQueriesHardObjective.withConstraint(objective);
        }
        dse.addObjective(modelQueriesHardObjective.withType(ModelQueryType.NO_MATCH));

        for (DSETransformationRule<?, ?> rule : rules) {
            dse.addTransformationRule(rule);
        }

        try {
            dse.addGlobalConstraint(new ModelQueriesGlobalConstraint().withConstraint(ConflictsQuerySpecification.instance()).withType(ModelQueryType.NO_MATCH));
//            dse.addTransformationRule(
//                    new DSETransformationRule<ExecutableDeleteChangeMatch, ExecutableDeleteChangeMatcher>(
//                    ExecutableDeleteChangeQuerySpecification.instance(),
//                    new DefaultMatchProcessor<ExecutableDeleteChangeMatch>()));
//            dse.addTransformationRule(
//                    new DSETransformationRule<IPatternMatch, IncQueryMatcher<IPatternMatch>>(
//                    id2eobject, 
//                    new DefaultMatchProcessor<IPatternMatch>()));
        } catch (IncQueryException e) {
            logger.error(e.getMessage(), e);
        }
        dse.setMaxNumberOfThreads(4);
    }

    /**
     * Build readable solutions from the DSE-related {@link org.eclipse.viatra.dse.api.Solution}    
     * @param DSE-related solutions
     * @return readable solutions
     */
    private Collection<Solution> buildSolutions(Collection<org.eclipse.viatra.dse.api.Solution> solutions) {
        Collection<Solution> s = Lists.newArrayList();
        for (org.eclipse.viatra.dse.api.Solution solution : solutions) {
            s.add(new Solution(scope, solution));
        }
        return s;
    }

    /**
     * An empty match processor.
     */
    private class DefaultMatchProcessor<T extends IPatternMatch> implements IMatchProcessor<T> {

        @Override
        public void process(T match) {
        }

    }

    /**
     * More readable solution class. 
     * @author Csaba Debreceni
     *
     */
    
    public class Solution {

        private org.eclipse.viatra.dse.api.Solution solution;
        private DSEMergeScope scope;
        private boolean applied = false;

        public Solution(DSEMergeScope scope, org.eclipse.viatra.dse.api.Solution solution) {
            this.scope = (DSEMergeScope) EMFHelper.clone(scope);
            this.solution = solution;
        }

        /**
         * Returns the full scope of the merge where the solution is applied
         * @return the full scope of the merge where the solution is applied
         */
        public DSEMergeScope getScope() {
            if (!applied)
                applyMerge();
            return scope;
        }

        /**
         * Applies the trajectory to the scope.
         */
        private void applyMerge() {
            try {
                SolutionTrajectory trajectory = solution.getShortestTrajectory();
                trajectory.setModel(this.scope);
                trajectory.doTransformation();
                applied = true;
            } catch (IncQueryException e) {
                logger.error(e.getMessage(), e);
            }
        }

        public SolutionTrajectory getTrajectory() {
            return solution.getShortestTrajectory();
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Solution:\n");
            SolutionTrajectory trajectory = solution.getShortestTrajectory();
            List<Object> list = trajectory.getActivationCodes();
            for (Object l : list) {
                sb.append(l);
            }
            return sb.toString();
        }
    }
}
