package animals;

import data.AnimalTypeData;
import data.ColorData;


public class Animal {
    private int id;
    private String name;
    private int age;
    private int weight;
    private ColorData color;
    private AnimalTypeData type;

    public Animal(int id, String name, int age, int weight, ColorData color, AnimalTypeData type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
        this.type = type;
    }

    public Animal(String name, int age, int weight, ColorData color, AnimalTypeData type) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
        this.type = type;
    }

    public AnimalTypeData getType() {
        return type;
    }

    public ColorData getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
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

    public String toShortString() {
        return String.format("Привет! Меня зовут %s, мне %d %s, я вешу %d кг, мой цвет- %s.", name, age, getAgeCase(),
                weight, color.getName());
    }

    public String toString() {
        return String.format(id + " Привет! Меня зовут %s, мне %d %s, я вешу %d кг, мой цвет- %s.", name, age, getAgeCase(),
                weight, color.getName());
    }
}