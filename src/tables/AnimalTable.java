package tables;

import animals.Animal;
import data.AnimalTypeData;
import db.IDataBase;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class AnimalTable extends AbsTable {

    public AnimalTable(IDataBase iDataBase) {
        super(iDataBase, "animals");
    }

    public void createTable() throws SQLException, IOException {
        String sql = "CREATE TABLE IF NOT EXISTS animals (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(15), " +
                "type VARCHAR(15), " +
                "age INT, " +
                "weight INT, " +
                "color VARCHAR(15))";
        iDataBase.executeUpdate(sql);
    }

    public void add(Animal animal) throws SQLException, IOException {
        String sql = String.format(
                "INSERT INTO animals (name, type, age, weight, color) VALUES ('%s', '%s', %d, %d, '%s')",
                animal.getName(), animal.getType().name(), animal.getAge(), animal.getWeight(), animal.getColor().name());
        iDataBase.executeUpdate(sql);
    }

    public List<Animal> getAll() throws SQLException, IOException {
        String sql = "SELECT * FROM animals";
        ResultSet resultSet = iDataBase.requestExecute(sql);
        return resultToAnimals(resultSet);
    }

    public List<Animal> findByType(AnimalTypeData type) throws SQLException, IOException {
        String sql = String.format("SELECT * FROM animals WHERE type = '%s'", type.name());
        ResultSet resultSet = iDataBase.requestExecute(sql);
        return resultToAnimals(resultSet);
    }

    public boolean update(int id, String newName) throws SQLException, IOException {
        String sql = String.format("UPDATE animals SET name = '%s' WHERE id = %d", newName, id);
        int rowsAffected = iDataBase.executeUpdate(sql);
        return rowsAffected > 0;
    }
}
