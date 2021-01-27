package week13d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {


    @Test
    void readFromFileTest() {
        Assignment ass = new Assignment();
        ass.readFromFile();
        System.out.println(ass.getLessons().size());
        assertEquals("Lesson{teacher='Szarvas Szamanta', subject='informatika', nameOfClass='12.x', lessonPerWeek=2}", ass.getLessons().get(328).toString());
        assertEquals("Lesson{teacher='Albatrosz Aladin', subject='kemia', nameOfClass='9.a', lessonPerWeek=2}", ass.getLessons().get(1).toString());
    }

    @Test
    void lessonsPerTeacherTest() {
        Assignment ass = new Assignment();
        ass.readFromFile();
        assertEquals(18, ass.lessonsPerTeacher("Pulyka Pozsinka"));
        assertEquals(23, ass.lessonsPerTeacher("Poloska Polli"));
    }
}