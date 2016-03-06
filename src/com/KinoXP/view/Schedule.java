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
import java.util.Calendar;

/**
 * Created by krystian on 2015-09-04.
 */
public class Schedule {

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
    //columns for schedule
    TableColumn<TimeModel, String> hour;
    TableColumn monday;
    TableColumn tuesday;
    TableColumn wednesday;
    TableColumn thursday;
    TableColumn friday;
    TableColumn saturday;
    TableColumn sanday;

    //some layouts
    VBox vBox;
    VBox vBox1;
    //movie object
    Movie movie;
    //label for storing movie title
    Label movieTitleText;
    //constructor for schedule which is takes movie object
    int weekFromDb = 0;

    public Schedule(Movie m){

        movie= m;
    }
    //empty construction for schedue
    public Schedule(){

    }

    public void start() {
        //setting week from db
         Calendar cal = Calendar.getInstance();
         cal.setTime(movie.getDate());
        weekFromDb = cal.get(Calendar.WEEK_OF_YEAR);
        final int weekLimit =weekFromDb+12;

        // set primaryStage
        Stage primaryStage = new Stage();
        //populate array with 12 weeks
        arrayList = manageMovieScheduleController.getArrayList();
        //iniciate table
        table = new TableView();
        //nr of week
        nrOfWeek = new Label("week"+weekFromDb);
        nrOfWeek.setId("room");
        //back Button
        back = new Button("Go back");

        back.setId("back");
        //acton for back
        back.setOnAction(event3 -> {
            primaryStage.close();
        });
        //movie title lablle
        Label movieTitle = new Label("movie 1");
        //movieTitle
        movieTitleText = new Label("movie title: " );
        movieTitleText.setId("movieTitleText");

        pleaseSelectMovie = new Label("Please select movie");
        pleaseSelectMovie.setPrefSize(200,30);
        nextButton = new Button("next week");
        nextButton.setId("navigationButon");
        nextButton.setOnAction(event2 -> {
            // Increments  weekCounter
            weekCounter++;
            weekFromDb++;
            // If week counter is bigger then less or equals  12
            if (weekFromDb <weekLimit) {
                //return week from array

                arrayList.get(weekCounter-1).readFromDb(manageMovieScheduleController.getScheduleForMovie(movie.getTitle(),weekCounter));
                table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                setNumberOfWeek(weekFromDb);



            } else {
                weekCounter = 1;
                weekFromDb = weekLimit-12;
                arrayList.get(weekCounter-1).readFromDb(manageMovieScheduleController.getScheduleForMovie(movie.getTitle(),weekCounter));
                table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                setNumberOfWeek(weekFromDb);


            }
        });
        preButton = new Button("pre week");
        preButton.setId("navigationButon");
        preButton.setOnAction(event2 -> {
            if (weekCounter > 1) {
                weekCounter--;
                weekFromDb--;
                arrayList.get(weekCounter-1).readFromDb(manageMovieScheduleController.getScheduleForMovie(movie.getTitle(),weekCounter));
                table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                setNumberOfWeek(weekFromDb);


            } else {
                weekCounter = 12;
                weekFromDb = weekLimit;
                arrayList.get(weekCounter-1).readFromDb(manageMovieScheduleController.getScheduleForMovie(movie.getTitle(),weekCounter));
                table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                setNumberOfWeek(weekFromDb);

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
                            if (item.contains("n")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #9bb6b3;" +
                                              "-fx-border-bottom-style: solid; " +
                                              "-fx-border-color: white; " );
                              //  this.setStyle("-fx-border-style: solid");
                                //this.setStyle("-fx-border-color: white");


                            }
                            if (item.contains("y")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #506360;" +
                                        "-fx-border-bottom-style: solid; " +
                                        "-fx-border-color: white; " );
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
                            if (item.contains("n")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #9bb6b3;" +
                                        "-fx-border-bottom-style: solid; " +
                                        "-fx-border-color: white; " );
                            }
                            if (item.contains("y")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #506360;" +
                                        "-fx-border-bottom-style: solid; " +
                                        "-fx-border-color: white; " );
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
                            if (item.contains("n")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #9bb6b3;" +
                                        "-fx-border-bottom-style: solid; " +
                                        "-fx-border-color: white; " );
                            }
                            if (item.contains("y")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #506360;" +
                                        "-fx-border-bottom-style: solid; " +
                                        "-fx-border-color: white; " );
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
                            if (item.contains("n")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #9bb6b3;" +
                                        "-fx-border-bottom-style: solid; " +
                                        "-fx-border-color: white; " );
                            }
                            if (item.contains("y")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #506360;" +
                                        "-fx-border-bottom-style: solid; " +
                                        "-fx-border-color: white; " );
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
                            if (item.contains("n")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #9bb6b3;" +
                                        "-fx-border-bottom-style: solid; " +
                                        "-fx-border-color: white; " );
                            }
                            if (item.contains("y")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #506360;" +
                                        "-fx-border-bottom-style: solid; " +
                                        "-fx-border-color: white; " );
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
                            if (item.contains("n")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #9bb6b3;" +
                                        "-fx-border-bottom-style: solid; " +
                                        "-fx-border-color: white; " );
                            }
                            if (item.contains("y")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #506360;" +
                                        "-fx-border-bottom-style: solid; " +
                                        "-fx-border-color: white; " );
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
                            if (item.contains("n")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #9bb6b3;" +
                                        "-fx-border-bottom-style: solid; " +
                                        "-fx-border-color: white; " );
                            }
                            if (item.contains("y")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #506360;" +
                                        "-fx-border-bottom-style: solid; " +
                                        "-fx-border-color: white; " );
                            }
                        }
                    }
                };
            }
        });



        table.setItems(arrayList.get(weekCounter-1).readFromDb(manageMovieScheduleController.getScheduleForMovie(movie.getTitle(),1)));

        table.getColumns().addAll(hour, monday, tuesday, wednesday, thursday, friday, saturday, sanday);
        table.setOnMouseClicked(event -> {
            TablePosition firstCell = table.getSelectionModel().getSelectedCells().get(0);
            int column = firstCell.getColumn();
            int row = firstCell.getRow();
            TimeModel timeModel = table.getSelectionModel().getSelectedItem();

            if (column == 1) {
                if (timeModel.getMonday().equals("n")) {
                    timeModel.setMonday("y");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                } else {
                    timeModel.setMonday("n");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                }


            }
            if (column == 2) {
                if (timeModel.getTuesday().equals("n")) {
                    timeModel.setTuesday("y");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                } else {
                    timeModel.setTuesday("n");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                }
            }
            if (column == 3) {
                if (timeModel.getWednesday().equals("n")) {

                    timeModel.setWednesday("y");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                } else {
                    timeModel.setWednesday("n");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                }
            }
            if (column == 4) {
                if (timeModel.getThrusday().equals("n")) {

                    timeModel.setThrusday("y");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                } else {
                    timeModel.setThrusday("n");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                }
            }
            if (column == 5) {
                if (timeModel.getFriday().equals("n")) {
                    timeModel.setFriday("y");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                } else {
                    timeModel.setFriday("n");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                }
            }
            if (column == 6) {
                if (timeModel.getSaturday().equals("n")) {

                    timeModel.setSaturday("y");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                } else {
                    timeModel.setSaturday("n");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                }
            }
            if (column == 7) {
                if (timeModel.getSunday().equals("n")) {

                    timeModel.setSunday("y");
                    arrayList.get(weekCounter - 1).setYesDb(timeModel, row);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());;
                } else {
                    timeModel.setSunday("n");
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
        HBox hBox = new HBox(30);
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
        Button button1 = new Button("Go to main manu");
        button1.setOnAction(event2 -> {
            primaryStage.close();
        });
        button1.setId("button");
        hBox.getChildren().addAll(button1,button);

        ComboBox<Movie> comboBox = new ComboBox<>();

        ComboBox<String>movieTheaterTxt= new ComboBox<>(options);
        movieTheaterTxt.setOnAction(event -> {
            comboBox.setItems(manageMovieScheduleController.getMovieTitles(movieTheaterTxt.getSelectionModel().getSelectedItem()));
        });
        movieTheaterTxt.setValue("Theater 1");

        String cinameRoomName = movieTheaterTxt.getSelectionModel().getSelectedItem();
        comboBox.setItems(manageMovieScheduleController.getMovieTitles(cinameRoomName));

        vbox.getChildren().addAll(label,label1,movieTheaterTxt, label2,comboBox,hBox);
        vbox.setMargin(label,new Insets(120,0,0,0));
        vbox.setMargin(label1,new Insets(30,0,0,0));
        vbox.setMargin(movieTheaterTxt,new Insets(10,0,0,0));
        vbox.setMargin(label2,new Insets(30,0,0,0));
        vbox.setMargin(comboBox,new Insets(10,0,0,0));
        vbox.setMargin(hBox,new Insets(180,0,0,0));


        button.setOnAction(event1 -> {
            try{
                Movie movie =   comboBox.getSelectionModel().getSelectedItem();
                manageMovieScheduleController.scheduleDisplay(movie);

            }catch (Exception e){
                label2.setId("chooseMovie");
            }

        });

        vbox.setAlignment(Pos.TOP_CENTER);
        hBox.setAlignment(Pos.TOP_CENTER);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //conformition for saving

    public void conformitionForSaving(){

        Stage primaryStage = new Stage();
        VBox vbox = new VBox();
        String title = movie.getTitle();
        Label label = new Label("You have save "+" week "+weekFromDb +"\n"+" for \n "+ "''"+title+"''");
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
