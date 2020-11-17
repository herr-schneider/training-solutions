package week04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameChangerTest {
    @Test
    public void crateNameChangerTest() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new NameChanger(""));
    assertEquals("Invalid name:", iae.getMessage());}


}
