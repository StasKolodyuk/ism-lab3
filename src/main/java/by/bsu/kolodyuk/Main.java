package by.bsu.kolodyuk;


import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.UncorrelatedRandomVectorGenerator;

public class Main {

    public static void main(String[] args) {
        RandomGenerator congruentialGenerator = new LinearCongruentialGenerator(2, 1, 5, 101);
        System.out.println(congruentialGenerator.nextInt());
        GaussianRandomGenerator gaussianRandomGenerator = new GaussianRandomGenerator(congruentialGenerator);
        System.out.println(gaussianRandomGenerator.nextNormalizedDouble());
        /*UncorrelatedRandomVectorGenerator uncorrelatedRandomVectorGenerator = new UncorrelatedRandomVectorGenerator(10, gaussianRandomGenerator);
        System.out.println(uncorrelatedRandomVectorGenerator.nextVector());*/
    }

}
