package com.codecool;

import com.codecool.dao.Dao;

import java.sql.SQLException;

public class Session extends Dao {
    private String loggedAs;
    UI ui = new UI();
    Login login = new Login();
    Register register = new Register();
    CustomerProvider customerProvider = new CustomerProvider();
    AdminProvider adminProvider = new AdminProvider();

    public Session() throws SQLException {
        connect();
        askIfLoginOrRegistration();
        askIfAdminOrUser();
    }

    private void askIfLoginOrRegistration() throws SQLException {
        boolean registered = false;
        do {
            ui.menuForLoginOrRegister();
            String input = ui.gatherInput("");
            if (input.equals("2")) {
                ui.registerMenu();
                if (ui.gatherInput("").equals("1")) {
                    register.enterAdminData();
                } else if (ui.gatherInput("").equals("2")) {
                    register.enterUserData();
                }
            }else if (input.equals("1")){
                askIfAdminOrUser();
            }
        }while (!registered);
    }

    private void askIfAdminOrUser() throws SQLException {
        ui.menuForUserOrAdmin();
        String input = ui.gatherInput("");
        if (input.equals("1")) {
            login.loginAdmin();
        } else if (input.equals("2")) {
            login.loginUser();
        }
    }


}