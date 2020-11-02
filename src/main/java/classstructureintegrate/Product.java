package classstructureintegrate;

public class Product {
    private String name;
    private int price;

    public void Product (String product, int price) {

        this.name = product;
        this.price = price;
    }

    public String getName() {

        return name;
    }

    public int getPrice() {

        return price;
    }


    public void increasePrice (int change) {
        this.price = price + change;
    }

    public void decreasePrice (int change) {
        this.price = price - change;
    }

}

