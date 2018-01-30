package org.mondo.collaboration.security.locking.eval.simulation;

import org.apache.commons.math3.distribution.ExponentialDistribution;
import org.apache.commons.math3.distribution.WeibullDistribution;
import org.apache.commons.math3.random.JDKRandomGenerator;

public abstract class Distribution {

	public abstract double getNext();

	public static class Exponential extends Distribution {

		private JDKRandomGenerator rand;
		private ExponentialDistribution distribution;

		public Exponential(double mean) {
			this.rand = new JDKRandomGenerator();
			this.distribution = new ExponentialDistribution(rand, mean);
		}

		@Override
		public double getNext() {
			return distribution.sample();
		}

	}

	public static class Weibull extends Distribution {

		private JDKRandomGenerator rand;
		private WeibullDistribution distribution;

		public Weibull(double shape, double scale) {
			this.rand = new JDKRandomGenerator();
			this.distribution = new WeibullDistribution(rand, shape, scale,
					WeibullDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
		}

		@Override
		public double getNext() {
			return distribution.sample();
		}

	}

}
