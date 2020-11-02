package classstructureintegrate;

import localvariables.Distance;

import java.util.Scanner;

public class BankAccountMain {
    public static void main(String[] args) {

        BankAccount source = new BankAccount("1234", "Szabo", 1000);
        BankAccount target = new BankAccount("1256", "Dara", 800);
        String q = "Ammount to transfer: ";
        String s = " ";
        System.out.println(q);
        Scanner scanner = new Scanner(System.in);
        int ammount = scanner.nextInt();
        scanner.nextLine();
        source.transit(target, ammount);
        System.out.println(source.getAccountName() + s + s + source.getOwner() + s + source.getBalance());
        System.out.println(target.getAccountName() + s + s + target.getOwner() + s + target.getBalance());
    }
}
