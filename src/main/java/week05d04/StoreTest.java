package week05d04;

import org.junit.Before;
import org.junit.Test;
import week04.Library;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class StoreTest {
    Store store = new Store();

    @Before
    public void setUp() {
        store.addProduct("milk", 2020, 11, 30);
        store.addProduct("butter", 2020, 11, 30);
        store.addProduct("beer", 2020, 11, 30);
        store.addProduct("jar", 2020, 11, 30);
        store.addProduct("egg", 2020, 10, 25);
        store.addProduct("fish", 2020, 9, 25);
    }
    @Test
    public void testAllreadyThereIs() {
        assertEquals(true, store.addProduct("milk", 2020, 12, 30));
    }

    @Test
    public void expiredProduct() {
        assertEquals(true, store.addProduct("whiskey", 2020, 5, 30));
    }

    @Test
    public void numberOfExpiredProduct() {
        for (Product testProduct : store.getProductList()) {
            System.out.println(testProduct.getName());
           // System.out.println(testProduct.getBestBefore() + " " + LocalDate.now());
        }
        System.out.println(store);
        assertEquals(2, store.getNumberOfExpired());
    }
}
