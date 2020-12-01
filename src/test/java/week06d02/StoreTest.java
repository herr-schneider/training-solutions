package week06d02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {

    Store store = new Store(Arrays.asList(new Product("kenyer", Category.BAKEDGOODS, 1000),
            new Product("kifli", Category.BAKEDGOODS, 500), new Product("csoki", Category.SWEETS, 250)));

    @Test
    public void categoryNumber() { //Given When Then


        assertEquals(2, store.getProductByCategoryName(Category.BAKEDGOODS));

        assertEquals(1, store.getProductByCategoryName(Category.SWEETS));
    }

    @Test
    public void allCategoryNumber() { //Given When Then

        for (CategoryCounter catCount : store.getProductAllCategoryName()) {
            System.out.println(catCount.toString());
        }

        //assertEquals(1, store.getProductAllCategoryName());
    }

}
