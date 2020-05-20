package com.codecool.models;

public class Basket {

    private String bikeName;
    private String color;
    private int quantity;

    public Basket(String bikeName, String color, int quantity) {

        this.bikeName = bikeName;
        this.color = color;
        this.quantity = quantity;
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
