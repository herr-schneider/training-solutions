package week06d04;

import java.time.LocalDate;

public class Item {
    private int price;
    private final LocalDate month;
    private final String name;

    public Item(int price, LocalDate month, String name) {
        if (name == null || price<0) {throw new IllegalArgumentException("Wrong input!");}

        this.price = price;
        this.month = month;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getMonth() {
        return month.getMonthValue();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  "price=" + price + "\n" +
                ", month=" + month + "\n" +
                ", name='" + name;
    }
}
