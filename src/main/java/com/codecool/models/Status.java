package com.codecool.models;

public class Status {

    int statusID;
    String ordStatus;

    public Status(int id, String status){
        this.statusID = id;
        this.ordStatus = status;
    }

    public int getStatusID() {
        return this.statusID;
    }
    public String getOrdStatus() {
        return this.ordStatus;
    }

}