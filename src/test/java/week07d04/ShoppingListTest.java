package week07d04;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import week07d01.MathAlgorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShoppingListTest {

    ShoppingList s = new ShoppingList();

    @Test
    public void testShopping() {

        assertEquals(240, s.calculateSum("/training/training_solutions/src/main/java/week07d04/shoppingList.txt"));
    }

    @Test
    public void testZeroInput() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> s.calculateSum("../shoppingList.txt"));
        Assertions.assertEquals("Wrong path!", ex.getMessage());
    }

    @Test
    public void testNullInput() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> s.calculateSum(null));
        Assertions.assertEquals( "Try with a path!", ex.getMessage());
    }

}
