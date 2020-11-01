package classstructureattributes;

import java.util.Scanner;

public class StoreMain {
    public static void main(String[] args) {
        Store store = new Store();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Product name: ");
        String name = scanner.nextLine();
        store.setProduct(name);
    }
}