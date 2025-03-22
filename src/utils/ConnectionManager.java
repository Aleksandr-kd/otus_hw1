package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.*;



public class ConnectionManager {
    private static final String url = "jdbc:mysql://sql.home.kartushin.su:3306/test";
    private static final String user = "admin";
    private static final String password = "711267";

    private static Connection connection;
    private static Statement statement;

    static {
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ConnectionManager(){}

    public static ResultSet executeQueryWithAnswer(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public static void executeQuery(String query) throws SQLException {
        statement.executeQuery(query);
    }

    public static void executeUpdate(String query) throws SQLException {
        statement.executeUpdate(query);
    }
}