package week2;

import java.util.Arrays;
import java.util.List;

public class Controller {

    public void readOffice() {}

    public void printMenu() {
        String[] menuPoints = {"1. Meeting room in order.", "2. Meeting room in reverse order.", "3. Every event meeting rooms", "4. Areas", "5. Search", "6. Particularly search. ", "Area search."};
        List<String> menu = Arrays.asList(menuPoints);
        for (String points : menu) {
            System.out.println(points);
        }
    }

    public void runMenu() {}

    public static void main(String[] args) {
        Office office = new Office();
        readOffice();


    }
}

