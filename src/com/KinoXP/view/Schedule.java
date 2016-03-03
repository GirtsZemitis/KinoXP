package com.KinoXP.view;

import com.KinoXP.controller.ManageMovieScheduleController;
import com.KinoXP.model.ManageMovieSceduleModel;
import com.KinoXP.model.Movie;
import com.KinoXP.model.TimeModel;
import com.KinoXP.controller.NewMovieViewController;
import com.sun.org.apache.xml.internal.security.utils.SignerOutputStream;
import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.ArrayList;

/**
 * Created by krystian on 2015-09-04.
 */
public class Schedule {
    //button for prinitng week in console

    //button for change week
    Button nextButton;
    //button for change week
    Button preButton;
    //array list which gonna hold 12 weeks
    ArrayList<MovieWeek> arrayList;
    //label for week nr
    Label nrOfWeek;
    //label informing about choosing movie firstly
    Label pleaseSelectMovie;
    // weekcounter
    int weekCounter = 1;
    //table view for holding schedule
    TableView<TimeModel> table;
    //controller object
    ManageMovieScheduleController manageMovieScheduleController = new ManageMovieScheduleController();
    //save Button
    Button saveButton;
    //back Button
    Button back;
    TableColumn<TimeModel, String> hour;
    TableColumn monday;
    TableColumn tuesday;
    TableColumn wednesday;
    TableColumn thursday;
    TableColumn friday;
    TableColumn saturday;
    TableColumn sanday;
    ComboBox<Movie> choiceBox;

    VBox vBox;
    VBox vBox1;
    int b =0;
    Movie movie;
    Label movieTitleText;
    public Schedule(Movie m){
        movie= m;
    }
    public Schedule(){

    }
    public void start() {
        Stage primaryStage = new Stage();
        //populate array with 12 weeks
        arrayList = manageMovieScheduleController.getArrayList();
        table = new TableView();
        nrOfWeek = new Label("week 1");
        nrOfWeek.setId("room");
        back = new Button("Go back");
        back.setId("back");
        back.setOnAction(event3 -> {
            primaryStage.close();
        });
        Label movieTitle = new Label("movie 1");
        movieTitleText = new Label("movie title: " );
        movieTitleText.setId("movieTitleText");
        pleaseSelectMovie = new Label("Please select movie");
        pleaseSelectMovie.setPrefSize(200,30);
        nextButton = new Button("next week");
        nextButton.setId("navigationButon");
        nextButton.setOnAction(event2 -> {
            weekCounter++;
            if (weekCounter <= 10) {

                //--next-- when movie form add
                arrayList.get(weekCounter-1).readFromDb(manageMovieScheduleController.getScheduleForMovie(movie.getTitle(),weekCounter),10);
                table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                setNumberOfWeek(weekCounter);



            } else {
                weekCounter = 1;
                arrayList.get(weekCounter-1).readFromDb(manageMovieScheduleController.printScheduleFromDb(weekCounter),weekCounter);
                table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                setNumberOfWeek(weekCounter);


            }
        });
        preButton = new Button("pre week");
        preButton.setId("navigationButon");
        preButton.setOnAction(event2 -> {
            if (weekCounter > 1) {
                weekCounter--;
                arrayList.get(weekCounter-1).readFromDb(manageMovieScheduleController.getScheduleForMovie(movie.getTitle(),weekCounter),10);
                table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                setNumberOfWeek(weekCounter);


            } else {
                weekCounter = 10;
                arrayList.get(weekCounter-1).readFromDb(manageMovieScheduleController.getScheduleForMovie(movie.getTitle(),weekCounter),10);
                table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                setNumberOfWeek(weekCounter);

            }
        });

        saveButton = new Button("Save ");
        saveButton.setId("save");
        saveButton.setOnAction(event1 -> {

            manageMovieScheduleController.saveSchedule(arrayList.get(weekCounter-1).save(arrayList.get(weekCounter-1).getObservableListFromDb()),weekCounter,movie.getMovieId());
            conformitionForSaving();

        });
        vBox = new VBox();
        vBox1 = new VBox();
        HBox hBox = new HBox();
        HBox hBox1 = new HBox();
        vBox.setAlignment(Pos.TOP_CENTER);
        primaryStage.setTitle("Schedule");
        table = new TableView();
        table.setEditable(true);
        table.getSelectionModel().setCellSelectionEnabled(true);

        hour = new TableColumn("hours");
        hour.setCellValueFactory(new PropertyValueFactory<>("time"));
        monday = new TableColumn("Monday");
        monday.setCellValueFactory(new PropertyValueFactory<TimeModel, String>("monday"));
        monday.setCellFactory(new Callback<TableColumn, TableCell>() {
            public TableCell call(TableColumn param) {
                return new TableCell<TableCellTextColorExample.TableData, String>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            if (item.contains("no")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #9bb6b3");

                            }
                            if (item.contains("yes")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #96cd99");

                            }
                            // Get fancy and change color based on data

                        }
                    }
                };
            }
        });

        tuesday = new TableColumn("Tuesday");
        tuesday.setCellValueFactory(new PropertyValueFactory<>("tuesday"));
        tuesday.setCellFactory(new Callback<TableColumn, TableCell>() {
            public TableCell call(TableColumn param) {
                return new TableCell<TableCellTextColorExample.TableData, String>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            if (item.contains("no")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #9bb6b3");

                            }
                            if (item.contains("yes")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #96cd99");

                            }
                            // Get fancy and change color based on data

                        }
                    }
                };
            }
        });

        wednesday = new TableColumn("Wednesday");
        wednesday.setCellValueFactory(new PropertyValueFactory<>("wednesday"));
        wednesday.setCellFactory(new Callback<TableColumn, TableCell>() {
            public TableCell call(TableColumn param) {
                return new TableCell<TableCellTextColorExample.TableData, String>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            if (item.contains("no")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #9bb6b3");

                            }
                            if (item.contains("yes")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #96cd99");

                            }
                            // Get fancy and change color based on data

                        }
                    }
                };
            }
        });

        thursday = new TableColumn("Thursday");
        thursday.setCellValueFactory(new PropertyValueFactory<>("thrusday"));
        thursday.setCellFactory(new Callback<TableColumn, TableCell>() {
            public TableCell call(TableColumn param) {
                return new TableCell<TableCellTextColorExample.TableData, String>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            if (item.contains("no")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #9bb6b3");

                            }
                            if (item.contains("yes")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #96cd99");

                            }
                            // Get fancy and change color based on data

                        }
                    }
                };
            }
        });

        friday = new TableColumn("Friday");
        friday.setCellValueFactory(new PropertyValueFactory<>("friday"));
        friday.setCellFactory(new Callback<TableColumn, TableCell>() {
            public TableCell call(TableColumn param) {
                return new TableCell<TableCellTextColorExample.TableData, String>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            if (item.contains("no")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #9bb6b3");

                            }
                            if (item.contains("yes")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #96cd99");

                            }
                            // Get fancy and change color based on data

                        }
                    }
                };
            }
        });


        saturday = new TableColumn("Saturday");
        saturday.setCellValueFactory(new PropertyValueFactory<>("saturday"));
        saturday.setCellFactory(new Callback<TableColumn, TableCell>() {
            public TableCell call(TableColumn param) {
                return new TableCell<TableCellTextColorExample.TableData, String>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            if (item.contains("no")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #9bb6b3");

                            }
                            if (item.contains("yes")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #96cd99");

                            }
                            // Get fancy and change color based on data

                        }
                    }
                };
            }
        });


        sanday = new TableColumn("Sanday");
        sanday.setCellValueFactory(new PropertyValueFactory<TimeModel, String>("sunday"));

        sanday.setCellFactory(new Callback<TableColumn, TableCell>() {
            public TableCell call(TableColumn param) {
                return new TableCell<TableCellTextColorExample.TableData, String>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            if (item.contains("no")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #9bb6b3");

                            }
                            if (item.contains("yes")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #96cd99");

                            }
                        }
                    }
                };
            }
        });



        table.setItems(arrayList.get(weekCounter-1).readFromDb(manageMovieScheduleController.getScheduleForMovie(movie.getTitle(),1),10));

        table.getColumns().addAll(hour, monday, tuesday, wednesday, thursday, friday, saturday, sanday);
        table.setOnMouseClicked(event -> {
            TablePosition firstCell = table.getSelectionModel().getSelectedCells().get(0);
            int column = firstCell.getColumn();
            int row = firstCell.getRow();
            TimeModel timeModel = table.getSelectionModel().getSelectedItem();

            if (column == 1) {
                if (timeModel.getMonday().equals("no")) {
                    timeModel.setMonday("yes");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                } else {
                    timeModel.setMonday("no");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                }


            }
            if (column == 2) {
                if (timeModel.getTuesday().equals("no")) {
                    timeModel.setTuesday("yes");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                } else {
                    timeModel.setTuesday("no");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                }
            }
            if (column == 3) {
                if (timeModel.getWednesday().equals("no")) {

                    timeModel.setWednesday("yes");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                } else {
                    timeModel.setWednesday("no");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                }
            }
            if (column == 4) {
                if (timeModel.getThrusday().equals("no")) {

                    timeModel.setThrusday("yes");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                } else {
                    timeModel.setThrusday("no");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                }
            }
            if (column == 5) {
                if (timeModel.getFriday().equals("no")) {
                    timeModel.setFriday("yes");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                } else {
                    timeModel.setFriday("no");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                }
            }
            if (column == 6) {
                if (timeModel.getSaturday().equals("no")) {

                    timeModel.setSaturday("yes");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                } else {
                    timeModel.setSaturday("no");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                }
            }
            if (column == 7) {
                if (timeModel.getSunday().equals("no")) {

                    timeModel.setSunday("yes");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());;
                } else {
                    timeModel.setSunday("no");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                }
            }


        });
        hBox.setMargin(preButton, new Insets(10,200,0,10));
        hBox.setMargin(nrOfWeek, new Insets(10,200,0,10));
        hBox.setMargin(nextButton, new Insets(10,0,0, 0));
        hBox.getChildren().addAll(preButton,nrOfWeek,nextButton);
        hBox1.setMargin(back, new Insets(10,0,0,10));
        hBox1.setMargin(saveButton, new Insets(30,0,20,280));
        hBox1.getChildren().addAll(back,saveButton);
        vBox.setMargin(movieTitleText, new Insets(20,0,0,0));
        movieTitle.setText(movie.getTitle());
        vBox.getChildren().addAll(hBox,movieTitleText,movieTitle,table,hBox1);

        //set column size
        hour.prefWidthProperty().bind(table.widthProperty().divide(10)); // w * 1/4
        monday.prefWidthProperty().bind(table.widthProperty().divide(8)); // w * 1/4
        tuesday.prefWidthProperty().bind(table.widthProperty().divide(8)); // w * 1/4
        wednesday.prefWidthProperty().bind(table.widthProperty().divide(8)); // w * 1/4
        thursday.prefWidthProperty().bind(table.widthProperty().divide(8)); // w * 1/4
        friday.prefWidthProperty().bind(table.widthProperty().divide(8)); // w * 1/4
        saturday.prefWidthProperty().bind(table.widthProperty().divide(8)); // w * 1/4
        sanday.prefWidthProperty().bind(table.widthProperty().divide(8)); // w * 1/4

        Scene scene = new Scene(vBox, 650, 600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        movieTitle.setId("movieTitle");

        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public void setNumberOfWeek(int i) {

        nrOfWeek.setText("week " + i);
    }
    public void startSchedule(){


        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Theater 1",
                        "Theater 2"

                );


        Stage primaryStage = new Stage();
        VBox vbox = new VBox();
        Scene scene = new Scene(vbox,650,600);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        Label label = new Label("Welcome to manage schedule");
        label.setId("welcome");
        Label label1 = new Label("Please choose room");
        label1.setId("room");
        Label label2 = new Label("Please select movie");
        label2.setId("room");
        Button button = new Button("Go to schedule");
        button.setId("button");

        ComboBox<Movie> comboBox = new ComboBox<>();

        ComboBox<String>movieTheaterTxt= new ComboBox<>(options);
        movieTheaterTxt.setOnAction(event -> {
            comboBox.setItems(manageMovieScheduleController.getMovieTitles(movieTheaterTxt.getSelectionModel().getSelectedItem()));
        });
        movieTheaterTxt.setValue("Theater 1");

        String cinameRoomName = movieTheaterTxt.getSelectionModel().getSelectedItem();
        comboBox.setItems(manageMovieScheduleController.getMovieTitles(cinameRoomName));

        vbox.getChildren().addAll(label,label1,movieTheaterTxt, label2,comboBox,button);
        vbox.setMargin(label,new Insets(120,0,0,0));
        vbox.setMargin(label1,new Insets(30,0,0,0));
        vbox.setMargin(movieTheaterTxt,new Insets(10,0,0,0));
        vbox.setMargin(label2,new Insets(30,0,0,0));
        vbox.setMargin(comboBox,new Insets(10,0,0,0));
        vbox.setMargin(button,new Insets(180,0,0,0));


        button.setOnAction(event1 -> {
            try{
                Movie movie =   comboBox.getSelectionModel().getSelectedItem();
                manageMovieScheduleController.scheduleDisplay(movie);

            }catch (Exception e){
                label2.setId("chooseMovie");
            }

        });

        vbox.setAlignment(Pos.TOP_CENTER);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //conformition for saving

    public void conformitionForSaving(){

        Stage primaryStage = new Stage();
        VBox vbox = new VBox();
        String title = movie.getTitle();
        Label label = new Label("You have save "+" week "+weekCounter +"\n"+" for \n "+ "''"+title+"''");
        label.setId("conformition");
        Button button = new Button("ok");
        button.setId("ok");
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.getChildren().addAll(label,button);
        vbox.setMargin(label, new Insets(30,0,0,0));
        vbox.setMargin(button, new Insets(30,0,30,0));
        button.setOnAction(event -> {
            primaryStage.close();
        });
        Scene scene = new Scene(vbox,350,250);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
