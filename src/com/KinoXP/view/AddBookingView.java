package com.KinoXP.view;/**
 * Created by MazurJestBoski on 2016-02-29.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AddBookingView {




    public void start() {
        //LABELS
        Label mainLabel = new Label("Add Booking");
        mainLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        mainLabel.setAlignment(Pos.CENTER);
        Label searchLabel = new Label("Search");
        Label dateLabel = new Label("Date");
        Label timeLabel = new Label("Time");
        Label titleLabel = new Label("Title");
        Label hallLabel  = new Label("Hall");
        Label seatsAmountLabel = new Label("Seats amount");
        Label phoneNumberLabel = new Label("Phone number");
        Label paidLabel = new Label("Paid");
        Label reservationLabel = new Label("Reservation");

        //TEXTFIELDS
        TextField searchField = new TextField();
        searchField.setPromptText("ex. 91110399");
        DatePicker dateField = new DatePicker();
        TextField timeField = new TextField("00:00");
        timeField.setPromptText("ex. 20:40");
        timeField.setMaxWidth(150);
        TextField seatsField = new TextField();
        seatsField.setPromptText("ex. 3");
        seatsField.setMaxWidth(40);
        TextField phoneNrField = new TextField();
        phoneNrField.setPromptText("ex 91110399");
        phoneNrField.setMaxWidth(150);

        //COMBOBOXES
        ComboBox titleCombo  = new ComboBox();
        titleCombo.setPromptText("Choose a movie");
        ComboBox hallCombo  = new ComboBox();
        hallCombo.setPromptText("Choose a hall");

        //CHECHBOXES
        CheckBox paidCheck = new CheckBox();
        CheckBox reservedCheck = new CheckBox();

        //BUTTONS

        Button searchButton = new Button();


        Image imageSearch = new Image(getClass().getResourceAsStream("search.png"));
        searchButton.setGraphic(new ImageView(imageSearch));
        Button addButton = new Button("GO");


        //LAYOUT
        HBox search = new HBox();
        search.getChildren().addAll(searchField, searchButton);
        HBox isPaid = new HBox();
        isPaid.getChildren().addAll(paidLabel, paidCheck, reservationLabel, reservedCheck);
        VBox layout = new VBox();
        layout.getChildren().addAll(mainLabel, searchLabel, search, dateLabel, dateField, timeLabel, timeField, titleLabel, titleCombo, hallLabel, hallCombo, seatsAmountLabel, seatsField, phoneNumberLabel, phoneNrField, isPaid, addButton );
        addButton.setAlignment(Pos.BOTTOM_RIGHT);
        layout.setPadding(new Insets(40, 40, 40, 60));
        layout.setSpacing(5);

        //SCENE
        //SCENE
        Scene scene = new Scene(layout, 300, 550);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }


}
