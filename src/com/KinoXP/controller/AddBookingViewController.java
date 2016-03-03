package com.KinoXP.controller;

import com.KinoXP.model.AddBookingViewModel;
import com.KinoXP.model.Booking;
import com.KinoXP.view.AddBookingView;

/**
 * Created by MazurJestBoski on 2016-02-29.
 */
public class AddBookingViewController {

    AddBookingViewModel addBookingViewModel;

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



}
