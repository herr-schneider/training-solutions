package week06d02;

public class CategoryCounter {
    Category category;
    int counter;

    public CategoryCounter(Category category, int counter) {
        this.category = category;
        this.counter = counter;
    }

    public CategoryCounter(){}

    public Category getCategory() {
        return category;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return  "category:" + category + ", counter=" + counter;
    }
}
