package week14d03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClassNoteBook {
    private List<Student> students = new ArrayList<>();

    public ClassNoteBook(List<Student> students) {
        this.students = students;
    }

    public ClassNoteBook() {
        super();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> sortNotebook() {
        List<Student> sorted = new ArrayList<>(students);
        Collections.sort(sorted, new Comparator<Student>() {  // result.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return sorted;
    }

    public List<Student> sortNotebookComp() { // a studentbe compareTo felül van irva és implements Comparable
        List<Student> sorted = new ArrayList<>(students);
        Collections.sort(sorted);
        return sorted;
    }

    public List<Student> sortNotebookCompModvedett() { // Vedett modositas ellen, mert a studenteket is masoljuk uj studentbe
        List<Student> result = new ArrayList<>();
        for(Student s : this.students){
            result.add(new Student(s));
        }
        Collections.sort(result);
        return result;
    }
}

