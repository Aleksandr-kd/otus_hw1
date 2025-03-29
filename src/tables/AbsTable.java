package tables;

import animals.Animal;
import data.AnimalTypeData;
import data.ColorData;
import db.IDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsTable{
    protected String animals;
    protected IDataBase iDataBase;

    public AbsTable(IDataBase iDataBase, String tableName){
        this.iDataBase=iDataBase;
        this.animals =tableName;
    }

    public Animal mapRowToAnimal(ResultSet rs) throws SQLException{
//        String name = rs.getString("name");
//        int age = rs.getInt("age");
//        int weight = rs.getInt("weight");
//        ColorData color = ColorData.valueOf(rs.getString("color"));
//        AnimalTypeData type = AnimalTypeData.valueOf(rs.getString("type"));
//        return new Animal(name, age, weight, color, type);

        return new Animal(
                rs.getString("name"),
                rs.getInt("age"),
                rs.getInt("weight"),
                ColorData.valueOf(rs.getString("color").toUpperCase()),
                AnimalTypeData.valueOf(rs.getString("type").toUpperCase())
                );
    }

    public List<Animal> mapResultSetToAnimals(ResultSet rs) throws SQLException{
        List<Animal> animals = new ArrayList<>();
        while (rs.next()){
            animals.add(mapRowToAnimal(rs));
        }
        return animals;
    }
}