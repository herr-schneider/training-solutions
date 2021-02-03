package week14d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassNoteBookTest {

    @Test
    public void testClass() {
        Student ramon = new Student("Ramón");
        ramon.giveAMark("Földrajz", 3);
        ramon.giveAMark("Tarifa", 1);
        Student feri = new Student("Ramón");
        feri.giveAMark("Földrajz", 3);
        feri.giveAMark("Földrajz", 5);
        feri.giveAMark("Tarifa", 1);
        ClassNoteBook classNoteBook = new ClassNoteBook();
        classNoteBook.addStudent(ramon);
        classNoteBook.addStudent(feri);

        assertEquals(2, classNoteBook.sortNotebook().size());
        System.out.println(classNoteBook.sortNotebook());
        assertEquals("[Student{name='Ramón', marks={Földrajz=[3, 3], Tarifa=[1, 1]}}, Student{name='Ramón', marks={Földrajz=[3, 3, 5], Tarifa=[1, 1]}}]", classNoteBook.sortNotebook().toString());
    }

}