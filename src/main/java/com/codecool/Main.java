package com.codecool;


import java.sql.SQLException;

public class Main {
        public static void main(String[] args) throws SQLException {
                Session session = new Session();
                session.connect();
//                Admin admin = new Admin(1, "login", "haslo");
//                AdminProvider adminProvider = new AdminProvider(admin);
//                adminProvider.adminsMenu();

        }
}
