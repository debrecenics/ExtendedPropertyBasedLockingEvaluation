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
package org.eclipse.viatra.dse.merge.util

import org.eclipse.viatra.dse.designspace.api.ITransition
import org.eclipse.viatra.dse.merge.DSEMergeStrategy
import java.util.Set

class FilterHelper {
	
	def static filterEmptyTransitions(Iterable<? extends ITransition> transitions) {
		return transitions.filter[x | !x.getId().toString().equals("")]
	}
	
	def static filterMustTransitions(Iterable<? extends ITransition> transitions) {
		return transitions.filter[x | x.getId().toString().startsWith(DSEMergeStrategy.MUST_PREFIX)]
	}
	
	def static hasMustTransition(Iterable<? extends ITransition> transitions) {
		return transitions.exists[x | x.getId().toString().startsWith(DSEMergeStrategy.MUST_PREFIX)]
	}
	
	def static filterAlreadyUsedTransitions(Iterable<? extends ITransition> transitions, Set<String> usedMustTransitions) {
		return transitions.filter[x | !usedMustTransitions.contains(x.getId().toString())]
	}
	
	def static selectTempLiberateMustTransitions(Iterable<? extends ITransition> transitions, Set<String> usedMustTransitions) {
		return transitions.filter[x | usedMustTransitions.contains(x.getId())].map[x | x.getId().toString()].toList
	}
	
	def static orderTransitions(Iterable<? extends ITransition> transitions) {
		return transitions.sortBy[x | x.id.toString]
	}
}