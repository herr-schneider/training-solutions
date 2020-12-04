package week06d05;

import methodoverloading.ListOfGoodPubs;
import methodoverloading.Pub;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BiscuitTest {

        @Test
        public void emptyListShouldThrowException() throws IllegalArgumentException {

            Exception ex = assertThrows(IllegalArgumentException.class, () -> new Biscuit(BiscuitType.CSOKIS, 0));
            assertEquals("Incorrect amount!", ex.getMessage());
        }

        @Test
        public void testFindTheBest() {

            Biscuit biscuit = Biscuit.of(BiscuitType.MAS, 100);
            Biscuit otherBiscuit = new Biscuit(BiscuitType.MAS, 200);

            assertEquals("MAS 100", biscuit.toString());
            assertEquals("MAS 200", otherBiscuit.toString());
        }
    }

