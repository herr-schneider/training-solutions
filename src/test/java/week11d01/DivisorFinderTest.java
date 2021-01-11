package week11d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisorFinderTest {

    @Test
    public void test() {
        DivisorFinder dv = new DivisorFinder();
        assertEquals(1, dv.findDivisorsMyOwn(425));
        assertEquals(2, dv.findDivisorsMyOwn(363));
        assertEquals(4, dv.findDivisorsMyOwn(1112));
        assertEquals(1, dv.findDivisorsMyOwn(1000));
    }


    @Test
    public void test3() {
        DivisorFinder dv = new DivisorFinder();
        assertEquals(1, dv.findDivisors2(425));
        assertEquals(2, dv.findDivisors2(363));
        assertEquals(4, dv.findDivisors2(1112));
        assertEquals(1, dv.findDivisors2(1000));}

    @Test
    public void test2() {
        DivisorFinder dv = new DivisorFinder();
        assertEquals(1, dv.findDivisors(425));
        assertEquals(2, dv.findDivisors(363));
        assertEquals(4, dv.findDivisors(1112));
        assertEquals(1, dv.findDivisors2(1000));}
}
