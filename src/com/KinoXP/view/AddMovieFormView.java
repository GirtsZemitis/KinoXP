package com.KinoXP.view;

import com.KinoXP.controller.AddMovieFormViewController;
import com.KinoXP.controller.ManageMovieScheduleController;
import com.KinoXP.model.AddMovieFormViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Created by Grzegorz, Mazur on 25-02-2016.
 */
public class AddMovieFormView {

    private AddMovieFormViewController addMovieFormViewController = new AddMovieFormViewController();
    private AddMovieFormViewModel addMovieFormViewModel = new AddMovieFormViewModel();
    private Stage stage;
    TextField posterPathTxt;
    TextField titleTxt;
    //CONSTRUCTOR
    public AddMovieFormView() {
        addMovieFormViewModel = new AddMovieFormViewModel();
        addMovieFormViewController = new AddMovieFormViewController(this, addMovieFormViewModel);
    }

    public void getAddMovieView() {

        //TEXT FIELDS
         titleTxt = new TextField();
        TextField playingTimeInMinutesTxt = new TextField();
        TextField releaseYearTxt = new TextField();
        TextField directorTxt = new TextField();
         posterPathTxt = new TextField();
        //TextField movieTheaterTxt = new TextField();

        TextField genreTxt = new TextField();
        TextField ageLimitTxt = new TextField();

        //TEXT AREAS
        TextArea plotTxt = new TextArea();
        TextArea cast = new TextArea();

        //LABELS
        Label mainTitleLbl = new Label("Add MovieModel");
        mainTitleLbl.setFont(Font.font("Courier", FontWeight.BOLD, 25));
        mainTitleLbl.setFont(Font.font(25));
        Label titleLbl = new Label("Title");
        Label yearLbl = new Label("Year");
        Label durationLbl = new Label("Duration");
        Label genreLbl = new Label("Genre");
        Label descriptionLbl = new Label("Description");
        Label directorLbl = new Label("Director");
        Label ageLimitLbl = new Label("Age Limit");
        Label castLbl = new Label("Cast");
        Label posterLbl = new Label("Poster URL");
        Label movieTheaterLbl = new Label("MovieModel Theater");

        //BUTTONS

        Button addMovieBtn = new Button("Add MovieModel");
        Button backBtn = new Button("Go Back");


        ObservableList<String> options =
                FXCollections.observableArrayList(
                        "Theater 1",
                        "Theater 2"
                );

        ComboBox<String>movieTheaterTxt= new ComboBox<>(options);

        //active validation of  fields (decoration)
        addMovieFormViewController.validateFieldsControlsFx(titleTxt, playingTimeInMinutesTxt, releaseYearTxt,
                plotTxt, directorTxt, posterPathTxt, cast,movieTheaterTxt, genreTxt, ageLimitTxt);

        // Add Movie Button Action
        addMovieBtn.setOnAction(event -> {

            addMovieFormViewController.validateFieldsAndAction(titleTxt, playingTimeInMinutesTxt, releaseYearTxt,
                    plotTxt, directorTxt, posterPathTxt, cast,movieTheaterTxt.getValue(), genreTxt, ageLimitTxt);

        });



        // ACTION - BACK BUTTON
        backBtn.setOnAction(event -> {
            closeStage();
            NewMovieView newMovieView = new NewMovieView();
            newMovieView.start();
        });


        //H-BOXES
        HBox hBoxTitle = new HBox();
        hBoxTitle.getChildren().add(mainTitleLbl);
        hBoxTitle.setAlignment(Pos.TOP_LEFT);

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(durationLbl, genreLbl, ageLimitLbl);
        hBox1.setSpacing(155);

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(playingTimeInMinutesTxt, genreTxt, ageLimitTxt);
        hBox2.setSpacing(30);

        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(directorLbl, yearLbl);
        hBox3.setSpacing(150);

        HBox hBox4 = new HBox();
        hBox4.getChildren().addAll(directorTxt, releaseYearTxt);
        hBox4.setSpacing(30);

        HBox hBox5 = new HBox();
        hBox5.getChildren().addAll(cast);
        hBox5.setSpacing(30);

        HBox hBox6 = new HBox();
        hBox6.getChildren().addAll(posterPathTxt);
        hBox6.setSpacing(30);

        HBox hBox7 = new HBox();
        hBox7.getChildren().addAll(addMovieBtn, backBtn);
        hBox7.setSpacing(30);
        hBox7.setAlignment(Pos.BOTTOM_RIGHT);

        //V-BOX CONTAINING THE H-BOXES ABOVE
        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBoxTitle, titleLbl, titleTxt, descriptionLbl, plotTxt, hBox1, hBox2, hBox3,
                            hBox4, castLbl, hBox5, posterLbl, hBox6, movieTheaterLbl, movieTheaterTxt, hBox7);
        vBox.setPadding(new Insets(40, 40, 40, 60));
        vBox.setSpacing(10);

        //LAYOUT OF THE SCENE
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(25));
        borderPane.setLeft(vBox);

        //SETTING UP THE SCENE AND THE STAGE
        Scene scene = new Scene(borderPane, 800, 800);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }

    //METHOD FOR THE ALERT MESSAGES SHOWN TO THE USER
    public void updateAlertMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }



    //METHOD TO USE FOR CLOSING THE STAGE
    public void closeStage(){
        stage.close();
    }

 //get url form addmovie
 public String getUrl(){
     return  posterPathTxt.getText();
 }
    public String getTitle(){
        return titleTxt.getText();
    }

}
