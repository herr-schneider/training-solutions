package classstructureattributes;

import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book();
        Scanner scanner = new Scanner(System.in);
        String message = "Please enter the Author of Book?";
        System.out.println(message);
        book.author = scanner.nextLine();
        String message2 = "Please enter the Title of Book?";
        System.out.println(message2);
        book.author = scanner.nextLine();
        String message3 = "Registration number:";
        System.out.println(message3);
        String regNumber = scanner.nextLine();
        book.register(regNumber);
        System.out.println("Author: " + book.getAuthor() );
        System.out.println("Title: " + book.getTitle() );
        System.out.println("Registration: " + book.getRegNumber ());
    }
}
