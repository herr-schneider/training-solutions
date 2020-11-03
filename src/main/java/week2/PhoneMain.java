package week2;

import java.util.Scanner;

public class PhoneMain {
    public static void main(String[] args) {

       System.out.println("Tipus: ");
       Scanner scanner = new Scanner(System.in);
       String type = scanner.nextLine();
       System.out.println("Mem meret: ");
       int mem = scanner.nextInt();
       scanner.nextLine();
       Phone phone = new Phone(type, mem);

       System.out.println("Tipus2: ");
       type = scanner.nextLine();
       System.out.println("Mem meret2: ");
       mem = scanner.nextInt();
       scanner.nextLine();
       Phone phoneother = new Phone(type, mem);

       System.out.println("Telefon tipusa:" + phone.getType() + "Mem merete:" + phone.getMem());
       System.out.println("Telefon tipusa2:" + phoneother.getType() + "Mem merete:" + phoneother.getMem());

    }}
