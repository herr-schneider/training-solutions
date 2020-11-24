package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {
    String nameOfClass;
    Random random;
    List<Student> studentsOfClass = new ArrayList<>();

    public ClassRecords(String nameOfClass, Random random) {
        this.nameOfClass = nameOfClass;
        this.random = random;
    }

    public String getClassName() {
        return  nameOfClass;
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
            if (studentAlready.getName().equals(student.getName())) {
                return false;
            }
        }
        studentsOfClass.add(student);
        return true;
    }


    public boolean removeStudent(Student remStudent) {
        if (remStudent == null) {
                throw new IllegalArgumentException("Empty string!");
            }
            for (Student studentAlready : studentsOfClass) {
                if (studentAlready.getName().equals(remStudent.getName())) {
                    studentsOfClass.remove(remStudent);
                    return true;
                }
            }
                return false;
        }

    public double calculateClassAverage(){ //osztályátlagot számol, minden diákot figyelembe véve
        if (studentsOfClass.size() < 1) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");}

        double avg = 0.0;
        double div = 0.0;
        for (Student student : studentsOfClass) {
            avg += student.calculateAverage();
            div++;
        }
        if (avg == 0) throw new ArithmeticException("No marks present, average calculation aborted!");
        return Math.round((avg/div)*100.0)/100.0;
    }

    public double calculateClassAverageBySubjectReal(Subject subject) {//tantárgy szerinti osztályátlagot számol,
        // kihagyja azon diákokat, akiknek az adott tantárgyból nincs jegye
        double avg = 0.0;
        double div = 0.0;
        for (Student student : studentsOfClass) {
            for (Mark mark : student.getMarkOfStudent()) {
                if (mark.getSubject().getSubjectName().equals(subject.getSubjectName())) {
                    avg = avg + mark.getMarkType().getWithNumber();
                    div++;
                }
            }
        }
        if (div == 0.0) {return 0.0;}
        return Math.round((avg/div)*100.0)/100.0;
    }

    public double calculateClassAverageBySubject(Subject subject) {//tantárgy szerinti osztályátlagot számol,
        // kihagyja azon diákokat, akiknek az adott tantárgyból nincs jegye
        double avg = 0.0;
        double div = 0.0;
        for (Student student : studentsOfClass) {
            avg = avg + student.calculateSubjectAverage(subject);
            if (student.calculateSubjectAverage(subject) != 0) {
                    div++;
                }
            }

        return Math.round((avg/div)*100.0)/100.0;
    }

    public Student findStudentByName(String name) {// név szerint megkeres egy diákot az osztályban
       if (name.isEmpty()) {throw new IllegalArgumentException("Student name must not be empty!");}
       if (studentsOfClass.size() < 1) {throw new IllegalStateException("No students to search!");}

       for (Student student : studentsOfClass) {
       if (student.getName().equals(name)){
           return student;
       }
       }
       /*Student notFound = new Student("Not found");
       return notFound;*/
        throw new IllegalArgumentException("Student by this name cannot be found! "+ name);

    }

    public Student repetition() {//felelethez a listából random módon kiválaszt egy diákot
        if (studentsOfClass.size()<1) {throw new IllegalStateException("No students to select for repetition!");}
        return studentsOfClass.get(random.nextInt(studentsOfClass.size()));
    }

    public List<StudyResultByName> listStudyResults() { //a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi,
        // és azok listáját adja vissza
        List<StudyResultByName> studyResultByNames = new ArrayList<>();

        /*int index = 0;
        for (Student student : studentsOfClass) {
            studyResultByNames.get(index).setNameOf(student.getName());
            studyResultByNames.get(index).setAverageOfMarks(student.calculateAverage());
            index++;
            } */

        for (int index = 0; index < studentsOfClass.size()-1; index++) {
            StudyResultByName srbn = new StudyResultByName(studentsOfClass.get(index).getName(), studentsOfClass.get(index).calculateAverage());
            studyResultByNames.add(srbn);
           }
        return  studyResultByNames;
    }


    public String listStudentNames(){//kilistázza a diákok neveit, vesszővel elválasztva
        String studentName ="";

        for (Student student : studentsOfClass) {
            studentName = studentName.concat(student.getName() + ", ");
        }
        studentName = studentName.trim();
        studentName = studentName.substring(0, studentName.length()-1);
        return studentName;
    }
}
