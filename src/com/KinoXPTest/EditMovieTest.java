package com.KinoXPTest;

import com.KinoXP.controller.EditMovieViewController;
import com.KinoXP.model.Movie;
import com.KinoXP.model.MovieTheater;
import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Girts Zemitis on 25/02/2016.
 * https://github.com/GirtsZemitis
 */
public class EditMovieTest extends TestCase {

    @org.junit.Test
    public void editMovie() {
        MovieTheater movieTheater = new MovieTheater();
        Movie movie = new Movie("Title", 180, "release year", "plot", "director", "posterPath", "mainActor", movieTheater);
        Movie movie1 = new Movie("Title1", 181, "release year1", "plot1", "director1", "posterPath1", "mainActor1", movieTheater);
        ArrayList<Movie> arrayList = new ArrayList<Movie>();
        arrayList.add(movie);
        arrayList.add(movie1);


        EditMovieViewController emvController = new EditMovieViewController();

        emvController.editTitle("Title", "release year", "director", "EditedTitle");
        assertEquals("EditedTitle", movie.getTitel());

        emvController.editPlayingInMinutes("EditedTitle", "release year", "director", 200);
        assertEquals(200, movie.getPlayingtimeInMinutes());

        emvController.editReleaseYear("EditedTitle", "release year", "director", "EditedReleaseYear");
        assertEquals("EditedReleaseYear", movie.getRealeseYear());

        emvController.editPlot("EditedTitle", "EditedReleaseYear", "director", "EditedPlot");
        assertEquals("EditedPlot", movie.getPlot());

        emvController.editDirectore("EditedTitle", "EditedReleaseYear", "director", "EditedDirector");
        assertEquals("EditedDirector", movie.getDirector());

        emvController.editPoster("EditedTitle", "EditedReleaseYear", "EditedDirector", "EditedPosterPath");
        assertEquals("EditedPosterPath", movie.getPosterpath());

        emvController.editMainActor("EditedTitle", "EditedReleaseYear", "EditedDirector", "EditedMainActor");
        assertEquals("EditedMainActor", movie.getMainActor());


        MovieTheater editedMovieTheater = new MovieTheater();
        emvController.editMovieTheater("EditedTitle", "EditedReleaseYear", "EditedDirector", editedMovieTheater);
        assertEquals(editedMovieTheater, movie.getMovieTheater());

    }
}
