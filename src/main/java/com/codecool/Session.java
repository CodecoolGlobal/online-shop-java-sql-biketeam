package com.codecool;

import com.codecool.models.Admin;

public class Session {
    private String loggedAs;
    private final UI ui;

    public Session() {
        ui = new UI();
        askIfLoginOrRegistration();
        Admin admin = logIn();
    }


    private Admin logIn() {
        Admin loggedAdmin;
        String adminLogin;
        Login login = new Login();
        do {
            adminLogin = ui.gatherInput("Login ").toLowerCase();
            String userPassword = ui.gatherInput("Password: ");
            loggedAdmin = login.loginAttempt(adminLogin, userPassword);
        } while (loggedAdmin == null);
        System.out.println("Logged in");
        loggedAs = adminLogin;
        return loggedAdmin;
    }
    private void askIfLoginOrRegistration() {
        boolean registered = false;
        do {
            ui.menuForLoginOrRegister();
            String input = ui.gatherInput("What to do?: ");
            if (input.equals("2")) {
                new Register();
            }else if (input.equals("1")){
                registered = true;
            }
        }while (!registered);
    }


    public String getLoggedAs() {
        return loggedAs;
    }

    

}