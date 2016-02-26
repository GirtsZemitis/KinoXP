package com.KinoXPTest;

import com.KinoXP.model.Employee;
import com.KinoXP.model.LoginViewModul;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Monica on 26-02-2016.
 */
public class LoginViewModulTest {
    LoginViewModul loginViewModel = new LoginViewModul();

    @Before
    public void connectToDatabase(){
        loginViewModel.connectToDatabase();
    }
    @Test
    public void testLogIn(){
        Employee employee = new Employee("1","1");
        assertEquals("1",loginViewModel.checkLoginAndPassword(employee).getUserName());
        assertEquals("1",loginViewModel.checkLoginAndPassword(employee).getPassword());


    }



}