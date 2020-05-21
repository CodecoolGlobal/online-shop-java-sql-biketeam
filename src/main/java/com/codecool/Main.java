package com.codecool;

//import com.jakewharton.fliptables.FlipTableConverters;

import com.codecool.patterns.BasketIterator;

import java.sql.SQLException;

public class Main {
        public static void main(String[] args) throws SQLException {

                BasketIterator bike = new BasketIterator();
                UI print = new UI();
                CustomerProvider customerProvider = new CustomerProvider();
//                print.displayBikes();
//                CustomerProvider customer = new CustomerProvider();
//                Customer customer1 = new Customer(1, "login", "password");
//                CustomerProvider basket = new CustomerProvider(customer1);
                print.seeBasket();

        }
    }

