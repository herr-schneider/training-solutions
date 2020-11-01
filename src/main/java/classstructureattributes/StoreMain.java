package classstructureattributes;

import java.util.Scanner;

public class StoreMain {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Product name: ");
        String name = scanner.nextLine();
        store.setProduct(name);
        System.out.println("Book title: " + store.getProduct() + "  Store: " + store.getStock());
        System.out.println("Plus: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Storage:" + store.store(num));
        System.out.println("Minus: ");
        num = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Storage:" + store.dispatch(num));
    }
}