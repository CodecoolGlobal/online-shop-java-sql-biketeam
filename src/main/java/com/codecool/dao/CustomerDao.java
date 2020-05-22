package com.codecool.dao;

import com.codecool.CustomerProvider;
import com.codecool.UI;
import com.codecool.models.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao extends Dao {
    UI print = new UI();
    CustomerProvider customerProvider = new CustomerProvider();

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

    public void registerCustomer(String login, String password) {
        String query = "INSERT INTO Customer (Login, Password)" + String.format("VALUES ('%s', '%s')", login, password);
        connect();
        try {
            statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loginCustomer(String login, String password) {
        String query = "SELECT COUNT(*) FROM Customer WHERE Login LIKE '" + login + "'AND Password LIKE '" + password + "'";
        connect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    boolean found = resultSet.getBoolean(1);
                    if (found) {
                        System.out.println("access accepted");
                        customerProvider.customerMenu();
                    } else {
                        System.out.println("access denied");
                        found = false;
                    }
                }
            }
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}