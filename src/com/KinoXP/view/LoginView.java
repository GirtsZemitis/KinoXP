package com.KinoXP.view;

import com.KinoXP.controller.LoginViewController;
import com.KinoXP.controller.ManageEmployeeController;
import com.KinoXP.model.EmployeeModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LoginView {
    EmployeeModel employeeModel;///// DON'T DELETE WITHOUT SAYING IT!!!!
    ManageEmployeeController manageEmployeeController = new ManageEmployeeController();

    public void start(){

        //creating scene
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        Text scenetitle = new Text("KINO CINEMA Management");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        gridPane.setPadding(new Insets(0, 0, 50, 0));
        gridPane.setStyle("-fx-background-color: \n" +
                "        #c3c4c4,\n" +
                "        linear-gradient(#d6d6d6 20%, white 100%),\n" +
                "        radial-gradient(center 50% -40%, radius 100%, #e6e6e6 25%, rgba(230,230,230,0) 50%);");

        gridPane.setVgap(20);
        gridPane.setHgap(-80);

        Scene scene = new Scene(gridPane,600,450);
        primaryStage.setScene(scene);


        Label errorLabel = new Label("");//////////////////BY MONICA/////////////////
        errorLabel.setStyle("-fx-font-size: 15;-fx-text-fill: crimson;-fx-font-weight:bold;");
        Label user = new Label("User");
        user.setStyle("-fx-font-size: 20");
        TextField userField = new TextField();
        userField.setStyle("-fx-font-size: 16");
        Label password = new Label("Password");
        password.setStyle("-fx-font-size: 20");
        TextField passwordText = new TextField();
        passwordText.setStyle("-fx-font-size: 16");
        Button logIn = new Button("Log In");
        Button exit = new Button("Exit");
        logIn.setStyle("-fx-min-width: 130px;\n" +
                "    -fx-max-width: 130px;\n" +
                "    -fx-background-color:\n" +
                "            #000000,\n" +
                "            linear-gradient(#7ebcea, #2f4b8f),\n" +
                "            linear-gradient(#426ab7, #263e75),\n" +
                "            linear-gradient(#395cab, #223768);\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 12px;");

        exit.setStyle("-fx-min-width: 130px;\n" +
                "    -fx-max-width: 130px;\n" +
                "    -fx-background-color:\n" +
                "            #000000,\n" +
                "            linear-gradient(#7ebcea, #2f4b8f),\n" +
                "            linear-gradient(#426ab7, #263e75),\n" +
                "            linear-gradient(#395cab, #223768);\n" +
                "    -fx-background-insets: 0,1,2,3;\n" +
                "    -fx-background-radius: 3,2,2,2;\n" +
                "    -fx-padding: 12 30 12 30;\n" +
                "    -fx-text-fill: white;\n" +
                "    -fx-font-size: 12px;");
        LoginViewController loginViewController = new LoginViewController();

        //locating the text fields and labels

        GridPane.setConstraints(scenetitle,0,0);
        GridPane.setConstraints(errorLabel,0,1);/////////////////////BY MONICA///////////
        GridPane.setConstraints(user,0,2);
        GridPane.setConstraints(userField,1,2);
        GridPane.setConstraints(password,0,3);
        GridPane.setConstraints(passwordText,1,3);
        GridPane.setConstraints(logIn,1,4);
        GridPane.setConstraints(exit, 1,5);

        gridPane.setAlignment(Pos.CENTER);


        //after typing in username and password u can press "enter" to log in.
        passwordText.setOnKeyPressed((keyEvent) -> {
                    if (keyEvent.getCode() == KeyCode.ENTER) {
                        employeeModel = new EmployeeModel(userField.getText(), passwordText.getText());

                        errorLabel.setText(loginViewController.checkLogIn(employeeModel));//CALL METHOD FROM CONTROLLER
                        primaryStage.close();// CLOSE THIS STAGE

                        if (checkIfManager() == false) {
                            manageEmployeeController.changeButtonVisibility();
                        }


                    }});









        //exit button to close the whole app.
        exit.setOnAction(event1 -> {
                primaryStage.close();
        });
        //ACTION TO LOG IN BUTTON/////////////////////////////////////////////////////////////
        logIn.setOnAction(event -> {
            //CREATING NEW EMPLOYEE OBJECT TO GRAB THE INPUT ATTRIBUTE VALUES
            employeeModel = new EmployeeModel(userField.getText(),passwordText.getText());

            errorLabel.setText(loginViewController.checkLogIn(employeeModel));//CALL METHOD FROM CONTROLLER
            primaryStage.close();// CLOSE THIS STAGE

            if(checkIfManager()==false){
                manageEmployeeController.changeButtonVisibility();
            }


        });
        //////////////////////////////////////////////////////////////////////////////////////

        gridPane.getChildren().addAll(scenetitle,errorLabel,user,userField,password,passwordText,logIn, exit);
        primaryStage.show();

    }

    //GUI ALERT USED BY LogInViewController////////////////////////////////////////////////////
    public void networkAlertMethod(){
       Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("The system failed to start due to lack of internet connection signal! Please check your network connection.");
        alert.showAndWait();
    }

    public boolean checkIfManager(){
        if(employeeModel.getUserName().equals("1")&& employeeModel.getPassword().equals("1")){
            return true;
        }

        return false;
    }
    //////////////////////////////////////////////////////BY MONICA// COMMUNICATE BEFORE YOU MOVE/CHANGE/DELETE!
}