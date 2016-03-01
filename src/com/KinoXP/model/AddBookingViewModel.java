package com.KinoXP.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Girts Zemitis on 01/03/2016.
 * https://github.com/GirtsZemitis
 */
public class AddBookingViewModel {

    Connection conn = LoginViewModel.conn;

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
            return new Booking(date, time, title, seats, phoneNumber);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
