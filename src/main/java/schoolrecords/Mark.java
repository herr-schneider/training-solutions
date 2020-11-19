package schoolrecords;

public class Mark {

    Subject subject;
    Tutor tudor;
    MarkType mark;

    public Mark(Subject subject, Tutor tudor, MarkType mark) {
        this.subject = subject;
        this.tudor = tudor;
        this.mark = mark;
    }

    public Mark(Subject subject, Tutor tudor, String mark) {
        this.subject = subject;
        this.tudor = tudor;
        this.mark = mark;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTudor() {
        return tudor;
    }

    public MarkType getMark() {
        return mark;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "subject=" + subject +
                ", tudor=" + tudor +
                ", mark=" + mark +
                '}';
    }
}
