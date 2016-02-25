package com.KinoXP.controller;

import com.KinoXP.model.ManageMovieViewModul;
import com.KinoXP.view.ManageMovieView;

/**
 * Created by Girts Zemitis on 25/02/2016.
 * https://github.com/GirtsZemitis
 */
public class ManageMovieViewController {

    private ManageMovieViewModul manageMovieViewModul;
    private ManageMovieView manageMovieView;

    //CONSTRUCTORS
    public ManageMovieViewController(ManageMovieView manageMovieView, ManageMovieViewModul manageMovieViewModul) {
        this.manageMovieView = manageMovieView;
        this.manageMovieViewModul = manageMovieViewModul;
    }
    public ManageMovieViewController(){
    }

    //METHOD FOR HANDLING -EDIT MOVIE- BUTTON
    public void editMovieButtonAction(String titleInput, String playingtimeInMinutesInput, String releaseYearInput, String plotInput, String directorInput, String posterPathInput, String mainActorInput, String movieTheaterInput){
        try {
            String title = manageMovieViewModul.getTitle(titleInput);
            String playingtimeInMinutes = manageMovieViewModul.getPlayingTimeInMinutes(playingtimeInMinutesInput);
            String releaseYear = manageMovieViewModul.getReleaseYear(releaseYearInput);
            String plot = manageMovieViewModul.getPlot(plotInput);
            String director = manageMovieViewModul.getDirector(directorInput);
            String posterPath = manageMovieViewModul.getPosterPath(posterPathInput);
            String mainActor = manageMovieViewModul.getMainActor(mainActorInput);
            String movieTheater = manageMovieViewModul.getTheatreName(movieTheaterInput);

            if (!title.equals(titleInput)) {
                manageMovieViewModul.editTitle(titleInput, title);
            } else if(!playingtimeInMinutes.equals(playingtimeInMinutesInput)){
                manageMovieViewModul.editPlayingInMinutes(title, Integer.parseInt(playingtimeInMinutesInput));
            } else if(!releaseYear.equals(releaseYearInput)){
                manageMovieViewModul.editReleaseYear(title, releaseYearInput);
            } else if(!plot.equals(plotInput)){
                manageMovieViewModul.editPlot(titleInput, plotInput);
            } else if(!director.equals(directorInput)){
                manageMovieViewModul.editDirector(titleInput, directorInput);
            } else if(!posterPath.equals(posterPathInput)){
                manageMovieViewModul.editPoster(titleInput, posterPathInput);
            } else if(!mainActor.equals(mainActorInput)){
                manageMovieViewModul.editMainActor(titleInput, mainActorInput);
            } else if(!movieTheater.equals(movieTheaterInput)){
                manageMovieViewModul.editMovieTheater(titleInput, movieTheaterInput);
            }
        }catch(Exception e){
            System.out.println("Exception in editMovieButtonAction() from Controller: " + e.getMessage());
        }
    }

    //METHOD FOR HANDLING -GO BACK- BUTTON
    public void goBackButtonAction(){

    }
}
