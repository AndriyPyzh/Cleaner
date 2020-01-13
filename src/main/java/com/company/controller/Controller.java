package com.company.controller;

import java.util.List;

public interface Controller {
    void goToTheNewShop();
    List getShopProducts();
    List sortSelectedCleaners(int type);
}
