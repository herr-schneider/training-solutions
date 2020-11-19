package schoolrecords;

import java.util.List;
import java.util.Random;

public class ClassRecords {
    String nameOfClass;
    Random random;
    List<Student> studentsOfClass;

    public ClassRecords(String nameOfClass, Random random) {
        this.nameOfClass = nameOfClass;
        this.random = random;
    }

    private boolean isEmpty(String str) {
        if (str == null || str.isBlank() || str.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean addStudent(Student student) // felvesz egy diákot az osztályba
    {
        if (student == null) {
            throw new IllegalArgumentException("Empty string!");
        }

        for (Student studentAlready : studentsOfClass) {
            if (studentAlready == student) {
                return true;
            }
            studentsOfClass.add(student);
            return false;
        }
    }


    public boolean removeStudent(Student remStudent) {
        if (remStudent == null) {
                throw new IllegalArgumentException("Empty string!");
            }

            for (Student studentAlready : studentsOfClass) {
                if (studentAlready != remStudent) {
                    return true;
                }
            }
            studentsOfClass.remove(studentsOfClass.indexOf(remStudent));
            return false;
        }

    public double calculateClassAverage() //osztályátlagot számol, minden diákot figyelembe véve

    public double calculateClassAverageBySubject(Subject subject) //tantárgy szerinti osztályátlagot számol,
    // kihagyja azon diákokat, akiknek az adott tantárgyból nincs jegye
    public Student findStudentByName(String name) // név szerint megkeres egy diákot az osztályban
    public Student repetition() //felelethez a listából random módon kiválaszt egy diákot
    public List<StudyResultByName> listStudyResults() //a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi,
    // és azok listáját adja vissza
    public String listStudentNames() //kilistázza a diákok neveit, vesszővel elválasztva
}
