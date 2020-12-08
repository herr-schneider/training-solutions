package week07d02;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DigitSumTest {

    @Test
    public void testSumOfDigits() {
        assertEquals(6, DigitSum.sumOfDigits(123));
        assertEquals(10, DigitSum.sumOfDigits(1234));
        assertEquals(15, DigitSum.sumOfDigits(12345));

        Exception ex = assertThrows(IllegalArgumentException.class, () -> DigitSum.sumOfDigits(-112345));
    }
}
