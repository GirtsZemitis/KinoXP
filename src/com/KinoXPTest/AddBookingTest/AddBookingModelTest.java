package com.KinoXPTest.AddBookingTest;

import com.KinoXP.model.EditMovieViewModel;
import com.KinoXP.model.LoginViewModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Girts Zemitis on 01/03/2016.
 * https://github.com/GirtsZemitis
 */
public class AddBookingModelTest {

    @org.junit.Test
    public void testAddBooking() {


        LoginViewModel viewModel = new LoginViewModel();
        viewModel.connectToDatabase();
        EditMovieViewModel emvController = new EditMovieViewModel();
        // String DB_URL = "jdbc:mysql://localhost/testkinoxp";
        String DB_URL = "jdbc:mysql://localhost/testkinoxp";
        String USER = "root";
        String PASS = "root";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO movie (title, playingTimeMin, releaseYear, plot, director, posterPath, mainActor, theatreName) VALUES (?,?,?,?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Title");
            ps.setInt(2, 60);
            ps.setString(3, "releaseYear");
            ps.setString(4, "plott");
            ps.setString(5, "director");
            ps.setString(6, "posterPath");
            ps.setString(7, "main Actor");
            ps.setString(8, "theathe name");
            ps.execute();
            ps.close();}
        catch (SQLException e) {
            e.printStackTrace();
        }

        String editTitle = emvController.editTitle("Title", "EditedTitle");
        //assertNotNull(editTitle);
        //assertEquals("EditedTitle", editTitle);




        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "DELETE FROM movie WHERE 1;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            ps.close();}
        catch (SQLException e) {
            e.printStackTrace();
        }

    }




}

