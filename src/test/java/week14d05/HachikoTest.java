package week14d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HachikoTest {

    @Test
    public void testHachiko() {
        assertEquals("{haza=15, Hachiko=4, jó=15, pályaudvar=5}", new Hachiko().countWords("src/main/java/week14d05/hachiko.srt", "Hachiko", "haza",
                "pályaudvar", "jó").toString());
    }
}
