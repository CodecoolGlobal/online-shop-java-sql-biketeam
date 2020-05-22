package com.codecool.dao;

import com.codecool.models.Bike;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BikeDao extends Dao {
    List<Bike> bikes = new ArrayList<>();

    public List<Bike> getBikes() {

        connect();

        try {
            boolean isAvailable;
            ResultSet results = statement.executeQuery("SELECT * FROM Bike;");
            while (results.next()) {
                int id = results.getInt("Bike_ID");
                String brand = results.getString("Brand");
                String type = results.getString("Type");
                String colour = results.getString("Colour");
                int supplies = results.getInt("In_Stock");
                int price = results.getInt("Price");
                String isItAvailable = results.getString("Is_Available");
                if (isItAvailable.equals("Available")){
                   isAvailable = true;
                }
                else {isAvailable = false;}

                Bike bike = new Bike(id, brand, type, colour, supplies, price, isAvailable);
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

    public void createBike(String brand, String type, String colour, int howMany, int price) {
        connect();

        try {

            statement.executeUpdate("INSERT INTO Bike (Brand, Type, Colour, In_Stock, Price, Is_Available)" +
                    String.format("VALUES ('%s', '%s', '%s', '%d', %d, 'Available')", brand, type, colour, howMany, price));
            statement.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateAmountBike(String brand, int howMany) {
        connect();

        try {
            ResultSet results = statement.executeQuery(String.format("SELECT * FROM Bike WHERE Brand IN ('%s')", brand));
            int updatedSupplies = results.getInt("In_Stock") + howMany;
            if(updatedSupplies < 0){
                System.out.println("Error: You can not do that");
            }
            else if (updatedSupplies == 0) {
                statement.executeUpdate(String.format("UPDATE Bike SET In_Stock = %d WHERE Brand = '%s'", updatedSupplies, brand));
                statement.executeUpdate(String.format("UPDATE Bike SET Is_Available = 'Not Available' WHERE Brand = '%s'",brand));
            }
            else {
                statement.executeUpdate(String.format("UPDATE Bike SET In_Stock = %d WHERE Brand = '%s'", updatedSupplies, brand));
                statement.executeUpdate(String.format("UPDATE Bike SET Is_Available = 'Available' WHERE Brand = '%s'",brand));}

            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteBikes(String brand){
        connect();
        try{
            statement.executeUpdate(String.format("DELETE FROM Bike WHERE Brand = '%s'", brand));
            statement.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void changeBrand(String currentBrand, String futureBrand) {
        connect();
        try {
            statement.executeUpdate(String.format("UPDATE Bike SET Brand = '%s' WHERE Brand = '%s'", futureBrand, currentBrand));
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changePrice(String currentBrand, int futurePrice) {
        connect();
        try {
            statement.executeUpdate(String.format("UPDATE Bike SET Price = %d WHERE Brand = '%s'", futurePrice, currentBrand));
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setActive(String brand, Boolean active ) {
        connect();
        try {
        if (active) {
            statement.executeUpdate(String.format("UPDATE Bike SET Is_Available = 'Available' WHERE Brand = '%s'", brand));
        } else if (!(active)) {
            statement.executeUpdate(String.format("UPDATE Bike SET Is_Available = 'Not Available' WHERE Brand = '%s'", brand));
        } } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Bike> getBikesByCategory(String category) {
        List<Bike> bikes = new ArrayList<>();
        connect();
        try {
            boolean isAvailable;
            ResultSet results = statement.executeQuery(String.format("SELECT * FROM Bike WHERE Type='%s';",category));
            while (results.next()) {
                int id = results.getInt("Bike_ID");
                String brand = results.getString("Brand");
                String type = results.getString("Type");
                String colour = results.getString("Colour");
                int supplies = results.getInt("In_Stock");
                int price = results.getInt("Price");
                String isItAvailable = results.getString("Is_Available");
                if (isItAvailable.equals("Available")) {
                    isAvailable = true;
                } else {
                    isAvailable = false;
                }

                Bike bike = new Bike(id, brand, type, colour, supplies, price, isAvailable);
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