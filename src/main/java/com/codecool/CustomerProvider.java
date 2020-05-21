package com.codecool;

import com.codecool.dao.BasketDao;
import com.codecool.dao.BikeDao;
import com.codecool.models.Basket;
import com.codecool.models.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerProvider {

    Customer customer;
    Scanner input = new Scanner(System.in);
    BasketDao basketDao = new BasketDao();
    BikeDao bikes = new BikeDao();

    public CustomerProvider(Customer customer) {
        this.customer = customer;
    }
    public CustomerProvider() {}

    public void addToBasket() {
        System.out.println("Add a name of bike: ");
        String bikeName = input.next();
        System.out.println("Choose a color: ");
        String color = input.next();
        System.out.println("Choose quantity: ");
        int quantity = input.nextInt();

        basketDao.addToBasket(bikeName, color, quantity);
    }

    public void printUserBasket() {
        List<Basket> printBasket = basketDao.getBasket();
        for (Basket basket : printBasket) {
            System.out.println(basket.getBikeName() + " " + basket.getColor() + " " + basket.getQuantity());
        }
    }

    public void updateQuantity() {
        System.out.println("Which bike's quantity you want to change? ");
        String bikeName = input.next();
        System.out.println("How many? ");
        int newQuantity = input.nextInt();
        basketDao.updateBasket(bikeName, newQuantity);
    }

    public void deleteBike() {
        System.out.println("Enter a name of bike which you want to delete: ");
        String bikeName = input.next();
        basketDao.deleteFromBasket(bikeName);
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
                basketDao.basketToOrder();
                System.out.println("Thanks for order, see you soon");
            case "no":
                System.out.println("Return to shopping!");
        }
    }


    public void seeAll() {
        for (int i = 0; i < bikes.getBikes().size(); i++) {
            System.out.println(bikes.getBikes().get(i).getBrand() + " " + bikes.getBikes().get(i).getType() + " " +
                    bikes.getBikes().get(i).getColor() + " " + bikes.getBikes().get(i).getPrice() + " " +
                    bikes.getBikes().get(i).getIsAvailable());
        }
    }
}
