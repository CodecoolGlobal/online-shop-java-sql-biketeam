package com.codecool.models;

public class Basket {

    private int basketID;
    private int bikeID;
    private int customerID;
    private String bikeName;

    public Basket(int basketID, int bikeID, int customerID, String bikeName) {

        this.basketID = basketID;
        this.bikeID = bikeID;
        this.customerID = customerID;
        this.bikeName = bikeName;
    }


    public int getBasketID() {
        return basketID;
    }

    public void setBasketID(int basketID)  {
        this.basketID = basketID;
    }

    public int getBikeID() {
        return bikeID;
    }

    public void setBikeID(int bikeID) {
        this.bikeID = bikeID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getBikeName() {
        return this.bikeName;
    }
    public String toString() {
        int ID = getBikeID();
        String bikeBrand = getBikeName();
        String format = String.format(" [%d] | Your future bike is: '%s",
                ID, bikeBrand);
        return format;
    }

}