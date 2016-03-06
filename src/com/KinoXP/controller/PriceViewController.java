package com.KinoXP.controller;

import com.KinoXP.model.ExtrasModel;
import com.KinoXP.model.LoginViewModel;
import com.KinoXP.model.PriceViewModel;

import java.sql.Connection;

/**
 * Created by Monica on 06-03-2016.
 */
public class PriceViewController {
    PriceViewModel priceViewModel = new PriceViewModel();
    LoginViewModel loginViewModel = new LoginViewModel();
    Connection conn = LoginViewModel.conn;


    public ExtrasModel getPrice(String type){

        ExtrasModel extra = new ExtrasModel(priceViewModel.retrievePricesOfExtras("Soda").getCategory(),
                priceViewModel.retrievePricesOfExtras("Soda").getLargePrice(),
                priceViewModel.retrievePricesOfExtras("Soda").getSmallPrice());
        return extra;
    }
}