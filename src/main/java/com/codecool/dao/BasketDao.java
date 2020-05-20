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
            ResultSet result = statement.executeQuery("SELECT * FROM Basket;");
            while (result.next()) {
                String bikeName = result.getString("Bike_Name");
                String color = result.getString("Color");
                int quantity = result.getInt("Quantity");

                Basket userBasket = new Basket(bikeName, color, quantity);
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

    public void addToBasket(String bikeName, String color, int quantity) {
        connect();
        try {
            statement.executeUpdate("INSERT INTO Basket (Bike_Name, Color, Quantity)" +
                    String.format("VALUES ('%s', '%s', '%d')", bikeName, color, quantity));
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteFromBasket(String bikeName) {
        connect();
        try {
            statement.executeUpdate(String.format("DELETE FROM Basket WHERE Bike_Name='%s'", bikeName));
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateBasket(String bikeName, int quantity) {
        connect();
        try {
            statement.executeUpdate(String.format("UPDATE Basket SET Quantity='%d' WHERE Bike_Name='%s'", quantity, bikeName));
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
