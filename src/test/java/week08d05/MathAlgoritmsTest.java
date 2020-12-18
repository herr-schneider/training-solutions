package week08d05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathAlgoritmsTest {
    int a = 6300;
    int b = 18000;
    int c = 900;
    MathAlgoritms m = new MathAlgoritms();

    @Test
    public void test() {
        assertEquals(c, m.Euclidean(a, b));
    }

    @Test
    public void test2() {
        assertEquals(c, m.greatestCommonDivisorBack(a, b));
    }

    @Test
    public void test3() {
        assertEquals(c, m.greatestCommonDivisor2(a, b));
    }

    @Test
    public void test4() {
        assertEquals(c, m.greatestCommonDivisor(a, b));
    }
}
