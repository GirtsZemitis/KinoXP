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

    public Schedule getSchedule(String movieName) {
        try {
            String query = "SELECT * FROM Movie INNER JOIN schedule ON Movie.indexMovie= schedule.indexMovie WhERE Movie.title=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, movieName);
            ResultSet results = preparedStatement.executeQuery();
            Schedule schedule = new Schedule();
            while (results.next()){
                //CHANGE HEREEEEE
                for (int i = 1; i < 10; i++){
                    schedule.parseSchedule(results.getString("week" + i), i);
                }




            }

            return schedule;



        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // it doesnt find getSchedule in model
    /*public Booking getSchedule(String phoneNumber){
        return addBookingViewModel.getSchedule();

    }*/


}
