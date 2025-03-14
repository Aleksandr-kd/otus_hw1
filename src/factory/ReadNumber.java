package factory;

import tools.NumberTools;
import java.util.Scanner;


public class ReadNumber {

    public int readNumber(Scanner scanner, String name) {

        NumberTools numberTools = new NumberTools();

        while (true) {
            System.out.printf("Введите %s:%n", name);
            String input = scanner.next().trim();
            if (numberTools.isNumber(input)) {
                return Integer.parseInt(input);
            } else {
                System.out.printf("Не корректный %s. Введите число от 1 до 99.%n", name);
            }
        }
    }
}
