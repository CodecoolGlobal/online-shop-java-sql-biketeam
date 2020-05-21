package com.codecool.models;

public class Category {

    int ID;
    String category;

    public Category(int ID, String category){
        this.ID = ID;
        this.category = category;
    }

    public int getID() {
        return this.ID;
    }
    public String getCategory() {
        return this.category;
    }

}
