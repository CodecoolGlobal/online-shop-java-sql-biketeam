package com.codecool.patterns;

import com.codecool.dao.BikeDao;
import com.codecool.models.Bike;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BikeIterator implements Iterator<List<Bike>> {

    private List<Bike> bikeList = new ArrayList<>();
    BikeDao bike = new BikeDao();
    Iterator<Bike> iterator = bike.getBikes().iterator();

    @Override
    public boolean hasNext() {
        return bikeList.size() < bike.getBikes().size();
    }

    @Override
    public List<Bike> next() {
        while (iterator.hasNext()) {
            bikeList.add(iterator.next());
        }
        return bikeList;
    }
}
