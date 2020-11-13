package operators.operators;

import operators.Operators;

import java.util.Scanner;

public class OperatorsMain {
    public static void main(String[] args) {
        System.out.println("Please enter a number:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        Operators operators = new Operators(num);
        System.out.println("Is it even:" + operators.isEven());
    }
}
