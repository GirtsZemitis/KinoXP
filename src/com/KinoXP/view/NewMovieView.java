package com.KinoXP.view;

import com.KinoXP.controller.AddMovieFormViewController;
import com.KinoXP.controller.EditMovieViewController;
import com.KinoXP.controller.LoginViewController;
import com.KinoXP.controller.NewMovieViewController;
import com.KinoXP.model.EditMovieViewModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by quena on 25-02-2016.
 */
public class NewMovieView {
    /**
     * EditMovieView
     * by Grzegorz Goraj
     */


    Scene scene;
    BorderPane borderPane;
    HBox topLayoutHBox;
    FlowPane flowPane;
    Button plusButton;
    Button logOut;
    Label topLayout;


    //** common work

    //****

    //CONTROLLERS
    NewMovieViewController newMovieViewController = new NewMovieViewController();
    AddMovieFormViewController addMoveFormViewController = new AddMovieFormViewController();
    //


    public void start() {


        Stage primaryStage = new Stage();
        //ROOT
        borderPane = new BorderPane();

        //TOP
        topLayout = new Label("Movies OVERVIEW");

        topLayout.setPrefSize(1280, 70);
        topLayout.setAlignment(Pos.CENTER);
        topLayout.setStyle("-fx-background-color: silver;-fx-font-size: 50");

        topLayoutHBox = new HBox();
        topLayoutHBox.setSpacing(10);
        topLayoutHBox.getChildren().addAll(topLayout);
        borderPane.setTop(topLayoutHBox);

        //BORDER Left
        plusButton = new Button("+");
        plusButton.setPrefSize(40, 40);
        plusButton.setStyle("-fx-background-color: #94ff6d");

        /***
         *          Greg + Mazur :
         */

        flowPane = new FlowPane();
        flowPane.setHgap(30);
        flowPane.setVgap(30);
        flowPane.setPadding(new Insets(60));
        flowPane.setMaxWidth(1500);

        //method that gets indexMovie to arraylist
        ArrayList<String> urlString = new ArrayList<>();
        ArrayList<String> titlesString = new ArrayList<>();
        ResultSet resultSet = newMovieViewController.getMovieTitleFromModel();

        try {
            while (resultSet.next()){
                titlesString.add(resultSet.getString(1));
                urlString.add(resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // reading from DB and creating Buttons + adding Buttons to ArrayList
        for(int i=0; i<titlesString.size(); i++) {
            ImageView imageView;
            String url = null;
            String label = null;

            File file = new File("res/" + urlString.get(i) + ".png" );
            Image image = new Image(file.toURI().toString());
            imageView =  new ImageView(image); //newMovieViewController.getWrapImageFromUrlCtrl(urlString.get(i));

            imageView.setFitHeight(200);
            imageView.setFitWidth(200);
            Button button666 = new Button();

            button666.setPadding(new Insets(0, 0, 0, 0));
            button666.setGraphic(imageView);
            final int finalI = i;
            button666.setOnAction(event -> {
                EditMovieViewModel editMovieViewModel = new EditMovieViewModel();
                EditMovieView editMovieView = new EditMovieView(titlesString.get(finalI));
                EditMovieViewController editMovieViewController = new EditMovieViewController(editMovieView, editMovieViewModel);
                editMovieView.setEditMovieViewController(editMovieViewController);
                editMovieView.setManageMovieViewModul(editMovieViewModel);
                primaryStage.close();
                try {
                    editMovieView.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            Label titleBtnLabel666 = new Label();
            titleBtnLabel666.setPrefSize(80, 20);
            titleBtnLabel666.setTextAlignment(TextAlignment.RIGHT);
            titleBtnLabel666.setText(titlesString.get(i));

            VBox vBox = new VBox();
            vBox.setPrefSize(80, 120);
            //vBox.setMaxSize(80,120);
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(button666, titleBtnLabel666);
            flowPane.getChildren().add(vBox);
        }

        /***
        *
        */


        plusButton.setOnAction(event -> {

            addMoveFormViewController.addMovieFormViewDisplay();
            primaryStage.close();

        });

        borderPane.setAlignment(plusButton, Pos.CENTER);
        borderPane.setLeft(plusButton);


        //Center - FlowPane
        borderPane.setCenter(flowPane);

        logOut = new Button("Log Out");
        logOut.setPrefSize(150,50);
        logOut.setOnAction(event1 -> {
            LoginViewController loginViewController = new LoginViewController();
            loginViewController.startLoginWidnow();
            primaryStage.close();
        });
        borderPane.setAlignment(logOut,Pos.CENTER);
        borderPane.setBottom(logOut);

        logOut.setStyle("-fx-border-color: black;-fx-font-size: 20");


        //SCENE
        scene = new Scene(borderPane, 1280, 800);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }




}




