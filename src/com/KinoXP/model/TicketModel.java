package com.KinoXP.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

    /*public int getUnpaidTicket(String title, String date, String time) {
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
    }*/


    public ObservableList<String> getMovies() {
        ObservableList<String> observableList = FXCollections.observableArrayList();
        Booking booking;
        String out = "";


        try {
            String sql = "SELECT title FROM Movie";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


                String movie = (resultSet.getString(1));


                observableList.add(movie);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return observableList;
    }

    public ObservableList<Booking> getBookingByPhoneNumber(String phoneNumber) {
        ObservableList<Booking> observableList = FXCollections.observableArrayList();
        Booking booking;
        String out = "";


        try {
            String sql = "SELECT * FROM Booking1 WHERE bookingId=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, phoneNumber);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


                booking = new Booking(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4), resultSet.getString(5), resultSet.getBoolean(6));


                observableList.add(booking);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return observableList;
    }

    public ObservableList<Booking> getBookingByTitle(String title) {
        ObservableList<Booking> observableList = FXCollections.observableArrayList();
        Booking booking;
        String out = "";


        try {
            String sql = "SELECT * FROM Booking1 WHERE title=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, title);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


                booking = new Booking(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4), resultSet.getString(5), resultSet.getBoolean(6));


                observableList.add(booking);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return observableList;
    }

    public ObservableList<Booking> getBookingByDate(String date) {
        ObservableList<Booking> observableList = FXCollections.observableArrayList();
        Booking booking;
        String out = "";


        try {
            String sql = "SELECT * FROM Booking1 WHERE date=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //noinspection JpaQueryApiInspection
            preparedStatement.setString(1, date);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


                booking = new Booking(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4), resultSet.getString(5), resultSet.getBoolean(6));


                observableList.add(booking);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return observableList;
    }

    public ObservableList<Booking> getBookingByPaidTickets(boolean paid) {
        ObservableList<Booking> observableList = FXCollections.observableArrayList();
        Booking booking;
        String out = "";


        try {
            String sql = "SELECT * FROM Booking1 WHERE isPaid='1';";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            //noinspection JpaQueryApiInspection
            preparedStatement.setBoolean(1, paid);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


                booking = new Booking(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4), resultSet.getString(5), resultSet.getBoolean(6));


                observableList.add(booking);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return observableList;
    }
}

