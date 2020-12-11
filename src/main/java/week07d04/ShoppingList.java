package week07d04;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class ShoppingList {
    static long sumOf;

    public long calculateSum(String path) {
        if (path == null || path.isBlank() || path.isEmpty()) {
            throw new IllegalArgumentException("Try with a path!");
        }
        int result = 0;
        try ( Scanner s = new Scanner(Path.of(path));){
            s.useDelimiter(";");
            while (s.hasNext()) {
                String str = s.next();
                int pieces = Integer.parseInt(s.next());
                int price = Integer.parseInt(s.next());
                result += pieces * price;
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("Wrong path!");
        }
        return result;
    }
}

