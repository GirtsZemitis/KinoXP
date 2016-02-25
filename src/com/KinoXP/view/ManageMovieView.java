package com.KinoXP.view;

import com.KinoXP.controller.ManageMovieViewController;
import com.KinoXP.model.ManageMovieViewModul;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    ManageMovieViewModul manageMovieViewModul;

    //MAIN METHOD TO START THE APPLICATION
    public static void main(String[] args) {
        Application.launch(args);
    }

    //CONSTRUCTOR
    public ManageMovieView(){
        manageMovieViewModul = new ManageMovieViewModul();
        manageMovieViewController = new ManageMovieViewController();
    }

    //START METHOD FOR THE VIEW
    public void start(Stage primaryStage) throws Exception {
        VBox vBox = new VBox();

        //TEXTFIELDS
        TextField titleTxt = new TextField();
        TextField playingtimeInMinutesTxt = new TextField();
        TextField realeseYearTxt = new TextField();
        TextArea plotTxt = new TextArea();
        TextField directorTxt = new TextField();
        TextField posterpathTxt = new TextField();
        TextField mainActorTxt = new TextField();
        TextField movieTheaterTxt = new TextField();
        TextField genreTxt = new TextField();
        TextField ageLimitTxt = new TextField();

        //LABELS
        Label mainTitleLbl = new Label("Edit Movie");
        mainTitleLbl.setFont(new Font("Serif", 30));
        Label titleLbl = new Label("Title");
        Label yearLbl = new Label("Year");
        Label durationLbl = new Label("Duration");
        Label genreLbl = new Label("Genre");
        Label descriptionLbl = new Label("Description");
        Label directorLbl = new Label("Director");
        Label ageLimitLbl = new Label("Age Limit");
        Label castLbl = new Label("Cast");
        Label posterLbl = new Label("Poster");
        Label movieTheaterLbl = new Label("Movie Theater");

        //BUTTONS
        Button addCastBtn = new Button("Add");
        Button addPosterBtn = new Button("Add");
        Button editMovieBtn = new Button("Edit Movie");
        Button backBtn = new Button("Go Back");

        //HBOXES
        HBox hBoxTitle = new HBox();
        hBoxTitle.getChildren().add(mainTitleLbl);
        hBoxTitle.setAlignment(Pos.TOP_LEFT);

        HBox hBox1 = new HBox();
        hBox1.getChildren().addAll(yearLbl, durationLbl, genreLbl);
        hBox1.setSpacing(170);

        HBox hBox2 = new HBox();
        hBox2.getChildren().addAll(realeseYearTxt, playingtimeInMinutesTxt, genreTxt);
        hBox2.setSpacing(30);

        HBox hBox3 = new HBox();
        hBox3.getChildren().addAll(directorLbl, ageLimitLbl);
        hBox3.setSpacing(150);

        HBox hBox4 = new HBox();
        hBox4.getChildren().addAll(directorTxt, ageLimitTxt);
        hBox4.setSpacing(30);

        HBox hBox5 = new HBox();
        hBox5.getChildren().addAll(mainActorTxt, addCastBtn);
        hBox5.setSpacing(30);

        HBox hBox6 = new HBox();
        hBox6.getChildren().addAll(posterpathTxt, addPosterBtn);
        hBox6.setSpacing(30);

        HBox hBox7 = new HBox();
        hBox7.getChildren().addAll(editMovieBtn, backBtn);
        hBox7.setSpacing(30);
        hBox7.setAlignment(Pos.BOTTOM_RIGHT);

        //VBOX CONTAINING THE HBOXES ABOVE
        vBox.getChildren().addAll(hBoxTitle, titleLbl, titleTxt, hBox1, hBox2, descriptionLbl, plotTxt, hBox3, hBox4, castLbl, hBox5, posterLbl, hBox6, movieTheaterLbl, movieTheaterTxt ,hBox7);
        vBox.setPadding(new Insets(40, 40, 40, 60));
        vBox.setSpacing(10);

        //LAYOUT OF THE SCENE
        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(vBox);

        //SETTING UP THE SCENE AND THE STAGE
        Scene scene = new Scene(borderPane, 700, 600);
        primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();

        //HANDLING THE BUTTONS ACTIONS
        addCastBtn.setOnAction(event -> {

        });

        addPosterBtn.setOnAction(event -> {

        });

        editMovieBtn.setOnAction(event -> {
            manageMovieViewController.editMovieButtonAction(titleTxt.getText(), playingtimeInMinutesTxt.getText(), realeseYearTxt.getText(), plotTxt.getText(), directorTxt.getText(), posterpathTxt.getText(), mainActorTxt.getText(), movieTheaterTxt.getText());
        });

        backBtn.setOnAction(event -> {

        });

    }
}
