package com.KinoXP.model;

import java.sql.*;

/**
 * Created by hartyandi on 2/25/16.
 */
public class LoginViewModul {
    Connection conn = null;
    Employee employee;



    //DATABASE CONNECTING METHOD
    //PLEASE APPLY YOUR LOCAL MODIFICATIONS IN ORDER FOR THESE TO WORK!!!
    public void connectToDatabase(){
        System.out.println("***********Welcome to connections**************");
        try {

            String DB_URL = "jdbc:mysql://sql2.freesqldatabase.com:3306/sql2108018";
            String USER = "sql2108018";
            String PASS = "nP5%zC6%";
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("conn obj created" + conn + " message: ");
        }
        catch (SQLException e)
        {
            System.out.println("db error" + e.getMessage());
        }
    }
    //CHECK LOG IN AND PASSWORD WITH SQL - DATABASE (PLEASE MODIFY HERE AND UP FOR YOUR LOCAL DATABASES!!!!!)
    public Employee checkLoginAndPassword(Employee employee){
        try {
            String sql = "SELECT * FROM Employee WHERE userName=?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, employee.getUserName());
            //preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                employee = new Employee(resultSet.getString(1),resultSet.getString(2));
            } else {
                employee = null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  employee;
    }


}
