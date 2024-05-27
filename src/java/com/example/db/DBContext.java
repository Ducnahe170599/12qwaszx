package com.example.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    private static final String USER = "sa";
    private static final String PASS = "123";
    private static final String DATABASE = "Quiz_DB";
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=" + DATABASE;

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
        return connection;
    }
}
