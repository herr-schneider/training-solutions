package schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {
    private String name;
    private List<Subject> taughtSubjects = new ArrayList<>();

    public Tutor(String name, List<Subject> taughtSubjects) {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public String getName() {
        return this.name;
    }

    public boolean tutorTeachingSubject (Subject subject) {
        for (Subject taughtSubject : taughtSubjects) {
            if (taughtSubject.equals(subject)) {
                return false;
            }
        }
        return true;
    }
}