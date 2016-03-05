package com.KinoXP.controller;

import com.KinoXP.view.BuyFoodView;

/**
 * Created by MazurJestBoski on 2016-03-05.
 */
public class BuyFoodViewController {

    private BuyFoodView buyFoodView = new BuyFoodView();

    public Integer getsSodaCount() {
        return buyFoodView.getsSodaCount();
    }

    public Integer getLSodaCount() {
        return buyFoodView.getlSodaCount();
    }

    public Integer getsCandyCount() {
        return buyFoodView.getsCandyCount();
    }

    public Integer getLCandyCount() {
        return buyFoodView.getlCandyCount();
    }
}
