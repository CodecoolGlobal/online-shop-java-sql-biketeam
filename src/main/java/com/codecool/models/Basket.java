package com.codecool.models;

public class Basket {
    private int basketId;
    private int bikeId;
    private int customerId;
    private String bikeName;
    private String color;
    private int quantity;

    public Basket(int basketId, int bikeId, int customerId, String bikeName, String color, int quantity) {
        this.basketId = basketId;
        this.bikeId =  bikeId;
        this.customerId = customerId;
        this.bikeName = bikeName;
        this.color = color;
        this.quantity = quantity;
    }

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName)  {
        this.bikeName = bikeName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
