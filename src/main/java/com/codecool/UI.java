package com.codecool;

import com.jakewharton.fliptables.FlipTable;

public class UI {

    public static void login() {
        String[] headers = {"Welcome to our store!"};
        String[][] data = {
                {"Please enter your login and password :"}
        };
        System.out.println(FlipTable.of(headers,data));

    }

    public static void menuForAdmin(){
        String[] headers = {"Hello Master what you want to do ?"};
        String[][] data = {
            {"1. Create new product category"},
            {"2. Edit name of the product"},
                {"3. Deactivate product"},
                {"4. Create new product"},
                {"5. Edit product"},
                {"6. Give a discount"},
                {"7. Status of orders"},
                {"8. See feedback and statistics"}
        };
        System.out.println(FlipTable.of(headers,data));
    }

    public static void menuForUser() {
        String[] headers = {"Hello Customer what you want to do ?"};
        String[][] data = {
                {"1. Add product to basket"},
                {"2. Edit product quantity in my basket"},
                {"3. Remove product from basket"},
                {"4. See my basket"},
                {"5. Place an order"},
                {"6. See my history of orders"},
                {"7. Rate product"}
        };
        System.out.println(FlipTable.of(headers,data));
    }
//
//    public void userSwitch() {
//        switch (menuForUser()) {
//
//        }
//    }

}
