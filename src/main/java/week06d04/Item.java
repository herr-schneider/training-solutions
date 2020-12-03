package week06d04;

public class Item {
    private int price;
    private final int month;
    private final String name;

    public Item(int price, int month, String name) {
        if (name == null || price<0 || month <1 || month > 12) {throw new IllegalArgumentException("Wrong input!");}

        this.price = price;
        this.month = month;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getMonth() {
        return month;
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
