package com.KinoXP.view;/**
 * Created by MazurJestBoski on 2016-02-29.
 */

import com.KinoXP.controller.AddBookingViewController;
import com.KinoXP.controller.NewMovieViewController;
import com.KinoXP.model.Booking;
import com.KinoXP.model.Schedule;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Optional;

public class AddBookingView {

    AddBookingViewController addBookingViewController = new AddBookingViewController();
    private Schedule schedule;


    private String phoneNr;


    public void start() {
        //LABELS
        Label mainLabel = new Label("Add Booking");
        mainLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        mainLabel.setAlignment(Pos.CENTER);
        Label searchLabel = new Label("Search");
        Label dateLabel = new Label("Date");
        Label timeLabel = new Label("Time");
        Label titleLabel = new Label("Title");
        Label seatsAmountLabel = new Label("Seats amount");
        Label phoneNumberLabel = new Label("Phone number");
        Label paidLabel = new Label("Paid");
        Label reservationLabel = new Label("Reservation");
        Label searchNotFound = new Label();
        searchNotFound.setTextFill(Color.web("#FF0000"));

        //TEXTFIELDS
        TextField searchField = new TextField();
        searchField.setPromptText("ex. 91110399");
        ComboBox<String> dateField = new ComboBox<>();
        dateField.setMinWidth(150);
        ComboBox<String> timeField = new ComboBox<>();
        timeField.setMinWidth(150);
        TextField seatsField = new TextField();
        seatsField.setPromptText("ex. 3");
        seatsField.setMaxWidth(40);
        TextField phoneNrField = new TextField();
        phoneNrField.setPromptText("ex 91110399");
        phoneNrField.setMaxWidth(150);


        //COMBOBOXES
        ObservableList<String> options = addBookingViewController.getMoviesWithSchedule();
        ComboBox titleCombo = new ComboBox(options);
        titleCombo.setPromptText("Choose a movie");


        ComboBox hallCombo = new ComboBox();
        hallCombo.setPromptText("Choose a hall");

        //CHECHBOXES
        CheckBox paidCheck = new CheckBox();
        CheckBox reservedCheck = new CheckBox();

        //BUTTONS

        Button searchButton = new Button();
        Button updateButton = new Button("Update");
        updateButton.setVisible(false);



        Image imageSearch = new Image(getClass().getResourceAsStream("search.png"));
        searchButton.setGraphic(new ImageView(imageSearch));
        Button addButton = new Button("GO");



        //LAYOUT
        HBox search = new HBox();
        search.getChildren().addAll(searchField, searchButton);
        HBox isPaid = new HBox();
        isPaid.getChildren().addAll(paidLabel, paidCheck);
        VBox layout = new VBox();
        layout.getChildren().addAll(mainLabel, searchLabel, search,searchNotFound, titleLabel, titleCombo, dateLabel, dateField, timeLabel,  timeField, seatsAmountLabel, seatsField, phoneNumberLabel, phoneNrField, isPaid, addButton, updateButton);
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

        titleCombo.getSelectionModel().selectedItemProperty().addListener(observable -> {

            schedule = addBookingViewController.getSchedule(titleCombo.getSelectionModel().getSelectedItem().toString());
            dateField.setItems(addBookingViewController.getDateFieldInfo(titleCombo.getSelectionModel().getSelectedItem().toString()));
            dateField.setPromptText("Choose a week and date");


        });

        dateField.getSelectionModel().selectedItemProperty().addListener(observable -> {
            int day = Integer.parseInt(dateField.getSelectionModel().getSelectedItem().toString().substring(4, 5));
            int week = Integer.parseInt(dateField.getSelectionModel().getSelectedItem().toString().substring(11));
            ArrayList<String> times = new ArrayList<>();
            for (int i = 0; i < schedule.getSchedule().get(week - 1).get(Integer.toString(day)).size(); i++) {
                times.add(schedule.getSchedule().get(week - 1).get(Integer.toString(day)).get(i));
            }

            timeField.setItems( addBookingViewController.parseTimes(addBookingViewController.getTimes(Integer.parseInt(dateField.getSelectionModel().getSelectedItem().toString().substring(4, 5)),
            
                    Integer.parseInt(dateField.getSelectionModel().getSelectedItem().toString().substring(11)), schedule)));
            timeField.setPromptText("Choose time");

        });

        searchButton.setOnAction(event -> {
            phoneNrField.setDisable(true);
            updateButton.setVisible(true);
            String phoneNumber = searchField.getText();
            Booking booking = addBookingViewController.getBookingByPhoneNUmber(phoneNumber);
            /*String dateValue = booking.getDate();
            try {
                Date date = new SimpleDateFormat("yyyy-mm-dd").parse(dateValue);
                LocalDate localDate = LocalDate.parse(new SimpleDateFormat(("yyyy-MM-dd").format(dateValue)));
                dateField.setValue(localDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }*/

            if (booking != null) {
                titleCombo.setValue((booking.getTitle()));
                dateField.setValue(booking.getDate());
                timeField.setValue(booking.getTime());
                seatsField.setText(Integer.toString(booking.getSeats()));
                phoneNrField.setText(booking.getPhoneNumber());
                paidCheck.setSelected(booking.isPaid());
                addButton.setVisible(false);
            } else {
                searchNotFound.setText("This ticket id doesn't exist");
            }


        });

        addButton.setOnAction(event -> {

            addBookingViewController.insertBooking(dateField.getValue(),timeField.getValue(),titleCombo.getValue().toString(),Integer.parseInt(seatsField.getText()),phoneNrField.getText(),paidCheck.isSelected());
            primaryStage.close();

            }else{
                addBookingViewController.insertBooking(
                        dateField.getValue(),
                        timeField.getValue(),
                        titleCombo.getValue().toString(),
                        Integer.parseInt(seatsField.getText()),
                        phoneNrField.getText(),
                        paidCheck.isSelected());
                BuyFoodView buyFoodView = new BuyFoodView();
                buyFoodView.startBuyFoodView();
                buyFoodView.phoneNumber = phoneNrField.getText();
            }
            primaryStage.close();
        });
        updateButton.setOnAction(event -> {
            Booking booking = addBookingViewController.getBookingByPhoneNUmber(phoneNrField.getText());
            if(!paidCheck.isSelected()==(booking.isPaid())){
                addBookingViewController.updatePaid(paidCheck.isSelected(),phoneNrField.getText());
            }if(!seatsField.getText().equals(booking.getSeats())){
                addBookingViewController.updateSeat(seatsField.getText(), phoneNrField.getText());
            }if(!timeField.getValue().equals(booking.getTime())){
                addBookingViewController.updateTime(timeField.getValue(), phoneNrField.getText());

            }if(!dateField.getValue().equals(booking.getDate())){
                addBookingViewController.updateDate(dateField.getValue(),phoneNrField.getText());
            }if(!titleCombo.getValue().equals(booking.getTitle())){
                addBookingViewController.updateTitle(titleCombo.getValue().toString(),phoneNrField.getText());

            }
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Save");
            alert.setHeaderText("You updated the booking");
            ButtonType buttonTypeYes = new ButtonType("OK");

            Optional<ButtonType> results = alert.showAndWait();
            if (results.get() == buttonTypeYes){
                alert.close();
            }


            alert.getButtonTypes().setAll(buttonTypeYes);
            primaryStage.close();






        });



    }



}
