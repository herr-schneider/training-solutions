package activitytracker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationTest {

    @Test
    public void isEmailValid() {
        Registration reg = new Registration();
        assertTrue(reg.isEmailValid("szf@gmail.com"));
        assertFalse(reg.isEmailValid("szf.gmail.com"));
        assertFalse(reg.isEmailValid("szf.gmail"));
        assertFalse(reg.isEmailValid("szf@gmail"));
    }

        @Test
        public void writingLog() {
            new Registration().writeLog("Hello2");
    }
}