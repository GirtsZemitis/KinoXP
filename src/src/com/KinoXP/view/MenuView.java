package com.KinoXP.view;


import com.KinoXP.controller.ManageMovieSceduleController;
import com.KinoXP.controller.NewMovieViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Created by hartyandi on 2/24/16.
 */
public class MenuView {

    Stage mainMenu;
    Scene menu;
    BorderPane menuLayout;
    VBox vbox;
    Label menuLabel, loggedUser;
    Button movies, schedule, employees, logOut;
    ManageMovieSceduleController manageMovieSceduleController = new ManageMovieSceduleController();
    NewMovieViewController newMovieViewController = new NewMovieViewController();


    public void start() {

        Stage primaryStage = new Stage();
        mainMenu = new Stage();
        mainMenu = primaryStage;
        menuLabel = new Label("Main menu");
        menuLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        movies = new Button("Manage movies");
        schedule = new Button("Manage schedule");
        employees = new Button("Manage employees");
        logOut = new Button("Log out");


        menuLayout = new BorderPane();
        menuLayout.setPadding(new Insets(30));
        vbox = new VBox(20);
        vbox.getChildren().addAll(movies, schedule, employees);
        menuLayout.setCenter(vbox);
        menuLayout.setTop(menuLabel);
        menuLayout.setAlignment(menuLabel, Pos.TOP_CENTER);
        menuLayout.setBottom(logOut);
        menuLayout.setAlignment(logOut, Pos.BOTTOM_RIGHT);
        vbox.setAlignment(Pos.CENTER);

        movies.setOnAction(event -> {
            newMovieViewController.newMovieViewDisplay();
        });

        schedule.setOnAction(event -> {
            manageMovieSceduleController.scheduleDisplay();

      });

        menu = new Scene(menuLayout, 500, 500);
        mainMenu.setScene(menu);
        mainMenu.show();


    }


}
