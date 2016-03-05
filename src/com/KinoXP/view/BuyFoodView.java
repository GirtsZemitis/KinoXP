package com.KinoXP.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


/**
 * Created by hartyandi on 3/4/16.
 */
public class BuyFoodView extends Application{

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        startBuyFoodView();
    }

    public void startBuyFoodView(){

        Label mainLabel = new Label("Do you want any goods?");
        Label soda = new Label("Soda");
        Label popcorn = new Label("Popcorn");

        Button sodaPlus = new Button("+");
        Button sodaMinus = new Button("-");
        Button popcornPlus = new Button("+");
        Button popcornMinus = new Button("-");
        Button noThankYou = new Button("No");
        Button yes        =new Button("Yes");

        Label sodaAmount = new Label("?");
        Label popcornAmount = new Label("?");
        sodaAmount.setAlignment(Pos.CENTER);
        popcornAmount.setAlignment(Pos.CENTER);
        sodaAmount.setTextAlignment(TextAlignment.CENTER);
        popcornAmount.setTextAlignment(TextAlignment.CENTER);
        sodaAmount.setMinWidth(20);
        popcornAmount.setMinWidth(20);
        VBox layout = new VBox();
        HBox layoutSoda = new HBox();
        layoutSoda.getChildren().addAll(soda);

        HBox hboxSoda = new HBox();
        hboxSoda.getChildren().addAll(sodaMinus, sodaAmount, sodaPlus);
        hboxSoda.setAlignment(Pos.CENTER);
        HBox hboxPopcorn = new HBox();
        hboxPopcorn.setAlignment(Pos.CENTER);
        hboxPopcorn.getChildren().addAll(popcornMinus, popcornAmount, popcornPlus);
        HBox hboxButtons = new HBox();
        hboxButtons.setPadding(new Insets(10, 10, 10, 10));
        hboxButtons.setAlignment(Pos.CENTER);

        hboxButtons.getChildren().addAll(noThankYou,yes);
        layout.getChildren().addAll(mainLabel, soda, hboxSoda, popcorn, hboxPopcorn, hboxButtons);
        layout.setPadding(new Insets(40, 40, 40, 60));
        layout.setAlignment(Pos.TOP_CENTER);

        layoutSoda.setAlignment(Pos.CENTER);





        Scene scene = new Scene(layout, 300, 210);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();





    }
}
