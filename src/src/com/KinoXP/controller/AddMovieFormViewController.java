package com.KinoXP.controller;

import com.KinoXP.model.AddMovieFormViewModul;
import com.KinoXP.view.AddMovieFormView;

/**
 * Created by Paula on 26/02/2016.
 */
public class AddMovieFormViewController {



    public void newMovieFormViewDisplay(){
        AddMovieFormView addMovieFormView = new AddMovieFormView();
        addMovieFormView.getNewMovieView();
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
        try {
            if (titleInput.length() > 0 && releaseYearInput.length() > 0 && playingTimeInMinutesInput.length() > 0 &&
                    genreInput.length() > 0 && plotInput.length() > 0 && directorInput.length() > 0 &&
                    ageLimitInput.length() > 0 && castInput.length() > 0 && posterPathInput.length() > 0 &&
                    theatreNameInput.length() > 0) {
                addMovieFormViewModul.insertMovie(titleInput, playingTimeInMinutesInput, releaseYearInput, plotInput,
                        directorInput, posterPathInput, castInput, theatreNameInput, genreInput, ageLimitInput);
                addMovieFormView.updateAlertMessage("New movie was succesfully added to the database");
                addMovieFormView.closeStage();
            } else {
                addMovieFormView.updateAlertMessage("All text fields must contain information in order to save the movie");
            }

        } catch (Exception e) {
            System.out.println("Exception in addMovieButtonAction() from Controller: " + e.getMessage());
        }
    }
}
