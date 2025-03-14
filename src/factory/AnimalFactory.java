package factory;

import animals.Animal;
import animals.birds.Duck;
import animals.pets.Cat;
import animals.pets.Dog;
import data.AnimalTypeData;
import data.ColorData;


public class AnimalFactory {

    private String name;
    private int age;
    private int weight;
    private ColorData colorData;
    private AnimalTypeData type;

    public AnimalFactory(String name, int age, int weight, ColorData colorData, AnimalTypeData type) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.colorData = colorData;
        this.type = type;
    }

    public Animal createAnimal(AnimalTypeData animalTypeData) {
        switch (animalTypeData) {
            case CAT: {
                return new Cat(name, age, weight, colorData, type);
            }
            case DOG: {
                return new Dog(name, age, weight, colorData, type);
            }
            case DUCK: {
                return new Duck(name, age, weight, colorData, type);
            }
        }
        return null;
    }
}