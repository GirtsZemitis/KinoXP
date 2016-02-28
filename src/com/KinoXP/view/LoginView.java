package com.KinoXP.view;

import com.KinoXP.controller.LoginViewController;
import com.KinoXP.model.EmployeeModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by hartyandi on 2/24/16.
 */
public class LoginView {
    EmployeeModel employeeModel;

    public void start(){

        //creating scene
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        Text scenetitle = new Text("Welcome to KINO XP!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        gridPane.setPadding(new Insets(0, 0, 50, 0));

        gridPane.setVgap(20);
        gridPane.setHgap(-80);

        Scene scene = new Scene(gridPane,600,450);
        primaryStage.setScene(scene);



        Label user = new Label("User");
        user.setStyle("-fx-font-size: 20");
        TextField userField = new TextField();
        userField.setStyle("-fx-font-size: 16");
        Label password = new Label("Password");
        password.setStyle("-fx-font-size: 20");
        TextField passwordText = new TextField();
        passwordText.setStyle("-fx-font-size: 16");
        Button logIn = new Button("Confirm");
        logIn.setStyle("-fx-font-size: 20;-fx-background-color: #ffdd19;-fx-border-color: black");
        LoginViewController loginViewController = new LoginViewController();






        //locating the text fields and labels

        GridPane.setConstraints(scenetitle,0,0);
        GridPane.setConstraints(user,0,1);
        GridPane.setConstraints(userField,1,1);
        GridPane.setConstraints(password,0,2);
        GridPane.setConstraints(passwordText,1,2);
        GridPane.setConstraints(logIn,1,3);



        gridPane.setAlignment(Pos.CENTER);



        logIn.setOnAction(event -> {

            //CREATING NEW EMPLOYEE OBJECT TO GRAM THE INPUTED ATTRIBUTE VALUES
            employeeModel = new EmployeeModel(userField.getText(),passwordText.getText());
            loginViewController.checkLogIn(employeeModel);//CALL METHOD FROM CONTROLLER
            primaryStage.close();// CLOSE THIS STAGE
        });



        gridPane.getChildren().addAll(scenetitle,user,userField,password,passwordText,logIn);


        primaryStage.show();

    }
}
