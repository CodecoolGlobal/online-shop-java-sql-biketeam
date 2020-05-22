package com.codecool.dao;

import com.codecool.UI;
import com.codecool.models.Admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao extends Dao {
    UI print = new UI();

    public List<Admin> getAdmins(String query) {
        List<Admin> admins = new ArrayList<>();
        connect();

        try {
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                int id = results.getInt("Admin_ID");
                String login = results.getString("Login");
                String password = results.getString("Password");
                Admin user = new Admin(id, login, password);
                admins.add(user);
            }
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admins;
    }

    public void registerAdmin(String login, String password) {
        String query = "INSERT INTO Admin (Login, Password)" + String.format("VALUES ('%s', '%s')", login, password);
        connect();
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loginAdmin(String login, String password) {
        String query = "SELECT COUNT(*) FROM Admin WHERE Login LIKE '" + login + "'AND Password LIKE '" + password + "'";
        connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    boolean found = resultSet.getBoolean(1);
                    if (found) {
                        System.out.println("access accepted");
                        print.menuForAdmin();
                    } else {
                        System.out.println("access denied");
                        found = false;
                    }
                }
            }
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}