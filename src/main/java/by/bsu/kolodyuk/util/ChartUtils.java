package by.bsu.kolodyuk.util;

import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;

import java.util.List;

public class ChartUtils
{
    private ChartUtils() {}

    public static Series<Double, Double> toChartSeries(List<? extends Number> numbers, String seriesName) {

        Series<Double, Double> series = new Series<>();
        series.setName(seriesName);

        for(int i = 0; i < numbers.size() - 1; i++) {
            series.getData().add(new Data<>(numbers.get(i).doubleValue(), numbers.get(i + 1).doubleValue()));
        }

        return series;
    }
}
