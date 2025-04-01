package factory;

import java.util.Scanner;


public class ReadName {

    public String readName(Scanner scanner) {
        System.out.println("Введите имя:");
        return scanner.nextLine().trim();
    }
}
