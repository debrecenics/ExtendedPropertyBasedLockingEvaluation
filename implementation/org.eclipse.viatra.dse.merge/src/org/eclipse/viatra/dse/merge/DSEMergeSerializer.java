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

import java.util.Comparator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.viatra.dse.merge.model.Attribute;
import org.eclipse.viatra.dse.merge.model.Change;
import org.eclipse.viatra.dse.merge.model.ChangeSet;
import org.eclipse.viatra.dse.merge.model.Create;
import org.eclipse.viatra.dse.merge.model.Delete;
import org.eclipse.viatra.dse.merge.model.Priority;
import org.eclipse.viatra.dse.merge.model.Reference;
import org.eclipse.viatra.dse.merge.scope.DSEMergeScope;
import org.eclipse.viatra.dse.merge.util.DSEMergeUtil;
import org.eclipse.viatra.dse.statecode.IStateCoder;

/**
 * State Coder for the DSE Merge.
 * 
 * @author Csaba Debreceni
 *
 */
public class DSEMergeSerializer implements IStateCoder {

    protected DSEMergeScope scope;
    protected DSEMergeIdMapper mapper;
    
    public DSEMergeSerializer(DSEMergeIdMapper idMapper) {
        this.mapper = idMapper;
    }

    @Override
    public Object createStateCode() {
        StringBuilder sb = new StringBuilder();

        sb.append("Local mods: {\n");
        serializeChangeSet(scope.getLocal(), sb);
        sb.append("\n}\n");
        sb.append("Remote mods: {\n");
        serializeChangeSet(scope.getRemote(), sb);
        sb.append("\n}\n");

        return sb.toString();
    }

    /**
     * Serialize the changes of a {@link ChangeSet} in an ordered way and append it to the {@link String builder}.
     * 
     * @param changeSet
     * @param sb
     */
    private void serializeChangeSet(ChangeSet changeSet, StringBuilder sb) {
        ECollections.sort(changeSet.getChanges(), new ChangeComparator());

        for (Change change : changeSet.getChanges()) {
            sb.append(serializeChange(change).toString());
        }
    }

    /**
     * Serialize the {@link Change}
     * 
     * @param change
     * @return serialized change
     */
    private ChangeWrapper serializeChange(Change change) {
        return new ChangeWrapper(change);
    }

    @Override
    public Object createActivationCode(IPatternMatch match) {
        return new ActivationCodeWrapper(match);
    }

    @Override
    public void init(Notifier notifier) {
        if (notifier instanceof DSEMergeScope) {
            this.scope = (DSEMergeScope) notifier;
            } else {
            Logger.getLogger(this.getClass())
                    .error("Only DSEMergeScope can be used instead of: " + notifier.getClass());
        }
    }

    public static class ChangeWrapper {
        
        private Change change;

        public ChangeWrapper(Change change) {
            this.change = change;
        }
        
        @Override
        public String toString() {
            String ret = "";

            if (change instanceof Create) {
                Create _change = (Create) change;
                ret = "Create{executable=" + _change.isExecutable() + ";srcId=" + DSEMergeUtil.getId(_change.getSrc())
                        + ";containerId=" + DSEMergeUtil.getId(_change.getContainer()) + ";feature="
                        + _change.getFeature().getName() + "}";
            }
            if (change instanceof Delete) {
                Delete _change = (Delete) change;
                ret = "Delete{executable=" + _change.isExecutable() + ";srcId=" + DSEMergeUtil.getId(_change.getSrc())
                        + "}";
            }
            if (change instanceof Reference) {
                Reference _change = (Reference) change;
                ret = "Reference{executable=" + _change.isExecutable() + ";srcId=" + DSEMergeUtil.getId(_change.getSrc())
                        + ";trgId=" + DSEMergeUtil.getId(_change.getTrg()) + ";feature=" + _change.getFeature().getName()
                        + ";kind=" + _change.getKind() + "}";
            }
            if (change instanceof Attribute) {
                Attribute _change = (Attribute) change;
                ret = "Attribute{executable=" + _change.isExecutable() + ";srcId=" + DSEMergeUtil.getId(_change.getSrc())
                        + ";value=" + _change.getValue() + ";feature=" + _change.getFeature().getName() + ";kind="
                        + _change.getKind() + "}";
            }
            if (change.getPriority() == Priority.MUST)
                ret = DSEMergeStrategy.MUST_PREFIX + ret;
            else
                ret = DSEMergeStrategy.MAY_PREFIX + ret;

            return ret + "\n";
        }
        
        @Override
        public boolean equals(Object obj) {
            return toString().equals(obj);
        }
        
        @Override
        public int hashCode() {
            return toString().hashCode();
        }
    }
    
    public class ActivationCodeWrapper {
        
        private IPatternMatch match;
        private Change change;
        private String code;
        
        public ActivationCodeWrapper(IPatternMatch match) {
            this.match = match;
            this.change = (Change) match.get("change");
            this.code = calculateCode();
         }
        
        public Change getChange() {
            return change;
        }
        
        private String calculateCode() {
            String ret = "";
//            if (match instanceof ExecutableDeleteChangeMatch)
//                return ret;
            if (change == null)
                return ret;
            if (change.getPriority() == Priority.MUST)
                ret = DSEMergeStrategy.MUST_PREFIX;
            else
                ret = DSEMergeStrategy.MAY_PREFIX;

            ret += "Match|" + match.patternName() + "|(";
            for (String param : match.parameterNames()) {
                Object p = match.get(param);
                if (p instanceof DSEMergeScope) {
                    ret += "scope;";
                } else if (p instanceof Change) {
                    ret += new ChangeWrapper((Change) p).toString().replace("\n", "") + ";";
                } else if (p instanceof EObject) {
                    String id = String.valueOf(mapper.getId((EObject) p));
                    ret += id + ";";
                } else {
                    ret += p.toString() + ";";
                }
            }            
            return ret;
        }
        
        @Override
        public String toString() {
            return code;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((code == null) ? 0 : code.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            ActivationCodeWrapper other = (ActivationCodeWrapper) obj;
            if (code == null) {
                if (other.code != null)
                    return false;
            } else if (!code.equals(other.code))
                return false;
            return true;
        }
        
    }
    
    /**
     * Comparator to provide fix order of the operations between two transitions application
     * 
     * @author Csaba Debreceni
     *
     */
    public static class ChangeComparator implements Comparator<Change> {

        @Override
        public int compare(Change o1, Change o2) {
            int ret = checkType(o1, o2);
            if (ret != 0)
                return ret;

            if (o1 instanceof Create && o2 instanceof Create)
                ret = checkCreate((Create) o1, (Create) o2);
            if (o1 instanceof Delete && o2 instanceof Delete)
                ret = checkDelete((Delete) o1, (Delete) o2);
            if (o1 instanceof Reference && o2 instanceof Reference)
                ret = checkReference((Reference) o1, (Reference) o2);
            if (o1 instanceof Attribute && o2 instanceof Attribute)
                ret = checkAttribute((Attribute) o1, (Attribute) o2);

            return ret;
        }

        /**
         * Compares two {@link Attribute} changes based on the their sources, features, types, values
         *
         * @param o1
         * @param o2
         * @return
         */
        private int checkAttribute(Attribute o1, Attribute o2) {
            int src = String.valueOf(DSEMergeUtil.getId(o1.getSrc())).compareTo(
                    String.valueOf(DSEMergeUtil.getId(o2.getSrc())));
            int feature = o1.getFeature().getName().compareTo(o2.getFeature().getName());
            int type = o1.getKind().getName().compareTo(o2.getKind().getName());
            
            String value1 = o1.getValue() == null ? "" : o1.getValue().toString();
            String value2 = o2.getValue() == null ? "" : o2.getValue().toString();
            int value = value1.compareTo(value2);

            return src + feature + type + value;
        }

        /**
         * Compares two {@link Reference} changes based on the their sources, features, types, targets
         *
         * @param o1
         * @param o2
         * @return
         */
        private int checkReference(Reference o1, Reference o2) {
            int src = String.valueOf(DSEMergeUtil.getId(o1.getSrc())).compareTo(
                    String.valueOf(DSEMergeUtil.getId(o2.getSrc())));
            int feature = o1.getFeature().getName().compareTo(o2.getFeature().getName());
            int type = o1.getKind().getName().compareTo(o2.getKind().getName());
            int trg = String.valueOf(DSEMergeUtil.getId(o1.getTrg())).compareTo(
                    String.valueOf(DSEMergeUtil.getId(o2.getTrg())));

            return src + feature + type + trg;
        }

        /**
         * Compares two {@link Delete} changes based on the identifier of their source
         * 
         * @param o1
         * @param o2
         * @return
         */
        private int checkDelete(Delete o1, Delete o2) {
            return String.valueOf(DSEMergeUtil.getId(o1.getSrc())).compareTo(
                    String.valueOf(DSEMergeUtil.getId(o2.getSrc())));
        }

        /**
         * Compares two {@link Create} changes based on the identifier of their source
         * 
         * @param o1
         * @param o2
         * @return
         */
        private int checkCreate(Create o1, Create o2) {
            return String.valueOf(DSEMergeUtil.getId(o1.getSrc())).compareTo(
                    String.valueOf(DSEMergeUtil.getId(o2.getSrc())));
        }

        /**
         * Alphabetically compares two changes based on the type.
         * 
         * @param o1
         * @param o2
         * @return
         */
        private int checkType(Change o1, Change o2) {
            return o1.getClass().getSimpleName().compareTo(o2.getClass().getSimpleName());
        }

    }

}
