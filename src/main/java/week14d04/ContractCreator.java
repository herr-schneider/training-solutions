package week14d04;

import java.util.*;
//        Legyen egy szerződés (Contract) osztály, melynek van egy String client és egy List<Integer> monthlyPrices attribútuma.
//        Az előbbi a szerződő neve, a második pedig a havonta fizetendő összeg.
//        Legyen egy ContractCreator osztály, melynek van egy ContractCreator(String client, List<Integer> monthlyPrices)
//        konstruktora, mely létrehoz egy szerződéssablont, a paraméterként
//        megadott adatokkal, melyet összesen EGY attribútumban tárolj!
//        Majd írj egy create(String name) metódust, mely a sablon alapján létrehoz egy
//        új szerződést, de a nevet kicseréli a paraméterként megadott névre.
//        Próbáld ki, hogy a visszaadott szerződésben módosítod a 12. havi értéket. Ha létrehozol
//        egy új szerződést a sablon alapján, akkor a 12 havi érték az eredeti sablon alapján van
//        kitöltve?

public class ContractCreator {
    public Contract template;


    public ContractCreator(String client,  List<Integer>monthlyPrices) {
        this.template = new Contract(client, monthlyPrices);
    }

    public Contract create(String name){
        List<Integer> montlyPrices = new ArrayList<>(template.getMonthlyPrices());
        return new Contract(name, montlyPrices);
    }

    public Contract getTemplate() {
        return template;
    }

    public static void main(String[] args) {
        ContractCreator cc = new ContractCreator("John Doe", List.of(10,10,10,10,10,10,10));
        Contract john = cc.create("John Smith");
        john.getMonthlyPrices().set(1,20);
        System.out.println(cc.getTemplate().toString());
        System.out.println(john.getClient() + john.getMonthlyPrices());
    }
}
