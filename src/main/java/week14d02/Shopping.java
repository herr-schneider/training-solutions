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

//
        private Map<String, TreeSet<String>> ordersMap = new HashMap<>();

        public void readFiles(String file) {
             try (BufferedReader reader = new BufferedReader(Files.newBufferedReader(Path.of(file)))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    String[] splitLine = line.split(" ");
                    TreeSet<String> products = new TreeSet<>();
                    Collections.addAll(products, splitLine[1].split(","));
                    ordersMap.put(splitLine[0], products);
                }
            } catch (IOException ioe) {
                throw new IllegalStateException("Can not read file!", ioe);
            }
        }

        public TreeSet<String> getProductsOrdersById(String id) {
            return ordersMap.get(id);
        }

        public Map<String, Integer> getProductsMap() {
            Map<String, Integer> productsMap = new HashMap<>();
            for (TreeSet<String> set : ordersMap.values()) {
                for (String item : set) {
                    if (!productsMap.containsKey(item)) {
                        productsMap.put(item, 1);
                    } else {
                        productsMap.put(item, productsMap.get(item) + 1);
                    }
                }
            }
            return productsMap;
        }

        public int getNumberOfOrderedProducts(String product) {
            return getProductsMap().get(product);
        }

        public int getNumberByOderedId(String id) {
            return getProductsOrdersById(id).size();
        }

        public static void main(String[] args) {
            Shopping orders = new Shopping();
            orders.readFiles("src/main/java/week14d02/shoppingtour.txt");
            System.out.println(orders.ordersMap);
            System.out.println(orders.getProductsOrdersById("A10")); //1.
            System.out.println(orders.getNumberOfOrderedProducts("beer")); //2.
            System.out.println(orders.getNumberByOderedId("A10")); //3.
            System.out.println(orders.getProductsMap()); //4.
        }
    }