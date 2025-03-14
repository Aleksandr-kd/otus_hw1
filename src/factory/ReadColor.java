package factory;

import data.ColorData;
import java.util.Arrays;
import java.util.Scanner;


public class ReadColor {

    public ColorData readColor(Scanner scanner) {
        System.out.println("Введите цвет:");
        for (ColorData color : ColorData.values()){
            System.out.println("- " + color.getName());
        }
        while (true) {
            String colorInput = scanner.next().trim();
            for (ColorData color : ColorData.values()) {
                if (color.getName().equalsIgnoreCase(colorInput)) {
                    return color;
                }
            }
            System.out.println("Не верно выбран цвет. Введите из предложенных");
        }
    }
}
