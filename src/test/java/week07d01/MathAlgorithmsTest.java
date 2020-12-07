package week07d01;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MathAlgorithmsTest {


    @Test
    public void testZeroInput() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> MathAlgorithms.isPrimeFromList(0));
    }

    @Test
    public void testAPrimeAndANotAPrime() {
        assertTrue(MathAlgorithms.isPrimeFromList(2));
        assertFalse(MathAlgorithms.isPrimeFromList(4));

        assertTrue(MathAlgorithms.isPrime(2));
        assertFalse(MathAlgorithms.isPrime(4));
        assertTrue(MathAlgorithms.isPrimeFromList(1));
        assertTrue(MathAlgorithms.isPrime(1));
        Integer[] prims = new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271};
    for (int x : prims) {
        assertTrue(MathAlgorithms.isPrime(x));
    }
    }
}
