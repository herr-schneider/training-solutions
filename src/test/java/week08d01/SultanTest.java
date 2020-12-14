package week08d01;

import org.junit.Test;

public class SultanTest {

    @Test
    public void testTheKey(){
        Sultan s = new Sultan();
        s.reset();
        s.openDoors();
        s.printTheResult();
    }
}
