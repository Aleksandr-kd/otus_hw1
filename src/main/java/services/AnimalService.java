package services;

import animals.Animal;
import db.IDataBase;
import factory.AddAnimal;
import tables.AnimalTable;
import tools.NumberTools;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;


public class AnimalService {
    private NumberTools idNumber;
    private AnimalTable animalTable;
    private AddAnimal addAnimal;

    public AnimalService(IDataBase iDataBase) {
        this.idNumber = new NumberTools();
        this.animalTable = new AnimalTable(iDataBase);
        this.addAnimal = new AddAnimal(iDataBase);
    }

    public void update(Scanner scanner) throws SQLException, IOException {
        while (true) {
            System.out.print("Введите ID животного для обновления: \n");
            String idInput = scanner.nextLine().trim();

            if (!idNumber.isNumberId(idInput)) {
                System.out.println("Не корректный ID.Попробуй еще раз!\n ");
                continue;
            }
            int id = Integer.parseInt(idInput);

            System.out.println("Введите новые данные для животного:");
            Animal updatedAnimal = addAnimal.addAnimal(scanner);

            boolean isUpdated = animalTable.updateAllData(
                    id,
                    updatedAnimal.getName(),
                    updatedAnimal.getAge(),
                    updatedAnimal.getWeight(),
                    updatedAnimal.getColor().name(),
                    updatedAnimal.getType().name()
            );

            if (!isUpdated) {
                System.out.println("Животное с ID " + id + " не найдено. C помощью команды LIST можно посмотреть " +
                        "ID животных.\n");
            } else {
                System.out.println("Животного с ID " + id + " успешно обновлен.");
            }
            break;
        }
    }
}