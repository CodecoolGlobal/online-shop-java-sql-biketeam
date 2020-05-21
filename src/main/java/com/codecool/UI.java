package com.codecool;

import com.codecool.dao.BikeDao;
import com.codecool.models.Bike;
import com.jakewharton.fliptables.FlipTable;

import java.util.List;

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
                {"[3] Deactivate product"},
                {"[4] Delete product"},
                {"[5] Create new product"},
                {"[6] Edit product"},
                {"[7] Give a discount"},
                {"[8] Status of orders"},
                {"[9] See feedback and statistics"}
        };
        System.out.println(FlipTable.of(headers,data));


    }

    public static void menuForUser() {
        String[] headers = {"Hello Customer what you want to do ?"};
        String[][] data = {
                {"[1] Add product to basket"},
                {"[2] Edit product quantity in my basket"},
                {"[3] Remove product from basket"},
                {"[4] See your basket"},
                {"[5] Place a order"},
                {"[6] See your history of orders"},
                {"[7] Rate product"}
        };
        System.out.println(FlipTable.of(headers,data));
    }

    public static void displayBikes() {
        String[] headers = {"Our Bikes to sell: "};
        BikeDao bikeDao = new BikeDao();
        List<Bike> bikes = bikeDao.getBikes();

        for (Bike bike : bikes) {
            String[][] data  = {
                    {String.format("%s", bike.getId())},
                    {String.format("%s", bike.getBrand())}
            };
            System.out.println(FlipTable.of(headers,data));
            //System.out.println(bike.getId() + " " + bike.getBrand() + " | " + bike.getType() + " | " + bike.getColor() + " | In stock: " + bike.getInStock() + " | Price: " + bike.getPrice());

        }

    }


}
