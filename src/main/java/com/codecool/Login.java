package com.codecool;

import java.sql.SQLException;
import java.util.List;

import com.codecool.dao.AdminDao;
import com.codecool.dao.Dao;
import com.codecool.models.Admin;

public class Login extends Dao {


    public Admin loginAttempt(String userEmail, String userPassword) {
        connect();
        List<Admin> users = null;
        try {
            users = getMatchingUser(userEmail, userPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users.isEmpty() ? null : users.get(0);

    }

    private List<Admin> getMatchingUser(String adminLogin, String adminPassword) throws SQLException {
        return new AdminDao().getAdmins(
                "SELECT * FROM Admin WHERE Login = '" + adminLogin + "' AND password = '" + adminPassword + "';");
    }

}