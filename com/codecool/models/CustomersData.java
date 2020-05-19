package com.codecool.models;

public class CustomersData {

    private int id;
    private String city;
    private String street;
    private int phoneNumber;

    public CustomersData(int id, String city, String street, int phoneNumber) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
