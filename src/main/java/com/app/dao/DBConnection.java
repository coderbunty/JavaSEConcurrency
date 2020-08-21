package com.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // register jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // open a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test1", "root",
                    "abhi0724");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
