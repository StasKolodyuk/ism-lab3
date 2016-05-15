package by.bsu.kolodyuk.controller;

import by.bsu.kolodyuk.distribution.impl.CauchyDistribution;
import by.bsu.kolodyuk.distribution.impl.GaussianDistribution;
import by.bsu.kolodyuk.distribution.impl.PascalDistribution;
import by.bsu.kolodyuk.generator.A5Generator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import org.apache.commons.math3.random.RandomGenerator;

import java.net.URL;
import java.util.ResourceBundle;

import static by.bsu.kolodyuk.util.ChartUtils.prepareChart;

public class Controller implements Initializable
{
    @FXML
    XYChart<Integer, Double> pascalChart;
    @FXML
    XYChart<Double, Double> gaussianChart;
    @FXML
    XYChart<Double, Double> cauchyChart;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateValues();
    }

    public void generateValues() {
        RandomGenerator generator = new A5Generator();

        PascalDistribution pascalDistribution = new PascalDistribution(generator, 50, 0.5);
        GaussianDistribution gaussianDistribution = new GaussianDistribution(generator, 0, 1);
        CauchyDistribution cauchyDistribution = new CauchyDistribution(generator, 0, 1);

        prepareChart(pascalChart, pascalDistribution, 200);
        prepareChart(gaussianChart, gaussianDistribution, 200, 10);
        prepareChart(cauchyChart, cauchyDistribution, 200, 50);
    }

}
