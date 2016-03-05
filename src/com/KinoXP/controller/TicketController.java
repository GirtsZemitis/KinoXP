package com.KinoXP.controller;

import com.KinoXP.model.TicketModel;

/**
 * Created by Palko on 05/03/2016.
 */
public class TicketController {

    public int getUnpaidTicket(String title,String date,String time){
        TicketModel ticketModel = new TicketModel();
        int unpaidTicketNumber = 0;
      unpaidTicketNumber=  ticketModel.getUnpaidTicket(title,date,time);
        return  unpaidTicketNumber;
    }
    public int getPaidTicket(String title,String date,String time){
        TicketModel ticketModel = new TicketModel();
        int unpaidTicketNumber = 0;
        unpaidTicketNumber=  ticketModel.getPaidTicket(title,date,time);
        return  unpaidTicketNumber;
    }
}
