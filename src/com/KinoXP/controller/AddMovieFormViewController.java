package com.KinoXP.controller;

import com.KinoXP.model.AddMovieFormViewModel;
import com.KinoXP.view.AddMovieFormView;

/**
 * Created by Paula on 26/02/2016.
 */
public class AddMovieFormViewController {

    //Greg - I moved AddmovieButtonActions Logic to AddMovieFormViewModel.
    // controller only binds View with logic(Model)..



    public void addMovieFormViewDisplay(){
        AddMovieFormView addMovieFormView = new AddMovieFormView();
        addMovieFormView.getAddMovieView();
    }

    private AddMovieFormView addMovieFormView;
    private AddMovieFormViewModel addMovieFormViewModel;

    //CONSTRUCTORS
    public AddMovieFormViewController(AddMovieFormView addMovieFormView, AddMovieFormViewModel addMovieFormViewModel) {
        this.addMovieFormView = addMovieFormView;
        this.addMovieFormViewModel = addMovieFormViewModel;
    }

    public AddMovieFormViewController(){};

    //METHOD WHICH PASSES THE INPUT FROM THE VIEW TO THE MODEL
    public void addMovieButtonAction(String titleInput, String playingTimeInMinutesInput, String releaseYearInput,
                                     String plotInput, String directorInput, String posterPathInput, String castInput,
                                     String theatreNameInput, String genreInput, String ageLimitInput) {

        addMovieFormViewModel.insertMovie(titleInput, playingTimeInMinutesInput, releaseYearInput, plotInput,
                directorInput, posterPathInput, castInput, theatreNameInput, genreInput, ageLimitInput);
    }
}
