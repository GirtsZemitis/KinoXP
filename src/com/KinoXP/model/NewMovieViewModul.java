package com.KinoXP.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by quena on 25-02-2016.
 */

public class NewMovieViewModul {

    Connection conn;

    public String getActorFromDatabase(String mainActor) {
        String out = "";
        try {
            String query = " SELECT title FROM Movie WHERE mainActor=? ";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, mainActor);
            ResultSet results = preparedStatement.executeQuery();

            if (results.next()) {
                out = results.getString(1);
            } else {
                out = "";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }
}
