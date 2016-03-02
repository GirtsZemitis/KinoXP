package com.KinoXP.controller;

import com.KinoXP.model.EmployeeModel;
import com.KinoXP.model.LoginViewModel;
import com.KinoXP.model.ManageEmployeeModel;
import com.KinoXP.view.ManageEmployeeView;
import javafx.collections.ObservableList;

/**
 * Created by Paula on 01/03/16.
 */
public class ManageEmployeeController {
    ManageEmployeeModel manageEmployeeModel;
    ManageEmployeeView manageEmployeeView;
    EmployeeModel employeeModel;
    LoginViewModel loginViewModel;

    public ManageEmployeeController(ManageEmployeeModel manageEmployeeModel, ManageEmployeeView manageEmployeeView){
        this.manageEmployeeModel = manageEmployeeModel;
        this.manageEmployeeView = manageEmployeeView;
    }




    public ObservableList<EmployeeModel> returnEmployeeInfo(){
        ObservableList<EmployeeModel> tab = manageEmployeeModel.getEmployeeInformation();
        return tab;

    }


    public ObservableList<LoginViewModel> returnLogInInfo(){
        ManageEmployeeModel manageEmployeeModel = new ManageEmployeeModel();
        ObservableList<LoginViewModel> list =  manageEmployeeModel.getLoginInformation();

        return  list;
    }

    public String getPassword(String a){
        String password = manageEmployeeModel.getPassword(a);

        return password;
}

    public void editEmployee(String userName,String name,String surname, String email, int phoneNumber, String jobTitle, String oldUser){
        manageEmployeeModel.editEmployee(userName,name,surname,email,phoneNumber,jobTitle,oldUser);
    }

    public void editLogin(String userName, String password, String oldUserName){
        manageEmployeeModel.editLogIn(userName,password,oldUserName);
    }



    public ManageEmployeeController(){}

    //METHODS WHICH MAKE THE CONNECTION BETWEEN THE VIEW AND THE MODEL

    //ADD EMPLOYEE TO THE DATABASE
    public void addEmployeeAction(String userNameInput, String nameInput, String surnameInput, String emailInput,
                                  Integer phoneNumberInput, String jobTitleInput){
        try {
            if (userNameInput.length() > 0 && nameInput.length() > 0 && surnameInput.length() > 0 &&
                    emailInput.length() > 0 && phoneNumberInput != 0 && jobTitleInput.length() > 0) {
                manageEmployeeModel.insertEmployee(userNameInput, nameInput, surnameInput, emailInput,
                        phoneNumberInput, jobTitleInput);
                //manageEmployeeView.updateAlertMessage("New employee was successfully added to the database");
                //manageEmployeeView.closeStage();
            } else {
                manageEmployeeView.updateAlertMessage("All text fields must contain information in order to save the employee");
            }

        } catch (Exception e) {
            System.out.println("Exception in addEmployeeAction() from ManageEmployeeController: " + e.getMessage());
        }
    }

    //CREATE USER AND PASSWORD FOR EMPLOYEE OR ADMIN
    public void addLogInCredentials(String userNameInput, String passwordInput){
        try {
            if (userNameInput.length() > 0 && passwordInput.length() > 0) {
                manageEmployeeModel.insertLogIn(userNameInput, passwordInput);
                manageEmployeeView.updateAlertMessage("New employee was successfully added to the database");
                //manageEmployeeView.closeStage();
            } else {
                manageEmployeeView.updateAlertMessage("All text fields must contain information in order to save the employee");
            }

        } catch (Exception e) {
            System.out.println("Exception in addLogInCredentials() from ManageEmployeeController: " + e.getMessage());
        }
    }

    //EDIT EMPLOYEE FROM DATABASE
    public void editEmployeeAction(String userNameInput, String nameInput, String surnameInput, String emailInput,
                                   Integer phoneNumberInput, String jobTitleInput, String passwordInput){
        String userName = employeeModel.getUserName();
        String name = employeeModel.getName();
        String surname = employeeModel.getSurname();
        String email = employeeModel.getEmail();
        int phoneNumber = employeeModel.getPhoneNumber();
        String jobTitle = employeeModel.getJobTitle();
        String password = loginViewModel.getPassword();

        if(!userNameInput.equals(userName) || !nameInput.equals(name) || !surnameInput.equals(surname) ||
                !emailInput.equals(email) || !phoneNumberInput.equals(phoneNumber) || !jobTitleInput.equals(jobTitle)){
            manageEmployeeModel.editEmployee(userNameInput, nameInput, surnameInput, emailInput, phoneNumberInput,
                    jobTitleInput, userName);
        }else if(!userNameInput.equals(userName) || !passwordInput.equals(password)){
            manageEmployeeModel.editLogIn(userNameInput, passwordInput, userName);
        }else{
            manageEmployeeView.updateAlertMessage("No fields were modified");

        }
    }

    //DELETE EMPLOYEE FROM DATABASE
    public void deleteEmployeeAction(String userNameInput){
        manageEmployeeModel.deleteEmployee(userNameInput);
        manageEmployeeModel.deleteLogInCredentials(userNameInput);
    }

    public void manageAlert(){
        manageEmployeeView.updateAlertMessage("Already existing user");
    }
}
