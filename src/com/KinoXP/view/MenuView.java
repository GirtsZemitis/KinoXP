package com.KinoXP.view;


import com.KinoXP.controller.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
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
    public static Button movies, schedule, employees, booking, logOut, prices, ticketStatus;
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
        movies.setId("button");
        movies.setMaxWidth(Double.MAX_VALUE);
        schedule = new Button("Manage schedule");
        schedule.setId("button");
        schedule.setMaxWidth(Double.MAX_VALUE);
        booking = new Button("Manage bookings");
        booking.setId("button");
        booking.setMaxWidth(Double.MAX_VALUE);
        employees = new Button("Manage employees");
        employees.setId("button");
        employees.setMaxWidth(Double.MAX_VALUE);
        prices = new Button("Manage prices");
        prices.setId("button");
        prices.setMaxWidth(Double.MAX_VALUE);
        ticketStatus = new Button("Ticket Status");
        ticketStatus.setId("button");

        logOut = new Button("Log out");
        
        logOut.setStyle("-fx-font-size: 20");
        logOut.setId("button");
        logOut.setOnAction(event1 -> {
            loginViewController.startLoginWindow();
            primaryStage.close();
        });
        menuLayout = new BorderPane();
        menuLayout.setId("backgroundImage");
        menuLayout.setPadding(new Insets(30));
        vbox = new VBox(10);

        vbox.getChildren().addAll(movies, schedule, employees, prices,booking,ticketStatus);
        vbox.setPadding(new Insets(0, 20, 0, 20 ));
        vbox.setSpacing(20);
        vbox.setMaxWidth(200);
        menuLayout.setCenter(vbox);
        menuLayout.setTop(menuLabel);
        menuLayout.setAlignment(menuLabel, Pos.TOP_CENTER);
        menuLayout.setBottom(logOut);
        menuLayout.setAlignment(logOut, Pos.BOTTOM_RIGHT);
        vbox.setAlignment(Pos.CENTER);

        movies.setOnAction(event -> {
            newMovieViewController.newMovieViewDisplay();
            mainMenu.close();
        });

        schedule.setOnAction(event -> {
           // manageMovieScheduleController.scheduleDisplay();
            manageMovieScheduleController.scheduleFromTheatre();
            mainMenu.close();
      });
        booking.setOnAction(event -> {
            addBookingViewController.addBookingViewDisplay();
            mainMenu.close();
        });

        employees.setOnAction(event -> {
            ManageEmployeeView manageEmployeeView = new ManageEmployeeView();
            manageEmployeeView.start();
            mainMenu.close();
        });

        ticketStatus.setOnAction(event1 -> {
            TicketView ticketView = new TicketView();
            ticketView.start();
        });

        prices.setOnAction(event -> {
          //  PricesView pricesView = new PricesView();
          //  pricesView.start();
           // mainMenu.close();
        });

        menu = new Scene(menuLayout, 500, 500);
        menu.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        mainMenu.setScene(menu);
        mainMenu.show();


    }


}
