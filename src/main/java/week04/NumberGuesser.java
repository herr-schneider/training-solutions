package week04;

import java.util.Random;
import java.util.Scanner;

public class NumberGuesser {
    public static void main(String[] args) {
        int randomNum = new Random().nextInt(100)+1;
        System.out.println(randomNum);
        boolean ok = false;
        int num, triing = 0;
        Scanner scanner = new Scanner(System.in);
        while (!ok && triing < 4 ) {
            triing ++;
            System.out.println(triing + ". próbálkozás. Szám:");
            num = scanner.nextInt();
            scanner.nextLine();
            if (num == randomNum) {
                System.out.println("Király vagy");
                ok = true;
            } else {
                System.out.println("Nem nyert");
                if (num > randomNum) {
                    System.out.println("Kisebbet");
                } else {
                    System.out.println("Nagyobbat");
                }

            }
        }
    }
}
