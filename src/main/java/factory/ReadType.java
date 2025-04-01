package factory;

import data.AnimalTypeData;
import java.util.Scanner;


public class ReadType {

    public AnimalTypeData readType(Scanner scanner) {
        System.out.println("Введите тип животного:");
        for (AnimalTypeData type : AnimalTypeData.values()) {
            System.out.println("- " + type.getName());
        }
        while (true) {
            String typeInput = scanner.nextLine().trim();
            for (AnimalTypeData type : AnimalTypeData.values()) {
                if (type.getName().equalsIgnoreCase(typeInput)) {
                    return type;
                }
            }
            System.out.println("Не верно выбран тип. Введите из предложенных");
        }
    }
}