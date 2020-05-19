package com.codecool;
import com.codecool.models.Bike;
import java.util.Iterator;

public class ProductIterator implements Iterator<Bike> {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Bike next() {
        return null;
    }
}
