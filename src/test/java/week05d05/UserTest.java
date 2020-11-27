package week05d05;

import immutable.satellite.CelestialCoordinates;
import immutable.satellite.Satellite;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    public void emptyNameShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new User("", "Feri", "email@mail.hu"));
        assertEquals("Empty name!", ex.getMessage());
    }

    @Test
    public void wrongEmailShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new User("Szabo", "Feri", "@."));
        assertEquals("Invalid Email!", ex.getMessage());
    }

    @Test
    public void goodNameAndEmail() {
        assertEquals("Szabó Ferenc", new User("Szabó", "Ferenc", "szabofer@yahoo.com").getFullName());
    }
    @Test
    public void aBitWrongEmailShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new User("Szabo", "Feri", "y@."));
        assertEquals("Invalid Email!", ex.getMessage());
    }
}
