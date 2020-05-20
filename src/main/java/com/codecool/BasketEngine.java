package com.codecool;

import com.codecool.dao.BasketDao;
import com.codecool.models.Basket;
import com.codecool.models.Customer;

import java.util.List;
import java.util.Scanner;

public class BasketEngine {

    Customer customer;
    Scanner input = new Scanner(System.in);
    BasketDao basketDao = new BasketDao();

    public BasketEngine(Customer customer) {
        this.customer = customer;
    }
    public BasketEngine() {}

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
}
