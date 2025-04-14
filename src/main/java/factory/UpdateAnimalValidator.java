package factory;

import java.util.Scanner;


public class UpdateAnimalValidator {
    ReadNumber readNumber = new ReadNumber();
    ReadName readName = new ReadName();

    public String[] getValidatorFieldUpdate(Scanner scanner) {
        while (true) {
            System.out.print("Введите название поля для обновления (name или age): \n");
            String field = scanner.nextLine().trim().toLowerCase();

            if ("age".equals(field)) {
                int age = readNumber.readNumber(scanner, "возраст");
                return new String[]{field, String.valueOf(age)};
            } else if ("name".equals(field)) {
                String name = readName.readName(scanner);
                return new String[]{field, name};
            }
            System.out.println("Поле должно быть только 'name или age'");
        }
    }
}
