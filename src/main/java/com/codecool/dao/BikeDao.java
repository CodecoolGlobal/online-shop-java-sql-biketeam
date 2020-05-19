package com.codecool.dao;

import com.codecool.models.Bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BikeDao extends Dao {

    public List<Bike> getBikes() {
        List<Bike> bikes = new ArrayList<>();
        connect();

        try {
            ResultSet results = statement.executeQuery("SELECT * FROM Bike;");
            while (results.next()) {
                int id = results.getInt("Bike ID");
                String brand = results.getString("Brand");
                String type = results.getString("Type");
                String colour = results.getString("Colour");
                int supplies = results.getInt("In_Stock");

                Bike bike = new Bike(id, brand, type, colour, supplies);
                bikes.add(bike);
            }
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bikes;
    }
}