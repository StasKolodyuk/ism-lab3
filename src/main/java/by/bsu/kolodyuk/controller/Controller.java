package by.bsu.kolodyuk.controller;


import by.bsu.kolodyuk.generator.LinearCongruentialGenerator;
import by.bsu.kolodyuk.generator.MacLarenMarsagliaGenerator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import org.apache.commons.math3.distribution.UniformIntegerDistribution;
import org.apache.commons.math3.distribution.UniformRealDistribution;
import org.apache.commons.math3.random.RandomGenerator;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static by.bsu.kolodyuk.util.ChartUtils.toChartSeries;
import static by.bsu.kolodyuk.util.MomentUtils.*;
import static java.util.Arrays.asList;
import static org.apache.commons.lang3.ArrayUtils.toObject;

public class Controller implements Initializable
{
    @FXML
    LineChart<Double, Double> firstLineChart;
    @FXML
    LineChart<Double, Double> secondLineChart;
    @FXML
    LineChart<Double, Double> thirdLineChart;
    @FXML
    LineChart<Double, Double> fourthLineChart;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateValues();
    }

    public void generateValues() {

        RandomGenerator firstCongruentialGenerator = new LinearCongruentialGenerator(0, 3, 1, 31);
        RandomGenerator secondCongruentialGenerator = new LinearCongruentialGenerator();

        RandomGenerator firstMacLarenMarsagliaGenerator = new MacLarenMarsagliaGenerator(firstCongruentialGenerator, secondCongruentialGenerator, 64);
        RandomGenerator secondMacLarenMarsagliaGenerator = new MacLarenMarsagliaGenerator(secondCongruentialGenerator, firstCongruentialGenerator, 64);

        List<RandomGenerator> generators = asList(firstCongruentialGenerator,
                                                  secondCongruentialGenerator,
                                                  firstMacLarenMarsagliaGenerator,
                                                  secondMacLarenMarsagliaGenerator);

        List<LineChart<Double, Double>> charts = asList(firstLineChart,
                                                        secondLineChart,
                                                        thirdLineChart,
                                                        fourthLineChart);

        // Real Random Values
        System.out.println("Real Distribution");

        for(int i = 0; i < generators.size(); i++) {
            List<Double> distribution = asList(toObject(new UniformRealDistribution(generators.get(i), 0, 1).sample(2000)));
            System.out.println(distribution);
            printMoments(distribution, 5);
            charts.get(i).getData().add(toChartSeries(distribution, generators.get(i).getClass().getSimpleName()));
        }

        // Discrete Random Values
        System.out.println("Discrete Distribution");

        for(RandomGenerator generator : generators) {
            for(int i = 1; i < 4; i++) {
                List<Integer> distribution = asList(toObject(new UniformIntegerDistribution(generator, 0, i).sample(10)));
                System.out.println("On [0, " + i + "]");
                System.out.println(distribution);
                printMoments(distribution, 5);
            }
        }

    }

}
