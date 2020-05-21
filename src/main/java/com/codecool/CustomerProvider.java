package com.codecool;

import com.codecool.dao.BasketDao;
import com.codecool.dao.BikeDao;
import com.codecool.dao.OrderDao;
import com.codecool.models.Basket;
import com.codecool.models.Customer;
import com.codecool.models.Order;

import java.util.List;
import java.util.Scanner;

public class CustomerProvider {

    Customer customer;
    Scanner input = new Scanner(System.in);
    BikeDao bikes = new BikeDao();



    public CustomerProvider(Customer customer) {
        this.customer = customer;
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
        switch (answer) {
            case "y":
                List<Basket> boughtProducts = basket.getBasket();
                for (Basket item: boughtProducts){
                    int temp = item.getBikeID();
                    int customerID = 1;
                  order.createOrder(customerID,temp);
                }
                basket.clearBasket();
                System.out.println("Thanks for order, see you soon");
            case "n":
                System.out.println("Return to shopping!");
        }
    }


    public void seeAll() {
        for (int i = 0; i < bikes.getBikes().size(); i++) {
            System.out.println(bikes.getBikes().get(i).getId() + " " + bikes.getBikes().get(i).getBrand() + " " + bikes.getBikes().get(i).getType() + " " +
                    bikes.getBikes().get(i).getColor() + " " + bikes.getBikes().get(i).getPrice() + " " +
                    bikes.getBikes().get(i).getIsAvailable());
        }
    }

    public void history(){
        OrderDao order = new OrderDao();
        List<Order> orders = order.getOrders();
        for (Order ord: orders){
            System.out.println(ord.getBikeId());
        }
    }

    public void customersMenu(){
        boolean isRunning = true;
        seeAll();
        while (isRunning) {
            UI.menuForUser();
            System.out.println("Choose option: ");
            switch (input.nextInt()){
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
                    printUserBasket();
                    break;
                case 5:
                    order();
                case 6:
                    history();
                case 7:
                    //TODO
            }
        }
    }
}