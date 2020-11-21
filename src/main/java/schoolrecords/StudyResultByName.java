package schoolrecords;

public class StudyResultByName {
 private String studentName;
 private double averageOfMarks;

    public StudyResultByName(String studentName, double averageOfMarks) {
        this.studentName = studentName;
        this.averageOfMarks = averageOfMarks;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getStudyAverage() {
        return averageOfMarks;
    }

    public void setNameOf(String nameOf) {
        this.studentName = nameOf;
    }

    public void setAverageOfMarks(double averageOfMarks) {
        this.averageOfMarks = averageOfMarks;
    }
}
