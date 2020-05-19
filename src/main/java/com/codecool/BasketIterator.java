package com.codecool;

import com.codecool.models.Basket;
import java.util.Iterator;

public class BasketIterator implements Iterator<Basket> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Basket next() {
        return null;
    }

    @Override
    public void remove() { }
}
