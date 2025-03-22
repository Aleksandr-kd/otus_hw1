package animals;

import data.AnimalTypeData;
import data.ColorData;


public class Animal {
    private String name;
    private int age;
    private int weight;
    private ColorData color;
    private AnimalTypeData type;

    public Animal(String name, int age, int weight, ColorData color, AnimalTypeData type) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
        this.type = type;
    }

    public Animal(long id, String name, int age, int weight, String color, String type) {
    }

    public Animal() {

    }

    public AnimalTypeData getType() {
        return type;
    }

    public ColorData getColor() {
        return color;
    }

    public void say() {
        System.out.println("Я говорю");
    }

    public void go() {
        System.out.println("Я иду");
    }

    public void drink() {
        System.out.println("Я пью");
    }

    public void eat() {
        System.out.println("Я ем");
    }

    private String getAgeCase() {

        if (age >= 11 && age <= 14) {
            return "лет";
        }

        int ostatok = age % 10;

        if (ostatok == 1) {
            return "год";
        }
        if (ostatok >= 2 && ostatok <= 4) {
            return "года";
        }
        return "лет";
    }

    public String toString() {
        return String.format("Привет! Меня зовут %s, мне %d %s, я вешу %d кг, мой цвет- %s.", name, age, getAgeCase(),
                weight, color);
    }
}
//                weight, color.getName());