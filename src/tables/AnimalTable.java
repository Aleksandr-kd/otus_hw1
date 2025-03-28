package tables;

import animals.Animal;
import db.IDataBase;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AnimalTable extends AbsTable {
    private IDataBase iDataBase = null;

    protected String tableName;
    protected Map<String, String> columns = new HashMap<>();


    public AnimalTable() throws SQLException, IOException {


        super("animal");
        columns.put("id", "bigint PRIMARY KEY AUTO_INCREMENT");
        columns.put("type", "varchar(15)");
        columns.put("name", "varchar(15)");
        columns.put("color", "varchar(15)");
        columns.put("weight", "int");
        columns.put("age", "int");

//        iDataBase = new MySqlConnectorDb();


        public void createTable (String animals) throws SQLException, IOException {
            String sqlRequest = String.format("CREATE TABLE IF NOT EXISTS %s (%s)", this.tableName, convertMapColumnsToString());
            iDataBase.executeUpdate(sqlRequest);
        }

        public List<Animal> findAll () {
            List<Animal> animals = new ArrayList<>();
            try {
                try (ResultSet rs = iDataBase.requestExecuteWithReturned("SELECT * FROM " + tableName);) {
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

        private String convertMapColumnsToString () {
            String result = "";
            for (Map.Entry<String, String> el : columns.entrySet()) {
                result += el.getKey() + " " + el.getValue() + ",";
            }
            result = result.substring(0, result.length() - 1);
            return result;
        }
    }
}