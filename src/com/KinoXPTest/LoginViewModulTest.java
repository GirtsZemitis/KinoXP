package com.KinoXPTest;

import com.KinoXP.model.LoginViewModel;
import org.junit.Before;



/**
 * Created by Monica on 26-02-2016.
 */
public class LoginViewModulTest {
    LoginViewModel loginViewModel = new LoginViewModel();

    @Before//DOING THE CONNECTION
    public void connectToDatabase(){
        loginViewModel.connectToDatabase();
    }
   /* @Test // TESTING THE LOG IN METHODS!
    public void testLogIn(){
        EmployeeModel employeeModel = new EmployeeModel("1","1");
        assertEquals("1",loginViewModel.checkLoginAndPassword(employeeModel).getUserName());
        assertEquals("1",loginViewModel.checkLoginAndPassword(employeeModel).getPassword());


    }*/



}