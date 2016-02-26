package com.KinoXP.controller;


import com.KinoXP.model.Employee;
import com.KinoXP.model.LoginViewModul;
import com.KinoXP.view.MenuView;

/**
 * Created by hartyandi on 2/24/16.
 */
public class LoginViewController {

    //CREATED OBJECT
    LoginViewModul loginViewModul = new LoginViewModul();

    //CHECK IF THE INSERTED USERNAME AND PASSWORD ARE AS THE ONES ESTABLISHED IN THE DATABASE
    public void checkLogIn(Employee employee){

        //CALL THE DATABASE CONNECTION METHOD => CONNECT TO DATABASE
        loginViewModul.connectToDatabase();

        //COMPARE IF INPUTED USERNAME && PASS ARE == TO MANUALLY ESTABLISHED ONES IN DB
        if((loginViewModul.checkLoginAndPassword(employee).getUserName().equals(employee.getUserName()))&&
                (loginViewModul.checkLoginAndPassword(employee).getPassword().equals(employee.getPassword()))){

            //IF YES THEN :
                MenuView menuView = new MenuView();
                menuView.start();
            }else{
                System.out.println("The userName and Password don't match!");
        }
    }

}

