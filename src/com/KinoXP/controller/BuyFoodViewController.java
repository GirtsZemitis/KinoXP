package com.KinoXP.controller;

import com.KinoXP.model.BuyFoodViewModel;

/**
 * Created by MazurJestBoski on 2016-03-05.
 */
public class BuyFoodViewController {
    BuyFoodViewModel buyFoodViewModel = new BuyFoodViewModel();

    public void insertFood(int phonenumber, int sCandyCount, int lCandyCount, int sSodaCount, int lSodaCount){

        buyFoodViewModel.setFoodToDB(phonenumber ,sCandyCount,lCandyCount,sSodaCount, lSodaCount);
    }

}
