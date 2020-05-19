package com.codecool;

//import com.jakewharton.fliptables.FlipTableConverters;

import com.codecool.dao.CustomerDao;
import com.codecool.models.Customer;

import java.util.List;

public class Main {
        public static void main(String[] args) {
            CustomerDao customerDao = new CustomerDao();
            List<Customer> customers = customerDao.getCustomers();

            for (Customer customer : customers) {
                System.out.println(customer.getLogin() + " " + customer.getPassword());
            }

       //      pretty table
    //        System.out.println(FlipTableConverters.fromIterable(users, User.class));

        }
    }

