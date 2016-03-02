package com.KinoXP.view;

import com.KinoXP.controller.ManageEmployeeController;

import com.KinoXP.model.EmployeeModel;
import com.KinoXP.model.LoginViewModel;
import com.KinoXP.model.ManageEmployeeModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



/**
 * Created by Palko on 01/03/2016.
 */
public class ManageEmployeeView {

    private ManageEmployeeController manageEmployeeController;
    private ManageEmployeeModel manageEmployeeModel;


    private TableView<EmployeeModel>tableView = new TableView<>();
    private TableView<LoginViewModel>tableView1 = new TableView<>();




    public ManageEmployeeView(){
        manageEmployeeModel = new ManageEmployeeModel();
        manageEmployeeController = new ManageEmployeeController(manageEmployeeModel, this);
    }

    public void start() {

        //CREATING BORDER PANE WITH HBOX-CENTERED/BUTTOM AND GRIDPANE CENTERED IN THE MIDDLE
        Stage primaryStage = new Stage();
        HBox hBox1 = new HBox();
        hBox1.setPrefSize(600,80);
        HBox hBox = new HBox(20);
        hBox.setPrefSize(600,80);
        BorderPane borderPane = new BorderPane();


        Button logOut = new Button("LOG OUT");
        logOut.setStyle("-fx-font-size: 10");
        Button add = new Button("ADD");
        add.setStyle("-fx-font-size: 18");
        Button delete =new Button("DELETE");
        delete.setStyle("-fx-font-size:  18");
        Button edit = new Button("EDIT");
        edit.setStyle("-fx-font-size: 18");


        TabPane tabPane = new TabPane();
        Tab tab = new Tab();
        Tab tab1 = new Tab();
        tab1.setText("LOGIN INFO");
        tab.setText("EMPLOYEE INFO");
        tab.setContent(new Rectangle(200,200, Color.LIGHTSTEELBLUE));
        tab.setContent(new Cylinder(200,200));
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.getTabs().addAll(tab,tab1);

        tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

            //OVERWRITE FUNCTIONALITY OF BUTTON WHEN CHANGING TO DIFFERENT TAP
            @Override
            public void changed(ObservableValue<? extends Tab> observable, Tab oldTab, Tab newTab) {
                if (newTab == tab1) {
                    add.setDisable(true);
                    edit.setDisable(true);
                    delete.setDisable(true);
                } else {
                    add.setDisable(false);
                    edit.setDisable(false);
                    delete.setDisable(false);
                }
            }

        });

        //EDIT BOTH EMPLOYEE INFORMATION AND LOG IN INFORMATION

        edit.setOnAction(event ->{

            Stage stage1 = new Stage();
            GridPane gridPane = new GridPane();
            Label name = new Label("Name");
            TextField nameTextField = new TextField();
            Label surname = new Label("Surname");
            TextField surnameText = new TextField();
            Label email = new Label("Email");
            TextField emailText = new TextField();
            Label phoneNumber = new Label("Phone number");
            TextField phoneNumberText = new TextField();
            Label position = new Label("Position");
            TextField positionTextField = new TextField();
            Button confirm = new Button("Confirm");
            Label userName = new Label("User name");
            TextField userNameTextField = new TextField();
            Label password = new Label("Password");
            TextField passwordTextField = new TextField();

            GridPane.setConstraints(name,0,0);
            GridPane.setConstraints(nameTextField,1,0);
            GridPane.setConstraints(surname,0,1);
            GridPane.setConstraints(surnameText,1,1);
            GridPane.setConstraints(email,0,2);
            GridPane.setConstraints(emailText,1,2);
            GridPane.setConstraints(phoneNumber,0,3);
            GridPane.setConstraints(phoneNumberText,1,3);
            GridPane.setConstraints(position,0,4);
            GridPane.setConstraints(positionTextField,1,4);
            GridPane.setConstraints(userName,0,5);
            GridPane.setConstraints(userNameTextField,1,5);
            GridPane.setConstraints(password,0,6);
            GridPane.setConstraints(passwordTextField,1,6);
            GridPane.setConstraints(confirm,1,7);

            EmployeeModel employeeModel = tableView.getSelectionModel().getSelectedItem();



            userNameTextField.setText(employeeModel.getUserName());
            nameTextField.setText(employeeModel.getName());
            surnameText.setText(employeeModel.getSurname());
            emailText.setText(employeeModel.getEmail());
            phoneNumberText.setText(String.valueOf(employeeModel.getPhoneNumber()));
            positionTextField.setText(employeeModel.getJobTitle());
            passwordTextField.setText(manageEmployeeController.getPassword(employeeModel.getUserName()));


            confirm.setStyle("-fx-font-size: 20");



            gridPane.setAlignment(Pos.CENTER);

            gridPane.getChildren().addAll(name,nameTextField,surname,surnameText,email,emailText,phoneNumber,phoneNumberText,position,userName,userNameTextField,password,passwordTextField,positionTextField,confirm);

            gridPane.setHgap(20);
            gridPane.setVgap(30);
            Scene scene = new Scene(gridPane,1000,650);

            stage1.setScene(scene);
            stage1.show();

                    confirm.setOnAction(event1 -> {

                        manageEmployeeController.editEmployee(userNameTextField.getText(),nameTextField.getText(),surnameText.getText(),emailText.getText(),Integer.parseInt(phoneNumberText.getText()),positionTextField.getText(),employeeModel.getUserName());
                        manageEmployeeController.editLogin(userNameTextField.getText(),passwordTextField.getText(),employeeModel.getUserName());



                        tableView.setItems(manageEmployeeController.returnEmployeeInfo());
                        tableView1.setItems(manageEmployeeController.returnLogInInfo());
                stage1.close();

            });




    });

        //deletes chosen rows

        delete.setOnAction(event-> {


            manageEmployeeController.returnEmployeeInfo().remove(tableView.getSelectionModel().getSelectedItem());

            ManageEmployeeModel manageEmployeeModel = new ManageEmployeeModel();

            manageEmployeeModel.deleteEmployee(tableView.getSelectionModel().getSelectedItem().getUserName());
            String user = tableView.getSelectionModel().getSelectedItem().getUserName();
            tableView.setItems(manageEmployeeController.returnEmployeeInfo());

            //DELETE FROM DATABASE AND UPDATE LOGIN INFO TABLE VIEW
            manageEmployeeModel.deleteLogInCredentials(user);
            tableView1.setItems(manageEmployeeModel.getLoginInformation());


    });

        hBox.getChildren().addAll(add,edit,delete,logOut);

        borderPane.setBottom(hBox);
        tab.setContent(showBookings());
        tab1.setContent(showLogInInfo());

     //   borderPane.setCenter(showBookings());
        borderPane.setTop(tabPane);

        //ADDS BOTH EMPLOYEE AND LOGIN INFORMATION
        add.setOnAction(event -> {
            Stage stage1 = new Stage();
            GridPane gridPane = new GridPane();
            Label name = new Label("Name");
            TextField nameTextField = new TextField();
            Label surname = new Label("Surname");
            TextField surnameText = new TextField();
            Label email = new Label("Email");
            TextField emailText = new TextField();
            Label phoneNumber = new Label("Phone number");
            TextField phoneNumberText = new TextField();
            Label position = new Label("Position");
            TextField positionTextField = new TextField();
            Button confirm = new Button("Confirm");
            Label userName = new Label("User name");
            TextField userNameTextField = new TextField();
            Label password = new Label("Password");
            TextField passwordTextField = new TextField();

            //POSITION TEXT AND LABEL ELEMENTS
            GridPane.setConstraints(name,0,0);
            GridPane.setConstraints(nameTextField,1,0);
            GridPane.setConstraints(surname,0,1);
            GridPane.setConstraints(surnameText,1,1);
            GridPane.setConstraints(email,0,2);
            GridPane.setConstraints(emailText,1,2);
            GridPane.setConstraints(phoneNumber,0,3);
            GridPane.setConstraints(phoneNumberText,1,3);
            GridPane.setConstraints(position,0,4);
            GridPane.setConstraints(positionTextField,1,4);
            GridPane.setConstraints(userName,0,5);
            GridPane.setConstraints(userNameTextField,1,5);
            GridPane.setConstraints(password,0,6);
            GridPane.setConstraints(passwordTextField,1,6);
            GridPane.setConstraints(confirm,1,7);


            confirm.setStyle("-fx-font-size: 20");

            gridPane.setAlignment(Pos.CENTER);

            gridPane.getChildren().addAll(name,nameTextField,surname,surnameText,email,emailText,phoneNumber,phoneNumberText,position,userName,userNameTextField,password,passwordTextField,positionTextField,confirm);

            gridPane.setHgap(20);
            gridPane.setVgap(30);
            Scene scene = new Scene(gridPane,1000,650);

            stage1.setScene(scene);
            stage1.show();


            //UPDATE BOTH TABLE VIEWS AND DELETE FROM DATABASE
            confirm.setOnAction(event1 -> {
                    manageEmployeeController.addEmployeeAction(userNameTextField.getText(), nameTextField.getText(),
                            surnameText.getText(), emailText.getText(), Integer.parseInt(phoneNumberText.getText()),
                            positionTextField.getText());
                    manageEmployeeController.addLogInCredentials(userNameTextField.getText(), passwordTextField.getText());
                    tableView.setItems(manageEmployeeController.returnEmployeeInfo());
                    tableView1.setItems(manageEmployeeController.returnLogInInfo());

                    stage1.close();


            });

        });

        logOut.setOnAction(event -> {
            primaryStage.close();
            LoginView loginView = new LoginView();
            loginView.start();

        });


        hBox.setAlignment(Pos.CENTER);
        borderPane.setAlignment(logOut,Pos.TOP_RIGHT);

        Scene scene = new Scene(borderPane,1000,650);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    //METHOD FOR THE ALERT MESSAGES SHOWN TO THE USER
    public static void updateAlertMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public TableView<EmployeeModel> showBookings() {



        manageEmployeeController.returnEmployeeInfo();
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        javafx.scene.control.TableColumn < EmployeeModel, String > userName = new javafx.scene.control.TableColumn<>("User name");
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        userName.setMinWidth(100);

        javafx.scene.control.TableColumn<EmployeeModel, String> name = new javafx.scene.control.TableColumn<>("Name:");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        name.setMinWidth(200);

        javafx.scene.control.TableColumn<EmployeeModel, String> surname = new javafx.scene.control.TableColumn<>("Surname:");
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        surname.setMinWidth(100);


        javafx.scene.control.TableColumn<EmployeeModel, String> email = new javafx.scene.control.TableColumn<>("Email:");
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        email.setMinWidth(150);

        javafx.scene.control.TableColumn<EmployeeModel, Integer> phoneNumber = new javafx.scene.control.TableColumn<>("Phone nuber:");
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        phoneNumber.setMinWidth(150);


        javafx.scene.control.TableColumn<EmployeeModel, String> jobTitle = new javafx.scene.control.TableColumn<>("Job title:");
        jobTitle.setCellValueFactory(new PropertyValueFactory<>("jobTitle"));
        jobTitle.setMinWidth(150);

        tableView.getColumns().addAll(userName,name,surname,email,phoneNumber,jobTitle);
        tableView.setItems(manageEmployeeController.returnEmployeeInfo());

        return tableView;

    }

    public TableView<LoginViewModel> showLogInInfo() {

        ManageEmployeeModel manageEmployeeModel = new ManageEmployeeModel();
        tableView1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        javafx.scene.control.TableColumn < LoginViewModel, String > userName = new javafx.scene.control.TableColumn<>("User name");
        userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        userName.setMinWidth(50);

        javafx.scene.control.TableColumn<LoginViewModel, String> password = new javafx.scene.control.TableColumn<>("Password:");
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        password.setMinWidth(50);

        tableView1.getColumns().addAll(userName,password);

        tableView1.setItems(manageEmployeeModel.getLoginInformation());

        return tableView1;

    }

}
