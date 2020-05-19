package com.codecool.models;

public class Basket {

    private int basketId;
    private int bikeId;
    private int customerId;

    public Basket(int basketId, int bikeId, int customerId) {
        this.basketId = basketId;
        this.bikeId =  bikeId;
        this.customerId = customerId;
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
}
