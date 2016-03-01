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

    public void addPicturePath(){
        addMovieFormViewModel.makeFileFromURI();
    }


    //METHOD WHICH PASSES THE INPUT FROM THE VIEW TO THE MODEL
    public void addMovieButtonAction(String titleInput, String playingTimeInMinutesInput, String releaseYearInput,
                                     String plotInput, String directorInput, String posterPathInput, String castInput,
                                     String theatreNameInput, String genreInput, String ageLimitInput) {
        try {
            if (titleInput.length() > 0 && releaseYearInput.length() > 0 && playingTimeInMinutesInput.length() > 0 &&
                    genreInput.length() > 0 && plotInput.length() > 0 && directorInput.length() > 0 &&
                    ageLimitInput.length() > 0 && castInput.length() > 0 && posterPathInput.length() > 0 &&
                    theatreNameInput.length() > 0) {
                addMovieFormViewModel.insertMovie(titleInput, playingTimeInMinutesInput, releaseYearInput, plotInput,
                        directorInput, posterPathInput, castInput, theatreNameInput, genreInput, ageLimitInput);
                addMovieFormView.updateAlertMessage("New movie was succesfully added to the database");
                //addMovieFormView.closeStage();
            } else {
                addMovieFormView.updateAlertMessage("All text fields must contain information in order to save the movie");
            }

        } catch (Exception e) {
            System.out.println("Exception in addMovieButtonAction() from Controller: " + e.getMessage());
        }
    }
}


