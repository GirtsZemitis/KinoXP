package com.KinoXP.controller;


import com.KinoXP.model.EmployeeModel;
import com.KinoXP.model.LoginViewModel;
import com.KinoXP.view.LoginView;
import com.KinoXP.view.MenuView;

/**
 * Created by hartyandi on 2/24/16.
 */
public class LoginViewController {

    //CREATED OBJECT
    LoginViewModel loginViewModel = new LoginViewModel();

    //CHECK IF THE INSERTED USERNAME AND PASSWORD ARE AS THE ONES ESTABLISHED IN THE DATABASE
    public void checkLogIn(EmployeeModel employeeModel){

        //CALL THE DATABASE CONNECTION METHOD => CONNECT TO DATABASE
        loginViewModel.connectToDatabase();

        //COMPARE IF INPUTED USERNAME && PASS ARE == TO MANUALLY ESTABLISHED ONES IN DB
        if((loginViewModel.checkLoginAndPassword(employeeModel).getUserName().equals(employeeModel.getUserName()))&&
                (loginViewModel.checkLoginAndPassword(employeeModel).getPassword().equals(employeeModel.getPassword()))){

            //IF YES THEN :
                MenuView menuView = new MenuView();
                menuView.start();
            }else{
                System.out.println("The userName and Password don't match!");
        }
    }

    public void startLoginWidnow(){
        LoginView loginView = new LoginView();
        loginView.start();
    }

}

