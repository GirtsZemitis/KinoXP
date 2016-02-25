package com.KinoXP.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by quena on 26-02-2016.
 */
public class AddMovieFormModul {
    private Connection conn = null;


    /**
     * Database Model that creates connection with the MySQL server
     * when it is instantiated.
     */

    //THE CONNECTION
    public void writeToDB(String title, double duration, int releaseYear, String plot, String director, String posterPath, String mainActor, String theatreName, int ageLimit, String genre){
        String sql="INSERT INTO movie VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n";

        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setDouble(2, duration);
            preparedStatement.setInt(3, releaseYear);
            preparedStatement.setString(4, plot);
            preparedStatement.setString(5, director);
            preparedStatement.setString(6, posterPath);
            preparedStatement.setString(7, mainActor);
            preparedStatement.setString(8, theatreName);
            preparedStatement.setInt(9, ageLimit);
            preparedStatement.setString(10, genre);

            int numberOfRows= preparedStatement.executeUpdate();

            System.out.println("Completed insert. Number of rows affected:" + numberOfRows);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
