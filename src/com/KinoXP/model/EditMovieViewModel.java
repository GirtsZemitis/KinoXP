package com.KinoXP.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by hartyandi on 2/25/16.
 */
public class EditMovieViewModel {

    //connection pinned to LoginViewModel
    private Connection conn = LoginViewModel.conn;


    public String editTitle(String title, String editTitle) {
        String sql = "UPDATE Movie SET title=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, editTitle);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return editTitle;
        } catch (SQLException e) {
            System.out.println("Database_Controller error");
        }
        return null;
    }

    public int editPlayingInMinutes(String title, int editPlayingInMinutes) {
        String sql = "UPDATE Movie SET playingTimeMin=? WHERE title = ?";
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

    public String editReleaseYear(String title, String releaseYear) {
        String sql = "UPDATE Movie SET releaseYear=? WHERE title = ?";
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

    public String editPlot(String title, String plot) {
        String sql = "UPDATE Movie SET plot=? WHERE title = ?";
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

    public String editMovieTheater(String title, String moveiTheaterName) {
        String sql = "UPDATE Movie SET theatreName=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, moveiTheaterName);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return moveiTheaterName;
        } catch (SQLException e) {
            System.out.println("Database_Controller error");
        }
        return null;
    }


    public String editDirector(String title, String editedDirector) {
        String sql = "UPDATE Movie SET director=? WHERE title = ?";
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

    public String editPoster(String title, String editedPosterPath) {
        String sql = "UPDATE Movie SET posterPath=? WHERE title = ?";
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

    public String editMainActor(String title, String editedMainActor) {
        String sql = "UPDATE Movie SET mainActor=? WHERE title = ?";
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
