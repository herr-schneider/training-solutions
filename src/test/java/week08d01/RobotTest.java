package week08d01;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {

    @Test
    public void testMoving() {
        Robot r = new Robot("JBFLLFBJL");
        Robot other = new Robot("JBFLJBFLL");
        r.mover();
        other.moverIf();
        assertEquals(r.getPos(),other.getPos());
    }
}


