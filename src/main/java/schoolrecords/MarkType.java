package schoolrecords;

public enum MarkType {
    A(5, "excellent"),
    B(4, "very good"),
    C(3, "improvement needed"),
    D(2, "Close fail"),
    F(1, "fail");

    private final int withNumber;

    private final String withWords;

    MarkType(int withNumber, String withWords) {
        this.withNumber = withNumber;
        this.withWords = withWords;
    }

    public int getWithNumber() {
        return withNumber;
    }

    public String getWithWords() {
        return withWords;
    }
}
