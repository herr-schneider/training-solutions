package collectionsiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LibraryManager {
    Set<Book> libraryBooks = new HashSet<>();

    public LibraryManager(Set<Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findBookByRegNumber(int regNumber) {
        for (Iterator<Book> i = libraryBooks.iterator(); i.hasNext(); ) {
            Book value = i.next();
            if (value.getRegNumber() == regNumber) {
                return value;
            }
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public int removeBookByRegNumber(int regNumber) {
        boolean result = false;
        for (Iterator<Book> i = libraryBooks.iterator(); i.hasNext(); ) {
            Book value = i.next();
            if (value.getRegNumber() == regNumber) {
                i.remove();
                result = true;
            }
        }
        if (result) {
            return regNumber;
        }
        throw new MissingBookException("No books found with regnumber: " + regNumber);
    }

    public Set<Book> selectBooksByAuthor(String author) {
        Set<Book> resultBooks = new HashSet<>();
        for (Iterator<Book> i = libraryBooks.iterator(); i.hasNext(); ) {
            Book value = i.next();
            if (value.getAuthor().equals(author)) {
                resultBooks.add(value);
            }
        }
        if (resultBooks.size() > 0) {
            return resultBooks;
        }
        throw new MissingBookException("No books found by " + author);
    }

    public int libraryBooksCount(){
        int result = libraryBooks.size();
        return result;
    }
}
