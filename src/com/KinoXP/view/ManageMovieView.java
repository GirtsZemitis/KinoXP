package com.KinoXP.view;

import com.KinoXP.controller.ManageMovieViewController;
import com.KinoXP.model.ManageMovieViewModel;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by Paula on 25/2/16.
 */
public class ManageMovieView extends Application {

    ManageMovieViewController manageMovieViewController;
    ManageMovieViewModel manageMovieViewModul;

    //MAIN METHOD TO START THE APPLICATION
    public static void main(String[] args) {
        Application.launch(args);
    }

    //CONSTRUCTOR
    public ManageMovieView() {
        manageMovieViewModul = new ManageMovieViewModel();
        manageMovieViewController = new ManageMovieViewController();
    }

    //START METHOD FOR THE VIEW
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox();

        //TEXT FIELDS
        TextField titleTxt = new TextField();
        TextField playingTimeInMinutesTxt = new TextField();
        TextField releaseYearTxt = new TextField();
        TextField directorTxt = new TextField();
        TextField posterPathTxt = new TextField();
        TextField movieTheaterTxt = new TextField();
        TextField genreTxt = new TextField();
        TextField ageLimitTxt = new TextField();

        //TEXT AREAS
        TextArea plotTxt = new TextArea();
        TextArea mainActorTxt = new TextArea();

        //LABELS
        Label mainTitleLbl = new Label("Edit MovieModel");
        mainTitleLbl.setFont(new Font("Serif", 30));
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
        //Button addCastBtn = new Button("Add");
        Button addPosterBtn = new Button("Add");
        Button editMovieBtn = new Button("Edit MovieModel");
        Button backBtn = new Button("Go Back");

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
        hBox5.getChildren().addAll(mainActorTxt);
        hBox5.setSpacing(30);

        HBox hBox6 = new HBox();
        hBox6.getChildren().addAll(posterPathTxt, addPosterBtn);
        hBox6.setSpacing(30);

        HBox hBox7 = new HBox();
        hBox7.getChildren().addAll(editMovieBtn, backBtn);
        hBox7.setSpacing(30);
        hBox7.setAlignment(Pos.BOTTOM_RIGHT);

        //V-BOXES CONTAINING THE H-BOXES ABOVE
        vBox.getChildren().addAll(hBoxTitle, titleLbl, titleTxt, descriptionLbl, plotTxt, hBox1,
                                hBox2, hBox3, hBox4, castLbl, hBox5, posterLbl, hBox6, movieTheaterLbl, movieTheaterTxt, hBox7);
        vBox.setPadding(new Insets(40, 40, 40, 60));
        vBox.setSpacing(10);

        //LAYOUT OF THE SCENE
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(vBox);

        //SETTING UP THE SCENE AND THE STAGE
        Scene scene = new Scene(borderPane, 700, 650);
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();

        //HANDLING THE BUTTONS ACTIONS
        addPosterBtn.setOnAction(event -> {
        });

        editMovieBtn.setOnAction(event -> {
            manageMovieViewController.editMovieButtonAction(titleTxt.getText(), playingTimeInMinutesTxt.getText(),
                    releaseYearTxt.getText(), plotTxt.getText(), directorTxt.getText(), posterPathTxt.getText(),
                    mainActorTxt.getText(), movieTheaterTxt.getText());
        });

        backBtn.setOnAction(event -> {
            manageMovieViewController.goBackButtonAction();
        });


    }

    //METHOD FOR THE ALERT MESSAGES SHOWN TO THE USER
    public void updateAlertMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
