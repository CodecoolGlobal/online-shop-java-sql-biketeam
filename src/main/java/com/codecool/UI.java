package com.codecool;

import com.codecool.dao.BasketDao;
import com.codecool.dao.Dao;
import com.codecool.patterns.BasketIterator;
import com.codecool.patterns.BikeIterator;
import com.jakewharton.fliptables.FlipTable;

import java.sql.SQLException;

public class UI extends Dao {
    BasketDao basketDao = new BasketDao();
    BasketIterator basketIterator = new BasketIterator();
    BikeIterator bikeIterator = new BikeIterator();
    private IO io;

    public UI() {
        io = new IO();
    }

    public void menuForAdmin() {
        String[] headers = {"Choose your action:"};
        String[][] data = {
                {"[1] Create new product category"},
                {"[2] Edit name of the product"},
                {"[3] Deactivate product"},
                {"[4] Delete product"},
                {"[5] Create new product"},
                {"[6] Edit product"},
                {"[7] Give a discount"},
                {"[8] Status of orders"},
                {"[9] See feedback and statistics"},
                {"[10] See all products"}
        };
        System.out.println(FlipTable.of(headers, data));
    }

    public void menuForUser() {
        String[] headers = {"Choose your action:"};
        String[][] data = {
                {"[1] Add product to basket"},
                {"[2] Edit product quantity in my basket"},
                {"[3] Remove product from basket"},
                {"[4] See your basket"},
                {"[5] Place a order"},
                {"[6] See your history of orders"},
                {"[7] Rate product"},
                {"[8] See all products"}
        };
        System.out.println(FlipTable.of(headers, data));
    }

    public void displayBikes() throws SQLException {

        String[] header = {"Our products"};
        String[][] data = {{bikeIterator.next().toString()}};
        System.out.println(FlipTable.of(header, data));
    }

    public void displayBasket() throws SQLException {
        String[] header = {"Your Basket"};
        String[][] data = {{basketIterator.next().toString()}};
        System.out.println(FlipTable.of(header, data));
        }


    public void menuForLoginOrRegister() {
        String[] headers = {"Welcome to BikeShop!"};
        String[][] data ={
                {"(1) Login"},
                {"(2) Register"}
        };
        System.out.println(FlipTable.of(headers, data));
    }

    public void menuForUserOrAdmin() {
        String[] headers = {"LOG IN AS"};
        String[][] data = {{"(1) Admin"}, {"(2) User"}};
        System.out.println(FlipTable.of(headers, data));
    }

    public void registerMenu() {
        String[] headers = {"REGISTER AS"};
        String[][] data = {{"(1) Admin"}, {"(2) Customer"}};
        System.out.println(FlipTable.of(headers, data));
    }

    public String gatherInput(String message) {
        return io.gatherInput(message);
    }
}