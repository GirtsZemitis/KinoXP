package com.KinoXP.view;

import com.KinoXP.controller.AddBookingViewController;
import com.KinoXP.controller.TicketController;
import com.KinoXP.model.Booking;
import com.KinoXP.model.TicketModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 * Created by Palko on 05/03/2016.
 */
public class TicketView {


    private AddBookingViewController addBookingViewController = new AddBookingViewController();
    private TicketController ticketController;
    private TicketModel ticketModel;
    private com.KinoXP.model.Schedule schedule;
    private Booking booking;

    private TableView<Booking> tableView = new TableView<>();
    CheckBox paidCheckBox,reservedCheckBox,theatre1CheckBox,theatre2CheckBox;
    TextField phoneNumberTxt;
    Stage resultStage;

    public TicketView(){
        ticketModel = new TicketModel();
        ticketController = new TicketController(ticketModel, this);
    }

    public void start() {

        BorderPane borderPane = new BorderPane();

        //LABELS
        Label mainLabel = new Label("Search Booking");
        mainLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
        mainLabel.setAlignment(Pos.CENTER);
        Label searchLabel = new Label("Search booking by:");
        searchLabel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        Label phoneLabel = new Label("Phone Number");
        Label titleLabel = new Label("Movie");
        Label dateLabel = new Label("Date");
        Label timeLabel = new Label("Time");
        Label paidLabel = new Label("Paid");
        Label reservedLabel = new Label("Reserved");
        Label theatreLabel = new Label("Theatre");

        //TEXT FIELDS
        phoneNumberTxt = new TextField();
        phoneNumberTxt.setMaxWidth(150);

        //COMBO BOXES
        ObservableList<String> options = ticketModel.getMovies(); //addBookingViewController.getMoviesWithSchedule();
        ComboBox titleCombo = new ComboBox(options);
        titleCombo.setPromptText("Choose a movie");
        titleCombo.setMaxWidth(150);
        ComboBox<String> dateField = new ComboBox<>();
        dateField.setMinWidth(150);
        ComboBox<String> timeField = new ComboBox<>();
        timeField.setMinWidth(150);
        ObservableList<String> theatreList = FXCollections.observableArrayList(
                        "Theatre 1",
                        "Theatre 2"
                );
        ComboBox<String> theatreField = new ComboBox(theatreList);
        theatreField.setMinWidth(150);



                //CHECK BOXES
        paidCheckBox = new CheckBox();
        paidCheckBox.setSelected(false);
        reservedCheckBox = new CheckBox();
        reservedCheckBox.setSelected(false);
        theatre1CheckBox = new CheckBox();
        theatre1CheckBox.setSelected(false);
        theatre2CheckBox = new CheckBox();
        theatre2CheckBox.setSelected(false);

        //BUTTONS
        Button searchButton = new Button("SEARCH");
        searchButton.setId("scheduleButtons");
        Button mainMenuButton = new Button("MAIN MENU");
        mainMenuButton.setId("scheduleButtons");

        //H-BOXES
        VBox vBoxLeft = new VBox();
        vBoxLeft.setSpacing(5);
        HBox paidBox = new HBox();
        paidBox.setSpacing(10);
        HBox reservedBox = new HBox();
        reservedBox.setSpacing(10);
        HBox theatre1 = new HBox();
        theatre1.setSpacing(10);
        HBox theatre2 = new HBox();
        theatre1.setSpacing(10);
        HBox buttons = new HBox();
        buttons.setSpacing(50);
        buttons.setAlignment(Pos.BOTTOM_CENTER);
        HBox checkedBoxes1 = new HBox();
        checkedBoxes1.setSpacing(10);
        HBox checkedBoxes2 = new HBox();
        checkedBoxes2.setSpacing(10);
        VBox layout = new VBox();

        paidBox.getChildren().addAll(paidLabel, paidCheckBox);
        reservedBox.getChildren().addAll(reservedLabel, reservedCheckBox);
        buttons.getChildren().addAll(mainMenuButton, searchButton);
        checkedBoxes1.getChildren().addAll(paidBox, reservedBox);
        checkedBoxes2.getChildren().addAll(theatre1, theatre2);
        vBoxLeft.getChildren().addAll(phoneLabel, phoneNumberTxt, titleLabel, titleCombo, dateLabel, dateField,
                timeLabel, timeField, theatreLabel ,theatreField);

        layout.getChildren().addAll(searchLabel, vBoxLeft, checkedBoxes1, checkedBoxes2);
        layout.setPadding(new Insets(40, 40, 40, 60));
        layout.setSpacing(10);

        borderPane.setTop(mainLabel);
        borderPane.setCenter(layout);
        borderPane.setBottom(buttons);
        borderPane.setPadding(new Insets(40, 40, 40, 60));


        //SCENE
        Scene scene = new Scene(borderPane, 400, 550);
        Stage primaryStage = new Stage();

        primaryStage.setScene(scene);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setResizable(false);
        primaryStage.show();

        //CHECK BOXES LISTENERS
        paidCheckBox.setOnAction(e -> handleButtonAction(e));
        reservedCheckBox.setOnAction(e -> handleButtonAction(e));
        theatre1CheckBox.setOnAction(e -> handleButtonAction(e));
        theatre2CheckBox.setOnAction(e -> handleButtonAction(e));


        //COMBO BOXES LISTENERS
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

        //BUTTONS ACTION
        searchButton.setOnAction(event -> {
            primaryStage.close();

            if(phoneNumberTxt.getText().length() > 0){
                ticketController.returnBookingByPhoneNumber(phoneNumberTxt.getText());
                tableView.setItems(ticketController.returnBookingByPhoneNumber(phoneNumberTxt.getText()));
            }else if(titleCombo.getValue() != null){
                ticketController.returnBookingByTitle(String.valueOf(titleCombo.getValue()));
                tableView.setItems(ticketController.returnBookingByTitle(String.valueOf(titleCombo.getValue())));
            }else if(dateField.getValue() != null){
                ticketController.returnBookingByDate(String.valueOf(dateField.getValue()));
                tableView.setItems(ticketController.returnBookingByDate(String.valueOf(dateField.getValue())));
            }else if(timeField.getValue() != null){
                //ticketController.returnBookingByTime(String.valueOf(timeField.getValue()));
                //tableView.setItems(ticketController.returnBookingByTime(String.valueOf(timeField.getValue())));
            }else if (paidCheckBox.isSelected()){
                //ticketController.returnBookingByPaidTickets(paidCheckBox.isSelected());
                //tableView.setItems(ticketController.returnBookingByPaidTickets(paidCheckBox.isSelected()));
            }else{
                updateAlertMessage("You need to select at least one criteria to be able to search for a booking");
            }

            //H-BOXES
            HBox hBox = new HBox(20);
            hBox.setPrefSize(200, 80);

            //BUTTONS
            Button logOut = new Button("LOG OUT");
            logOut.setStyle("-fx-font-size: 15");
            Button goBack = new Button("GO BACK");
            goBack.setStyle("-fx-font-size: 15");

            //BUTTONS ACTION
            logOut.setOnAction(event1 -> {
                resultStage.close();
                LoginView loginView = new LoginView();
                loginView.start();

            });

            goBack.setOnAction(event2 -> {
                resultStage.close();
                TicketView ticketView = new TicketView();
                ticketView.start();
            });

            hBox.getChildren().addAll(goBack, logOut);
            hBox.setAlignment(Pos.CENTER);

            BorderPane secondBorderPane = new BorderPane();
            secondBorderPane.setTop(showBookings());
            secondBorderPane.setBottom(hBox);

            //SCENE
            Scene scene2 = new Scene(secondBorderPane, 1000, 650);

            //STAGE
            resultStage = new Stage();
            resultStage.setScene(scene2);
            resultStage.show();

        });

        mainMenuButton.setOnAction(event -> {
            primaryStage.close();
            MenuView menuView = new MenuView();
            menuView.start();
        });

    }

    //METHOD FOR HANDLING THE CHECK BOXES
    private void handleButtonAction(ActionEvent e) {
        if (paidCheckBox.isSelected()) {

        }
        if (reservedCheckBox.isSelected()) {

        }
        if (theatre1CheckBox.isSelected()) {

        }
        if (theatre2CheckBox.isSelected()) {

        }
    }

    //TABLE VIEW FOR SHOWING BOOKINGS
    public TableView<Booking> showBookings() {

        //ticketController.returnBookingByPhoneNumber(phoneNumberTxt.getText());
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


        javafx.scene.control.TableColumn<Booking, String> date = new javafx.scene.control.TableColumn<>("Date:");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        date.setMinWidth(200);

        javafx.scene.control.TableColumn<Booking, String> time = new javafx.scene.control.TableColumn<>("Time:");
        time.setCellValueFactory(new PropertyValueFactory<>("time"));
        time.setMinWidth(100);

        javafx.scene.control.TableColumn<Booking, String> title = new javafx.scene.control.TableColumn<>("Title:");
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        title.setMinWidth(250);


        javafx.scene.control.TableColumn<Booking, Integer> seats = new javafx.scene.control.TableColumn<>("Seats:");
        seats.setCellValueFactory(new PropertyValueFactory<>("seats"));
        seats.setMinWidth(50);

        javafx.scene.control.TableColumn<Booking, String> phoneNumber = new javafx.scene.control.TableColumn<>("Phone number:");
        phoneNumber.setCellValueFactory(new PropertyValueFactory<>("phone_number"));
        phoneNumber.setMinWidth(150);


        javafx.scene.control.TableColumn<Booking, String> paid = new javafx.scene.control.TableColumn<>("Paid:");
        paid.setCellValueFactory(new PropertyValueFactory<>("isPaid"));
        paid.setMinWidth(50);

        tableView.getColumns().addAll(date, time, title, seats, phoneNumber, paid);

        return tableView;

    }

    //METHOD FOR THE ALERT MESSAGES SHOWN TO THE USER
    public static void updateAlertMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }

}



