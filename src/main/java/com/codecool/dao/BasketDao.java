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
            ResultSet result = statement.executeQuery("SELECT * FROM Basket INNER JOIN Bike on Basket.Bike_ID=Bike.Bike_ID");
            while (result.next()) {
                int basketID = result.getInt("Basket_ID");
                int bikeID = result.getInt("Bike_ID");
                int customerID = result.getInt("Customer_ID");
                String bikeName = result.getString("Brand");
                Basket userBasket = new Basket(basketID, bikeID, customerID, bikeName);
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

    public void addNewProduct(int bikeID, int customerID) {
        connect();
        try {
            statement.executeUpdate("INSERT INTO Basket (Bike_ID, Customer_ID)" +
                    String.format("VALUES (%d, %d)", bikeID, customerID));
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteFromBasket(int bikeID) {
        connect();
        try {
            statement.executeUpdate(String.format("DELETE FROM Basket WHERE Bike_ID ='%d'", bikeID));
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

    public void clearBasket() {
        connect();
        try {
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