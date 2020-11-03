package week2;

import localvariables.Distance;

import java.util.Scanner;

public class PhoneMain {
    public static void main(String[] args) {

        System.out.println("Tipus: ");
        Scanner scanner = new Scanner(System.in);
       String type = scanner.nextLine();
        System.out.println("Mem meret: ");
       int mem = scanner.nextInt();
       Phone phone = new Phone(type, mem);

        System.out.println("Tipus2: ");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        System.out.println("Mem meret2: ");
        int mem = scanner.nextInt();
        Phone phoneother = new Phone(type, mem);
    }}
