package db;

import properties.FilePropertiesReader;

import java.io.IOException;
import java.sql.*;
import java.util.Map;

public class MySqlConnectorDb implements IDataBase {

    private static Connection connection = null;
    private static Statement statement = null;

    private void openConnectionDb() throws SQLException, IOException {
        if (connection == null) {
            Map<String, String> settings = new FilePropertiesReader().getSettings();
            connection = DriverManager.getConnection(settings.get("url"), settings.get("login"), settings.get("password"));
        }

        if (statement == null) {
            statement = connection.createStatement();
        }
    }

    public ResultSet requestExecute(String sqlRequest) throws SQLException, IOException {
        openConnectionDb();
        return statement.executeQuery(sqlRequest);
    }

    public int executeUpdate(String query) throws SQLException, IOException {
        openConnectionDb();
        return statement.executeUpdate(query);

    }

    public void close() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }
}
