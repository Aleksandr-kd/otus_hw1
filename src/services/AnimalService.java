package services;

import db.IDataBase;
import factory.UpdateAnimalValidator;
import tables.AnimalTable;
import tools.NumberTools;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;


public class AnimalService {
    private NumberTools idNumber;
    private AnimalTable updateName;
    private UpdateAnimalValidator validatorName;

    public AnimalService(IDataBase iDataBase) {
        this.idNumber = new NumberTools();
        this.updateName = new AnimalTable(iDataBase);
        this.validatorName = new UpdateAnimalValidator();
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

            String newName = validatorName.getValidName(scanner);
            if (newName == null) {
                continue;
            }

            boolean updated = updateName.update(id, newName);

            if (!updated) {
                System.out.println("Животное с ID " + id + " не найдено. C помощью команды LIST можно посмотреть ID животных.\n");
            } else {
                System.out.println("Имя животного с ID " + id + " успешно изменено на " + newName + ".");
            }
            break;
        }
    }
}