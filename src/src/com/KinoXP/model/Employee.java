package com.KinoXP.model;

/**
 * Created by hartyandi on 2/24/16.
 */
public class Employee {

    private String userName;
    private String password;

    //CONSTRUCTOR
    public Employee(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
   // public Employee(){}

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
