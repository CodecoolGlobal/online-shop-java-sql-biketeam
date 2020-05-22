package com.codecool;

//import com.jakewharton.fliptables.FlipTableConverters;

import com.codecool.models.Admin;

public class Main {
        public static void main(String[] args) {

                Admin admin = new Admin(1, "testName", "PASS");
                AdminProvider adminProvider = new AdminProvider(admin);
                adminProvider.adminsMenu();

//                Customer custom = new Customer(1, "huj", "hasło");
//                CustomerProvider customer = new CustomerProvider(custom);
//                customer.customersMenu();

        }
    }

