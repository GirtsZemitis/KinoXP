package com.KinoXP.model;

import java.sql.*;

/**
 * Created by Paula on 26-02-2016.
 */
public class AddMovieFormViewModul {
    private static Connection conn;
    private static String url ;
    private static String user;
    private static String pass;

    //CONSTRUCTOR
    public AddMovieFormViewModul() {
        try {
            String DB_URL = "jdbc:mysql://sql2.freesqldatabase.com:3306/sql2108018";
            String USER = "sql2108018";
            String PASS = "nP5%zC6%";
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("conn obj created in AddMovieFormViewModul: " + conn + " message: ");
        } catch (SQLException e) {
            System.out.println("db error" + e.getMessage());
        }
    }

    //METHOD FOR CONNECTING WITH THE DATABASE
    public static Connection connect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException cnfe) {
            System.err.println("Error: " + cnfe.getMessage());
        } catch (InstantiationException ie) {
            System.err.println("Error: " + ie.getMessage());
        } catch (IllegalAccessException iae) {
            System.err.println("Error: " + iae.getMessage());
        }

        conn = DriverManager.getConnection(url, user, pass);
        return conn;
    }

    //METHOD FOR INSERTING THE MOVIE INTO THE DATABASE
    public void insertMovie(String title, String playingTimeInMinutes, String year, String plot, String director,
                            String posterPath, String cast, String theatreName, String genre, String ageLimit) {
        String sql = "INSERT INTO Movie VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, playingTimeInMinutes);
            preparedStatement.setString(3, year);
            preparedStatement.setString(4, plot);
            preparedStatement.setString(5, director);
            preparedStatement.setString(6, posterPath);
            preparedStatement.setString(7, cast);
            preparedStatement.setString(8, theatreName);
            preparedStatement.setString(9, genre);
            preparedStatement.setString(10, ageLimit);

            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("New title was successfully added to the database: " + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //METHOD USED FOR TESTING THE CLASS
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