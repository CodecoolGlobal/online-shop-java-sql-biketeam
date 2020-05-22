package com.codecool.dao;

import com.codecool.models.Basket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BasketDao extends Dao {
    List<Basket> basket = new ArrayList<>();

    public List<Basket> getBasket() {
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

    public void deleteFromBasket(int bikeID) {
        connect();
        try {
            statement.executeUpdate(String.format("DELETE FROM Basket WHERE Bike_ID='%d'", bikeID));
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

    public void order(String street, String city, int number) {
        connect();
        try {
            statement.executeUpdate(String.format("INSERT INTO Customer_Data (Street, City, Phone_Num) " +
                    String.format("VALUES ('%s', '%s', '%d')", street, city, number)));
            statement.executeUpdate("DELETE FROM Basket");
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void basketToOrder() {
        connect();
        try {
            statement.executeQuery("INSERT INTO Order SELECT Bike_Name, Color, Quantity FROM Basket");
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}