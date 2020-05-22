package com.codecool.patterns;

import com.codecool.dao.BikeDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BikeIterable implements Iterable<BikeDao> {

    List<BikeDao> list = new ArrayList<>();

    @Override
    public Iterator<BikeDao> iterator() {
        return this.list.iterator();
    }
}