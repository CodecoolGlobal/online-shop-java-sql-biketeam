package com.codecool.models;

public class Order {

    private int orderId;
    private int customerId;
    private int bikeId;

    public Order(int orderId, int customerId, int bikeId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.bikeId = bikeId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }
}
