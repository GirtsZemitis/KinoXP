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

import java.util.ArrayList;

/**
 * Created by krystian on 2015-09-04.
 */
public class Schedule extends Application {
    ObservableList<Time> observableList;
    Label welcom;
    Button printButton;
    Button nextButton;
    Button preButton;
    ArrayList<MovieWeek> arrayList;
    TableView<Time> table;


    Label nrOfWeek;
    int weekCounter = 1;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public  void start(Stage primaryStage) throws Exception{
        //arrayList for storing weeks
        arrayList = new ArrayList<>();
        for(int i=0; i<12; i++){
            arrayList.add(new MovieWeek());
        }



        nrOfWeek = new Label("week 1");
        Label movieTitle = new Label("movie title");
        nextButton = new Button("next week");
        nextButton.setOnAction(event2 -> {
            weekCounter++;
            if(weekCounter<=12){
                table.setItems(arrayList.get(weekCounter-1).getObservableList());
                setNumberOfWeek(weekCounter);

            }else{
                weekCounter = 1;
                setNumberOfWeek(weekCounter);
                table.setItems(arrayList.get(weekCounter-1).getObservableList());


            }
        });
        preButton = new Button("pre week");
        preButton.setOnAction(event2 -> {
            if(weekCounter>1){
                weekCounter--;
                setNumberOfWeek(weekCounter);
                table.setItems(arrayList.get(weekCounter-1).getObservableList());

            }else {
                weekCounter = 12;
                setNumberOfWeek(weekCounter);
                table.setItems(arrayList.get(weekCounter-1).getObservableList());

            }
        });
        printButton = new Button("Print schedule");
        printButton.setOnAction(event1 -> {
            arrayList.get(0).printOut();

        });
        VBox vBox = new VBox();
        HBox hBox = new HBox(490);
        vBox.setAlignment(Pos.TOP_CENTER);
        primaryStage.setTitle("Schedule");
        table = new TableView();
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


        table.setItems(arrayList.get(weekCounter-1).getObservableList());
        table.getColumns().addAll(hour, monday, tuesday, wednesday, thursday, friday, saturday,sanday);
        table.setOnMouseClicked(event -> {
            TablePosition firstCell = table.getSelectionModel().getSelectedCells().get(0);
            int column =  firstCell.getColumn();
            int row = firstCell.getRow();
            Time time = table.getSelectionModel().getSelectedItem();

            if(column==1){
                if(time.getMonday().equals("no")){
                    time.setMonday("yes");
                    arrayList.get(weekCounter-1).setYes(time,row);
                    table.setItems(arrayList.get(weekCounter-1).getObservableList());
                }else{
                    time.setMonday("no");
                    arrayList.get(weekCounter-1).setYes(time,row);
                    table.setItems(arrayList.get(weekCounter-1).getObservableList());
                }


            }
            if(column==2){
                if(time.getTuesday().equals("no")) {
                    time.setTuesday("yes");
                    arrayList.get(weekCounter-1).setYes(time, row);
                    table.setItems(arrayList.get(weekCounter-1).getObservableList());
                }else{
                    time.setTuesday("no");
                    arrayList.get(weekCounter-1).setYes(time,row);
                    table.setItems(arrayList.get(weekCounter-1).getObservableList());
                }
            }
            if(column==3){
                if(time.getWednesday().equals("no")) {

                    time.setWednesday("yes");
                    arrayList.get(weekCounter-1).setYes(time, row);
                    table.setItems(arrayList.get(weekCounter-1).getObservableList());
                }else {
                    time.setWednesday("no");
                    arrayList.get(weekCounter-1).setYes(time,row);
                    table.setItems(arrayList.get(weekCounter-1).getObservableList());
                }
            }
            if(column==4){
                if(time.getThrusday().equals("no")) {

                    time.setThrusday("yes");
                    arrayList.get(weekCounter-1).setYes(time, row);
                    table.setItems(arrayList.get(weekCounter-1).getObservableList());
                }else {
                    time.setThrusday("no");
                    arrayList.get(weekCounter-1).setYes(time, row);
                    table.setItems(arrayList.get(weekCounter-1).getObservableList());
                }
            }
            if(column==5){
                if(time.getFriday().equals("no")) {
                    time.setFriday("yes");
                    arrayList.get(weekCounter-1).setYes(time, row);
                    table.setItems(arrayList.get(weekCounter-1).getObservableList());
                }else {
                    time.setFriday("no");
                    arrayList.get(weekCounter-1).setYes(time,row);
                    table.setItems(arrayList.get(weekCounter-1).getObservableList());
                }
            }
            if(column==6){
                if(time.getSaturday().equals("no")) {

                    time.setSaturday("yes");
                    arrayList.get(weekCounter-1).setYes(time, row);
                    table.setItems(arrayList.get(weekCounter-1).getObservableList());
                }else {
                    time.setSaturday("no");
                    arrayList.get(weekCounter-1).setYes(time,row);
                    table.setItems(arrayList.get(weekCounter-1).getObservableList());
                }
            }
            if(column==7){
                if(time.getSunday().equals("no")) {

                    time.setSunday("yes");
                    arrayList.get(weekCounter-1).setYes(time, row);
                    table.setItems(arrayList.get(weekCounter-1).getObservableList());
                }else {
                    time.setSunday("no");
                    arrayList.get(weekCounter-1).setYes(time,row);
                    table.setItems(arrayList.get(weekCounter-1).getObservableList());
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

    public MovieWeek getWeek(int i){
        return  arrayList.get(i);
    }

}
