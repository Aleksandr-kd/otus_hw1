import animals.Animal;
import data.CommandsData;
import factory.AddAnimal;
import factory.FindAnimalsByColor;
import factory.FindAnimalsByType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    private static List<Animal> animalList = new ArrayList<>();


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> namesStr = new ArrayList<>();
        for (CommandsData commandsData : CommandsData.values()) {
            namesStr.add(commandsData.name().toLowerCase());
        }

        while (true) {
            System.out.println(String.format("Введите команду: %s", String.join("/", namesStr)));

            String userCommand = scanner.next().trim();
            String userCommandUpperCase = userCommand.toUpperCase();

            boolean isCommandExist = false;
            for (CommandsData commandsData : CommandsData.values()) {
                if (userCommandUpperCase.equals(commandsData.name())) {
                    isCommandExist = true;
                    break;
                }
            }

            if (!isCommandExist) {
                System.out.printf("Команда %s не поддерживается!\n", userCommand);
                continue;
            }

            switch (CommandsData.valueOf(userCommandUpperCase)) {
                case ADD: {
                    AddAnimal addAnimal = new AddAnimal();
                    addAnimal.addAnimal(scanner, animalList);
                    break;
                }
                case LIST: {
                    if (animalList.isEmpty()) {
                        System.out.println("Список пустой.");
                    }
                    for (Animal animal : animalList) {
                        System.out.println(animal);
                    }
                }
                break;
                case FIND_ANIMALS_BY_COLOR: {
                    FindAnimalsByColor findAnimalsByColor = new FindAnimalsByColor();
                    List<Animal> foundAnimals = findAnimalsByColor.findAnimalsByColor(scanner, animalList);

                    if (foundAnimals.isEmpty()) {
                        System.out.println("Не найдено с таким цветом");
                    } else {
                        System.out.println("Найденные животные:");
                        for (Animal animal : foundAnimals) {
                            System.out.println(animal.toString());
                        }
                    }
                }
                break;
                case FIND_ANIMALS_BY_TYPE: {
                    FindAnimalsByType findAnimalsByType = new FindAnimalsByType();
                    List<Animal> foundAnimalsType = findAnimalsByType.findAnimalsByType(scanner, animalList);

                    if (foundAnimalsType.isEmpty()) {
                        System.out.println("Не найдено с таким типом");
                    } else {
                        System.out.println("Найденные животные:");
                        for (Animal animal : foundAnimalsType) {
                            System.out.println(animal.toString());
                        }
                    }
                }
                break;
                case EXIT: {
                    System.exit(0);
                }
            }
        }
    }
}