package collectionsiterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionManager {
    List<Book> bookCollecion = new ArrayList<>();

    public CollectionManager(List<Book> library){
        this.bookCollecion = library;
    }

    public List<Book> createUnmodifiableLibrary() { //módosíthatatlan listát eredményez
        return Collections.unmodifiableList(bookCollecion);
    }
    public List<Book> reverseLibrary() {//az eredeti lista másolatán dolgozik!
        List<Book> reverseLibrary = new ArrayList<>(bookCollecion);
        Collections.sort(reverseLibrary, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getRegNumber()-o2.getRegNumber();
            }
        });
        return reverseLibrary;
    }

    public Book getFirstBook() //a legrégebbi (legkisebb id) könyvet adja vissza
    {
        List<Book> ordinaryLibrary = new ArrayList<>(bookCollecion);
//        Collections.sort(ordinaryLibrary, new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o2.getRegNumber()-o1.getRegNumber();
//            }
//        });
//        return ordinaryLibrary.get(0);
        return Collections.max(ordinaryLibrary, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o2.getRegNumber()-o1.getRegNumber();
            }
        });

    }

    public Book getLastBook() {
        List<Book> reverseLibrary = new ArrayList<>(bookCollecion);
        Collections.sort(reverseLibrary, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getRegNumber()-o2.getRegNumber();
            }
        });
        return reverseLibrary.get(0);

//        return Collections.min(reverseLibrary, new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return o2.getRegNumber()-o1.getRegNumber();
            }
    }