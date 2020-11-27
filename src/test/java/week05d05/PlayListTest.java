package week05d05;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PlayListTest {

        PlayList testPlayList = new PlayList();

        @Before
        public void setUp() {
            testPlayList.addSong("No milk today", 240, "Diablo");
            testPlayList.addSong("Push", 245, "Salt 'n Peppa");
            testPlayList.addSong("California Dreams", 200, "Mammas and Pappas");
            testPlayList.addSong("Unforgiven", 300, "Metallica");
        }
        @Test
        public void testLength() {
            PlayList controlPlayList = new PlayList();
            controlPlayList.addSong("Unforgiven", 300, "Metallica");
            assertEquals(controlPlayList.getPlayList(), testPlayList.findByLengthGreaterThan(4.9));
        }

        @Test
        public void wrongEmailShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(ArrayStoreException.class, () -> testPlayList.findByLengthGreaterThan(6));
        Assertions.assertEquals("Empty list! No songs on it!", ex.getMessage());
    }
    @Test
    public  void listToString() {
            testPlayList.listToString();

    }

}
