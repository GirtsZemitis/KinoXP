package com.KinoXP.view;

import com.KinoXP.controller.AddMovieFormViewController;
import com.KinoXP.controller.NewMovieViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 * Created by quena on 25-02-2016.
 */
public class NewMovieView {
    /**
     * ManageMovieView
     * by Grzegorz Goraj
     */


    Scene scene;
    BorderPane borderPane;
    HBox topLayoutHBox;
    FlowPane flowPane;
    Button plusButton;
    Button logOut;
    Label topLayout;

    //CONTROLLERS
    NewMovieViewController newMovieViewController = new NewMovieViewController();
    AddMovieFormViewController addMoveFormViewController = new AddMovieFormViewController();
    //

    //starting Stage
    public void start() {


        Stage primaryStage = new Stage();
        //ROOT
        borderPane = new BorderPane();

        //TOP
        topLayout = new Label("T o p   L a y o u t");
        topLayout.setPrefSize(1000, 30);
        topLayout.setAlignment(Pos.CENTER);
        topLayout.setStyle("-fx-background-color: azure");
        logOut = new Button("Log Out");
        logOut.setAlignment(Pos.CENTER_RIGHT);
        topLayoutHBox = new HBox();
        topLayoutHBox.setSpacing(10);
        topLayoutHBox.getChildren().addAll(topLayout, logOut);
        borderPane.setTop(topLayoutHBox);

        //BORDER Left
        plusButton = new Button("+");
        plusButton.setPrefSize(40, 40);

        /***
         *          Greg + Mazur :
         */
        //creating flowPane - its the Pane of posterButtons
        flowPane = new FlowPane();
        flowPane.setHgap(30);
        flowPane.setVgap(50);
        flowPane.setPadding(new Insets(60));
        flowPane.setMaxWidth(1500);

        addPosterButtons();

        //Center - BorderPane
        borderPane.setCenter(flowPane);

        /***
        *
        */


        plusButton.setOnAction(event -> {

            addMoveFormViewController.addMovieFormViewDisplay();
            primaryStage.close();

        });

        borderPane.setAlignment(plusButton, Pos.CENTER);
        borderPane.setLeft(plusButton);

        //SCENE
        scene = new Scene(borderPane, 1100, 700);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void addPosterButtons() {
        //Arraylist for Buttons
        ArrayList<Integer> indexMovieList;
        indexMovieList = newMovieViewController.getArrayListOfMovieIndexFromDb();


        // reading from DB and creating Buttons + adding Buttons to ArrayList
        for(int i=0; i<indexMovieList.size(); i++) {
            ImageView imageView;
            String url = null;
            String label = null;


            url = newMovieViewController.getPhotoLinkFromModel(indexMovieList.get(i));
            label = newMovieViewController.getMovieTitleFromModel(indexMovieList.get(i));

            imageView =  newMovieViewController.getWrapImageFromUrlCtrl(url);

            Button button666 = new Button();
            button666.setId(indexMovieList.get(i).toString());
            button666.setMaxSize(60, 90);
            button666.setPadding(new Insets(0, 0, 0, 0));
            button666.setGraphic(imageView);

            Label titleBtnLabel666 = new Label();
            titleBtnLabel666.setPrefSize(80, 20);
            titleBtnLabel666.setTextAlignment(TextAlignment.RIGHT);
            titleBtnLabel666.setText(label);

            VBox vBox = new VBox();
            vBox.setPrefSize(100, 130);
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(button666, titleBtnLabel666);
            flowPane.getChildren().add(vBox);
        }
    }

}




