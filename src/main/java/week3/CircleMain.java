package week3;

import java.util.Scanner;

public class CircleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("R=");
        double r = scanner.nextDouble();
        scanner.nextLine();
        Circle c = new Circle(r);
        System.out.println("Perimeter: " + c.Perimeter() + " Area: " + c.Area());
    }
}
