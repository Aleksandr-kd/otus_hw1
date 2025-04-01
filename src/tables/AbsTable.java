package tables;

import animals.Animal;
import data.AnimalTypeData;
import data.ColorData;
import db.IDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public abstract class AbsTable {
    protected String animals;
    protected IDataBase iDataBase;

    public AbsTable(IDataBase iDataBase, String tableName) {
        this.iDataBase = iDataBase;
        this.animals = tableName;
    }

    public List<Animal> resultToAnimals(ResultSet rs) throws SQLException {
        List<Animal> animals = new ArrayList<>();
        while (rs.next()) {
            animals.add(new Animal(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getInt("weight"),
                    ColorData.valueOf(rs.getString("color").toUpperCase()),
                    AnimalTypeData.valueOf(rs.getString("type").toUpperCase())
            ));
        }
        return animals;
    }
}