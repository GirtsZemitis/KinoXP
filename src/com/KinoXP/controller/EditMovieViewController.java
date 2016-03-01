package com.KinoXP.controller;

import com.KinoXP.model.EditMovieViewModel;
import com.KinoXP.view.EditMovieView;

/**
 * Created by Girts Zemitis on 25/02/2016.
 * https://github.com/GirtsZemitis
 */
public class EditMovieViewController {

    private EditMovieViewModel manageMovieViewModul;
    private EditMovieView editMovieView;

    //CONSTRUCTORS
    public EditMovieViewController(EditMovieView editMovieView, EditMovieViewModel manageMovieViewModul) {
        this.editMovieView = editMovieView;
        this.manageMovieViewModul = manageMovieViewModul;
    }
    public EditMovieViewController(){
    }

    //METHOD FOR HANDLING -EDIT MOVIE- BUTTON
    public void editMovieButtonAction(String titleTxtText, String playingTimeInMinutesTxtText, String releaseYearTxtText,
                                      String plotTxtText, String directorTxtText, String posterPathTxtText, String mainActorTxtText,
                                      String movieTheaterTxt, String genreTxtText, String ageLimitTxtText, String titleInput, String playingtimeInMinutesInput, String releaseYearInput, String plotInput,
                                      String directorInput, String posterPathInput, String mainActorInput, String movieTheaterInput,
                                      String genreInput, String ageLimitInput){


        if(!playingTimeInMinutesTxtText.equals(playingtimeInMinutesInput)){
                manageMovieViewModul.editPlayingInMinutes(titleInput, Integer.parseInt(playingTimeInMinutesTxtText));
            }
        if(!releaseYearTxtText.equals(releaseYearInput)){
                manageMovieViewModul.editReleaseYear(titleInput, releaseYearTxtText);
            }
        if(!plotTxtText.equals(plotInput)){
                manageMovieViewModul.editPlot(titleInput, plotTxtText);
            }
        if(!directorTxtText.equals(directorInput)){
                manageMovieViewModul.editDirector(titleInput, directorTxtText);
            }
        if(!posterPathTxtText.equals(posterPathInput)){
                manageMovieViewModul.editPoster(titleInput, posterPathTxtText);
            }
        if(!mainActorTxtText.equals(mainActorInput)){
                manageMovieViewModul.editMainActor(titleInput, mainActorTxtText);
            }
        if(!movieTheaterTxt.equals(movieTheaterInput)){
                manageMovieViewModul.editMovieTheater(titleInput, movieTheaterTxt);
            }
        if (!genreTxtText.equals(genreInput)) {
                manageMovieViewModul.editGenre(titleInput, genreTxtText);
            }
        if (!ageLimitTxtText.equals(ageLimitInput)) {
                manageMovieViewModul.editAgeLimit(titleInput, ageLimitTxtText);
            }
        if (!titleTxtText.equals(titleInput)) {
                manageMovieViewModul.editTitle(titleInput, titleTxtText);
            }

    }


    public void deleteMovieButtonAction(String titleTxtText) {
        manageMovieViewModul.deleteMovie(titleTxtText);
    }

    public void deleteFileAction(){
        manageMovieViewModul.deletefile();
    }
}
