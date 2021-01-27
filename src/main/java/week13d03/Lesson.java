package week13d03;

public class Lesson {

    private String teacher;
    private String subject;
    private String nameOfClass;
    private int lessonPerWeek;

    public Lesson(String teacher, String subject, String nameOfClass, int lessonPerWeek) {
        this.teacher = teacher;
        this.subject = subject;
        this.nameOfClass = nameOfClass;
        this.lessonPerWeek = lessonPerWeek;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getSubject() {
        return subject;
    }

    public String getNameOfClass() {
        return nameOfClass;
    }

    public int getLessonPerWeek() {
        return lessonPerWeek;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "teacher='" + teacher + '\'' +
                ", subject='" + subject + '\'' +
                ", nameOfClass='" + nameOfClass + '\'' +
                ", lessonPerWeek=" + lessonPerWeek +
                '}';
    }
}
