package com.KinoXP.controller;

import com.KinoXP.model.NewMovieViewModel;
import com.KinoXP.view.NewMovieView;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

/**
 * Created by quena on 25-02-2016.
 */
public class NewMovieViewController {

    NewMovieViewModel newMovieViewModel = new NewMovieViewModel();


    public void newMovieViewDisplay(){
        NewMovieView newMovieView = new NewMovieView();
        newMovieView.start();
    }

    public ImageView getWrapImageFromUrlCtrl(String url) {
        ImageView imageView = null;
        imageView = newMovieViewModel.wrapImageFromUrl(url);
        return imageView;
    }

    public ArrayList<Integer> getArrayListOfMovieIndexFromDb() {
        return newMovieViewModel.getArrayOfIndexMovieFromDb();
    }

    public String getPhotoLinkFromModel(int indexMovie) {
        return newMovieViewModel.getPhotoLink(indexMovie);
    }

    public String getMovieTitleFromModel(int indexMovie) {
        return newMovieViewModel.getMovieTitle(indexMovie);
    }
}
