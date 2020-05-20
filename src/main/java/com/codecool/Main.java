package com.codecool;

//import com.jakewharton.fliptables.FlipTableConverters;

import com.codecool.dao.BikeDao;
import com.codecool.models.Admin;
import com.codecool.models.Bike;

import java.util.List;

public class Main {
        public static void main(String[] args) {

                Admin admin = new Admin(1, "testName", "PASS");
                AdminProvider adminProvider = new AdminProvider(admin);
//              adminProvider.editName();
//              adminProvider.createProduct();
           //  adminProvider.setAvailable();
           //  adminProvider.updateAmount();

            BikeDao bikeDao = new BikeDao();
            List<Bike> bikes = bikeDao.getBikes();
            System.out.println("~~Our Bikes to sell: ~~");
            for (Bike bike : bikes) {

                System.out.println(bike.getId() + " " + bike.getBrand() + " | " + bike.getType() + " | " + bike.getColor() + " | In stock: " + bike.getInStock() + " | Price: " + bike.getPrice());

            }
            UI.login();
            UI.menuForAdmin();
            UI.menuForUser();


       //      pretty table
    //        System.out.println(FlipTableConverters.fromIterable(users, User.class));


        }
    }

