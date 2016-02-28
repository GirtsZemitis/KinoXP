package com.KinoXP.controller;

import com.KinoXP.model.NewMovieViewModel;
import com.KinoXP.view.NewMovieView;
import javafx.scene.image.ImageView;

/**
 * Created by quena on 25-02-2016.
 */
public class NewMovieViewController {

    NewMovieViewModel newMovieViewModel = new NewMovieViewModel();

    public void newMovieViewDisplay(){
        NewMovieView newMovieView = new NewMovieView();
        newMovieView.start();
    }

    public ImageView getWrapImageFromUrlCtrl() {
        ImageView imageView;
        imageView = newMovieViewModel.wrapImageFromUrl();
        return imageView;
    }

}
