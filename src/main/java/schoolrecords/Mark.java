package schoolrecords;

public class Mark {

    Subject subject;
    Tutor tutor;
    MarkType mark;

    public Mark(MarkType mark, Subject subject, Tutor tutor) {
        if (mark == null || subject == null || tutor == null) {
            throw new NullPointerException("Both subject and tutor must be provided!");
        }
        this.subject = subject;
        this.tutor = tutor;
        this.mark = mark;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return this.tutor;
    }

    public MarkType getMarkType() {
        return this.mark;
    }

    @Override //"excellent(5)"
    public String toString() {
        return mark.toString();
    }
}
