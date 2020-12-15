package interfaces.animal;

import java.util.List;

public class Zoo {

    List<Animal> animals;

    public Zoo(List<Animal> animals) {
        this.animals = animals;
    }

    public Zoo(Animal animal) {
        animals.add(animal);
    }

    public int getNumberOfAnimals() {
        return animals.size();
    }

    public int getNumberOfLegs() {
        int legs = 0;
        for (Animal animal : animals) {
            legs += animal.getNumberOfLegs();
        }
        return legs;
    }
}