package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisorFinderTest {

    @Test
    public void test() {
        DivisorFinder dv = new DivisorFinder();
        assertEquals(1, dv.findDivisors(425));
        assertEquals(2, dv.findDivisors(363));
    }
}
