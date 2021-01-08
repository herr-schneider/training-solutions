package week10d05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    public  void testCalculator(){
Calculator c = new Calculator();
        assertEquals(16, c.findMinSum(new int[]{1, 3, 5, 7, 9}));
    }
}
