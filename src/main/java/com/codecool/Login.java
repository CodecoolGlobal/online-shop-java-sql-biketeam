package com.codecool;

import com.codecool.dao.AdminDao;
import com.codecool.dao.CustomerDao;
import com.codecool.dao.Dao;
import com.codecool.models.Customer;

import java.sql.SQLException;

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

    public void loginUser() throws SQLException {
        Customer customer = new Customer(1, "login", "haslo");
        CustomerProvider customerProvider = new CustomerProvider(customer);
        customerProvider.customersMenu();

//        connect();
//        String login = ui.gatherInput("Login: ");
//        String password = ui.gatherInput("Password: ");
//        customerDao.loginCustomer(login, password);
    }
}