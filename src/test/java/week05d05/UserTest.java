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
    public void goodNameAndEmail() { //Given When Then

        User u = new User("Szabó", "Ferenc", "szabofer@yahoo.com");
        assertEquals(new StringBuilder("Szabó Ferenc").toString(), u.getFullName().toString());
        assertEquals( true, u.doesEmailContain("szabofer@yahoo.com"));
    }

    @Test
    public void aBitWrongEmailShouldThrowException() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new User("Szabo", "Feri", "y@."));
        assertEquals("Invalid Email!", ex.getMessage());
    }
}
