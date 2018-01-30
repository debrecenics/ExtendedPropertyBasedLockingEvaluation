package org.mondo.collaboration.queries;

import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.mondo.collaboration.queries.ContainedByMatcher;
import org.mondo.collaboration.queries.UserM0Matcher;
import org.mondo.collaboration.queries.UserM1Matcher;
import org.mondo.collaboration.queries.UserM2Matcher;
import org.mondo.collaboration.queries.UserMMatcher;
import org.mondo.collaboration.queries.UserR0ControlConsumeMatcher;
import org.mondo.collaboration.queries.UserR0ControlCycleMatcher;
import org.mondo.collaboration.queries.UserR0ControlProvideMatcher;
import org.mondo.collaboration.queries.UserR0ControlTypeMatcher;
import org.mondo.collaboration.queries.UserR0Matcher;
import org.mondo.collaboration.queries.UserR0SignalFrequencyMatcher;
import org.mondo.collaboration.queries.UserR1ControlConsumeMatcher;
import org.mondo.collaboration.queries.UserR1ControlCycleMatcher;
import org.mondo.collaboration.queries.UserR1ControlProvideMatcher;
import org.mondo.collaboration.queries.UserR1ControlTypeMatcher;
import org.mondo.collaboration.queries.UserR1Matcher;
import org.mondo.collaboration.queries.UserR1SignalFrequencyMatcher;
import org.mondo.collaboration.queries.UserR2ControlConsumeMatcher;
import org.mondo.collaboration.queries.UserR2ControlCycleMatcher;
import org.mondo.collaboration.queries.UserR2ControlProvideMatcher;
import org.mondo.collaboration.queries.UserR2ControlTypeMatcher;
import org.mondo.collaboration.queries.UserR2Matcher;
import org.mondo.collaboration.queries.UserR2SignalFrequencyMatcher;
import org.mondo.collaboration.queries.UserRControlConsumeMatcher;
import org.mondo.collaboration.queries.UserRControlCycleMatcher;
import org.mondo.collaboration.queries.UserRControlProvideMatcher;
import org.mondo.collaboration.queries.UserRControlTypeMatcher;
import org.mondo.collaboration.queries.UserRMatcher;
import org.mondo.collaboration.queries.UserRSignalFrequencyMatcher;
import org.mondo.collaboration.queries.UserT0Matcher;
import org.mondo.collaboration.queries.UserT1Matcher;
import org.mondo.collaboration.queries.UserT2Matcher;
import org.mondo.collaboration.queries.UserTMatcher;
import org.mondo.collaboration.queries.util.ContainedByQuerySpecification;
import org.mondo.collaboration.queries.util.UserM0QuerySpecification;
import org.mondo.collaboration.queries.util.UserM1QuerySpecification;
import org.mondo.collaboration.queries.util.UserM2QuerySpecification;
import org.mondo.collaboration.queries.util.UserMQuerySpecification;
import org.mondo.collaboration.queries.util.UserR0ControlConsumeQuerySpecification;
import org.mondo.collaboration.queries.util.UserR0ControlCycleQuerySpecification;
import org.mondo.collaboration.queries.util.UserR0ControlProvideQuerySpecification;
import org.mondo.collaboration.queries.util.UserR0ControlTypeQuerySpecification;
import org.mondo.collaboration.queries.util.UserR0QuerySpecification;
import org.mondo.collaboration.queries.util.UserR0SignalFrequencyQuerySpecification;
import org.mondo.collaboration.queries.util.UserR1ControlConsumeQuerySpecification;
import org.mondo.collaboration.queries.util.UserR1ControlCycleQuerySpecification;
import org.mondo.collaboration.queries.util.UserR1ControlProvideQuerySpecification;
import org.mondo.collaboration.queries.util.UserR1ControlTypeQuerySpecification;
import org.mondo.collaboration.queries.util.UserR1QuerySpecification;
import org.mondo.collaboration.queries.util.UserR1SignalFrequencyQuerySpecification;
import org.mondo.collaboration.queries.util.UserR2ControlConsumeQuerySpecification;
import org.mondo.collaboration.queries.util.UserR2ControlCycleQuerySpecification;
import org.mondo.collaboration.queries.util.UserR2ControlProvideQuerySpecification;
import org.mondo.collaboration.queries.util.UserR2ControlTypeQuerySpecification;
import org.mondo.collaboration.queries.util.UserR2QuerySpecification;
import org.mondo.collaboration.queries.util.UserR2SignalFrequencyQuerySpecification;
import org.mondo.collaboration.queries.util.UserRControlConsumeQuerySpecification;
import org.mondo.collaboration.queries.util.UserRControlCycleQuerySpecification;
import org.mondo.collaboration.queries.util.UserRControlProvideQuerySpecification;
import org.mondo.collaboration.queries.util.UserRControlTypeQuerySpecification;
import org.mondo.collaboration.queries.util.UserRQuerySpecification;
import org.mondo.collaboration.queries.util.UserRSignalFrequencyQuerySpecification;
import org.mondo.collaboration.queries.util.UserT0QuerySpecification;
import org.mondo.collaboration.queries.util.UserT1QuerySpecification;
import org.mondo.collaboration.queries.util.UserT2QuerySpecification;
import org.mondo.collaboration.queries.util.UserTQuerySpecification;

/**
 * A pattern group formed of all patterns defined in queries.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file queries.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package org.mondo.collaboration.queries, the group contains the definition of the following patterns: <ul>
 * <li>containedBy</li>
 * <li>userM</li>
 * <li>userT</li>
 * <li>userR</li>
 * <li>userRControlCycle</li>
 * <li>userRControlType</li>
 * <li>userRControlProvide</li>
 * <li>userRControlConsume</li>
 * <li>userRSignalFrequency</li>
 * <li>userM0</li>
 * <li>userT0</li>
 * <li>userR0</li>
 * <li>userR0ControlCycle</li>
 * <li>userR0ControlType</li>
 * <li>userR0ControlProvide</li>
 * <li>userR0ControlConsume</li>
 * <li>userR0SignalFrequency</li>
 * <li>userM1</li>
 * <li>userT1</li>
 * <li>userR1</li>
 * <li>userR1ControlCycle</li>
 * <li>userR1ControlType</li>
 * <li>userR1ControlProvide</li>
 * <li>userR1ControlConsume</li>
 * <li>userR1SignalFrequency</li>
 * <li>userM2</li>
 * <li>userT2</li>
 * <li>userR2</li>
 * <li>userR2ControlCycle</li>
 * <li>userR2ControlType</li>
 * <li>userR2ControlProvide</li>
 * <li>userR2ControlConsume</li>
 * <li>userR2SignalFrequency</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Queries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Queries instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Queries();
    }
    return INSTANCE;
  }
  
  private static Queries INSTANCE;
  
  private Queries() throws IncQueryException {
    querySpecifications.add(ContainedByQuerySpecification.instance());
    querySpecifications.add(UserMQuerySpecification.instance());
    querySpecifications.add(UserTQuerySpecification.instance());
    querySpecifications.add(UserRQuerySpecification.instance());
    querySpecifications.add(UserRControlCycleQuerySpecification.instance());
    querySpecifications.add(UserRControlTypeQuerySpecification.instance());
    querySpecifications.add(UserRControlProvideQuerySpecification.instance());
    querySpecifications.add(UserRControlConsumeQuerySpecification.instance());
    querySpecifications.add(UserRSignalFrequencyQuerySpecification.instance());
    querySpecifications.add(UserM0QuerySpecification.instance());
    querySpecifications.add(UserT0QuerySpecification.instance());
    querySpecifications.add(UserR0QuerySpecification.instance());
    querySpecifications.add(UserR0ControlCycleQuerySpecification.instance());
    querySpecifications.add(UserR0ControlTypeQuerySpecification.instance());
    querySpecifications.add(UserR0ControlProvideQuerySpecification.instance());
    querySpecifications.add(UserR0ControlConsumeQuerySpecification.instance());
    querySpecifications.add(UserR0SignalFrequencyQuerySpecification.instance());
    querySpecifications.add(UserM1QuerySpecification.instance());
    querySpecifications.add(UserT1QuerySpecification.instance());
    querySpecifications.add(UserR1QuerySpecification.instance());
    querySpecifications.add(UserR1ControlCycleQuerySpecification.instance());
    querySpecifications.add(UserR1ControlTypeQuerySpecification.instance());
    querySpecifications.add(UserR1ControlProvideQuerySpecification.instance());
    querySpecifications.add(UserR1ControlConsumeQuerySpecification.instance());
    querySpecifications.add(UserR1SignalFrequencyQuerySpecification.instance());
    querySpecifications.add(UserM2QuerySpecification.instance());
    querySpecifications.add(UserT2QuerySpecification.instance());
    querySpecifications.add(UserR2QuerySpecification.instance());
    querySpecifications.add(UserR2ControlCycleQuerySpecification.instance());
    querySpecifications.add(UserR2ControlTypeQuerySpecification.instance());
    querySpecifications.add(UserR2ControlProvideQuerySpecification.instance());
    querySpecifications.add(UserR2ControlConsumeQuerySpecification.instance());
    querySpecifications.add(UserR2SignalFrequencyQuerySpecification.instance());
  }
  
  public ContainedByQuerySpecification getContainedBy() throws IncQueryException {
    return ContainedByQuerySpecification.instance();
  }
  
  public ContainedByMatcher getContainedBy(final IncQueryEngine engine) throws IncQueryException {
    return ContainedByMatcher.on(engine);
  }
  
  public UserMQuerySpecification getUserM() throws IncQueryException {
    return UserMQuerySpecification.instance();
  }
  
  public UserMMatcher getUserM(final IncQueryEngine engine) throws IncQueryException {
    return UserMMatcher.on(engine);
  }
  
  public UserTQuerySpecification getUserT() throws IncQueryException {
    return UserTQuerySpecification.instance();
  }
  
  public UserTMatcher getUserT(final IncQueryEngine engine) throws IncQueryException {
    return UserTMatcher.on(engine);
  }
  
  public UserRQuerySpecification getUserR() throws IncQueryException {
    return UserRQuerySpecification.instance();
  }
  
  public UserRMatcher getUserR(final IncQueryEngine engine) throws IncQueryException {
    return UserRMatcher.on(engine);
  }
  
  public UserRControlCycleQuerySpecification getUserRControlCycle() throws IncQueryException {
    return UserRControlCycleQuerySpecification.instance();
  }
  
  public UserRControlCycleMatcher getUserRControlCycle(final IncQueryEngine engine) throws IncQueryException {
    return UserRControlCycleMatcher.on(engine);
  }
  
  public UserRControlTypeQuerySpecification getUserRControlType() throws IncQueryException {
    return UserRControlTypeQuerySpecification.instance();
  }
  
  public UserRControlTypeMatcher getUserRControlType(final IncQueryEngine engine) throws IncQueryException {
    return UserRControlTypeMatcher.on(engine);
  }
  
  public UserRControlProvideQuerySpecification getUserRControlProvide() throws IncQueryException {
    return UserRControlProvideQuerySpecification.instance();
  }
  
  public UserRControlProvideMatcher getUserRControlProvide(final IncQueryEngine engine) throws IncQueryException {
    return UserRControlProvideMatcher.on(engine);
  }
  
  public UserRControlConsumeQuerySpecification getUserRControlConsume() throws IncQueryException {
    return UserRControlConsumeQuerySpecification.instance();
  }
  
  public UserRControlConsumeMatcher getUserRControlConsume(final IncQueryEngine engine) throws IncQueryException {
    return UserRControlConsumeMatcher.on(engine);
  }
  
  public UserRSignalFrequencyQuerySpecification getUserRSignalFrequency() throws IncQueryException {
    return UserRSignalFrequencyQuerySpecification.instance();
  }
  
  public UserRSignalFrequencyMatcher getUserRSignalFrequency(final IncQueryEngine engine) throws IncQueryException {
    return UserRSignalFrequencyMatcher.on(engine);
  }
  
  public UserM0QuerySpecification getUserM0() throws IncQueryException {
    return UserM0QuerySpecification.instance();
  }
  
  public UserM0Matcher getUserM0(final IncQueryEngine engine) throws IncQueryException {
    return UserM0Matcher.on(engine);
  }
  
  public UserT0QuerySpecification getUserT0() throws IncQueryException {
    return UserT0QuerySpecification.instance();
  }
  
  public UserT0Matcher getUserT0(final IncQueryEngine engine) throws IncQueryException {
    return UserT0Matcher.on(engine);
  }
  
  public UserR0QuerySpecification getUserR0() throws IncQueryException {
    return UserR0QuerySpecification.instance();
  }
  
  public UserR0Matcher getUserR0(final IncQueryEngine engine) throws IncQueryException {
    return UserR0Matcher.on(engine);
  }
  
  public UserR0ControlCycleQuerySpecification getUserR0ControlCycle() throws IncQueryException {
    return UserR0ControlCycleQuerySpecification.instance();
  }
  
  public UserR0ControlCycleMatcher getUserR0ControlCycle(final IncQueryEngine engine) throws IncQueryException {
    return UserR0ControlCycleMatcher.on(engine);
  }
  
  public UserR0ControlTypeQuerySpecification getUserR0ControlType() throws IncQueryException {
    return UserR0ControlTypeQuerySpecification.instance();
  }
  
  public UserR0ControlTypeMatcher getUserR0ControlType(final IncQueryEngine engine) throws IncQueryException {
    return UserR0ControlTypeMatcher.on(engine);
  }
  
  public UserR0ControlProvideQuerySpecification getUserR0ControlProvide() throws IncQueryException {
    return UserR0ControlProvideQuerySpecification.instance();
  }
  
  public UserR0ControlProvideMatcher getUserR0ControlProvide(final IncQueryEngine engine) throws IncQueryException {
    return UserR0ControlProvideMatcher.on(engine);
  }
  
  public UserR0ControlConsumeQuerySpecification getUserR0ControlConsume() throws IncQueryException {
    return UserR0ControlConsumeQuerySpecification.instance();
  }
  
  public UserR0ControlConsumeMatcher getUserR0ControlConsume(final IncQueryEngine engine) throws IncQueryException {
    return UserR0ControlConsumeMatcher.on(engine);
  }
  
  public UserR0SignalFrequencyQuerySpecification getUserR0SignalFrequency() throws IncQueryException {
    return UserR0SignalFrequencyQuerySpecification.instance();
  }
  
  public UserR0SignalFrequencyMatcher getUserR0SignalFrequency(final IncQueryEngine engine) throws IncQueryException {
    return UserR0SignalFrequencyMatcher.on(engine);
  }
  
  public UserM1QuerySpecification getUserM1() throws IncQueryException {
    return UserM1QuerySpecification.instance();
  }
  
  public UserM1Matcher getUserM1(final IncQueryEngine engine) throws IncQueryException {
    return UserM1Matcher.on(engine);
  }
  
  public UserT1QuerySpecification getUserT1() throws IncQueryException {
    return UserT1QuerySpecification.instance();
  }
  
  public UserT1Matcher getUserT1(final IncQueryEngine engine) throws IncQueryException {
    return UserT1Matcher.on(engine);
  }
  
  public UserR1QuerySpecification getUserR1() throws IncQueryException {
    return UserR1QuerySpecification.instance();
  }
  
  public UserR1Matcher getUserR1(final IncQueryEngine engine) throws IncQueryException {
    return UserR1Matcher.on(engine);
  }
  
  public UserR1ControlCycleQuerySpecification getUserR1ControlCycle() throws IncQueryException {
    return UserR1ControlCycleQuerySpecification.instance();
  }
  
  public UserR1ControlCycleMatcher getUserR1ControlCycle(final IncQueryEngine engine) throws IncQueryException {
    return UserR1ControlCycleMatcher.on(engine);
  }
  
  public UserR1ControlTypeQuerySpecification getUserR1ControlType() throws IncQueryException {
    return UserR1ControlTypeQuerySpecification.instance();
  }
  
  public UserR1ControlTypeMatcher getUserR1ControlType(final IncQueryEngine engine) throws IncQueryException {
    return UserR1ControlTypeMatcher.on(engine);
  }
  
  public UserR1ControlProvideQuerySpecification getUserR1ControlProvide() throws IncQueryException {
    return UserR1ControlProvideQuerySpecification.instance();
  }
  
  public UserR1ControlProvideMatcher getUserR1ControlProvide(final IncQueryEngine engine) throws IncQueryException {
    return UserR1ControlProvideMatcher.on(engine);
  }
  
  public UserR1ControlConsumeQuerySpecification getUserR1ControlConsume() throws IncQueryException {
    return UserR1ControlConsumeQuerySpecification.instance();
  }
  
  public UserR1ControlConsumeMatcher getUserR1ControlConsume(final IncQueryEngine engine) throws IncQueryException {
    return UserR1ControlConsumeMatcher.on(engine);
  }
  
  public UserR1SignalFrequencyQuerySpecification getUserR1SignalFrequency() throws IncQueryException {
    return UserR1SignalFrequencyQuerySpecification.instance();
  }
  
  public UserR1SignalFrequencyMatcher getUserR1SignalFrequency(final IncQueryEngine engine) throws IncQueryException {
    return UserR1SignalFrequencyMatcher.on(engine);
  }
  
  public UserM2QuerySpecification getUserM2() throws IncQueryException {
    return UserM2QuerySpecification.instance();
  }
  
  public UserM2Matcher getUserM2(final IncQueryEngine engine) throws IncQueryException {
    return UserM2Matcher.on(engine);
  }
  
  public UserT2QuerySpecification getUserT2() throws IncQueryException {
    return UserT2QuerySpecification.instance();
  }
  
  public UserT2Matcher getUserT2(final IncQueryEngine engine) throws IncQueryException {
    return UserT2Matcher.on(engine);
  }
  
  public UserR2QuerySpecification getUserR2() throws IncQueryException {
    return UserR2QuerySpecification.instance();
  }
  
  public UserR2Matcher getUserR2(final IncQueryEngine engine) throws IncQueryException {
    return UserR2Matcher.on(engine);
  }
  
  public UserR2ControlCycleQuerySpecification getUserR2ControlCycle() throws IncQueryException {
    return UserR2ControlCycleQuerySpecification.instance();
  }
  
  public UserR2ControlCycleMatcher getUserR2ControlCycle(final IncQueryEngine engine) throws IncQueryException {
    return UserR2ControlCycleMatcher.on(engine);
  }
  
  public UserR2ControlTypeQuerySpecification getUserR2ControlType() throws IncQueryException {
    return UserR2ControlTypeQuerySpecification.instance();
  }
  
  public UserR2ControlTypeMatcher getUserR2ControlType(final IncQueryEngine engine) throws IncQueryException {
    return UserR2ControlTypeMatcher.on(engine);
  }
  
  public UserR2ControlProvideQuerySpecification getUserR2ControlProvide() throws IncQueryException {
    return UserR2ControlProvideQuerySpecification.instance();
  }
  
  public UserR2ControlProvideMatcher getUserR2ControlProvide(final IncQueryEngine engine) throws IncQueryException {
    return UserR2ControlProvideMatcher.on(engine);
  }
  
  public UserR2ControlConsumeQuerySpecification getUserR2ControlConsume() throws IncQueryException {
    return UserR2ControlConsumeQuerySpecification.instance();
  }
  
  public UserR2ControlConsumeMatcher getUserR2ControlConsume(final IncQueryEngine engine) throws IncQueryException {
    return UserR2ControlConsumeMatcher.on(engine);
  }
  
  public UserR2SignalFrequencyQuerySpecification getUserR2SignalFrequency() throws IncQueryException {
    return UserR2SignalFrequencyQuerySpecification.instance();
  }
  
  public UserR2SignalFrequencyMatcher getUserR2SignalFrequency(final IncQueryEngine engine) throws IncQueryException {
    return UserR2SignalFrequencyMatcher.on(engine);
  }
}
