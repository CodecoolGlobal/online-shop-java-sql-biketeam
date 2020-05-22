package com.codecool;

import com.codecool.dao.BasketDao;
import com.codecool.dao.BikeDao;
import com.codecool.dao.CategoryDao;
import com.codecool.dao.OrderDao;
import com.codecool.models.Bike;
import com.codecool.models.Customer;
import com.codecool.models.Order;
import com.codecool.patterns.BasketIterator;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CustomerProvider {

    Customer customer;
    Scanner input = new Scanner(System.in);
    BasketDao basketDao = new BasketDao();
    BikeDao bikes = new BikeDao();
    BasketIterator iterator = new BasketIterator();
    OrderDao order = new OrderDao();
    UI print = new UI();
    CategoryDao categoryDao = new CategoryDao();

    public CustomerProvider(Customer customer) {
        this.customer = customer;
    }

    public CustomerProvider() {
    }

    public void addToBasket() {
        System.out.println("Add a name of bike: ");
        String bikeName = input.next();
        System.out.println("Choose a color: ");
        String color = input.next();
        System.out.println("Choose quantity: ");
        int quantity = input.nextInt();

        basketDao.addToBasket(bikeName, color, quantity);
    }

    public void updateQuantity() {
        System.out.println("Which bike's quantity you want to change? ");
        String bikeName = input.next();
        System.out.println("How many? ");
        int newQuantity = input.nextInt();
        basketDao.updateBasket(bikeName, newQuantity);
    }

    public void deleteBike() {
        System.out.println("Enter product ID of bike which you want to delete: ");
        int bikeID = input.nextInt();
        basketDao.deleteFromBasket(bikeID);
    }

    public void order() {
        System.out.println("Do you want to place an order and pay? ");
        String answer = input.next();
        switch (answer) {
            case "yes":
                System.out.println("Enter your adress: ");
                System.out.println("Street: ");
                String street = input.next();
                System.out.println("City: ");
                String city = input.next();
                System.out.println("Phone number: ");
                int phone = input.nextInt();
                basketDao.order(street, city, phone);
                System.out.println("Thanks for order, see you soon");
            case "no":
                System.out.println("Return to shopping!");
        }
    }

    public void historyOrders() {
        List<Order> orders = order.getOrders();
        for (Order ord : orders) {
            System.out.println("Product ID:" + ord.getBikeId() + " |Date: " + ord.getDate() + " |Order Status: " + ord.getStatus());
        }
    }

    public void chooseCategory() {
        Common common = new Common();
        List<Bike> bikeCategory = bikes.getBikesByCategory(common.categoryChooser());
        for (Bike bike : bikeCategory) {
            System.out.println("ID: " + bike.getId() + " | " + bike.getBrand() + " | " + bike.getType() + " | " + bike.getColor() + " | Price: " + bike.getPrice() + " | " + bike.getIsAvailable());
        }

    }

    public void customerMenu() throws SQLException {
        boolean isRun = true;
        while (isRun) {
            print.menuForUser();
            int userChoice = input.nextInt();
            switch (userChoice) {
                case 1:
                    addToBasket();
                    break;
                case 2:
                    updateQuantity();
                    break;
                case 3:
                    deleteBike();
                    break;
                case 4:
                    print.displayBasket();
                    break;
                case 5:
                    order();
                    break;
                case 6:
                    historyOrders();
                    break;
                case 7:
                    print.displayBikes();
                    break;
                case 8:
                    print.displayBikes();
                    break;

            }
        }
    }
}