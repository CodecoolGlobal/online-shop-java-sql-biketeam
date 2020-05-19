package com.codecool.dao;

import com.codecool.models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends Dao {

    public List<Customer> getUsers() {
        List<Customer> users = new ArrayList<>();
        connect();

        try {
            ResultSet results = statement.executeQuery("SELECT * FROM Users;");
            while (results.next()) {
                int id = results.getInt("id");
                String login = results.getString("login");
                String password = results.getString("password");

                Customer user = new Customer(id, login, password);
                users.add(user);
            }
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}