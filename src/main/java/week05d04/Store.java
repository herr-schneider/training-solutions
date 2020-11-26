package week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Product> productList = new ArrayList<>();

    public boolean addProduct(String name, int year, int month, int day) {
        for (Product oldProduct : productList) {
            if (!isThere(oldProduct) && !oldProduct.isExpired()) {
                return false;
            }
        }
        productList.add(new Product(name, year, month, day));
        return true;
    }

    public boolean isThere(Product product){
        for (Product oldProduct : productList) {
            if (oldProduct.getName().equals(product.getName())) {
                return true;
            }
        }
        return false;
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

    public List<Product> getProductList (){ // only for test purpose
        return productList;
    }
}
