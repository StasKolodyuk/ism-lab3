package by.bsu.kolodyuk.util;


import java.util.List;

import static java.lang.Math.pow;

public class MomentUtils
{
    private MomentUtils(){}

    public static double getRawMoment(List<? extends Number> numbers, int power) {
        return numbers.stream().mapToDouble(n -> pow(n.doubleValue(), power)).average().getAsDouble();
    }

    public static double getCentralMoment(List<? extends Number> numbers, int power) {
        double mean = getMean(numbers);
        return numbers.stream().mapToDouble(n -> pow(n.doubleValue() - mean, power)).average().getAsDouble();
    }

    public static double getMean(List<? extends Number> numbers) {
        return numbers.stream().mapToDouble(n -> n.doubleValue()).average().getAsDouble();
    }

    public static void printMoments(List<? extends Number> distribution, int count) {
        for(int i = 0; i < count; i++) {
            System.out.printf("Moment %d: %5.2f / %5.2f \n", (i + 1), getRawMoment(distribution, (i + 1)), getCentralMoment(distribution, (i + 1)));
        }
    }
}
