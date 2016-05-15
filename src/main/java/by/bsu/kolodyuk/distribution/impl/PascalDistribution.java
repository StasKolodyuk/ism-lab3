package by.bsu.kolodyuk.distribution.impl;


import by.bsu.kolodyuk.distribution.IntegerDistribution;
import org.apache.commons.math3.random.RandomGenerator;


public class PascalDistribution implements IntegerDistribution {

    private org.apache.commons.math3.distribution.PascalDistribution ethalon;

    private RandomGenerator randomGenerator;
    private int r;
    private double p;

    public PascalDistribution(RandomGenerator randomGenerator, int r, double p) {
        this.randomGenerator = randomGenerator;
        this.r = r;
        this.p = p;
        this.ethalon = new org.apache.commons.math3.distribution.PascalDistribution(randomGenerator, r, p);
    }

    /**
     * Meтод Браковки
     */
    @Override
    public int sample() {
        int successes = 0;
        int failures = 0;
        while(successes != r) {
            if(randomGenerator.nextDouble() < p) {
                successes++;
            } else {
                failures++;
            }
        }
        return failures;
    }

    @Override
    public double cumulativeProbability(int x) {
        return ethalon.cumulativeProbability(x);
    }

    @Override
    public double probability(int x) {
        return ethalon.probability(x);
    }
}
