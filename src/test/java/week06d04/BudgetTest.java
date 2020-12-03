package week06d04;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BudgetTest {
    Budget testBudget = new Budget(new Item(1200, LocalDate.of(2020,12,01), "kenyer"),
            new Item(1400, LocalDate.of(2020,05,01), "narancs"), new Item(800, LocalDate.of(2020,8,01), "Valami"));

    @Test
    public void testBudget(){
        assertEquals("["+ new Item(1400, LocalDate.of(2020,05,01), "narancs").toString() +"]", testBudget.getItemsByMonth(5).toString());
    }

   @Test
    public void nullListShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> testBudget = new Budget(new Item(1200, LocalDate.of(2020,05,01), "kenyer"),
                new Item(1400, LocalDate.of(2020,05,01), "narancs"), new Item(800, LocalDate.of(2020,05,01), null)));
        Assertions.assertEquals("Wrong input!", ex.getMessage());
    }
}
