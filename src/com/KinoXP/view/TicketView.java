package com.KinoXP.view;

import com.KinoXP.controller.AddBookingViewController;
import com.KinoXP.controller.TicketController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;



/**
 * Created by Palko on 05/03/2016.
 */
public class TicketView  {


    AddBookingViewController addBookingViewController = new AddBookingViewController();
    TicketController ticketController = new TicketController();
    private com.KinoXP.model.Schedule schedule;




    public void start() {

        BorderPane borderPane = new BorderPane();

        //LABELS
        Label mainLabel = new Label("Ticket Review");
        mainLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        mainLabel.setAlignment(Pos.CENTER);
        Label dateLabel = new Label("Date");
        Label timeLabel = new Label("Time");
        Label titleLabel = new Label("Title");
        dateLabel.setAlignment(Pos.CENTER);

        //TEXTFIELDS

        ComboBox<String> dateField = new ComboBox<>();
        dateField.setMinWidth(150);
        ComboBox<String> timeField = new ComboBox<>();
        timeField.setMinWidth(150);


        //COMBOBOXES
        ObservableList<String> options = addBookingViewController.getMoviesWithSchedule();
        ComboBox titleCombo = new ComboBox(options);
        titleCombo.setPromptText("Choose a movie");


        //BUTTONS

        Button addButton = new Button("GO");


        //LAYOUT
        VBox layout = new VBox();

        layout.getChildren().addAll(mainLabel, titleLabel, titleCombo, dateLabel, dateField, timeLabel, timeField, addButton);
        borderPane.setCenter(layout);
        addButton.setAlignment(Pos.BOTTOM_CENTER);
        layout.setPadding(new Insets(40, 40, 40, 60));
        layout.setSpacing(5);
        layout.setAlignment(Pos.TOP_CENTER);

        //SCENE
        //SCENE
        Scene scene = new Scene(borderPane, 700, 550);
        Stage primaryStage = new Stage();

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        titleCombo.getSelectionModel().selectedItemProperty().addListener(observable -> {

            schedule = addBookingViewController.getSchedule(titleCombo.getSelectionModel().getSelectedItem().toString());
            dateField.setItems(addBookingViewController.getDateFieldInfo(titleCombo.getSelectionModel().getSelectedItem().toString()));
            dateField.setPromptText("Choose a week and date");


        });

        dateField.getSelectionModel().selectedItemProperty().addListener(observable -> {


            timeField.setItems(addBookingViewController.parseTimes(addBookingViewController.getTimes(Integer.parseInt(dateField.getSelectionModel().getSelectedItem().toString().substring(4, 5)),
                    Integer.parseInt(dateField.getSelectionModel().getSelectedItem().toString().substring(11)), schedule)));
            timeField.setPromptText("Choose time");

        });



        addButton.setOnAction(event -> {
            VBox vBox = new VBox();
            ticketController.getUnpaidTicket(titleCombo.getValue().toString(),dateField.getValue(),timeField.getValue());
            String unpaid = String.valueOf(ticketController.getUnpaidTicket(titleCombo.getValue().toString(),dateField.getValue(),timeField.getValue()));
            Label unpaidTicket = new Label();
            unpaidTicket.setStyle("-fx-font-size: 16");
            unpaidTicket.setText("Number of reserve tickets:"+ " " + "for movie" + " " +titleCombo.getValue() + " " + "on" + " " + dateField.getValue() + " "+ " at "+ " "+ timeField.getValue() + " "+ "is" +" "+unpaid+" "+"pcs");
            ticketController.getPaidTicket(titleCombo.getValue().toString(),dateField.getValue(),timeField.getValue());
            Label paidTicket = new Label();
            paidTicket.setStyle("-fx-font-size: 16");
            String paid =String.valueOf(ticketController.getPaidTicket(titleCombo.getValue().toString(),dateField.getValue(),timeField.getValue()));
            paidTicket.setText("Number of paid tickets:"+ " " + "for movie" + " " +titleCombo.getValue() + " " + "on" + " " + dateField.getValue() + " "+ " at "+ " "+ timeField.getValue() + " "+ "is" +" "+paid+" "+"pcs");
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(paidTicket,unpaidTicket);
            layout.getChildren().addAll(vBox);
            addButton.setOnAction(new EventHandler<ActionEvent>() {

                @Override public void handle(ActionEvent event) {
                    String unpaid = String.valueOf(ticketController.getUnpaidTicket(titleCombo.getValue().toString(),dateField.getValue(),timeField.getValue()));
                    String paid =String.valueOf(ticketController.getPaidTicket(titleCombo.getValue().toString(),dateField.getValue(),timeField.getValue()));

                    unpaidTicket.setText("Number of reserve tickets:"+ " " + "for movie" + " " +titleCombo.getValue() + " " + "on" + " " + dateField.getValue() + " "+ " at "+ " "+ timeField.getValue() + " "+ "is" +" "+unpaid+" "+"pcs");
                    paidTicket.setText("Number of paid tickets:"+ " " + "for movie" + " " +titleCombo.getValue() + " " + "on" + " " + dateField.getValue() + " "+ " at "+ " "+ timeField.getValue() + " "+ "is" +" "+paid+" "+"pcs");
                }
            });
        });




    }

}



