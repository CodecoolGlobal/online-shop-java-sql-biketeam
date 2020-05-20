package com.codecool.dao;

import com.codecool.models.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao extends Dao {

    public List<Admin> getAdmins(String query) {
        List<Admin> customers = new ArrayList<>();
        connect();

        try {
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                int id = results.getInt("Customer_ID");
                String login = results.getString("Login");
                String password = results.getString("Password");

                Admin user = new Admin(id, login, password);
                customers.add(user);
            }
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
}