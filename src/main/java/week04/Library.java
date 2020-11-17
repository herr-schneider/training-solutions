package week04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBooks(Book book) {
        books.add(book);
    }
    public void loadFromAnyFile(String sourceFile) {
        try (Scanner scanner = new Scanner(Library.class.getResourceAsStream(sourceFile))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] names = line.split(";");
                int year = Integer.parseInt(names[3]);
                Book newBook = new Book(names[0], names[1], names[2], year);
                addBooks(newBook);
            }
        }

    }
    public void loadFromFile() {
        loadFromAnyFile("/books.csv");
    }

    public List<Book> getBooks () {
        return this.books;
    }
}