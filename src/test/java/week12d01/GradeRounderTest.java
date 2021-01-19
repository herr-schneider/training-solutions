package week12d01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GradeRounderTest {

    @Test
    public void roundGrades() {
        GradeRounder gr = new GradeRounder();


        assertEquals("[10, 20, 30, 50, 65, 70]", gr.toString((gr.roundGrades(new int[]{10, 20, 30, 50, 63, 72}))));
    }
}