package animals.pets;

import animals.Animal;
import data.AnimalTypeData;
import data.ColorData;

public class Dog extends Animal {

    public Dog(String name, int age, int weight, ColorData color, AnimalTypeData type) {
        super(name, age, weight, color, type);
    }

    @Override
    public void say() {
        System.out.println("Гав");
    }
}
