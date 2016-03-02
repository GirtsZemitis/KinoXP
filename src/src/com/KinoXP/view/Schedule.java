package com.KinoXP.view;

import com.KinoXP.controller.ManageMovieSceduleController;
import com.KinoXP.model.Movie;
import com.KinoXP.model.TimeModel;
import com.KinoXP.controller.NewMovieViewController;
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
    Button printButton;
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
    ManageMovieSceduleController manageMovieSceduleController = new ManageMovieSceduleController();
    //save Button
    Button saveButton;
    ComboBox<Movie> choiceBox;
    String title ="";
    VBox vBox;
    VBox vBox1;
    int b =0;
    Movie movie;
    public Schedule(String s){
        title =s;
    }
    public Schedule(){

    }
    public void start() {
        Stage primaryStage = new Stage();
        //populate array with 12 weeks
        arrayList = manageMovieSceduleController.getArrayList();
        table = new TableView();
        nrOfWeek = new Label("week 1");
        choiceBox = new ComboBox<>();
        choiceBox.setItems(manageMovieSceduleController.getMovieTitles());
        choiceBox.setOnAction(event3 -> {
            System.out.println("you select "+choiceBox.getSelectionModel().getSelectedItem());
            movie=choiceBox.getSelectionModel().getSelectedItem();
            title = movie.getTitle();
            if(b==0){
                vBox1.getChildren().add(table);

            }
            b++;
            weekCounter=1;
            nrOfWeek.setText("week"+weekCounter);

            table.setItems(arrayList.get(weekCounter-1).readFromDb(manageMovieSceduleController.getScheduleForMovie(title,1),10));


        });

        Label movieTitle = new Label("movie 1");
        pleaseSelectMovie = new Label("Please select movie");
        pleaseSelectMovie.setPrefSize(200,30);
        nextButton = new Button("next week");
        nextButton.setOnAction(event2 -> {
            weekCounter++;
            if (weekCounter <= 10) {
                if(title.equals("")){
                    arrayList.get(weekCounter-1).readFromDb(manageMovieSceduleController.printScheduleFromDb(weekCounter),weekCounter);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                    setNumberOfWeek(weekCounter);
                }else {
                    //--next-- when movie form add
                    arrayList.get(weekCounter-1).readFromDb(manageMovieSceduleController.getScheduleForMovie(title,weekCounter),10);
                    table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                    setNumberOfWeek(weekCounter);

                }

            } else {
                weekCounter = 1;
                arrayList.get(weekCounter-1).readFromDb(manageMovieSceduleController.printScheduleFromDb(weekCounter),weekCounter);
                table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                setNumberOfWeek(weekCounter);


            }
        });
        preButton = new Button("pre week");
        preButton.setOnAction(event2 -> {
            if (weekCounter > 1) {
                weekCounter--;
                arrayList.get(weekCounter-1).readFromDb(manageMovieSceduleController.getScheduleForMovie(title,weekCounter),10);
                table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                setNumberOfWeek(weekCounter);


            } else {
                weekCounter = 10;
                arrayList.get(weekCounter-1).readFromDb(manageMovieSceduleController.getScheduleForMovie(title,weekCounter),10);
                table.setItems(arrayList.get(weekCounter - 1).getObservableListFromDb());
                setNumberOfWeek(weekCounter);

            }
        });
        printButton = new Button("Print schedule");
        printButton.setOnAction(event1 -> {
           arrayList.get(weekCounter-1).readFromDb(manageMovieSceduleController.printScheduleFromDb(weekCounter),weekCounter);
        });
        saveButton = new Button("Save ");
        saveButton.setOnAction(event1 -> {
            if(title.equals("")){
                manageMovieSceduleController.saveSchedule(arrayList.get(weekCounter-1).save(arrayList.get(weekCounter-1).getObservableListFromDb()),weekCounter,5);

            }else {
                manageMovieSceduleController.saveSchedule(arrayList.get(weekCounter-1).save(arrayList.get(weekCounter-1).getObservableListFromDb()),weekCounter,movie.getMovieId());

            }
        });
         vBox = new VBox();
         vBox1 = new VBox();
        HBox hBox = new HBox(490);
        vBox.setAlignment(Pos.TOP_CENTER);
        primaryStage.setTitle("Schedule");
        table = new TableView();
        table.setEditable(true);
        table.getSelectionModel().setCellSelectionEnabled(true);

        TableColumn<TimeModel, String> hour = new TableColumn("hours");
        hour.setCellValueFactory(new PropertyValueFactory<>("time"));
        TableColumn monday = new TableColumn("Monday");
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
                                this.setStyle("-fx-background-color: #8bffa7");

                            }
                            if (item.contains("yes")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #18ba0c");

                            }
                            // Get fancy and change color based on data

                        }
                    }
                };
            }
        });

        TableColumn tuesday = new TableColumn("Tuesday");
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
                                this.setStyle("-fx-background-color: #8bffa7");

                            }
                            if (item.contains("yes")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #18ba0c");

                            }
                            // Get fancy and change color based on data

                        }
                    }
                };
            }
        });

        TableColumn wednesday = new TableColumn("Wednesday");
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
                                this.setStyle("-fx-background-color: #8bffa7");

                            }
                            if (item.contains("yes")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #18ba0c");

                            }
                            // Get fancy and change color based on data

                        }
                    }
                };
            }
        });

        TableColumn thursday = new TableColumn("Thursday");
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
                                this.setStyle("-fx-background-color: #8bffa7");

                            }
                            if (item.contains("yes")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #18ba0c");

                            }
                            // Get fancy and change color based on data

                        }
                    }
                };
            }
        });
        TableColumn friday = new TableColumn("Friday");
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
                                this.setStyle("-fx-background-color: #8bffa7");

                            }
                            if (item.contains("yes")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #18ba0c");

                            }
                            // Get fancy and change color based on data

                        }
                    }
                };
            }
        });
        TableColumn saturday = new TableColumn("Saturday");
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
                                this.setStyle("-fx-background-color: #8bffa7");

                            }
                            if (item.contains("yes")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #18ba0c");

                            }
                            // Get fancy and change color based on data

                        }
                    }
                };
            }
        });
        TableColumn sanday = new TableColumn("Sanday");
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
                                this.setStyle("-fx-background-color: #8bffa7");

                            }
                            if (item.contains("yes")) {
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #18ba0c");

                            }
                        }
                    }
                };
            }
        });

       if(title.equals("")){
           table.setItems(arrayList.get(weekCounter - 1).readFromDb(manageMovieSceduleController.printScheduleFromDb(weekCounter),weekCounter));

       }else {

           table.setItems(arrayList.get(weekCounter-1).readFromDb(manageMovieSceduleController.getScheduleForMovie(title,1),10));
       }
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
        hBox.getChildren().addAll(preButton, nextButton);
        if(title.equals("")){
            vBox1.getChildren().add(pleaseSelectMovie);
            vBox.getChildren().addAll(hBox, nrOfWeek, choiceBox, movieTitle, vBox1, printButton,saveButton);

        }else {
            movieTitle.setText(title);
            vBox.getChildren().addAll(hBox, nrOfWeek, movieTitle,table, printButton,saveButton);

        }
        Scene scene = new Scene(vBox, 650, 600);
        scene.getStylesheets().add("ManageMovieSceduleViewPackage/style.css");

        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public void setNumberOfWeek(int i) {

        nrOfWeek.setText("week " + i);
    }

}
