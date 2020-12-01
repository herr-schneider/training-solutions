package week06d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {
    @Test
    public void categoryNumber() { //Given When Then

       Store store = new Store(Arrays.asList(new Product("kenyer", Category.BAKEDGOODS, 1000),
               new Product("kifli", Category.BAKEDGOODS, 500)));

        assertEquals(2, store.getProductByCategoryName(Category.BAKEDGOODS));

    }
}
