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
    public AddMovieFormModul() {

        try {
            String DB_URL = "jdbc:mysql://localhost/tableBook";
            String USER = "root";
            String PASS = "root";
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("connmod obj created" + conn + " message: ");

        } catch (SQLException e) {
            System.out.println("dbsss error Bitches!!" + e.getMessage());
        }
    }


    //METHOD FOR EDITING THE MOVIE TITLE
    public String editTitle(String title, String editTitle) {
        String sql = "UPDATE movie SET title=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, editTitle);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return editTitle;
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return null;
    }

    //METHOD FOR EDITING THE PLAYING TIME OF THE MOVIE
    public int editPlayingInMinutes(String title, int editPlayingInMinutes) {
        String sql = "UPDATE movie SET playingTimeMin=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, editPlayingInMinutes);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return editPlayingInMinutes;
        } catch (SQLException e) {
            System.out.println("Database_Controller error");
        }
        return -1;
    }

    //METHOD FOR EDITING THE RELEASE YEAR OF THE MOVIE
    public String editReleaseYear(String title, String releaseYear) {
        String sql = "UPDATE movie SET releaseYear=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, releaseYear);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return releaseYear;
        } catch (SQLException e) {
            System.out.println("Database_Controller error");
        }
        return null;
    }

    //METHOD FOR EDITING THE PLOT OF THE MOVIE
    public String editPlot(String title, String plot) {
        String sql = "UPDATE movie SET plot=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, plot);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return plot;
        } catch (SQLException e) {
            System.out.println("Database_Controller error");
        }
        return null;
    }

    //METHOD FOR EDITING THE MOVIE THEATER
    public String editMovieTheater(String title, String movieTheaterName) {
        String sql = "UPDATE movie SET theatreName=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, movieTheaterName);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return movieTheaterName;
        } catch (SQLException e) {
            System.out.println("Database_Controller error");
        }
        return null;
    }

    //METHOD FOR EDITING THE DIRECTOR OF THE MOVIE
    public String editDirector(String title, String editedDirector) {
        String sql = "UPDATE movie SET director=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, editedDirector);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return editedDirector;
        } catch (SQLException e) {
            System.out.println("Database_Controller error");
        }
        return null;
    }

    //METHOD FOR EDITING THE POSTER OF THE MOVIE
    public String editPoster(String title, String editedPosterPath) {
        String sql = "UPDATE movie SET posterPath=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, editedPosterPath);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return editedPosterPath;
        } catch (SQLException e) {
            System.out.println("Database_Controller error");
        }
        return null;
    }

    //METHOD FOR EDITING THE CAST OF THE MOVIE
    public String editMainActor(String title, String editedMainActor) {
        String sql = "UPDATE movie SET mainActor=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, editedMainActor);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return editedMainActor;
        } catch (SQLException e) {
            System.out.println("Database_Controller error");
        }
        return null;
    }
}
