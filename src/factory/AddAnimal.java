package factory;

import animals.Animal;
import animals.birds.IFlying;
import data.AnimalTypeData;
import data.ColorData;
import db.IDataBase;
import tables.AnimalTable;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;


public class AddAnimal {

    public AddAnimal(IDataBase db) {
    }

    public Animal addAnimal(Scanner scanner) throws SQLException, IOException {

        System.out.println("Добавление нового животного");

        ReadName readName = new ReadName();
        String name = readName.readName(scanner);

        ReadNumber readNumber = new ReadNumber();
        int age = readNumber.readNumber(scanner, "возраст");
        int weight = readNumber.readNumber(scanner, "вес");

        ReadColor readColor = new ReadColor();
        ColorData color = readColor.readColor(scanner);

        ReadType readAnimalType = new ReadType();
        AnimalTypeData type = readAnimalType.readType(scanner);

        AnimalFactory factory = new AnimalFactory(name, age, weight, color, type);
        Animal animal = factory.createAnimal(type);

        if (animal != null) {
            animal.say();
            animal.drink();
            animal.eat();
            animal.go();
        }
        if (animal instanceof IFlying) {
            ((IFlying) animal).fly();
        }
        return animal;
    }
}
