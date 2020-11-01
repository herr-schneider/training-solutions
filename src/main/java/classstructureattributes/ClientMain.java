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
        System.out.println("Name: " + client.name);
        System.out.println("Year: " + client.yearOfBirth);
        System.out.println("Address: " + client.address);
    }
}
