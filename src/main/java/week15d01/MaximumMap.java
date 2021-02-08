package week15d01;

import java.util.Map;

public class MaximumMap {

    public Map.Entry<Double, Double> maxValue(Map<Double, Double> graph) {
        if (graph.size() < 1 || graph.containsValue(Double.MIN_VALUE) || graph.containsValue(null)) {
            throw new IllegalArgumentException("");
        }
        Map.Entry<Double, Double> maxElement = null;
        double maxValue = Double.MIN_VALUE;
        for (Map.Entry<Double, Double> actual : graph.entrySet()) {
            if (maxValue < actual.getValue()) {
                maxElement = actual;
                maxValue = actual.getValue();
            }
        }
        return maxElement;
    }

    public Map.Entry<Double, Double> maxValue2(Map<Double, Double> graph) {
        if (graph.size() < 1 || graph.containsValue(Double.MIN_VALUE) || graph.containsValue(null)) {
            throw new IllegalArgumentException("");
        }
        Map.Entry<Double, Double> maxElement = null;
        for (Map.Entry<Double, Double> actual : graph.entrySet()) {
            if (maxElement == null || maxElement.getValue() < actual.getValue()) {
                maxElement = actual;
            }
        }
        return maxElement;
    }
}
