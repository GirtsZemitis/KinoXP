package com.KinoXP.view;


import com.KinoXP.controller.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Created by hartyandi on 2/24/16.
 */
public class MenuView {

    Stage mainMenu;
    Scene menu;
    BorderPane menuLayout;
    VBox vbox;
    Label menuLabel, loggedUser;
    Button movies, schedule, employees, booking, logOut;
    ManageMovieScheduleController manageMovieScheduleController = new ManageMovieScheduleController();
    NewMovieViewController newMovieViewController = new NewMovieViewController();
    LoginViewController loginViewController = new LoginViewController();
    AddBookingViewController addBookingViewController = new AddBookingViewController();
    ManageEmployeeView manageEmployeeView = new ManageEmployeeView();


    public void start() {

        Stage primaryStage = new Stage();
        mainMenu = new Stage();
        mainMenu = primaryStage;
        menuLabel = new Label("Main menu");
        menuLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        movies = new Button("Manage movies");
        movies.setStyle("-fx-font-size: 20;");
        schedule = new Button("Manage schedule");
        schedule.setStyle("-fx-font-size: 20");
        booking = new Button("Manage bookings");
        booking.setStyle("-fx-font-size: 20");

        employees = new Button("Manage employees");
        employees.setStyle("-fx-font-size: 20");

        logOut = new Button("Log out");
        
        logOut.setStyle("-fx-font-size: 20");
        logOut.setOnAction(event1 -> {
            loginViewController.startLoginWindow();
            primaryStage.close();
        });
        menuLayout = new BorderPane();
        menuLayout.setId("backgroundImage");
        menuLayout.setPadding(new Insets(50));
        vbox = new VBox(20);
        vbox.getChildren().addAll(movies, schedule, employees, booking);
        menuLayout.setCenter(vbox);
        menuLayout.setTop(menuLabel);
        menuLayout.setAlignment(menuLabel, Pos.TOP_CENTER);
        menuLayout.setBottom(logOut);
        menuLayout.setAlignment(logOut, Pos.BOTTOM_RIGHT);
        vbox.setAlignment(Pos.CENTER);

        movies.setOnAction(event -> {
            newMovieViewController.newMovieViewDisplay();
        });

        schedule.setOnAction(event -> {
           // manageMovieScheduleController.scheduleDisplay();
            manageMovieScheduleController.scheduleFromTheatre();
      });

        booking.setOnAction(event -> {
            addBookingViewController.addBookingViewDisplay();
        });

        employees.setOnAction(event -> {
            manageEmployeeView.start();
            mainMenu.close();
        });

        menu = new Scene(menuLayout, 500, 500);
        menu.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        mainMenu.setScene(menu);
        mainMenu.show();


    }


}
