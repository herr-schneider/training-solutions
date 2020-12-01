package week06d02;

import java.util.List;

public class Store {
    List<Product> productList;

    public Store(List<Product> productList) {
        this.productList = productList;
    }

    public int getProductByCategoryName(Category category){
        int num = 0;
        for (Product product : productList) {
            if (product.getCategory() == category){
                num++;
            }
        }
        return num;
    }
}
