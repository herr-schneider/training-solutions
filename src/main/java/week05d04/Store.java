package week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {
    List<Product> productList = new ArrayList<>();

    private Store(List<Product> productList) {
        this.productList = productList;
    }

    public boolean addProduct(String name, int year, int month, int day) {
        for (Product oldProduct : productList) {
            if (isValid(oldProduct) && oldProduct.isExpired()) {
                return false;
            }
            LocalDate today = LocalDate.now();
        }
        productList.add(new Product(name, year, month, day));
        return true;
    }

    public boolean isValid(Product product){
        for (Product oldProduct : productList) {
            if (oldProduct.getName().equals(product.getName())) {
                return false;
            }
        }
        return true;
    }

    public int getNumberOfExpired() {
        int num = 0;
        for (Product oldProduct : productList) {
            if (oldProduct.isExpired()) {
                num++;
            }
        }
        return num;
    }
}
