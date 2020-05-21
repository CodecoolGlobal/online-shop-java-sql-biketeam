package com.codecool.dao;

import com.codecool.models.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends Dao {

    public List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();
        connect();
        try {
            ResultSet result = statement.executeQuery("SELECT * FROM Order ");
            while (result.next()) {
                int id = result.getInt("Order_ID");
                int customerID = result.getInt("Customer_ID");
                int bikeID = result.getInt("Bike_ID");

                Order order = new Order(id, customerID, bikeID);
                orders.add(order);
            }
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return orders;
    }

    public void createOrder(int customerID, int bikeID) {
        connect();
        try {
            statement.executeUpdate(String.format("INSERT INTO Order (Bike_ID, Customer_ID) VALUES (%d,%d)", customerID, bikeID));
            statement.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}