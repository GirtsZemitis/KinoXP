package com.KinoXP.controller;

import com.KinoXP.model.Booking;
import com.KinoXP.model.TicketModel;
import com.KinoXP.view.TicketView;
import com.sun.org.apache.xpath.internal.operations.String;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 * Created by Palko on 05/03/2016.
 */
public class TicketController {
    TicketModel ticketModel;
    TicketView ticketView;
    Booking booking;

    public TicketController(TicketModel ticketModel, TicketView ticketView){
        this.ticketModel = ticketModel;
        this.ticketView = ticketView;
    }

    public TicketController(){}
/*
    //GET RESERVED TICKETS
    public int getUnpaidTicket(String title,String date,String time){
        ticketModel = new TicketModel();
        int unpaidTicketNumber = 0;
      unpaidTicketNumber=  ticketModel.getUnpaidTicket(title,date,time);
        return  unpaidTicketNumber;
    }

    //GET PAID TICKETS
    public int getPaidTicket(String title,String date,String time){
        ticketModel = new TicketModel();
        int unpaidTicketNumber = 0;
        unpaidTicketNumber=  ticketModel.getPaidTicket(title,date,time);
        return  unpaidTicketNumber;
    }*/

    //GET BOOKING INFO
    public ObservableList<Booking> returnBookingByPhoneNumber(java.lang.String phoneNumber) {
        ObservableList<Booking> tab = ticketModel.getBookingByPhoneNumber(phoneNumber);
        return tab;
    }

    public ObservableList<Booking> returnBookingByTitle(java.lang.String title) {
        ObservableList<Booking> tab = ticketModel.getBookingByTitle(title);
        return tab;
    }

    public ObservableList<Booking> returnBookingByDate(java.lang.String date) {
        ObservableList<Booking> tab = ticketModel.getBookingByDate(date);
        return tab;
    }

    public ObservableList<Booking> returnBookingByPaidTickets(boolean paid) {
        ObservableList<Booking> tab = ticketModel.getBookingByPaidTickets(paid);
        return tab;
    }

    public Booking searchBooking(){
        return booking;
    }
}
