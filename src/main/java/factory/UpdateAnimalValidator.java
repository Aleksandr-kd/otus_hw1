package factory;

import java.util.Scanner;


public class UpdateAnimalValidator {

    public String getValidName(Scanner scanner) {
        System.out.print("Введите новое имя животного: \n");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Имя не может быть пустым\n");
            return null;
        }
        return name;
    }
}
