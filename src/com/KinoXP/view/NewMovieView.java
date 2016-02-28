package com.KinoXP.view;

import com.KinoXP.controller.AddMovieFormViewController;
import com.KinoXP.controller.NewMovieViewController;
import com.KinoXP.model.NewMovieViewModel;
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
    VBox vBox;

    //CONTROLLERS
    NewMovieViewController newMovieViewController = new NewMovieViewController();
    AddMovieFormViewController addMoveFormViewController = new AddMovieFormViewController();
    //


    public void start(String urlGreg) {


        Stage primaryStage = new Stage();
        //ROOT
        borderPane = new BorderPane();

        //TOP
        topLayout = new Label("T o p   L a y o u t");
        topLayout.setPrefSize(1180, 30);
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



        //method that gets indexMovie to arraylist
        ArrayList<Integer> indexMovieList = new ArrayList<>();
        indexMovieList = newMovieViewController.getArrayListOfMovieIndexFromDb();
        System.out.println("indexy " + indexMovieList.toString());

        for(int i=0; i<indexMovieList.size(); i++) {
            indexMovieList.toString();
        }



        plusButton.setOnAction(event -> {

            addMoveFormViewController.addMovieFormViewDisplay();

            //*************************
            /*System.out.println("UrlGreg: " + urlGreg);
            if(urlGreg != null) {
                addMovie(urlGreg);
            }
            else {
                System.out.println("url = null");
                primaryStage.close();
            }*/
            //*************************

        });

        borderPane.setAlignment(plusButton, Pos.CENTER);
        borderPane.setLeft(plusButton);


        //Center - FlowPane


        vBox = new VBox();
        vBox.setPrefSize(80, 120);
        vBox.setAlignment(Pos.CENTER);
        flowPane = new FlowPane();
        flowPane.setHgap(30);
        flowPane.setVgap(30);
        flowPane.setPadding(new Insets(60));
        flowPane.setMaxWidth(1500);
        borderPane.setCenter(flowPane);


        //SCENE
        scene = new Scene(borderPane, 1280, 800);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public void addMovie(String url) {


        //Image imageOk = new Image(getClass().getResourceAsStream("moviePoster.png"));
        ImageView imageView;
        imageView =  newMovieViewController.getWrapImageFromUrlCtrl(url);

        Button button = new Button();
        button.setPrefSize(80, 100);
        button.setPadding(new Insets(0, 0, 0, 0));

        //button.setGraphic(imageView);

        Label titleBtnLabel = new Label();
        titleBtnLabel.setPrefSize(80, 20);
        titleBtnLabel.setTextAlignment(TextAlignment.RIGHT);
        //titleBtnLabel.setText("Ip-Man 3");

        vBox.getChildren().addAll(button, titleBtnLabel);
        flowPane.getChildren().add(vBox);
    }

}




