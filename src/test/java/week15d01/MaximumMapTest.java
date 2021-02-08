package week15d01;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MaximumMapTest {

    @Test
    public void testMax() {
        MaximumMap graph = new MaximumMap();

        Map<Double, Double> function = new HashMap<>();
        function.put(-2.0, -1.0);
        function.put(-3.0, 3.0);
        function.put(-4.0, 4.0);
        function.put(-5.0, 5.0);
        function.put(-6.0, 6.0);
        function.put(-7.0, 7.0);
        function.put(-8.0, 8.0);
        System.out.println(graph.maxValue(function));
        System.out.println(graph.maxValue2(function));
        assertEquals(graph.maxValue(function),graph.maxValue2(function));
    }


}