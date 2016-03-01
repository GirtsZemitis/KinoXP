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
    public String checkLogIn(EmployeeModel employeeModel){
        String errorLabelText = "";

        //CALL THE DATABASE CONNECTION METHOD => CONNECT TO DATABASE
        loginViewModel.connectToDatabase();
        //COMPARE IF INPUTED USERNAME && PASS ARE == TO MANUALLY ESTABLISHED ONES IN DB
        if(loginViewModel.checkLoginAndPassword(employeeModel)== true) {
            //IF YES THEN :
            MenuView menuView = new MenuView();
            menuView.start();
        }else{
            errorLabelText="Wrong username or password! Try again";
            System.out.println("Wrong username or password! Try again");
            return errorLabelText;
        }
        return errorLabelText;
    }

    public void startLoginWidnow(){
        LoginView loginView = new LoginView();
        loginView.start();
    }

}

