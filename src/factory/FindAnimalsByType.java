package factory;

import animals.Animal;
import data.AnimalTypeData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAnimalsByType {

    public List<Animal> findAnimalsByType(Scanner scanner, List<Animal> animalList) {

        System.out.println("Введите тип животного для поиска");

        ReadType typeData = new ReadType();
        AnimalTypeData type = typeData.readType(scanner);

        List<Animal> result = new ArrayList<>();

        for (Animal animal : animalList) {
            if (animal.getType().equals(type)) {
                result.add(animal);
            }
        }
        return result;
    }
}