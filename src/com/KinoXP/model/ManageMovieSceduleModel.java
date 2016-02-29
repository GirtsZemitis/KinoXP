package com.KinoXP.model;

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
    public void saveSchedule(String s, int i){

        String weeknr = "week1\n";
        weeknr = weeknr +s;
        String sql ="";
        if(i==1) {
            sql = "UPDATE `schedule` SET `week1`= ?;";
        }
        if(i==2){
            sql = "UPDATE `schedule` SET `week2`= ?;";

        }
        if(i==3){
            sql = "UPDATE `schedule` SET `week3`= ?;";

        }
        if(i==4){
            sql = "UPDATE `schedule` SET `week4`= ?;";

        }
        if(i==5){
            sql = "UPDATE `schedule` SET `week5`= ?;";

        }
        if(i==6){
            sql = "UPDATE `schedule` SET `week6`= ?;";

        }
        if(i==7){
            sql = "UPDATE `schedule` SET `week7`= ?;";

        }
        if(i==8){
            sql = "UPDATE `schedule` SET `week8`= ?;";

        }
        if(i==9){
            sql = "UPDATE `schedule` SET `week9`= ?;";

        }
        if(i==10){
            sql = "UPDATE `schedule` SET `week10`= ?;";

        }
        if(i==11){
            sql = "UPDATE `schedule` SET `week11`= ?;";

        }
        if(i==12){
            sql = "UPDATE `schedule` SET `week12`= ?;";

        }

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, weeknr);
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
}
