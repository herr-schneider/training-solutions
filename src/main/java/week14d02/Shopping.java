package week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Shopping {
//    Adott egy fájl melyben online bevásárlások találhatók. A fájl a még ki nem szállított rendeléseket tartalmazza. Egy sorban egy egyedi azonosító és utána a termékek neve van felsorololva. Minden vásárlás legalább 2 termékből áll.
//            ```
//    A233 bread,tomato,flour,sugar
//    A312 sugar,beer,apple,pear
//    B3402 meet,soda,cola,bbq_sauce
//    B341 pasta,passata,basil,cheese
//    A10 corn,hot_dog,rolls
//    CM231 beer,chips
//    C123 pepper,salt,rosmary,pizza_dough,passata,oregano
//    W34111 pasta,sugar,rosmary,cheese,meet,carrot,potato,tomato
//    K8921 wine,soda
//
//
//    Olvasd be a fájlt és tárold el az adatokat a memóriában, majd oldd meg a következő feladatokat.
//            1. Egyedi azonosító alapján legyenek lekérdezhetőek a vásárolt termékek ABC sorrendben.
//            2. Számoljuk össze, egy termék neve alapján, hogy abból a termékből mennyit adtak el.
//            3. Adjuk vissza egy vásárlási azonosító alapján, hogy hány termék szerepel a vásárlásban.
//            4. Készíts statisztikát melyben visszaadod, hogy az egyes termékek hányszor szerepelnek a fájlban.

    Map<String, List<String>> result = new HashMap<>();

    public void readFromFile(Path file) {
        String line;
        try (BufferedReader bf = new BufferedReader(Files.newBufferedReader(file))) {
            while ((line = bf.readLine()) != null) {
                String[] words = line.split(" ");
                String key = words[0];
                String[] value = words[1].split(",");
                List<String> products = new ArrayList<>();
                for (String str : value) {
                    products.add(str);
                }
                Collections.sort(products);
                index(key, products);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new IllegalStateException("File not found");
        }
    }

    public int iterateUsingEntrySet(String pr) {
        int numberOfProduct = 0;
        for (Map.Entry<String, List<String>> entry : result.entrySet()) {
            for (String product : entry.getValue()){
                if (pr.equals(product)){
                    numberOfProduct++;
                }
            }
        }
        return numberOfProduct;
    }

   public List<ProdStat> fourth(){
        List<ProdStat> list = new ArrayList<>();
        for (result.entrySet().)
        return list;
   }

    public Map<String, List<String>> index(String key, List<String> names) {
        for (String str : names) {
            if (!result.containsKey(key)) {
                result.put(key, new ArrayList<>());
            }
            result.get(key).add(str);
        }
        return result;
    }

    public int numberOfProduct(String key) {
        for (Map.Entry<String, List<String>> entry : result.entrySet()) {
            if (entry.getKey().equals(key)) {
                return entry.getValue().size();
            }
        }
        throw new IllegalArgumentException("Ez most nem jött össze!");
    }
}