package com.codecool;

//import com.jakewharton.fliptables.FlipTableConverters;

import com.codecool.models.Customer;

public class Main {
        public static void main(String[] args) {


            Customer customer = new Customer(2, "login2", "password2");
            BasketEngine basket = new BasketEngine(customer);
//            basket.addToBasket();
//            basket.deleteBike();
            basket.printUserBasket();
            basket.updateQuantity();
            basket.printUserBasket();


        }
    }

