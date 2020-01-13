package com.company.controller;

import com.company.model.Shop;
import com.company.model.Cleaner;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ControllerImpl implements Controller {
    private Shop shop;

    public ControllerImpl() {
        shop = new Shop();
    }

    @Override
    public void goToTheNewShop() {
        shop = new Shop();
    }

    @Override
    public List getShopProducts() {
        return shop.getCleaners();
    }

    @Override
    public List sortSelectedCleaners(int type) {
        List<Cleaner> selected_cleaners = new LinkedList<Cleaner>();
        selected_cleaners = shop.selectCleaners(type);
        Collections.sort(selected_cleaners);
        return selected_cleaners;
    }
}
