package com.KinoXP.controller;

import com.KinoXP.model.EmployeeModel;
import com.KinoXP.model.LoginViewModel;
import com.KinoXP.model.ManageEmployeeModel;
import com.KinoXP.view.ManageEmployeeView;
import com.KinoXP.view.MenuView;
import javafx.collections.ObservableList;

/**
 * Created by Paula on 01/03/16.
 */
public class ManageEmployeeController {
    ManageEmployeeModel manageEmployeeModel;
    ManageEmployeeView manageEmployeeView;
    EmployeeModel employeeModel;
    LoginViewModel loginViewModel;


    public ManageEmployeeController(ManageEmployeeModel manageEmployeeModel, ManageEmployeeView manageEmployeeView) {
        this.manageEmployeeModel = manageEmployeeModel;
        this.manageEmployeeView = manageEmployeeView;
    }

    public ManageEmployeeController(){

    }

    //CHANGES BUTTONS TO INVISIBLE IF USER LOGING IN IS NOT MANAGER
    public void changeButtonVisibility(){

        MenuView.employees.setDisable(true);
        MenuView.movies.setDisable(true);
    }
    /**
          METHODS WHICH MAKE THE CONNECTION BETWEEN THE VIEW AND THE MODEL
     **/

    //GET EMPLOYEE INFO
    public ObservableList<EmployeeModel> returnEmployeeInfo() {
        ObservableList<EmployeeModel> tab = manageEmployeeModel.getEmployeeInformation();
        return tab;

    }

    //GET LOG IN INFO
    public ObservableList<LoginViewModel> returnLogInInfo() {
        ManageEmployeeModel manageEmployeeModel = new ManageEmployeeModel();
        ObservableList<LoginViewModel> list = manageEmployeeModel.getLoginInformation();

        return list;
    }

    //GET PASSWORD
    public String getPassword(String a) {
        String password = manageEmployeeModel.getPassword(a);

        return password;
    }

    //ADD EMPLOYEE TO THE DATABASE
    public void addEmployeeAction(String userNameInput, String nameInput, String surnameInput, String emailInput,
                                  Integer phoneNumberInput, String jobTitleInput) {
        try {
            if(userNameInput.equals(manageEmployeeModel.getUserName(userNameInput))) {
                manageEmployeeView.updateAlertMessage("User name already exists. Please insert a different one.");
            }else if(!userNameInput.equals(manageEmployeeModel.getUserName(userNameInput))) {
                manageEmployeeModel.insertEmployee(userNameInput, nameInput, surnameInput, emailInput,
                        phoneNumberInput, jobTitleInput);
                manageEmployeeView.updateAlertMessage("New employee was successfully added to the database");
            }
        } catch (Exception e) {
            System.out.println("Exception in addEmployeeAction() from ManageEmployeeController: " + e.getMessage());
        }
    }

    //CREATE LOG IN ACCOUNT
    public void addLogInCredentials(String userNameInput, String passwordInput) {
        try {
            if (userNameInput.length() > 0 && passwordInput.length() > 0) {
                manageEmployeeModel.insertLogIn(userNameInput, passwordInput);
            }else if(userNameInput.equals(employeeModel.getUserName())) {
                manageEmployeeView.updateAlertMessage("User name already exists. Please insert a different one.");
            }else {
                manageEmployeeView.updateAlertMessage("All text fields must contain information in order to save the employee");
            }

        } catch (Exception e) {
            System.out.println("Exception in addLogInCredentials() from ManageEmployeeController: " + e.getMessage());
        }
    }

    //EDIT EMPLOYEE FROM DATABASE
    public void editEmployee(String userName, String name, String surname, String email, int phoneNumber, String jobTitle, String oldUser) {
        String existingUserName = manageEmployeeModel.checkUserName(userName);
        if (!userName.equals(existingUserName)) {
            manageEmployeeModel.editEmployee(userName, name, surname, email, phoneNumber, jobTitle, oldUser);
        } else if(userName.equals(existingUserName)){
            manageEmployeeModel.editEmployeeWithoutUserName(name,surname,email,phoneNumber,jobTitle,oldUser);
            manageEmployeeView.updateAlertMessage("Employee information was successfully edited into the database");
        }else{
            System.out.println("User name already exists. Please insert a different one.");
        }
    }

    //EDIT LOG IN ACCOUNT
    public void editLogin(String userName, String password, String oldUserName) {
        manageEmployeeModel.editLogIn(userName, password, oldUserName);
    }

    //DELETE EMPLOYEE FROM DATABASE
    public void deleteEmployeeAction(String userNameInput) {
        manageEmployeeModel.deleteEmployee(userNameInput);
        manageEmployeeView.updateAlertMessage("Employee was successfully deleted from the database");
    }

    //DELETE LOG IN ACCOUNT FROM DATABASE
    public void deleteLogInCredentials(String userNameInput){
        manageEmployeeModel.deleteLogInCredentials(userNameInput);
    }
}
