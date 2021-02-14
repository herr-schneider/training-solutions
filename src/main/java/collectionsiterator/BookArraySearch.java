package collectionsiterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class BookArraySearch {
    Book[] bookArray;

    public BookArraySearch(Book[] bookArray){
        this.bookArray = bookArray;
    }

    public Book findBookByAuthorTitle(String author, String title){
       for (Book book : bookArray){
           if (book.getAuthor().equals(author) && book.getTitle().equals(title)){
               return book;
           }
       }
       throw new MissingBookException("");
    }

}