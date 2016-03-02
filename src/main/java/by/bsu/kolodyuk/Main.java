package by.bsu.kolodyuk;

import org.apache.commons.math3.distribution.UniformIntegerDistribution;
import org.apache.commons.math3.distribution.UniformRealDistribution;
import org.apache.commons.math3.random.RandomGenerator;

import java.util.List;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.ArrayUtils.toObject;

public class Main {

    public static void main(String[] args) {

        RandomGenerator firstCongruentialGenerator = new LinearCongruentialGenerator(0, 3, 1, 31);
        RandomGenerator secondCongruentialGenerator = new LinearCongruentialGenerator();

        RandomGenerator firstMacLarenMarsagliaGenerator = new MacLarenMarsagliaGenerator(firstCongruentialGenerator, secondCongruentialGenerator, 64);
        RandomGenerator secondMacLarenMarsagliaGenerator = new MacLarenMarsagliaGenerator(firstCongruentialGenerator, secondCongruentialGenerator, 128);

        List<RandomGenerator> generators = asList(firstCongruentialGenerator,
                                                  secondCongruentialGenerator,
                                                  firstMacLarenMarsagliaGenerator,
                                                  secondMacLarenMarsagliaGenerator);

        // Real Random Values
        System.out.println("Real Distribution");

        for(RandomGenerator generator : generators) {
            System.out.println(asList(toObject(new UniformRealDistribution(generator, 0, 1).sample(10))));
        }

        // Discrete Random Values
        System.out.println("Discrete Distribution");

        for(RandomGenerator generator : generators) {
            for(int i = 1; i < 4; i++) {
                System.out.println("On [0, " + i + "]");
                System.out.println(asList(toObject(new UniformIntegerDistribution(generator, 0, i).sample(10))));
            }
        }

    }

}
