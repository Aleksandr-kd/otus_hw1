
package factory;

import animals.Animal;
import data.AnimalTypeData;
import tables.AnimalTable;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

    public class FindAnimalsByType {

        public List<Animal> findAnimalsByType(Scanner scanner, AnimalTable animalTable) throws SQLException, IOException {
            System.out.println("Введите тип животного для поиска");

            ReadType typeData = new ReadType();
            AnimalTypeData type = typeData.readType(scanner);

            return animalTable.findByType(type);
        }
    }