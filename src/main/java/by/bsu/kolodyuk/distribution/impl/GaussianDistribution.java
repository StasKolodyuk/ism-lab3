package by.bsu.kolodyuk.distribution.impl;

import by.bsu.kolodyuk.distribution.RealDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.random.RandomGenerator;

import java.util.stream.DoubleStream;

import static java.lang.Math.sqrt;


public class GaussianDistribution implements RealDistribution {

    private NormalDistribution ethalon;

    private static final int N = 12;
    private RandomGenerator randomGenerator;
    private double mean;
    private double sd;

    public GaussianDistribution(RandomGenerator randomGenerator, double mean, double sd) {
        this.randomGenerator = randomGenerator;
        this.mean = mean;
        this.sd = sd;
        this.ethalon = new NormalDistribution(randomGenerator, mean, sd);
    }

    @Override
    public double sample() {
        return (DoubleStream.generate(randomGenerator::nextDouble).limit(N).sum() - ((double)N)/2)* sqrt(12/N);
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
