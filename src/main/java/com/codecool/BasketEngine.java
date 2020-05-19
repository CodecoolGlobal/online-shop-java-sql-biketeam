package com.codecool;

import com.codecool.models.Basket;
import com.codecool.models.Bike;
import java.util.ArrayList;
import java.util.Iterator;

public class BasketEngine {

    private int basketId;
    Iterator<Basket> basketIter;
    ArrayList<Bike> listOfProducts;

    public BasketEngine(int basketId) {
        this.basketId = basketId;
    }

    public int getBasketId() {
        return basketId;
    }


}
