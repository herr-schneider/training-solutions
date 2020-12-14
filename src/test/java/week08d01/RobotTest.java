package week08d01;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {

    @Test
    public void testMovingString() {
        Robot r = new Robot("JBFLLFBJL");
        Robot other = new Robot("JBFLJBFLL");
        r.mover();
        other.moverIf();
        assertEquals(r.getPosString(), other.getPosString());
        assertEquals(true, r.getPosString().equals(other.getPosString()));

    }

    @Test
    public void testMoving() {
        Robot r = new Robot("JBFLLFBJL");
        Robot other = new Robot("JBFLJBFLL");
        r.mover();
        other.moverIf();
        assertEquals(true, r.getPos().equals(other.getPos()));
        assertEquals(r.getPos(), other.getPos());
    }
}


