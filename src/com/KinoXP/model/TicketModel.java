package com.KinoXP.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by hartyandi on 2/24/16.
 */
public class TicketModel {

    private static Connection conn = LoginViewModel.conn;

    public int getUnpaidTicket(String title, String date, String time) {
        int out = 0;
        try {
            String sql = "SELECT sum(seats) FROM Booking WHERE title =? and date = ? and time = ? and isPaid = '0'";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, time);

            ResultSet results = preparedStatement.executeQuery();

            if (results.next()) {
                out = results.getInt(1);
                System.out.println(out);
            } else {
                out = 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }
    public int getPaidTicket(String title, String date, String time) {
        int out = 0;
        try {
            String sql = "SELECT sum(seats) FROM Booking WHERE title =? and date = ? and time = ? and isPaid = '1'";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, date);
            preparedStatement.setString(3, time);

            ResultSet results = preparedStatement.executeQuery();

            if (results.next()) {
                out = results.getInt(1);
                System.out.println(out);
            } else {
                out = 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
}

    }

