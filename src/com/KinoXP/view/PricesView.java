package com.KinoXP.view;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;


public class PricesView {

    Stage pricesMenu;
    Scene menu;
    BorderPane menuLayout;
    VBox vbox;
    Label menuLabel, lSodaLabel, sSodaLabel, lCandyLabel, sCandyLabel;
    public static Button back, priceButton;
    private String lSodaPrice, sSodaPrice, lCandyPrice, sCandyPrice, textfield;
    TextField lSodaField, sSodaField, lCandyField, sCandyField;

    public void start() throws IOException {

        Stage primaryStage = new Stage();
        pricesMenu = new Stage();
        pricesMenu = primaryStage;
        menuLabel = new Label("Current prices");


        lSodaLabel = new Label("Large soda -- "+ lSodaPrice);
        lSodaLabel.setId("priceLabels");
        sSodaLabel = new Label("Small soda -- "+ sSodaPrice);
        sSodaLabel.setId("priceLabels");
        lCandyLabel = new Label("Large candy -- "+ lCandyPrice);
        lCandyLabel.setId("priceLabels");
        sCandyLabel = new Label("Small candy -- "+ sCandyPrice);
        sCandyLabel.setId("priceLabels");

        lSodaField = new TextField();
        lSodaField.setStyle("-fx-font-size: 16");
        sSodaField = new TextField();
        sSodaField.setStyle("-fx-font-size: 16");
        lCandyField = new TextField();
        lCandyField.setStyle("-fx-font-size: 16");
        sCandyField = new TextField();
        sCandyField.setStyle("-fx-font-size: 16");

        menuLabel.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold"

        );

        priceButton = new Button("Set Prices");
        priceButton.setId("pricesButton");


        back = new Button("Back");
        back.setStyle("-fx-font-size: 20");
        back.setId("button");









        priceButton.setOnAction(event1 -> {


            if (lSodaField != null){
                textfield = lSodaField.getText();
                lSodaLabel.setText("Large soda -- "+ textfield);


            }
            if (lCandyField != null){
                textfield = lCandyField.getText();
                lCandyLabel.setText("Large candy -- "+ textfield);
            }
            if (sCandyField != null){
                textfield = sCandyField.getText();
                sCandyLabel.setText("Small candy -- "+ textfield);
            }
            if (sSodaField != null){
                textfield = sSodaField.getText();
                sSodaLabel.setText("Small soda -- "+ textfield);
            }

            return;

        });

        back.setOnAction(event1 -> {
            MenuView menuView = new MenuView();
            menuView.start();
            primaryStage.close();
        });

        GridPane elements = new GridPane();

        elements.addRow(2, priceButton );
        elements.addRow(0,lCandyLabel, sCandyLabel, lSodaLabel, sSodaLabel);
        elements.addRow(1,lCandyField, sCandyField, lSodaField, sSodaField);
        elements.setMinWidth(600);
        elements.setHgap(50);
        elements.setVgap(20);

        elements.setStyle(
                " -fx-alignment: center;"


        );


        menuLayout = new BorderPane();
        menuLayout.setId("backgroundImage");
        menuLayout.setPadding(new Insets(30));


        menuLayout.setTop(menuLabel);
        menuLayout.setAlignment(menuLabel, Pos.TOP_CENTER);
        menuLayout.setBottom(back);
        menuLayout.setCenter(elements);

        menuLayout.setAlignment(back, Pos.BOTTOM_RIGHT);


        menu = new Scene(menuLayout, 800, 400);
        menu.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        pricesMenu.setScene(menu);
        pricesMenu.show();


    }


}
