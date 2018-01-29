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

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.viatra.dse.api.strategy.interfaces.LocalSearchStrategyBase;
import org.eclipse.viatra.dse.base.DesignSpaceManager;
import org.eclipse.viatra.dse.base.ThreadContext;
import org.eclipse.viatra.dse.designspace.api.ITransition;
import org.eclipse.viatra.dse.merge.model.Delete;
import org.eclipse.viatra.dse.merge.util.FilterHelper;
import org.eclipse.viatra.dse.objectives.Fitness;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

public class DSEMergeStrategy extends LocalSearchStrategyBase {

    private ThreadContext context;
    private boolean isInterrupted = false;
    public static String MUST_PREFIX = "MUST_";
    public static String MAY_PREFIX = "MAY_";
    private Logger logger = Logger.getLogger(DSEMergeStrategy.class);
    private DesignSpaceManager.FilterOptions filterOptions;
    private boolean onlyNewMust = false;

    public static Multimap<Object, Delete> deleteDependencies = HashMultimap.create();
    private Set<String> usedMustTransitions = Sets.newHashSet();
    private Set<String> tempLiberateMustTransitions = Sets.newHashSet();
    private Set<String> liberateMustTransitions = Sets.newHashSet();
    private boolean forceToFinish;
    private boolean fromBacktracking;

    @Override
    public void init(ThreadContext context) {
        this.context = context;
        filterOptions = new DesignSpaceManager.FilterOptions();
        filterOptions.nothingIfCut().nothingIfGoal().untraversedOnly();
    }


    @Override
    public ITransition getNextTransition(boolean lastWasSuccessful) {
        if (isInterrupted || forceToFinish) {
            return null;
        }

        DesignSpaceManager dsm = context.getDesignSpaceManager();

        // Query available transitions
        Iterable<? extends ITransition> transitions = null;
        transitions = FilterHelper.filterEmptyTransitions(dsm.getTransitionsFromCurrentState(filterOptions));
        transitions = restrictTransitions(transitions);

        if (fromBacktracking) {
            proccessFromBacktracking();
        }

        if (dsm.getTrajectoryInfo().getDepthFromRoot() == 0) {
            boolean needMust = FilterHelper.hasMustTransition(dsm.getCurrentState().getOutgoingTransitions());
            boolean hasMust = FilterHelper.hasMustTransition(transitions);
            if (needMust && !hasMust)
                return null;
        }

        // Backtrack if there is no transitions
        while (transitions == null || !transitions.iterator().hasNext()) {
            boolean didUndo = dsm.undoLastTransformation();
            if (!didUndo) {
                return null;
            }

            logger.debug("Backtracking as there aren't anymore transitions from this state:\n"
                    + dsm.getCurrentState().getId());

            // Update transitions
            transitions = FilterHelper.filterEmptyTransitions(dsm.getTransitionsFromCurrentState(filterOptions));
            transitions = restrictTransitions(transitions);

            logTransitionList(transitions, "After the backtracking, we found the following transitions");

        }

        // TODO: parallel execution
        Iterator<? extends ITransition> iterator = FilterHelper.orderTransitions(transitions).iterator();
        ITransition transition = iterator.next();

        logger.debug("Executing:");
        logger.debug(transition);
        logger.debug("From state:\n" + dsm.getCurrentState().getId());

        return transition;
    }

    private void proccessFromBacktracking() {
        logger.debug("We are from backtracking... (Don't forget it!)");
        usedMustTransitions.removeAll(liberateMustTransitions);
        liberateMustTransitions.clear();
        fromBacktracking = false;
    }

    private void logTransitionList(Iterable<? extends ITransition> transitions, String header) {
        logger.debug(header);
        logger.debug("Number of transitions " + Iterables.size(transitions));

        for (ITransition iTransition : transitions) {
            logger.debug(iTransition);
        }
    }

    private Iterable<? extends ITransition> restrictTransitions(Iterable<? extends ITransition> transitions) {
        logTransitionList(transitions, "All transaction");
        boolean hasMust = FilterHelper.hasMustTransition(transitions);
        if (hasMust || onlyNewMust)
            transitions = FilterHelper.filterMustTransitions(transitions);
        if (onlyNewMust)
            transitions = FilterHelper.filterAlreadyUsedTransitions(transitions, usedMustTransitions);
        logTransitionList(transitions, "Restricted transaction");
        return transitions;
    }

    @Override
    public void newStateIsProcessed(boolean isAlreadyTraversed, Fitness fitness, boolean constraintsNotSatisfied) {
        if (isAlreadyTraversed) {
            DesignSpaceManager dsm = context.getDesignSpaceManager();
            boolean isMust = dsm.getTrajectoryInfo().getLastTransition().getId().toString().startsWith(MUST_PREFIX);
            if (isMust) {
                undoUntilMust(isAlreadyTraversed, fitness, constraintsNotSatisfied, dsm);
            } else {
                if (!dsm.undoLastTransformation())
                    return;
            }
            return;
        }

        if (fitness.isSatisifiesHardObjectives()) {

            DesignSpaceManager dsm = context.getDesignSpaceManager();
            processNotTraversed(isAlreadyTraversed);
            onlyNewMust = true; // we found a solution
            logger.info("We found a new solution");
            undoUntilMust(isAlreadyTraversed, fitness, constraintsNotSatisfied, dsm);
            return;
        }

        processNotTraversed(isAlreadyTraversed);
    }

    private void processNotTraversed(boolean isAlreadyTraversed) {
        if (!isAlreadyTraversed && context.getDesignSpaceManager().getTrajectoryInfo().getLastTransition() != null) {

            DesignSpaceManager dsm = context.getDesignSpaceManager();
            boolean isMust = dsm.getTrajectoryInfo().getLastTransition().getId().toString().startsWith(MUST_PREFIX);
            if (isMust && !usedMustTransitions.contains(dsm.getTrajectoryInfo().getLastTransition().getId().toString())) {
                if (!usedMustTransitions.isEmpty() && dsm.getTrajectoryInfo().getFullTransitionTrajectory().size() == 1)
                    usedMustTransitions.clear();
                usedMustTransitions.add(dsm.getTrajectoryInfo().getLastTransition().getId().toString());
                onlyNewMust = false;
            }
        }
    }

    private void undoUntilMust(boolean isAlreadyTraversed, Fitness fitness, boolean constraintsNotSatisfied,
            DesignSpaceManager dsm) {
        boolean hasMust;
        logBacktrackReason(isAlreadyTraversed, fitness, constraintsNotSatisfied);
        do {
            if (!dsm.undoLastTransformation())
                return;

            logger.debug("Backtracked to the following state:\n" + dsm.getCurrentState().getId());

            liberateMustTransitions.addAll(tempLiberateMustTransitions);
            tempLiberateMustTransitions.clear();
            Iterable<? extends ITransition> transitions = FilterHelper.filterEmptyTransitions(dsm.getCurrentState()
                    .getOutgoingTransitions());
            tempLiberateMustTransitions.addAll(FilterHelper.selectTempLiberateMustTransitions(transitions,
                    usedMustTransitions));
            transitions = FilterHelper.filterEmptyTransitions(dsm.getTransitionsFromCurrentState(filterOptions));
            transitions = restrictTransitions(transitions);
            logTransitionList(transitions, "Executable operations in the backtracked state:");

            hasMust = FilterHelper.hasMustTransition(transitions);
            if (!hasMust && dsm.getTrajectoryInfo().getDepthFromRoot() == 0) {
                forceToFinish = true;
                logger.debug("We are the top and there is no more executable MUST operation... So we finished");
            }
        } while (!hasMust && dsm.getTrajectoryInfo().getDepthFromRoot() > 0);
        fromBacktracking = true;
    }

    /**
     * Logging the reason the backtrack
     * 
     * @param isAlreadyTraversed
     * @param fitness
     * @param constraintsNotSatisfied
     */
    private void logBacktrackReason(boolean isAlreadyTraversed, Fitness fitness, boolean constraintsNotSatisfied) {
        logger.debug("We have to backtrack from a state where:" + "\nAlready traversed: " + isAlreadyTraversed
                + "\nGoal state: " + (fitness.isSatisifiesHardObjectives()) + "\nConstraints not satisfied: "
                + constraintsNotSatisfied);
    }

    @Override
    public void interrupted() {
        isInterrupted = true;
    }
}
