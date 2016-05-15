package by.bsu.kolodyuk.distribution.impl;


import by.bsu.kolodyuk.distribution.RealDistribution;
import org.apache.commons.math3.random.RandomGenerator;

import static java.lang.Math.PI;
import static java.lang.Math.tan;
import static org.apache.commons.math3.distribution.CauchyDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY;

public class CauchyDistribution implements RealDistribution {

    private org.apache.commons.math3.distribution.CauchyDistribution ethalon;

    private RandomGenerator randomGenerator;
    private GaussianDistribution gaussianDistribution;
    private double median;
    private double scale;

    public CauchyDistribution(RandomGenerator randomGenerator, double median, double scale) {
        this.median = median;
        this.scale = scale;
        this.ethalon = new org.apache.commons.math3.distribution.CauchyDistribution(randomGenerator, median, scale, DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
        this.gaussianDistribution = new GaussianDistribution(randomGenerator, 0, 1);
    }

    @Override
    public double sample() {
        double y = gaussianDistribution.sample()/gaussianDistribution.sample();
        return median + scale * tan(PI * (y - 0.5));
    }

    @Override
    public double cumulativeProbability(double x) {
        return ethalon.cumulativeProbability(x);
    }

    @Override
    public double cumulativeProbability(double x0, double x1) {
        return ethalon.cumulativeProbability(x0, x1);
    }

    @Override
    public double density(double x) {
        return ethalon.density(x);
    }

    @Override
    public org.apache.commons.math3.distribution.RealDistribution getRealDistribution() {
        return ethalon;
    }
}
