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
            {"[1] Create new product category"},
            {"[2] Edit name of the product"},
                {"[3] Change availability"},
                {"[4] Delete product"},
                {"[5] Create new product"},
                {"[6] Edit product"},
                {"[7] Check all orders"},
                {"[8] Set status of orders"},
                {"[0] Log out"},
        };
        System.out.println(FlipTable.of(headers,data));


    }

    public static void menuForUser() {
        String[] headers = {"Hello Customer what you want to do ?"};
        String[][] data = {
                {"1. Add product to basket"},
                {"2. Edit product quantity in my basket"},
                {"3. Remove product from basket"},
                {"4. See your basket"},
                {"5. Place an order"},
                {"6. See your orders"},
                {"7. Show all available bikes"},
                {"8. Choose products by category"},
                {"0. Log out"}
        };
        System.out.println(FlipTable.of(headers,data));
    }

}
