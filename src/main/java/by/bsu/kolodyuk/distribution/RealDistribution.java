package by.bsu.kolodyuk.distribution;


import java.util.stream.DoubleStream;

public interface RealDistribution {

    double sample();
    double cumulativeProbability(double x);
    double cumulativeProbability(double x0, double x1);
    double density(double x);
    org.apache.commons.math3.distribution.RealDistribution getRealDistribution();

    default double[] sample(int n) {
        return DoubleStream.generate(() -> sample()).limit(n).toArray();
    }
}
