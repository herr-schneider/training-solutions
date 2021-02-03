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
        Collections.sort(sorted, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return sorted;
    }
}
