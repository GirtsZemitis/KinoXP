package com.KinoXPTest;

import com.KinoXP.model.AddMovieFormViewModul;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Paula on 26/02/16.
 */

public class AddMovieFormViewModulTest {
        AddMovieFormViewModul addMovieFormViewModul = new AddMovieFormViewModul();

    @Test
    public void testInsertMovie() throws Exception {
        addMovieFormViewModul.getActorFromDatabase("theActor");
        addMovieFormViewModul.insertMovie("newMovie", "90", "2016", "plot", "director", "posterPath", "theActor",
                "theatreName", "genre", "12");
        assertEquals("newMovie", addMovieFormViewModul.getActorFromDatabase("theActor"));
    }
}