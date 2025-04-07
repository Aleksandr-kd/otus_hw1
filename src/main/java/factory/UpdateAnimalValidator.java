package factory;

import java.util.Scanner;


public class UpdateAnimalValidator {
    ReadNumber readNumber = new ReadNumber();
    ReadName readName = new ReadName();

    public String[] getValidatorFieldUpdate(Scanner scanner) {
        System.out.print("Введите название поля для обновления (name или age): \n");
        String field = scanner.nextLine().trim().toLowerCase();

        String fieldUpdate;
        if ("age".equals(field)){
            fieldUpdate = String.valueOf(readNumber.readNumber(scanner, "возраст"));
        }else {
            fieldUpdate = readName.readName(scanner);
        }
        return new String[]{field, fieldUpdate};
    }
}
