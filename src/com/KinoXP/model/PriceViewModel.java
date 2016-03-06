package com.KinoXP.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

    /**
     * Created by Monica on 06-03-2016.
     */
    public class PriceViewModel {
        ExtrasModel extras;
        LoginViewModel loginViewModel;
        Connection conn = LoginViewModel.conn;

        public ExtrasModel retrievePricesOfExtras(String type){

            try {
                String query = "SELECT * FROM Extras WHERE Type=?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1,type);
                ResultSet results = preparedStatement.executeQuery();
                if(results.next()) {
                    ExtrasModel extras = new ExtrasModel(results.getString(1), results.getInt(2), results.getInt(3));
                    return  extras;
                }
            }catch (Exception e){
                System.out.println("Couldn't retrieve extras from db!");
            }
            return null;
        }


    }


