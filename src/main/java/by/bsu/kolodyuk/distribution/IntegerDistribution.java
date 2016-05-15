package by.bsu.kolodyuk.distribution;


import java.util.stream.IntStream;

public interface IntegerDistribution {

    int sample();
    double cumulativeProbability(int x);
    double probability(int x);

    default int[] sample(int n) {
        return IntStream.generate(() -> sample()).limit(n).toArray();
    }
}
