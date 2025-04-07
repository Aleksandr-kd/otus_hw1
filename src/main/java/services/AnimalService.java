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
    private AnimalTable animalTable;
    private UpdateAnimalValidator validatorField;

    public AnimalService(IDataBase iDataBase) {
        this.idNumber = new NumberTools();
        this.animalTable = new AnimalTable(iDataBase);
        this.validatorField = new UpdateAnimalValidator();
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

            String[] updateData = validatorField.getValidatorFieldUpdate(scanner);
            String field = updateData[0];
            String value = updateData[1];

            boolean isUpdated;
            try {
                if (field.toLowerCase().equals("name")){
                    isUpdated = animalTable.updateName(id, value);
                }else {
                    int age = Integer.parseInt(value);
                    isUpdated = animalTable.updateAge(id, age);
                }
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }

            if (!isUpdated) {
                System.out.println("Животное с ID " + id + " не найдено. C помощью команды LIST можно посмотреть ID животных.\n");
            } else {
                System.out.println("Животного с ID " + id + " успешно обновлен.");
            }
            break;
        }
    }
}