package week09d03;

import java.util.Objects;
import java.util.Random;

public class Person {
    private String name;
    private int age;
    private Present present;
    private Random testRandom;

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
    public void setPresentArray() {
        int ran;
        if (age <= 12){ran = testRandom.nextInt(2)+1;}
        else {ran = testRandom.nextInt(3);}
        present = Present.values()[ran];
    }

    public Present getPresent() {
        return present;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return present == person.present;
    }

    @Override
    public int hashCode() {
        return Objects.hash(present);
    }

    @Override
    public String toString() {
        return "" + present;
    }
}
