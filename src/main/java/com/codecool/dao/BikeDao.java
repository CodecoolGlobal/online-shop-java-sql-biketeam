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
                int price = results.getInt("Price");

                Bike bike = new Bike(id, brand, type, colour, supplies, price);
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

    public void addBike(String brand, String type, String colour, int howMany, int price ) {
        connect();

        try {
            statement.executeUpdate("INSERT INTO Bike (Brand, Type, Colour, In_Stock, Price)" +
                    String.format("VALUES ('%s', '%s', '%s', '%d', %d)", brand, type, colour, howMany, price));
            statement.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removeBike(String brand, int howMany) {
        connect();

        try {
            ResultSet results = statement.executeQuery(String.format("SELECT * FROM Bike WHERE Brand IN ('%s')", brand));
            int updatedSupplies = results.getInt("In_Stock") - howMany;
            statement.executeUpdate(String.format("UPDATE Bike SET In_Stock = %d WHERE Brand = '%s'", updatedSupplies, brand));
            if (updatedSupplies == 0) {
                statement.executeUpdate(String.format("DELETE FROM Bike WHERE Brand='%s'", brand));
            }
            statement.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}