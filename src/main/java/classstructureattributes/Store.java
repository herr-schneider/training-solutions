package classstructureattributes;

public class Store {

    private String product;
    private int stock;

    public void setProduct (String product) {
        this.product = product;
        }

    public String getProduct() {
        return product;
    }
    public int getStock() {
        return stock;
    }
    public int store (int quantity) {
        this.stock = stock + quantity;
        return stock;
    }

    public int dispatch (int quantity) {
        this.stock = stock - quantity;
        return stock;
    }
}

