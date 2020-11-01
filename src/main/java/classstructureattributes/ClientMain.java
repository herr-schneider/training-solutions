package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        String message = "What's your name?";
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        client.name = scanner.nextLine();
        String message2 = "When did you birth?";
        System.out.println(message2);
        client.yearOfBirth = scanner.nextInt();
        scanner.nextLine();
        String message3 = "Where are you live?";
        System.out.println(message3);
        client.address = scanner.nextLine();
        String message4 = "Year of your birth, once more?";
        System.out.println(message4);
        System.out.println("Name: " + client.getName() );
        System.out.println("Modify tha name:");
        String name2 = scanner.nextLine();
        client.changeName(name2);
        System.out.println("Name: " + client.getName() );
        System.out.println("Year: " + client.getYear() );
        System.out.println("Age: " + client.getAge (2020));
        System.out.println("Address: " + client.getAddress() );
    }
}
