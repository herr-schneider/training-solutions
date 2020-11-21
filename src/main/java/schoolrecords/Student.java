package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String nameOf;
    private List<Mark> markOfStudent = new ArrayList<>();

    public Student(String nameOf) {
        if (nameOf == null || nameOf.isBlank()) {
            throw new IllegalArgumentException("Student name must not be empty!");
        }
        this.nameOf = nameOf;
        }

    public String getName(){
        return nameOf;
    }

    public List<Mark> getMarkOfStudent(){
        return markOfStudent;
    }

    public void grading(Mark mark) {// érdemjegy rögzítése
        if (mark == null) {
            throw new NullPointerException("Mark must not be null!");
        }
        markOfStudent.add(mark);
    }

    public double calculateAverage() { // teljes átlag számolása
        double avg = 0;
        double div = 0;
        for (Mark mark : markOfStudent){
            avg = avg + mark.getMarkType().getWithNumber();
            div++;
        }
        return Math.round((avg/div)*100.0)/100.0;
    }


    public double calculateSubjectAverage(Subject subject) {// tantárgyhoz tartozó átlag számítása
        double avg = 0;
        double div = 0;
        for (Mark mark : markOfStudent) {
            if (subject.equals(mark.getSubject())) {
                avg = avg + mark.getMarkType().getWithNumber();
                div++;
            }
        }
        if (div == 0.0) {
            return div;
        }
        return avg/div;
    }

    public String toString(){
        return getName() + " marks: " + markOfStudent.get(0).getSubject().getSubjectName() + ": " + markOfStudent.get(0).toString();
    }
}
