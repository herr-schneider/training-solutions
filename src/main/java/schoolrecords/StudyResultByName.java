package schoolrecords;

public class StudyResultByName {
 private String nameOf;
 private double averageOfMarks;

    public StudyResultByName(String nameOf, double averageOfMarks) {
        this.nameOf = nameOf;
        this.averageOfMarks = averageOfMarks;
    }

    public String getNameOf() {
        return nameOf;
    }

    public double getAverageOfMarks() {
        return averageOfMarks;
    }
}
