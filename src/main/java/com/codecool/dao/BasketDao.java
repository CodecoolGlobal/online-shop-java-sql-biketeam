package com.codecool.dao;

import com.codecool.models.Basket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasketDao extends Dao {

    public List<Basket> getBasket() {
        List<Basket> basket = new ArrayList<>();
        connect();

        try {
            ResultSet result = statement.executeQuery("SELECT * FROM basket;");
            while (result.next()) {
                int basketId = result.getInt("Basket_ID");
                int bikeId = result.getInt("Bike_ID");
                int customerId = result.getInt("Customer_ID");
                String bikeName = result.getString("Bike_Name");
                String color = result.getString("Color");
                int quantity = result.getInt("Quantity");

                Basket userBasket = new Basket(basketId, bikeId, customerId, bikeName, color, quantity);
                basket.add(userBasket);
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return basket;
    }
}
