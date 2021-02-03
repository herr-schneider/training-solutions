package week14d03;

import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertEquals("Ramón", ramon.getName());
        assertEquals("[Student{name='Ramón', marks={Földrajz=[3, 3], Tarifa=[1, 1]}}, Student{name='Ramón', marks={Földrajz=[3, 3, 5], Tarifa=[1, 1]}}]", classNoteBook.sortNotebook().toString());
    }

    @Test
    public void addNoteTest(){
     Student s = new Student("Johnny");
     s.giveAMark("math", 5);
     s.giveAMark("bio", 3);
     assertEquals(3, s.getMarks().get("bio").get(0));
        assertEquals(2, s.getMarks().size());
    }

    @Test
    public void testNotebook(){

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
        List<Student> result = classNoteBook.sortNotebookComp();
        assertEquals(2, result.size());
        //assertEquals("Feri", result.get(0).getName());
        result.get(0).giveAMark("math",5);
    }

}