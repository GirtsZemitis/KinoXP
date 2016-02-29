package com.KinoXP.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Girts Zemitis on 25/02/2016.
 * https://github.com/GirtsZemitis
 */
public class EditMovieViewModel {
    private Connection conn = LoginViewModel.conn;


    public ResultSet getMovie(String title) {
        String out = "";
        try {
            String query = "SELECT * FROM Movie WHERE title=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, title);
            ResultSet results = preparedStatement.executeQuery();
            return results;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //METHOD FOR EDITING THE MOVIE TITLE
    public String editTitle(String title, String editTitle) {
        String sql = "UPDATE Movie SET title=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, editTitle);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return editTitle;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //METHOD FOR EDITING THE PLAYING TIME OF THE MOVIE
    public int editPlayingInMinutes(String title, int editPlayingInMinutes) {
        String sql = "UPDATE Movie SET playingTimeMin=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, editPlayingInMinutes);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return editPlayingInMinutes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //METHOD FOR EDITING THE RELEASE YEAR OF THE MOVIE
    public String editReleaseYear(String title, String releaseYear) {
        String sql = "UPDATE Movie SET releaseYear=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, releaseYear);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return releaseYear;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //METHOD FOR EDITING THE PLOT OF THE MOVIE
    public String editPlot(String title, String plot) {
        String sql = "UPDATE Movie SET plot=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, plot);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return plot;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //METHOD FOR EDITING THE MOVIE THEATER
    public String editMovieTheater(String title, String movieTheaterName) {
        String sql = "UPDATE Movie SET theatreName=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, movieTheaterName);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return movieTheaterName;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //METHOD FOR EDITING THE DIRECTOR OF THE MOVIE
    public String editDirector(String title, String editedDirector) {
        String sql = "UPDATE Movie SET director=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, editedDirector);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return editedDirector;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //METHOD FOR EDITING THE POSTER OF THE MOVIE
    public String editPoster(String title, String editedPosterPath) {
        String sql = "UPDATE Movie SET posterPath=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, editedPosterPath);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return editedPosterPath;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //METHOD FOR EDITING THE CAST OF THE MOVIE
    public String editMainActor(String title, String editedMainActor) {
        String sql = "UPDATE Movie SET mainActor=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, editedMainActor);
            preparedStatement.setString(2, title);
            preparedStatement.executeUpdate();
            return editedMainActor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String editGenre(String titleTxtText, String genreInput) {
        String sql = "UPDATE Movie SET genre=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, genreInput);
            preparedStatement.setString(2, titleTxtText);
            preparedStatement.executeUpdate();
            return genreInput;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String editAgeLimit(String titleTxtText, String ageLimitInput) {
        String sql = "UPDATE Movie SET ageLimit=? WHERE title = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, ageLimitInput);
            preparedStatement.setString(2, titleTxtText);
            preparedStatement.executeUpdate();
            return ageLimitInput;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


