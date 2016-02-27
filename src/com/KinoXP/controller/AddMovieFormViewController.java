package com.KinoXP.controller;

import com.KinoXP.model.AddMovieFormViewModul;
import com.KinoXP.view.AddMovieFormView;

/**
 * Created by Paula on 26/02/2016.
 */
public class AddMovieFormViewController {



    public void newMovieFormViewDisplay(){
        AddMovieFormView addMovieFormView = new AddMovieFormView();
        addMovieFormView.getAddMovieView();
    }

    private AddMovieFormView addMovieFormView;
    private AddMovieFormViewModul addMovieFormViewModul;

    //CONSTRUCTORS
    public AddMovieFormViewController(AddMovieFormView addMovieFormView, AddMovieFormViewModul addMovieFormViewModul) {
        this.addMovieFormView = addMovieFormView;
        this.addMovieFormViewModul = addMovieFormViewModul;
    }

    public AddMovieFormViewController(){};

    //METHOD WHICH PASSES THE INPUT FROM THE VIEW TO THE MODEL
    public void addMovieButtonAction(String titleInput, String playingTimeInMinutesInput, String releaseYearInput,
                                     String plotInput, String directorInput, String posterPathInput, String castInput,
                                     String theatreNameInput, String genreInput, String ageLimitInput) {

        addMovieFormViewModul.insertMovie(titleInput, playingTimeInMinutesInput, releaseYearInput, plotInput, directorInput, posterPathInput,
                castInput, theatreNameInput, genreInput, ageLimitInput);
    }
}
