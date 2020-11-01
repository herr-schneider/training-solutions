import java.util.Scanner;

public class Training {
    public static void main(String[] args) {
        String message = "What's your name?";
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("hello " + name);
        System.out.println("when did you birth?");
        int yearofBirth = scanner.nextInt();
        int age = 2019 - yearofBirth;
        System.out.println("Age:" + age);
    }
}
