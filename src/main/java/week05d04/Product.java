package week05d04;

import java.time.LocalDate;

public class Product {
    String name;
    LocalDate bestBefore;

    public Product(String name, int year, int month, int day) {
        if (name == null || name.isEmpty() || name.isBlank()){throw new IllegalArgumentException("Empty name!");}
        this.name = name;
        bestBefore = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    public boolean isExpired(){
        return bestBefore.isBefore(LocalDate.now());
    }
}
