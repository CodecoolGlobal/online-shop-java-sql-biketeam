package com.codecool.dao;

import com.codecool.models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends Dao {

    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        connect();

        try {
            ResultSet results = statement.executeQuery("SELECT * FROM Customer;");
            while (results.next()) {
                int id = results.getInt("Customer_ID");
                String login = results.getString("Login");
                String password = results.getString("Password");
                Customer user = new Customer(id, login, password);
                customers.add(user);
            }
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
}