package com.KinoXP.controller;

import com.KinoXP.model.ManageMovieViewModel;
import com.KinoXP.view.ManageMovieView;

/**
 * Created by Girts Zemitis on 25/02/2016.
 * https://github.com/GirtsZemitis
 */
public class ManageMovieViewController {

    private ManageMovieViewModel manageMovieViewModul;
    private ManageMovieView manageMovieView;

    //CONSTRUCTORS
    public ManageMovieViewController(ManageMovieView manageMovieView, ManageMovieViewModel manageMovieViewModul) {
        this.manageMovieView = manageMovieView;
        this.manageMovieViewModul = manageMovieViewModul;
    }
    public ManageMovieViewController(){
    }

    //METHOD FOR HANDLING -EDIT MOVIE- BUTTON
    public void editMovieButtonAction(String titleTxtText, String playingTimeInMinutesTxtText, String releaseYearTxtText,
                                      String plotTxtText, String directorTxtText, String posterPathTxtText, String mainActorTxtText,
                                      String movieTheaterTxt, String genreTxtText, String ageLimitTxtText, String titleInput, String playingtimeInMinutesInput, String releaseYearInput, String plotInput,
                                      String directorInput, String posterPathInput, String mainActorInput, String movieTheaterInput,
                                      String genreInput, String ageLimitInput){


            if(!playingTimeInMinutesTxtText.equals(playingtimeInMinutesInput)){
                manageMovieViewModul.editPlayingInMinutes(titleTxtText, Integer.parseInt(playingtimeInMinutesInput));
            } else if(!releaseYearTxtText.equals(releaseYearInput)){
                manageMovieViewModul.editReleaseYear(titleTxtText, releaseYearInput);
            } else if(!plotTxtText.equals(plotInput)){
                manageMovieViewModul.editPlot(titleTxtText, plotInput);
            } else if(!directorTxtText.equals(directorInput)){
                manageMovieViewModul.editDirector(titleTxtText, directorInput);
            } else if(!posterPathTxtText.equals(posterPathInput)){
                manageMovieViewModul.editPoster(titleTxtText, posterPathInput);
            } else if(!mainActorTxtText.equals(mainActorInput)){
                manageMovieViewModul.editMainActor(titleTxtText, mainActorInput);
            } else if(!movieTheaterTxt.equals(movieTheaterInput)){
                manageMovieViewModul.editMovieTheater(titleTxtText, movieTheaterInput);
            } else if (!genreTxtText.equals(genreInput)) {
                manageMovieViewModul.editGenre(titleTxtText, genreInput);
            }else if (!ageLimitTxtText.equals(ageLimitInput)) {
                manageMovieViewModul.editAgeLimit(titleTxtText, ageLimitInput);
            } else if (!titleTxtText.equals(titleInput)) {

                manageMovieViewModul.editTitle(titleTxtText, titleInput);
            }

    }

    //METHOD FOR HANDLING -GO BACK- BUTTON
    public void goBackButtonAction(){
        System.out.println( "going back");

    }
}
