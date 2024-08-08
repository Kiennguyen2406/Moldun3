package com.example.module3kt.dbConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/officedb";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "12345@abc";

    public static Connection getCon() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            if (connection != null) {
                System.out.println("Database connection established successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
