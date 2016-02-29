package com.KinoXP.controller;

import com.KinoXP.model.ManageMovieSceduleModel;
import com.KinoXP.view.Schedule;

import java.util.ArrayList;
import com.KinoXP.view.MovieWeek;
/**
 * Created by hartyandi on 2/24/16.
 */
public class ManageMovieSceduleController {
    ArrayList<MovieWeek> arrayList;
    ManageMovieSceduleModel manageMovieSceduleModel = new ManageMovieSceduleModel();

    public void scheduleDisplay(){
        Schedule schedule = new Schedule();
        schedule.start();
    }

    public ArrayList<MovieWeek> getArrayList(){
        arrayList = new ArrayList<>();
        for(int i=0; i<12; i++){
            arrayList.add(new MovieWeek());
        }
        return arrayList;
    }

    public void saveSchedule(String s, int i){

        manageMovieSceduleModel.saveSchedule(s,i);
    }

    public String printScheduleFromDb(int i){
      return manageMovieSceduleModel.getSchedule(i);
    }

}
