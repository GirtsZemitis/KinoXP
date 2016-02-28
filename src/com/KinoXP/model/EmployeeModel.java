package com.KinoXP.model;

/**
 * Created by hartyandi on 2/24/16.
 */
public class EmployeeModel {

    private String userName;
    private String password;

    //CONSTRUCTOR
    public EmployeeModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
   // public EmployeeModel(){}

    //GETTERS AND SETTERS
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
