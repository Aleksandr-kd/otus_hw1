package dao;


import animals.Animal;
import utils.ConnectionManager;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnimalTable extends AbsTable {
    public AnimalTable() {
        super("animals");
        columns.put("id", "bigint PRIMARY KEY AUTO_INCREMENT");
        columns.put("type", "varchar(15)");
        columns.put("name", "varchar(15)");
        columns.put("color", "varchar(15)");
        columns.put("weight", "int");
        columns.put("age", "int");
        create(tableName);
    }

    public List<Animal> findAll() {
        List<Animal> animals = new ArrayList<>();
        try {
            try (ResultSet rs = ConnectionManager.executeQueryWithAnswer("SELECT * FROM " + tableName)) {
                while (rs.next()) {
                    long id = rs.getLong("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    int weight = rs.getInt("weight");
                    String color = rs.getString("color");
                    String type = rs.getString("type");

                    Animal animal = new Animal(id, name, age, weight, color, type);
                    animals.add(animal);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return animals;
    }

    public Animal findByType(String searchType) {
        Animal animal = new Animal();
        try {
            try (ResultSet rs = ConnectionManager.executeQueryWithAnswer("SELECT * FROM " + tableName + " WHERE type=" + searchType)) {
                while (rs.next()) {
                    long id = rs.getLong("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    int weight = rs.getInt("weight");
                    String color = rs.getString("color");
                    String type = rs.getString("type");

                    animal = new Animal(id, name, age, weight, color, type);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return animal;
    }
}