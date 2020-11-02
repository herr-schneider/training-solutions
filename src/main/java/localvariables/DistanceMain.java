package localvariables;

import classstructureintegrate.Product;

import java.util.Scanner;

public class DistanceMain {
    public static void main(String[] args) {
        String d = "Distance: ";
        String e = "Is it exact: ";
        System.out.println(d);
        Distance distance = new Distance();
        Scanner scanner = new Scanner(System.in);
        int dis = scanner.nextInt();
        scanner.nextLine();
        System.out.println(e);
        boolean exact = scanner.nextBoolean();
        distance.Distance(dis,exact);
        System.out.println(d + distance.getDistanceInKm() + e + distance.isExact());
    }
}
