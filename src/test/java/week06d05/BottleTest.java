package week06d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BottleTest {

    @Test
    public void emptyListShouldThrowException() throws IllegalArgumentException {
        Bottle bottle = Bottle.of(BottleType.PET_BOTTLE);
        Exception ex = assertThrows(IndexOutOfBoundsException.class, () -> bottle.fill(500));
        assertEquals("Too much", ex.getMessage());
    }

    @Test
    public void testFindTheBest() {

        Biscuit biscuit = Biscuit.of(BiscuitType.MAS, 100);
        Biscuit otherBiscuit = new Biscuit(BiscuitType.MAS, 200);

        assertEquals("MAS 100", biscuit.toString());
        assertEquals("MAS 200", otherBiscuit.toString());
    }
}
