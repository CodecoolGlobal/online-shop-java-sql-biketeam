package com.codecool;

//import com.jakewharton.fliptables.FlipTableConverters;

import java.sql.SQLException;

public class Main {
        public static void main(String[] args) throws SQLException {

                UI print = new UI();
                CustomerProvider customerProvider = new CustomerProvider();
                customerProvider.customerMenu();
//                AdminProvider adminProvider = new AdminProvider();
//                adminProvider.adminsMenu();

        }
    }

