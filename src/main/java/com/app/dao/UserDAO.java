package com.app.dao;

import com.app.beans.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public int saveUser(User user) {
        int rows = 0;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("insert into user values (?, ?, ?)");
            statement.setInt(1, user.getId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());
            rows = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rows;
    }

    public int removeAllUsers() {
        int rows = 0;
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("delete from user");
            rows = statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rows;
    }
}
