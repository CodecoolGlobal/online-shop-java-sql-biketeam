package com.codecool.patterns;

import com.codecool.dao.BasketDao;
import com.codecool.models.Basket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BasketIterator implements Iterator<List<Basket>> {

    private List<Basket> basketList = new ArrayList<Basket>();
    BasketDao basket = new BasketDao();
    Iterator<Basket> iterator = basket.getBasket().iterator();

    @Override
    public boolean hasNext() {
        return basketList.size() < basket.getBasket().size();
    }

    @Override
    public List<Basket> next() {
        while (iterator.hasNext()) {
            basketList.add(iterator.next());
        }
        return basketList;
    }


}
