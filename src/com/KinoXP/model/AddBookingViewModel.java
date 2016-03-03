package com.KinoXP.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Girts Zemitis on 01/03/2016.
 * https://github.com/GirtsZemitis
 */
public class AddBookingViewModel {

    Connection conn = LoginViewModel.conn;
    Booking booking;
    public Booking insertBooking(String date, String time, String title, int seats, String phoneNumber) {
        try {
            String sql = "INSERT INTO Booking (date, time, title, seats, phone_number) VALUES (?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, date);
            ps.setString(2, time);
            ps.setString(3, title);
            ps.setInt(4, seats);
            ps.setString(5, phoneNumber);
            ps.execute();
            ps.close();
            booking = new Booking(date, time, title, seats, phoneNumber);
            return booking;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Booking getBooking(String phoneNumber){
        String out = "";
        try {
            String query = "SELECT * FROM Booking WHERE phone_number=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, phoneNumber);
            ResultSet results = preparedStatement.executeQuery();

            while(results.next()){
                booking = new Booking (results.getString(1),results.getString(2),results.getString(3),results.getInt(4),results.getString(5));
            }



            return booking;



        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
