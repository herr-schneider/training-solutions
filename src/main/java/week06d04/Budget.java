package week06d04;

import java.util.ArrayList;
import java.util.List;

public class Budget {
    List<Item> list = new ArrayList<>();

    public Budget(List<Item> list) {
        this.list = list;
    }

    public Budget(Item... items) {
        for (Item item : items) {
            list.add(item);
        }
    }

    public Budget(String name, int month, int price) { // It could be: addItem
        list.add(new Item(price, month, name));
    }

    public List<Item> getItemsByMonth(int month) {
        List<Item> found = new ArrayList<>();
        for (Item item : list) {
            if (item.getMonth() == month) {
                found.add(item);
            }
        }
        return new ArrayList<>(found);
    }

}
