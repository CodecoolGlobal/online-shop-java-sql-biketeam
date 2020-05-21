package com.codecool;

import com.codecool.dao.BasketDao;
import com.codecool.dao.Dao;
import com.codecool.patterns.BasketIterable;
import com.codecool.patterns.BasketIterator;
import com.jakewharton.fliptables.FlipTable;
import com.jakewharton.fliptables.FlipTableConverters;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UI extends Dao {
    BasketDao basketDao = new BasketDao();
    BasketIterator basketIterator = new BasketIterator();
    BasketIterable basketIterable = new BasketIterable();


    public static void login() {
        String[] headers = {"Welcome to our store!"};
        String[][] data = {
                {"Please enter your login and password :"}
        };
        System.out.println(FlipTable.of(headers, data));

    }

    public static void menuForAdmin() {
        String[] headers = {"Hello Master what you want to do ?"};
        String[][] data = {
                {"[1] Create new product category"},
                {"[2] Edit name of the product"},
                {"[3] Deactivate product"},
                {"[4] Delete product"},
                {"[5] Create new product"},
                {"[6] Edit product"},
                {"[7] Give a discount"},
                {"[8] Status of orders"},
                {"[9] See feedback and statistics"}
        };
        System.out.println(FlipTable.of(headers, data));


    }

    public static void menuForUser() {
        String[] headers = {"Hello Customer what you want to do ?"};
        String[][] data = {
                {"[1] Add product to basket"},
                {"[2] Edit product quantity in my basket"},
                {"[3] Remove product from basket"},
                {"[4] See your basket"},
                {"[5] Place a order"},
                {"[6] See your history of orders"},
                {"[7] Rate product"}
        };
        System.out.println(FlipTable.of(headers, data));
    }

    public void displayBikes() throws SQLException {
        connect();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Bike;");
        System.out.println(FlipTableConverters.fromResultSet(resultSet));
    }

    public void seeBasket() {

            String[] header = {"Your Basket"};
            String[][] data = {{basketIterator.next().getBasket().toString()}};
            System.out.println(FlipTable.of(header, data));
        }
    }
