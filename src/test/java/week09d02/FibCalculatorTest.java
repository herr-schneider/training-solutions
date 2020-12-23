package week09d02;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FibCalculatorTest {

    @Test
    public void testFib() {
        FibCalculator f = new FibCalculator();
        assertEquals(10, f.sumEvents(20));
    }

    @Test
    public void testFib40() {
        FibCalculator f = new FibCalculator();
        assertEquals(10, f.sumEvents(40));
    }
}
