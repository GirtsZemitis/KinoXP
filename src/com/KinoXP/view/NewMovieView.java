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
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
        plusButton.setPrefSize(100, 100);
        plusButton.setStyle("-fx-font-size: 32;-fx-background-color: #ffdd19;-fx-border-color: black");


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
        ResultSet resultSet1 = newMovieViewController.getMovieTitleFromModel();
        ResultSet resultSet2 = newMovieViewController.getUrlFromModel();

        try {
            while (resultSet1.next()){
                titlesString.add(resultSet1.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (resultSet2.next()) {
                urlString.add(resultSet2.getString(1));
            }
        }
        catch(SQLException e2) {
            e2.printStackTrace();
        }
        /**
         * / reading from DB and creating Buttons + adding Buttons to ArrayList
         */

        for(int i=0; i<titlesString.size(); i++) {
            ImageView imageView;
            boolean ifFileExistsOnThisPc;
            String filePath = "res/" + titlesString.get(i) + ".png";

            File file = new File("res/" + titlesString.get(i) + ".png" );
            ifFileExistsOnThisPc = file.exists();
            if(ifFileExistsOnThisPc == false) {

                System.out.println("Movie " + titlesString.get(i).toString() + " - picture doesn't exist on this Pc");
                System.out.println("Of Url: " + urlString.get(i).toString());
                imageView = newMovieViewController.getWrapImageFromUrlCtrl(urlString.get(i));

                //properly save to /res

                //newMovieViewController.createFile(filePath);

            }
            else {
                imageView = newMovieViewController.getWrapImageFromUrlCtrl(file.toURI().toString());
            }

            imageView.setFitHeight(200);
            imageView.setFitWidth(200);
            Button button666 = new Button();

            button666.setPadding(new Insets(0, 0, 0, 0));
            button666.setGraphic(imageView);
            final int finalI = i;
            //Poster Butons Action
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
            titleBtnLabel666.setPrefSize(50, 40);
            titleBtnLabel666.setAlignment(Pos.CENTER);
            titleBtnLabel666.setText(titlesString.get(i));
            VBox vBox = new VBox();
            vBox.setPrefSize(200, 120);
            vBox.setAlignment(Pos.TOP_CENTER);
            Text text = new Text(titleBtnLabel666.getText());
            text.setWrappingWidth(200);
            text.setTextAlignment(TextAlignment.CENTER);
            vBox.getChildren().add(button666);
            vBox.getChildren().add(text);
            vBox.setPadding(new Insets(-30, 0, 50, 0));
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
            loginViewController.startLoginWindow();
            primaryStage.close();
        });
        borderPane.setAlignment(logOut,Pos.CENTER);
        borderPane.setBottom(logOut);
        borderPane.setPadding(new Insets(0, 0, 30, 30));
        logOut.setStyle("-fx-border-color: black;-fx-font-size: 20");


        //SCENE
        scene = new Scene(borderPane, 1280, 800);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }




}




