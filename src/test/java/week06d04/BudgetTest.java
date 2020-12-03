package week06d04;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BudgetTest {
    Budget testBudget = new Budget(new Item(1200, 2, "kenyer"),
            new Item(1400, 5, "narancs"), new Item(800, 12, "Valami"));

    @Test
    public void testBudget(){
        assertEquals("["+ new Item(1400, 5, "narancs").toString() +"]", testBudget.getItemsByMonth(5).toString());
    }

   @Test
    public void nullListShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> testBudget = new Budget(new Item(1200, 2, "kenyer"),
                new Item(1400, 5, "narancs"), new Item(800, 12, null)));
        Assertions.assertEquals("Wrong input!", ex.getMessage());
    }
}
