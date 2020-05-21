package com.codecool.dao;

import com.codecool.models.Admin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao extends Dao {

    public List<Admin> getAdmins(String query) {
        List<Admin> admins = new ArrayList<>();
        connect();

        try {
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                int id = results.getInt("Customer_ID");
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
    public void insertUser(String[] values) {
        String[] columns = { "name", "surname", "email", "password", "phone", "Id_role" };
        
        for (int i = 0; i < 5; i++) {
            values[i] = String.format("'%s'", values[i]);
        }
        insert("Users", columns, values);

    }
}