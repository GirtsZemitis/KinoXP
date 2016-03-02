package com.KinoXP.model;

import com.KinoXP.controller.ManageEmployeeController;
import com.KinoXP.view.ManageEmployeeView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

/**
 * Created by Paula on 01/03/16.
 */
public class ManageEmployeeModel {
    private static Connection conn = LoginViewModel.conn;


    public void insertLogIn(String userName, String password) {
        String sql = "INSERT INTO LogIn VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("New login credentials were successfully added to the database: " + numberOfRows);
        } catch (SQLException e) {
            System.out.println("Already existing user");
        }
    }

    public void insertEmployee(String userName, String name, String surname, String email, Integer phoneNumber,
                               String jobTitle) {
        String sql = "INSERT INTO Employee VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surname);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, phoneNumber);
            preparedStatement.setString(6, jobTitle);

            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("New employee was successfully added to the database: " + numberOfRows);
        } catch (SQLException e) {
            ManageEmployeeView.updateAlertMessage("Already existing user");
        }
    }

    public String editEmployee(String userName, String name, String surname, String email, Integer phoneNumber, String jobTitle, String oldUserName) {
        String sql = "UPDATE Employee SET userName=?, name=?, surname=?, email=?, phoneNumber=?, jobTitle=? WHERE userName = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surname);
            preparedStatement.setString(4, email);
            preparedStatement.setInt(5, phoneNumber);
            preparedStatement.setString(6, jobTitle);
            preparedStatement.setString(7, oldUserName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ManageEmployeeView.updateAlertMessage("Phone has to be an integer");
        }
        return null;
    }

    public String editLogIn(String userName, String password, String oldUserName) {
        String sql = "UPDATE LogIn SET userName=?, password=? WHERE userName = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, oldUserName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteEmployee(String userName) {
        String sql = "DELETE FROM Employee WHERE userName=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("Employee deleted. Number of rows affected:" + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLogInCredentials(String userName) {
        String sql = "DELETE FROM LogIn WHERE userName=?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            int numberOfRows = preparedStatement.executeUpdate();
            System.out.println("LogIn account deleted. Number of rows affected:" + numberOfRows);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getEmployeeFromDatabase(String userName) {
        String out = "";
        try {
            String query = " SELECT name FROM Employee WHERE userName=? ";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userName);
            ResultSet results = preparedStatement.executeQuery();

            if (results.next()) {
                out = results.getString(1);
            } else {
                out = "";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }

    public ObservableList<EmployeeModel> getEmployeeInformation() {
        ObservableList<EmployeeModel> observableList = FXCollections.observableArrayList();
        EmployeeModel employee;
        String out = "";
        String sql = "SELECT  * FROM Employee ";


        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


                employee = new EmployeeModel(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6));


                observableList.add(employee);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return observableList;
    }
    public ObservableList<LoginViewModel> getLoginInformation() {
        ObservableList<LoginViewModel> observableList = FXCollections.observableArrayList();
        LoginViewModel loginViewModel;
        String out = "";
        String sql = "SELECT  * FROM LogIn ";


        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {


                loginViewModel = new LoginViewModel(resultSet.getString(1), resultSet.getString(2));


                observableList.add(loginViewModel);

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return observableList;
    }

    public String getPassword(String userName) {
        String out = "";
        try {
            String query = " SELECT password FROM LogIn WHERE userName=? ";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, userName);
            ResultSet results = preparedStatement.executeQuery();

            if (results.next()) {
                out = results.getString(1);
            } else {
                out = "";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }


}

