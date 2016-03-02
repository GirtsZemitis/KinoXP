package com.KinoXP.controller;

        import com.KinoXP.model.AddMovieFormViewModel;
        import com.KinoXP.view.AddMovieFormView;
        import javafx.scene.control.ComboBox;
        import javafx.scene.control.TextArea;
        import javafx.scene.control.TextField;
        import org.controlsfx.validation.ValidationSupport;
        import org.controlsfx.validation.Validator;

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

    //Fields Validation method - displays "recoration" - related to ControlFx - not fully functional yet
    public void validateFieldsControlsFx(TextField titleInput, TextField playingTimeInMinutesInput, TextField releaseYearInput,
                                        TextArea plotInput, TextField directorInput, TextField posterPathInput, TextArea castInput,
                                        ComboBox theatreNameInput, TextField genreInput, TextField ageLimitInput) {
        ValidationSupport validationSupport = new ValidationSupport();
        validationSupport.registerValidator(titleInput, Validator.createEmptyValidator("Empty Title Field"));
        validationSupport.registerValidator(playingTimeInMinutesInput, Validator.createEmptyValidator("Empty Duration Field"));
        validationSupport.registerValidator(releaseYearInput, Validator.createEmptyValidator("Empty Release Year Field"));
        validationSupport.registerValidator(plotInput, Validator.createEmptyValidator("Empty Plot Field"));
        validationSupport.registerValidator(directorInput, Validator.createEmptyValidator("Empty Director Field"));
        validationSupport.registerValidator(posterPathInput, Validator.createEmptyValidator("Empty Url Field"));
        validationSupport.registerValidator(castInput, Validator.createEmptyValidator("Empty  Cast Field"));
        validationSupport.registerValidator(theatreNameInput, Validator.createEmptyValidator("Empty Theatres Name Field"));
        validationSupport.registerValidator(genreInput, Validator.createEmptyValidator("Empty Genre Field"));
        validationSupport.registerValidator(ageLimitInput, Validator.createEmptyValidator("Empty AgeLimit Field"));
        if(validationSupport.isInvalid()) {
            System.out.println("ERROR GREG!");
        }


    }
}


