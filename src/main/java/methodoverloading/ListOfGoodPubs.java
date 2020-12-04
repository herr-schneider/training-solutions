package methodoverloading;

import java.util.ArrayList;
import java.util.List;

public class ListOfGoodPubs {
    List<Pub> goodPubs;

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs.size()<1) {throw new IllegalArgumentException("Pub list is empty!");}
        this.goodPubs = goodPubs;
    }

    public Pub findTheBest() {
        Pub result = new Pub("Error", 24, 00);
        for (Pub pub : goodPubs) {
            if (pub.getHours() < result.getHours()) {
                result = pub;
            }
        }
        return result;
    }
}
