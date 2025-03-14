package factory;

import animals.Animal;
import data.ColorData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAnimalsByColor {

    public List<Animal> findAnimalsByColor(Scanner scanner, List<Animal> animalList) {

        System.out.println("Введите цвет животного для поиска");

        ReadColor readColor = new ReadColor();
        ColorData color = readColor.readColor(scanner);

        List<Animal> result = new ArrayList<>();

        for (Animal animal : animalList) {
            if (animal.getColor().equals(color)) {
                result.add(animal);
            }
        }
        return result;
    }
}
