package classstructureattributes;

public class Book {

    String author;
    String title;
    String regNumber;

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void register (String regNumber) {
        this.regNumber = regNumber;
    }

}
