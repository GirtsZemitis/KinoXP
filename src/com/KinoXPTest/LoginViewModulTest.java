package com.KinoXPTest;

import com.KinoXP.model.EmployeeModel;
import com.KinoXP.model.LoginViewModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Monica on 26-02-2016.
 */
public class LoginViewModulTest {
    LoginViewModel loginViewModel = new LoginViewModel();

    @Before //DOING THE CONNECTION
    public void connectToDatabase(){
        loginViewModel.connectToDatabase();
    }
   /* @Test // TESTING THE LOG IN METHODS!
    public void testLogIn(){
        LoginViewModel loginViewModel = new LoginViewModel("1","1");
        assertEquals("1",loginViewModel.checkLoginAndPassword(loginViewModel).getUserName());
        assertEquals("1",loginViewModel.checkLoginAndPassword(loginViewModel).getPassword());


    }*/



}