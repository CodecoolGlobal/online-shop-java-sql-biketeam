package com.codecool;

//import com.jakewharton.fliptables.FlipTableConverters;

import com.codecool.dao.BikeDao;
import com.codecool.dao.CustomerDao;
import com.codecool.models.Bike;
import com.codecool.models.Customer;

import java.util.List;

public class Main {
        public static void main(String[] args) {
            CustomerDao customerDao = new CustomerDao();
            List<Customer> customers = customerDao.getCustomers();

            for (Customer customer : customers) {
                System.out.println(customer.getLogin() + " " + customer.getPassword());
            }

            BikeDao bikeDao = new BikeDao();
       //     bikeDao.createBike( "Merida", "City", "Red", 10, 2000);
         //    bikeDao.deleteBikes("Merida");
       //     bikeDao.updateAmountBike("Merida", -12);
       //     bikeDao.changeBrand("Merida", "KTM");
      //      bikeDao.changePrice("KTM", 2100);
            bikeDao.setActive("KTM", true);
            List<Bike> bikes = bikeDao.getBikes();
            System.out.println("~~Our Bikes to sell: ~~");
            for (Bike bike : bikes) {

                System.out.println(bike.getId() + " " + bike.getBrand() + " | " + bike.getType() + " | " + bike.getColor() + " | In stock: " + bike.getInStock() + " | Price: " + bike.getPrice() + " " + bike.getIsAvailable() );
            }


       //      pretty table
    //        System.out.println(FlipTableConverters.fromIterable(users, User.class));

        }
    }

