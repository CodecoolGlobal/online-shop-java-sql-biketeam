package com.codecool.patterns;

import com.codecool.dao.BasketDao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BasketIterable implements Iterable<BasketDao> {

    private List<BasketDao> list = new ArrayList<>();

    @Override
    public Iterator<BasketDao> iterator() {
        return this.list.iterator();
    }
}