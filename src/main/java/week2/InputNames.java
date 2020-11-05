package week2;

import java.util.Scanner;

public class InputNames {


    public static void main(String[] args) {
        String[] names = new String[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.println("Name" + i + ": ");
            String name = scanner.nextLine();
            names[i] = name;
        }
        int j;
        for (int i = 0; i < 4; i++) {
            j = i + 1;
            System.out.println(j + ".Name" + i + ": ");
            System.out.println(names[i]);
        }
    }
}