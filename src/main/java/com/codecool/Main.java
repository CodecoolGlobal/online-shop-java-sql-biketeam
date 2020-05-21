package com.codecool;

//import com.jakewharton.fliptables.FlipTableConverters;

import com.codecool.models.Customer;

public class Main {
        public static void main(String[] args) {

            Customer customer = new Customer(2, "login2", "password2");

            CustomerProvider basket = new CustomerProvider(customer);
            basket.seeAll();
            basket.printUserBasket();
//            basket.addToBasket();
//            basket.deleteBike();
//            basket.updateQuantity();
            basket.order();
            basket.printUserBasket();
        }
    }

