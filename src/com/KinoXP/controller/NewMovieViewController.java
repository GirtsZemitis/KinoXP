package com.KinoXP.controller;

import com.KinoXP.model.NewMovieViewModel;
import com.KinoXP.view.NewMovieView;
import javafx.scene.image.ImageView;

import java.sql.ResultSet;

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



    public ResultSet getMovieTitleFromModel() {
        return newMovieViewModel.getMovieTitle();
    }
    public ResultSet getUrlFromModel() {
        return newMovieViewModel.getPhotoLink();
    }
}
