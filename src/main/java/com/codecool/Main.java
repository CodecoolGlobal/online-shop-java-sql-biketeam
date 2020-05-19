package com.codecool;

import com.codecool.dao.BasketDao;
import com.codecool.dao.CustomerDao;
import com.codecool.models.Basket;
import com.codecool.models.Customer;

import java.util.List;

public class Main {
        public static void main(String[] args) {
            CustomerDao customerDao = new CustomerDao();
            List<Customer> customers = customerDao.getCustomers();

            for (Customer customer : customers) {
                System.out.println(customer.getLogin() + " " + customer.getPassword());
            }

            BasketDao basketDao = new BasketDao();
            List<Basket> baskets = basketDao.getBasket();

            for (Basket basket : baskets) {
                System.out.println(basket.getBasketId() + " " +
                        basket.getBikeId() + " " + basket.getCustomerId() + " " +
                        basket.getBikeName() );
            }

        }
    }

