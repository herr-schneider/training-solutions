package catalog;

import java.util.List;

public class PrintedFeatures implements Feature{
    private List<String> authors;
    private int numberOfPages;
    private String title;
    static int allPageNumber=0;

    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if (Validators.isEmpty(authors)){throw new IllegalArgumentException("Empty authors");}
        else{this.authors = authors;}
        if (Validators.isBlank(title)){throw new IllegalArgumentException("Empty title");}
        else {this.title = title;}
        if (numberOfPages < 1){throw new IllegalArgumentException("Invalid Number Of Pages");}
        else {
        this.numberOfPages = numberOfPages;
        allPageNumber += numberOfPages;}

    }

    @Override
    public List<String> getContributors() {
        return this.authors;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
