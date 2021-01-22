package week12d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KoronaTest {

    @Test
    void readerTest() {
        assertEquals(11, new Korona().reader());
        }

    @Test
    void lineReaderTest() {
        assertEquals(11, new Korona().lineReader());
    }
    }
