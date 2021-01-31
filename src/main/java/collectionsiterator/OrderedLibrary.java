package collectionsiterator;

import java.text.Collator;
import java.util.*;

public class OrderedLibrary {
    private List<Book> libraryBooks;

    public OrderedLibrary(List<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public List<Book> orderedByTitle() {
        List<Book> orderBooks = new ArrayList<>(libraryBooks);
        Collections.sort(orderBooks, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });
        return orderBooks;
    }

    public List<Book> orderedByAuthor() {
        List<Book> orderBooks = new ArrayList<>(libraryBooks);
        Collections.sort(orderBooks, new AuthorComparator());
        return orderBooks;
    }

    public List<String> orderedByTitleLocale(Locale locale){
        List<String> orderedList = new ArrayList<>();
        for (Book book : libraryBooks) {
            orderedList.add(book.getTitle());
        }
//        Collator hungarianCollator = Collator.getInstance(locale);
//        hungarianCollator.setStrength(Collator.PRIMARY);
//        Collections.sort(orderedList, hungarianCollator);
        Collections.sort(orderedList, Collator.getInstance(locale));
        return orderedList;
    }
}
