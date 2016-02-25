package com.KinoXP.view;

import com.KinoXP.controller.LoginViewController;
import com.KinoXP.model.LoginViewModul;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by hartyandi on 2/24/16.
 */
public class LoginView {


    public void start(){

        //creating scene
        Stage primaryStage = new Stage();
        GridPane gridPane = new GridPane();
        Label user = new Label("User");
        TextField userField = new TextField();
        Label password = new Label("Password");
        TextField passwordText = new TextField();
        Button logIn = new Button("Confirm");
        LoginViewController loginViewController = new LoginViewController();

        //setting space between textfields and labels
        gridPane.setPadding(new Insets(40, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);

        //locating the text fields and labels
        GridPane.setConstraints(user,0,0);
        GridPane.setConstraints(userField,1,0);
        GridPane.setConstraints(password,0,1);
        GridPane.setConstraints(passwordText,1,1);
        GridPane.setConstraints(logIn,1,2);

        logIn.setOnAction(event -> {
            loginViewController.mainMenuDisplay();
            primaryStage.close();
        });



        gridPane.getChildren().addAll(user,userField,password,passwordText,logIn);

        Scene scene = new Scene(gridPane,600,450);
        primaryStage.setScene(scene);

        primaryStage.show();

    }
}
