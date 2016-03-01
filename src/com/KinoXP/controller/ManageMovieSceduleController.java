package com.KinoXP.controller;

import com.KinoXP.model.ManageMovieSceduleModel;
import com.KinoXP.model.Movie;
import com.KinoXP.view.Schedule;

import java.util.ArrayList;
import com.KinoXP.view.MovieWeek;
import javafx.collections.ObservableList;

/**
 * Created by hartyandi on 2/24/16.
 */
public class ManageMovieSceduleController {
    ArrayList<MovieWeek> arrayList;
    ManageMovieSceduleModel manageMovieSceduleModel = new ManageMovieSceduleModel();

    public void scheduleDisplay() {
        Schedule schedule = new Schedule();
        schedule.start();
    }

    public void scheduleDisplay(String s) {
        Schedule schedule = new Schedule(s);
        schedule.start();
    }

    public ArrayList<MovieWeek> getArrayList() {
        arrayList = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            arrayList.add(new MovieWeek());
        }
        return arrayList;
    }

    public void saveSchedule(String s, int i, int id) {

        manageMovieSceduleModel.saveSchedule(s, i, id);
    }

    public String printScheduleFromDb(int i) {
        return manageMovieSceduleModel.getSchedule(i);
    }


    public void insertMovie(String s) {
        manageMovieSceduleModel.InsertDefaultSchedule(s);

    }

    public String getScheduleForMovie(String s, int i) {
        return manageMovieSceduleModel.getScheduleForMovie(s, i);
    }

    public ObservableList<Movie> getMovieTitles() {
        return manageMovieSceduleModel.getMovieTitles();
    }
}
