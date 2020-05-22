package com.codecool;

import com.codecool.dao.AdminDao;
import com.codecool.dao.CustomerDao;
import com.codecool.dao.Dao;

public class Login extends Dao {
    private UI ui = new UI();
    AdminDao adminDao = new AdminDao();
    CustomerDao customerDao = new CustomerDao();

    public void loginAdmin() {
        connect();
        String login = ui.gatherInput("Login: ");
        String password = ui.gatherInput("Password: ");
        adminDao.loginAdmin(login, password);
    }

    public void loginUser() {
        connect();
        String login = ui.gatherInput("Login: ");
        String password = ui.gatherInput("Password: ");
        customerDao.loginCustomer(login, password);
    }
}