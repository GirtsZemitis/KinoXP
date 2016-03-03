package com.KinoXP.model;

import com.KinoXP.view.Schedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 * Created by hartyandi on 2/25/16.
 */
public class ManageMovieSceduleModel {
    public static Connection conn = null;

    public  ManageMovieSceduleModel(){
        System.out.println("***********Welcome to connections**************");
        try {

            String DB_URL = "jdbc:mysql://sql2.freesqldatabase.com:3306/sql2108018";
            String USER = "sql2108018";
            String PASS = "nP5%zC6%";
            /*String DB_URL = "jdbc:mysql://localhost/testkinoxp";
            String USER = "root";
            String PASS = "root";*/
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("conn obj created" + conn + " message: ");
        }
        catch (SQLException e)
        {
            System.out.println("db error" + e.getMessage());
        }
    }
    public void saveSchedule(String s, int i, int id){


        String week = "week" +i;
        String sql ="";
        sql = "UPDATE `schedule` SET "+week +" = ? WHERE indexMovie= ?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, s);
            preparedStatement.setInt(2,id);
            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Schedule is save: " + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public String getSchedule(int i){
        //nr of week
        String schedule ="";

        String sql="";
        if( i==1) {
            sql = "SELECT `week1` FROM `schedule`";
        }
        if(i ==2){
            sql = "SELECT `week2` FROM `schedule`";
        }
        if(i ==3){
            sql = "SELECT `week3` FROM `schedule`";
        }
        if(i ==4){
            sql = "SELECT `week4` FROM `schedule`";
        }
        if(i ==5){
            sql = "SELECT `week5` FROM `schedule`";
        }
        if(i ==6){
            sql = "SELECT `week6` FROM `schedule`";
        }
        if(i ==7){
            sql = "SELECT `week7` FROM `schedule`";
        }
        if(i ==8){
            sql = "SELECT `week8` FROM `schedule`";
        }
        if(i ==9){
            sql = "SELECT `week9` FROM `schedule`";
        }
        if(i ==10){
            sql = "SELECT `week10` FROM `schedule`";
        }
        if(i ==11){
            sql = "SELECT `week11` FROM `schedule`";
        }
        if(i ==12){
            sql = "SELECT `week12` FROM `schedule`";
        }


        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                schedule = resultSet.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return schedule;
    }

    public void InsertDefaultSchedule(String s){
        String sql ="INSERT INTO `schedule`(`week1`, `week2`, `week3`, `week4`, `week5`, `week6`, `week7`, `week8`, `week9`, `week10`, `week11`, `week12`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,s);
            preparedStatement.setString(2,s);
            preparedStatement.setString(3,s);
            preparedStatement.setString(4,s);
            preparedStatement.setString(5,s);
            preparedStatement.setString(6,s);
            preparedStatement.setString(7,s);
            preparedStatement.setString(8,s);
            preparedStatement.setString(9,s);
            preparedStatement.setString(10,null);
            preparedStatement.setString(11,null);
            preparedStatement.setString(12,null);
            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Schedule is save: " + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getScheduleForMovie(String movieTitle, int weeknr){
        String week = "week"+weeknr;
        String sql = "SELECT "+ week +" FROM `schedule` INNER JOIN Movie ON schedule.indexMovie = Movie.indexMovie WHERE Movie.title = ?";
        String scheduleForMovie="";
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, movieTitle);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                scheduleForMovie = resultSet.getString(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(week);
        System.out.println("week form db is" + scheduleForMovie);

        return scheduleForMovie;

    }

    public ObservableList<Movie> getMovieTitles(String s){
        String sql ="SELECT `title` , `indexMovie`  FROM `Movie` WHERE cinemaRoomName=?";
        PreparedStatement preparedStatement = null;
        ObservableList<Movie> observableList = FXCollections.observableArrayList();
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, s);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                observableList.add(new Movie(resultSet.getString(1),resultSet.getInt(2)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return observableList;
    }

}
