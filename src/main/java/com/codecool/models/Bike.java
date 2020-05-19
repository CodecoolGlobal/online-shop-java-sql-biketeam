package com.codecool.models;

public class Bike {

    private int id;
    private String brand;
    private String type;
    private String color;
    private int inStock;
    private int price;

    public Bike(int id, String brand, String type, String color, int inStock, int price) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.color = color;
        this.inStock = inStock;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int bikeId) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getInStock() {
        return this.inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
    
    public int getPrice() { return this.price;}
    
    public void setPrice(int price) { price = this.price;}
}