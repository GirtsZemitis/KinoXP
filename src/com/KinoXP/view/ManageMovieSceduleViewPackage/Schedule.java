package ManageMovieSceduleViewPackage;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * Created by krystian on 2015-09-04.
 */
public class Schedule extends Application {
    ObservableList<Time> observableList;
    Label welcom;
    Button printButton;
    Button nextButton;
    Button preButton;
    MovieWeek movieWeek;
    Label nrOfWeek;
    int weekCounter = 1;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public  void start(Stage primaryStage) throws Exception{

        movieWeek = new MovieWeek();

        nrOfWeek = new Label("week 1");
        Label movieTitle = new Label("movie title");
        nextButton = new Button("next week");
        nextButton.setOnAction(event2 -> {
            weekCounter++;
            if(weekCounter<=12){
                setNumberOfWeek(weekCounter);
            }else{
                weekCounter = 1;
                setNumberOfWeek(weekCounter);

            }
        });
        preButton = new Button("pre week");
        preButton.setOnAction(event2 -> {
            if(weekCounter>1){
                weekCounter--;
                setNumberOfWeek(weekCounter);
            }else {
                weekCounter = 12;
                setNumberOfWeek(weekCounter);
            }
        });
        printButton = new Button("Print schedule");
        printButton.setOnAction(event1 -> {
            movieWeek.printOut();

        });
        VBox vBox = new VBox();
        HBox hBox = new HBox(490);
        vBox.setAlignment(Pos.TOP_CENTER);
        primaryStage.setTitle("Schedule");
        TableView<Time> table = new TableView();
        table.setEditable(true);
        table.getSelectionModel().setCellSelectionEnabled(true);

        TableColumn<Time,String> hour  = new TableColumn("hours");
        hour.setCellValueFactory(new PropertyValueFactory<>("time"));
        TableColumn monday = new TableColumn("Monday");
        monday.setCellValueFactory(new PropertyValueFactory<Time, String>("monday"));
        monday.setCellFactory(new Callback<TableColumn, TableCell>() {
            public TableCell call(TableColumn param) {
                return new TableCell<TableCellTextColorExample.TableData, String>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            if(item.contains("no")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #8bffa7");

                            }
                            if(item.contains("yes")){
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
                            if(item.contains("no")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #8bffa7");

                            }
                            if(item.contains("yes")){
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
                            if(item.contains("no")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #8bffa7");

                            }
                            if(item.contains("yes")){
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
                            if(item.contains("no")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #8bffa7");

                            }
                            if(item.contains("yes")){
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
                            if(item.contains("no")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #8bffa7");

                            }
                            if(item.contains("yes")){
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
                            if(item.contains("no")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #8bffa7");

                            }
                            if(item.contains("yes")){
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #18ba0c");

                            }
                            // Get fancy and change color based on data

                        }
                    }
                };
            }
        });
        TableColumn sanday  = new TableColumn("Sanday");
        sanday.setCellValueFactory(new PropertyValueFactory<Time, String>("sunday"));

        sanday.setCellFactory(new Callback<TableColumn, TableCell>() {
            public TableCell call(TableColumn param) {
                return new TableCell<TableCellTextColorExample.TableData, String>() {

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (!isEmpty()) {
                            if(item.contains("no")) {
                                this.setTextFill(Color.RED);
                                this.setStyle("-fx-background-color: #8bffa7");

                            }
                            if(item.contains("yes")){
                                this.setTextFill(Color.GREEN);

                                this.setStyle("-fx-background-color: #18ba0c");

                            }
                        }
                    }
                };
            }
        });


        table.setItems(movieWeek.getObservableList());
        table.getColumns().addAll(hour, monday, tuesday, wednesday, thursday, friday, saturday,sanday);
        table.setOnMouseClicked(event -> {
            TablePosition firstCell = table.getSelectionModel().getSelectedCells().get(0);
            int column =  firstCell.getColumn();
            int row = firstCell.getRow();
            Time time = table.getSelectionModel().getSelectedItem();

            if(column==1){
                if(time.getMonday().equals("no")){
                    time.setMonday("yes");
                    movieWeek.setYes(time,row);
                    table.setItems(movieWeek.getObservableList());
                }else{
                    time.setMonday("no");
                    movieWeek.setYes(time,row);
                    table.setItems(movieWeek.getObservableList());
                }


            }
            if(column==2){
                if(time.getTuesday().equals("no")) {
                    time.setTuesday("yes");
                    movieWeek.setYes(time, row);
                    table.setItems(movieWeek.getObservableList());
                }else{
                    time.setTuesday("no");
                    movieWeek.setYes(time,row);
                    table.setItems(movieWeek.getObservableList());
                }
            }
            if(column==3){
                if(time.getWednesday().equals("no")) {

                    time.setWednesday("yes");
                    movieWeek.setYes(time, row);
                    table.setItems(movieWeek.getObservableList());
                }else {
                    time.setWednesday("no");
                    movieWeek.setYes(time,row);
                    table.setItems(movieWeek.getObservableList());
                }
            }
            if(column==4){
                if(time.getThrusday().equals("no")) {

                    time.setThrusday("yes");
                    movieWeek.setYes(time, row);
                    table.setItems(movieWeek.getObservableList());
                }else {
                    time.setThrusday("no");
                    movieWeek.setYes(time, row);
                    table.setItems(movieWeek.getObservableList());
                }
            }
            if(column==5){
                if(time.getFriday().equals("no")) {
                    time.setFriday("yes");
                    movieWeek.setYes(time, row);
                    table.setItems(movieWeek.getObservableList());
                }else {
                    time.setFriday("no");
                    movieWeek.setYes(time,row);
                    table.setItems(movieWeek.getObservableList());
                }
            }
            if(column==6){
                if(time.getSaturday().equals("no")) {

                    time.setSaturday("yes");
                    movieWeek.setYes(time, row);
                    table.setItems(movieWeek.getObservableList());
                }else {
                    time.setSaturday("no");
                    movieWeek.setYes(time,row);
                    table.setItems(movieWeek.getObservableList());
                }
            }
            if(column==7){
                if(time.getSunday().equals("no")) {

                    time.setSunday("yes");
                    movieWeek.setYes(time, row);
                    table.setItems(movieWeek.getObservableList());
                }else {
                    time.setSunday("no");
                    movieWeek.setYes(time,row);
                    table.setItems(movieWeek.getObservableList());
                }
            }



        });
        hBox.getChildren().addAll(preButton,nextButton);
        vBox.getChildren().addAll(hBox,nrOfWeek, movieTitle,table,printButton);
        Scene scene = new Scene(vBox, 650,600);
        scene.getStylesheets().add("ManageMovieSceduleViewPackage/style.css");

        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public void setNumberOfWeek(int i){

        nrOfWeek.setText("week " + i);
    }


}
