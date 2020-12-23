package week09d03;

import java.util.Random;

public class Person {
    String name;
    int age;
    Present present;
    Random testRandom;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.testRandom = new Random();
    }
    public Person(String name, int age, Random testRandom) {
        this.name = name;
        this.age = age;
        this.testRandom = testRandom;
    }
    public void setPresent() {
        int choice;
        if (this.age <= 12) {choice = 2;}
        else {choice = 3;}
        switch (testRandom.nextInt(choice)){
            case 0:
            {present = Present.DECORATION;
                break;}
            case 1:
            {present = Present.ELECTRONIC;
                break;}
            case 2:
            {present = Present.HOUSEKEEPING;
                break;}
            case 3:
            {present = Present.TOY;
                break;}
            default:{throw new ArrayStoreException("");}
        }
    }

    public Present getPresent() {
        return present;
    }
}
