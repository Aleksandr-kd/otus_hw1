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
    private ColorData color;
    private AnimalTypeData type;

    public AnimalFactory(String name, int age, int weight, ColorData color, AnimalTypeData type) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
        this.type = type;
    }

    public Animal createAnimal(AnimalTypeData animalTypeData) {
        switch (animalTypeData) {
            case CAT: {
                return new Cat(name, age, weight, color, type);
            }
            case DOG: {
                return new Dog(name, age, weight, color, type);
            }
            case DUCK: {
                return new Duck(name, age, weight, color, type);
            }
        }
        return null;
    }
}