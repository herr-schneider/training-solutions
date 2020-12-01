package week06d02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Store {
    List<Product> productList;

    public Store(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return new ArrayList<>(productList); // store.getProductList().add(new Product("csavarhuzo", Category.HOUSE, 400) nem fog müködni
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

    public List<CategoryCounter> getProductAllCategoryName(){
        int num = 0;
        List<CategoryCounter> categoryCounters = new ArrayList<>();
        List<Category> categories = Arrays.asList(Category.values());
        for (Category cat : categories) {
            for (Product product : productList) {
                if (product.getCategory() == cat){
                    num++;
                }
            }
            categoryCounters.add(new CategoryCounter(cat, num));
        }
        return categoryCounters;
    }
}
