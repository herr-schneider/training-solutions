package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Product product1 = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Product name: ");
        String name = scanner.nextLine();
        System.out.println("Price:");
        int price = scanner.nextInt();
        scanner.nextLine();
        product1.Product(name, price);
        System.out.println("Name: " + product1.getName() + "Price: " + product1.getPrice());
        System.out.println("Increase: ");
        int change = scanner.nextInt();
        scanner.nextLine();
        product1.increasePrice(change);
        System.out.println("Name: " + product1.getName() + "Price: " + product1.getPrice());
        System.out.println("Decrease: ");
        change = scanner.nextInt();
        scanner.nextLine();
        product1.decreasePrice(change);
        System.out.println("Name: " + product1.getName() + "Price: " + product1.getPrice());
    }}
