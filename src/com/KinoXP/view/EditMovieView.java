package com.KinoXP.view;

import com.KinoXP.controller.EditMovieViewController;
import com.KinoXP.controller.NewMovieViewController;
import com.KinoXP.model.EditMovieViewModel;
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

import java.sql.ResultSet;

/**
 * Created by Paula on 25/2/16.
 */
public class EditMovieView extends Application {

    EditMovieViewController editMovieViewController;
    EditMovieViewModel manageMovieViewModul;
    String title;
    //CONSTRUCTOR
    public EditMovieView(String title) {
        this.title = title;
    }

    public EditMovieViewController getEditMovieViewController() {
        return editMovieViewController;
    }

    public void setEditMovieViewController(EditMovieViewController editMovieViewController) {
        this.editMovieViewController = editMovieViewController;
    }

    public EditMovieViewModel getManageMovieViewModul() {
        return manageMovieViewModul;
    }

    public void setManageMovieViewModul(EditMovieViewModel manageMovieViewModul) {
        this.manageMovieViewModul = manageMovieViewModul;
    }

    //START METHOD FOR THE VIEW
    public void start(Stage primaryStage) throws Exception {

        VBox vBox = new VBox();

        ResultSet resultSet = manageMovieViewModul.getMovie(title);
        String[] result = new String[12];


        while (resultSet.next()){
            for (int i = 1; i < 12; i++){
            result[i] = resultSet.getString(i);
            }
        }
        //        MovieModel movieModel = new MovieModel(result[2], result[3], result[4], result[5], result[6], result[7], result[8], result[9], result[10]);
        //TEXT FIELDS
        TextField titleTxt = new TextField(result[2]);
        TextField playingTimeInMinutesTxt = new TextField(result[3]);
        TextField releaseYearTxt = new TextField(result[4]);
        TextField directorTxt = new TextField(result[6]);
        TextField posterPathTxt = new TextField(result[7]);
        TextField movieTheaterTxt = new TextField(result[9]);
        TextField genreTxt = new TextField(result[10]);
        TextField ageLimitTxt = new TextField(result[11]);

        //TEXT AREAS
        TextArea plotTxt = new TextArea(result[5]);
        TextArea mainActorTxt = new TextArea(result[8]);

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

        final Stage finalPrimaryStage = primaryStage;
        editMovieBtn.setOnAction(event -> {
            editMovieViewController.editMovieButtonAction(titleTxt.getText(), playingTimeInMinutesTxt.getText(),
                    releaseYearTxt.getText(), plotTxt.getText(), directorTxt.getText(), posterPathTxt.getText(),
                    mainActorTxt.getText(), movieTheaterTxt.getText(), genreTxt.getText(), ageLimitTxt.getText(), result[2], result[3], result[4], result[5],
                    result[6], result[7], result[8], result[9], result[10], result[11]);
            NewMovieViewController newMovieViewController = new NewMovieViewController();
            newMovieViewController.newMovieViewDisplay();
            finalPrimaryStage.close();
        });

        backBtn.setOnAction(event -> {
            finalPrimaryStage.close();
        });


    }

    //METHOD FOR THE ALERT MESSAGES SHOWN TO THE USER
    public void updateAlertMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
