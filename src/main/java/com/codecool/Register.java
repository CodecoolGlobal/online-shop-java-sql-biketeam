package com.codecool;
import com.codecool.dao.AdminDao;
import com.codecool.dao.CustomerDao;
import com.codecool.dao.Dao;


public class Register extends Dao {
    private UI ui = new UI();
    AdminDao adminDao = new AdminDao();
    CustomerDao customerDao = new CustomerDao();


    public void enterAdminData() {
        connect();
        String login = ui.gatherInput("Enter your name: ");
        String password = ui.gatherInput("Enter your password: ");
        adminDao.registerAdmin(login, password);
    }

    public void enterUserData() {
        connect();
        String login = ui.gatherInput("Enter your name: ");
        String password = ui.gatherInput("Enter your password: ");
        customerDao.registerCustomer(login, password);
    }
}