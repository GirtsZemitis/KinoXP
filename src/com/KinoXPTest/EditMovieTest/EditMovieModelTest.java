package com.KinoXPTest.EditMovieTest;

import com.KinoXP.model.LoginViewModel;
import com.KinoXP.model.EditMovieViewModel;
import com.KinoXP.model.MovieTheaterModel;
import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Girts Zemitis on 25/02/2016.
 * https://github.com/GirtsZemitis
 */
public class EditMovieModelTest extends TestCase {



    @org.junit.Test
    public void testManageMovie() {


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
        assertNotNull(editTitle);
        assertEquals("EditedTitle", editTitle);

        int playingTime = emvController.editPlayingInMinutes("EditedTitle", 200);
        assertNotNull(playingTime);
        assertEquals(200, playingTime);

        String releaseYear = emvController.editReleaseYear("EditedTitle", "EditedReleaseYear");
        assertNotNull(releaseYear);
        assertEquals("EditedReleaseYear", releaseYear);

        String plot = emvController.editPlot("EditedTitle", "EditedPlot");
        assertNotNull(plot);
        assertEquals("EditedPlot", plot);

        String director = emvController.editDirector("EditedTitle", "EditedDirector");
        assertNotNull(director);
        assertEquals("EditedDirector", director);

        String poster = emvController.editPoster("EditedTitle", "EditedPosterPath");
        assertNotNull(poster);
        assertEquals("EditedPosterPath", poster);

        String mainActor = emvController.editMainActor("EditedTitle", "EditedMainActor");
        assertNotNull(mainActor);
        assertEquals("EditedMainActor", mainActor);


        MovieTheaterModel editedMovieTheater = new MovieTheaterModel();
        editedMovieTheater.setName("new name");
        String newEdit = emvController.editMovieTheater("EditedTitle", editedMovieTheater.getName());
        assertNotNull(newEdit);
        assertEquals("new name", editedMovieTheater.getName());

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
