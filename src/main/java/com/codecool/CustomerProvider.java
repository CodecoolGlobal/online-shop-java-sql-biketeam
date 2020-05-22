package com.codecool;

import com.codecool.dao.BasketDao;
import com.codecool.dao.BikeDao;
import com.codecool.dao.CategoryDao;
import com.codecool.dao.OrderDao;
import com.codecool.models.Basket;
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
        BasketDao basket = new BasketDao();
        System.out.println("Which bike do You want to add to cart? ");
        int bikeID = input.nextInt();
        basket.addNewProduct(bikeID, 1);
    }

    public void printUserBasket() {
        BasketDao basket = new BasketDao();
        List<Basket> printBasket = basket.getBasket();
        for (Basket bask : printBasket) {
            System.out.println("Product ID: " + bask.getBikeID() +" | Your future bike: " + bask.getBikeName());
        }
    }

    public void updateQuantity() {
        BasketDao basket = new BasketDao();
        System.out.println("Which bike's quantity you want to change? ");
        String bikeName = input.next();
        System.out.println("How many? ");
        int newQuantity = input.nextInt();
        basket.updateBasket(bikeName, newQuantity);
    }

    public void deleteBike() {
        BasketDao basket = new BasketDao();
        System.out.println("Enter product ID of bike which you want to delete: ");
        int bikeID = input.nextInt();
        basket.deleteFromBasket(bikeID);
    }

    public void order() {
        OrderDao order = new OrderDao();
        BasketDao basket = new BasketDao();
        System.out.println("Are You sure you want to place an order and pay? [y/n]");
        String answer = input.next();
        Common common = new Common();
        switch (answer) {
            case "y":
                List<Basket> boughtProducts = basket.getBasket();
                for (Basket item: boughtProducts){
                    int temp = item.getBikeID();
                    int customerID = 15;
                    order.createOrder(customerID, temp, common.getDate(), 1);
                }
                basket.clearBasket();
                System.out.println("Thanks for order, see you soon");
            case "n":
                System.out.println("Return to shopping!");
        }
    }

    public void historyOrders(){
        OrderDao order = new OrderDao();
        List<Order> orders = order.getOrders();
        for (Order ord: orders){
            System.out.println("Product ID:" + ord.getBikeId() + " |Date: " + ord.getDate() + " |Order Status: " + ord.getStatus());
        }
    }

    public void chooseCategory(){
        Common common = new Common();
        List<Bike> bikeCategory = bikes.getBikesByCategory(common.categoryChooser());
        for (Bike bike : bikeCategory) {
            System.out.println("ID: " + bike.getId() + " | " + bike.getBrand() + " | " + bike.getType() + " | " + bike.getColor() + " | Price: " + bike.getPrice() + " | " + bike.getIsAvailable() );
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
                case 0:
                    isRun = false;
                    break;

            }
        }
    }
}