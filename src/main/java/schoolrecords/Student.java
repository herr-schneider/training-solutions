package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String nameOf;
    private List<Integer> markofStudent = new ArrayList<>();

    public void grading(Mark mark) // érdemjegy rögzítése
    public double calculateAverage() // teljes átlag számolása
    public double calculateSubjectAverage(Subject subject) // tantárgyhoz tartozó átlag számítása
    public String toString(){
        return null;
    }
}
