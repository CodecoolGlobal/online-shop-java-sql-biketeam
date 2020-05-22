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
            ResultSet result = statement.executeQuery("SELECT * FROM Ordeer INNER JOIN Status ON Ordeer.Status_ID=Status.Status_ID;");
            while (result.next()) {
                int id = result.getInt("Ord_ID");
                int customerID = result.getInt("Customer_ID");
                int bikeID = result.getInt("Bike_ID");
                String date = result.getString("Date");
                String status = result.getString("Ord_Status");

                Order order = new Order(id, customerID, bikeID, date, status);
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

    public void createOrder(int customerID, int bikeID, String date, int statusID) {
        connect();
        try {
            statement.executeUpdate(String.format("INSERT INTO Ordeer (Customer_ID, Bike_ID, Date, Status_ID) VALUES (%d, %d, '%s', %d);", customerID, bikeID, date, statusID));
            statement.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void changeStatus(int statusID, int ordID){
        connect();
        try {
            statement.executeUpdate(String.format("UPDATE Ordeer SET Status_ID = %d WHERE Ord_ID = %d", statusID, ordID));
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}