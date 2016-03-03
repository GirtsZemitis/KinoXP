package com.KinoXP.controller;

import com.KinoXP.model.AddBookingViewModel;
import com.KinoXP.model.Booking;
import com.KinoXP.model.LoginViewModel;
import com.KinoXP.model.Schedule;
import com.KinoXP.view.AddBookingView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by MazurJestBoski on 2016-02-29.
 */
public class AddBookingViewController {

    AddBookingViewModel addBookingViewModel;
    Connection conn = LoginViewModel.conn;

    public AddBookingViewController() {
       this.addBookingViewModel = new AddBookingViewModel();

    }

    public void addBookingViewDisplay(){
        AddBookingView addBookingView = new AddBookingView();
        addBookingView.start();
    }

    public Booking getBookingByPhoneNUmber(String phoneNumber){
        return addBookingViewModel.getBooking(phoneNumber);

    }

    public ObservableList<String> getMoviesWithSchedule() {
        try {
            String query = "SELECT Movie.title FROM Movie INNER JOIN schedule ON Movie.indexMovie= schedule.indexMovie";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            ResultSet results = preparedStatement.executeQuery();
            ArrayList<String> arrayList = new ArrayList<>();
            while (results.next()){
                arrayList.add(results.getString(1));
            }
            ObservableList<String> movieTitles =  FXCollections.observableArrayList(arrayList);



            return movieTitles;



        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Schedule getSchedule(String title){
        return addBookingViewModel.getSchedule(title);
    }


    public ObservableList getDateFieldInfo(String title) {
        Schedule schedule = addBookingViewModel.getSchedule(title);
        ArrayList<String> weeksAndDays = new ArrayList<String>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                if (schedule.getSchedule().get(i).get(Integer.toString(j)) == null) {

                } else if (!schedule.getSchedule().get(i).get(Integer.toString(j)).isEmpty()) {
                    weeksAndDays.add("Day:" + j + " Week:" + (i + 1));
                }
            }
        }
        return FXCollections.observableArrayList(weeksAndDays);
    }

    public ObservableList<String> getTimes(int day, int week, Schedule schedule) {

        ArrayList<String> times = new ArrayList<>();
        for (int i = 0; i < schedule.getSchedule().get(week - 1).get(Integer.toString(day)).size(); i++){
            times.add(schedule.getSchedule().get(week - 1).get(Integer.toString(day)).get(i));
        }


        return FXCollections.observableArrayList(times);
    }

    public void insertBooking(String date,String time,String title,int seats,String phonenumber,boolean paid){

        addBookingViewModel.insertBooking(date,time,title,seats,phonenumber,paid);
    }

    // it doesnt find getSchedule in model
    /*public Booking getSchedule(String phoneNumber){
        return addBookingViewModel.getSchedule();

    }*/


}
