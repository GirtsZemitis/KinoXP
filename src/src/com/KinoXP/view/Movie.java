package com.KinoXP.model;

/**
 * Created by krystian on 2016-03-01.
 */
public class Movie {
    public String getTitle() {
        return title;
    }
    public Movie(String title, int movieId){
        this.title = title;
        this.movieId = movieId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
    public String toString(){
        return title;
    }

    String title;
    int movieId;
}
