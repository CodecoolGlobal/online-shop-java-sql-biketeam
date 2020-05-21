package com.codecool;
import com.codecool.dao.AdminDao;
import com.codecool.dao.Dao;


public class Register extends Dao {
    private UI ui;

    Register() {
        connect();
        ui = new UI();
        enterAdminData();
    }

    private void enterAdminData() {
        String login = ui.gatherInput("Enter your name: ");
        String password = ui.gatherInput("Enter your password: ");
        String[] values = {login, password};
        new AdminDao().insertUser(values);
    }
    

}