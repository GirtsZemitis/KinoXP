package com.KinoXPTest;

import com.KinoXP.controller.EditMovieViewController;
import com.KinoXP.model.Movie;
import com.KinoXP.model.MovieTheater;
import junit.framework.TestCase;

/**
 * Created by Girts Zemitis on 25/02/2016.
 * https://github.com/GirtsZemitis
 */
public class EditMovieTest extends TestCase {

    @org.junit.Test
    public void editMovie() {
        MovieTheater movieTheater = new MovieTheater();
        Movie movie = new Movie("Title", 180, "release year", "plot", "director", "posterPath", "mainActor", movieTheater);
        EditMovieViewController emvController = new EditMovieViewController();

        emvController.editTitle(movie, "EditedTitle");
        assertEquals("EditedTitle", movie.getTitel());

        emvController.editPlayingInMinutes(movie, 200);
        assertEquals(200, movie.getPlayingtimeInMinutes());

        emvController.editReleaseYear(movie, "EditedReleaseYear");
        assertEquals("EditedReleaseYear", movie.getRealeseYear());

        emvController.editPlot(movie, "EditedPlot");
        assertEquals("EditedPlot", movie.getPlot());

        emvController.editDirectore(movie, "EditedDirector");
        assertEquals("EditedDirector", movie.getDirector());

        emvController.editPoster(movie, "EditedPosterPath");
        assertEquals("EditedPosterPath", movie.getPosterpath());

        emvController.editMainActor(movie, "EditedMainActor");
        assertEquals("EditedMainActor", movie.getMainActor());


        MovieTheater editedMovieTheater = new MovieTheater();
        emvController.editMovieTheater(movie, editedMovieTheater);
        assertEquals(editedMovieTheater, movie.getMovieTheater());

    }
}
