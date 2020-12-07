package week07d01;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathAlgorithmsTest {


    @Test
    public void testZeroInput() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> MathAlgorithms.isPrime(0));
    }

    @Test
    public void testAPrimeAndANotAPrime() {
        assertTrue(MathAlgorithms.isPrime(2));
        assertFalse(MathAlgorithms.isPrime(4));
    }
}
