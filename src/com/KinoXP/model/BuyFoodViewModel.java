package com.KinoXP.model;

import com.KinoXP.controller.BuyFoodViewController;
import com.KinoXP.view.LoginView;
import com.sun.corba.se.spi.orbutil.fsm.Guard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by MazurJestBoski on 2016-03-05.
 */
public class BuyFoodViewModel {

    Connection conn = LoginViewModel.conn;
    BuyFoodViewController buyFoodViewController = new BuyFoodViewController();

    public void setFoodToDB(String phoneNumber) {
        ResultSet resultSet = null;
        int sSodaCount = buyFoodViewController.getsSodaCount();
        int lSodaCount = buyFoodViewController.getLSodaCount();
        int sCandyCount = buyFoodViewController.getsCandyCount();
        int lCandyCount = buyFoodViewController.getLCandyCount();

        String query;
        query = "INSERT into drinkSnacks VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, phoneNumber);
            preparedStatement.setInt(2, sCandyCount);
            preparedStatement.setInt(3, lCandyCount);
            preparedStatement.setInt(4, sSodaCount);
            preparedStatement.setInt(5, lSodaCount);
            preparedStatement.executeUpdate();

            System.out.println("snaki dodane łośki! ");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
