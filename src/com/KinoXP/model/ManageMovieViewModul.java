package com.KinoXP.model;

import java.sql.*;

/**
 * Created by Girts Zemitis on 25/02/2016.
 * https://github.com/GirtsZemitis
 */
public class ManageMovieViewModul {
    private Connection conn = null;


    /**
     * Database Model that creates connection with the MySQL server
     * when it is instantiated.
     */

    //THE CONNECTION
    public ManageMovieViewModul() {

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

    //METHOD FOR GETTING THE TITLE FROM DATABASE
    public String getTitle(String title){
        String out = "";
        try {
            String sql = "SELECT title FROM Movie WHERE title=?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, title);
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

    //METHOD FOR GETTING THE PLAYING TIME OF THE FILM FROM DATABASE
    public String getPlayingTimeInMinutes(String playingTimeInMinutes) {
        String out = "";
        try {
            String query = "SELECT playingTimeMin FROM Movie WHERE playingTimeMin=?";

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, playingTimeInMinutes);
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

    //METHOD FOR GETTING THE RELEASE YEAR FROM DATABASE
    public String getReleaseYear(String releaseYear) {
        String out = "";
        try {
            String query = "SELECT releaseYear FROM Movie WHERE releaseYear=?";

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, releaseYear);
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

    //METHOD FOR GETTING THE PLOT FROM DATABASE
    public String getPlot(String plot) {
        String out = "";
        try {
            String query = "SELECT plot FROM Movie WHERE plot=?";

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, plot);
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

    //METHOD FOR GETTING THE DIRECTOR FROM DATABASE
    public String getDirector(String director) {
        String out = "";
        try {
            String query = "SELECT director FROM Movie WHERE director=?";

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, director);
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

    //METHOD FOR GETTING THE POSTER PATH FROM DATABASE
    public String getPosterPath(String posterPath) {
        String out = "";
        try {
            String query = "SELECT posterPath FROM Movie WHERE posterPath=?";

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, posterPath);
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

    //METHOD FOR GETTING THE MAIN ACTOR FROM DATABASE
    public String getMainActor(String mainActor) {
        String out = "";
        try {
            String query = "SELECT mainActor FROM Movie WHERE mainActor=?";

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

    //METHOD FOR GETTING THE THEATER NAME FROM DATABASE
    public String getTheatreName(String theatreName) {
        String out = "";
        try {
            String query = "SELECT theatreName FROM Movie WHERE theatreName=?";

            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, theatreName);
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


