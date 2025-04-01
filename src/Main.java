import animals.Animal;
import data.CommandsData;
import db.IDataBase;
import db.MySqlConnectorDb;
import factory.AddAnimal;
import factory.FindAnimalsByType;
import services.AnimalService;
import tables.AnimalTable;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IDataBase db = new MySqlConnectorDb();
    private static final AnimalTable animalTable = new AnimalTable(db);

    public static void main(String[] args) throws SQLException, IOException {

        animalTable.createTable();

        List<String> nameStr = new ArrayList<>();
        for (CommandsData cmd : CommandsData.values()) {
            nameStr.add(cmd.name().toLowerCase());
        }

        while (true) {
            System.out.println("Введите команду: " + String.join("/", nameStr));
            String userCommand = scanner.nextLine().trim().toUpperCase();

            boolean isCommandExist = false;
            for (CommandsData commandsData : CommandsData.values()) {
                if (userCommand.equals(commandsData.name())) {
                    isCommandExist = true;
                    break;
                }
            }

            if (!isCommandExist) {
                System.out.printf("Команда %s не поддерживается!\n", userCommand);
                continue;
            }

            switch (CommandsData.valueOf(userCommand)) {
                case ADD: {
                    AddAnimal addAnimal = new AddAnimal(db);
                    Animal animal = addAnimal.addAnimal(scanner);
                    animalTable.add(animal);
                    break;
                }
                case LIST: {
                    List<Animal> animals = animalTable.getAll();
                    animalTable.getAll();
                    if (animals.isEmpty()) {
                        System.out.println("Список пустой.");
                    }
                    for (Animal animal : animals) {
                        System.out.println(animal);
                    }
                    break;
                }
                case FIND: {
                    FindAnimalsByType find = new FindAnimalsByType();
                    List<Animal> foundAnimals = find.findAnimalsByType(scanner, animalTable);
                    if (foundAnimals.isEmpty()) {
                        System.out.println("Не найдено с таким типом");
                    } else {
                        System.out.println("Найденные животные:");
                        for (Animal animal : foundAnimals) {
                            System.out.println(animal);
                        }
                    }
                    break;
                }
                case UPDATE: {
                    IDataBase iDataBase = new MySqlConnectorDb();
                    AnimalService animalService = new AnimalService(iDataBase);
                    animalService.update(scanner);
                    break;
                }
                case EXIT: {
                    db.close();
                    System.exit(0);
                }
            }
        }
    }
}