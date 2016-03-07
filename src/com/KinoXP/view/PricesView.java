package com.KinoXP.view;


import com.KinoXP.controller.PriceViewController;
import com.KinoXP.model.ExtrasModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class PricesView {

    Stage pricesMenu;
    Scene menu;
    BorderPane menuLayout;
    VBox vbox;
    Label menuLabel, lSodaLabel, sSodaLabel, lCandyLabel, sCandyLabel;
    public static Button back, priceButton;
    public String lSodaPrice, sSodaPrice, lCandyPrice, sCandyPrice;
    TextField lSodaField, sSodaField, lCandyField, sCandyField;
    PriceViewController priceViewController;

    public void start() {

        Stage primaryStage = new Stage();
        pricesMenu = new Stage();
        pricesMenu = primaryStage;
        menuLabel = new Label("Current prices");
        priceViewController = new PriceViewController();




        //TEXTFIELDS
        lSodaField = new TextField();
        lSodaField.setStyle("-fx-font-size: 16");

        sSodaField = new TextField();
        sSodaField.setStyle("-fx-font-size: 16");

        lCandyField = new TextField();
        lCandyField.setStyle("-fx-font-size: 16");

        sCandyField = new TextField();
        sCandyField.setStyle("-fx-font-size: 16");

        //MAKE LABELS !!!!!
        lSodaLabel = new Label();
        sSodaLabel = new Label();
        lCandyLabel = new Label();
        lCandyLabel = new Label();
        sCandyLabel = new Label();


        //GET PRICES FROM DB && SET THE LABELS
        setLabels();
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
            if ((!lSodaField.getText().equals(null))&&(!sSodaField.getText().equals(null))&&
                    (!lCandyField.getText().equals(null))&&(!sCandyField.getText().equals(null))){

                priceViewController.updatePrices("Soda",Integer.valueOf(lSodaField.getText()),Integer.valueOf(sSodaField.getText()));
                priceViewController.updatePrices("Candy",Integer.valueOf(lCandyField.getText()),Integer.valueOf(sCandyField.getText()));

                setLabels();
            }else{
                System.out.println("Insert some shit please!!!");
            }


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

        elements.setStyle("-fx-alignment: center;");

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
    public void setLabels(){
        ExtrasModel soda = new ExtrasModel(priceViewController.getPrice("Soda").getCategory(),
                priceViewController.getPrice("Soda").getLargePrice(),
                priceViewController.getPrice("Soda").getSmallPrice());
        ExtrasModel candy = new ExtrasModel(priceViewController.getPrice("Candy").getCategory(),
                priceViewController.getPrice("Candy").getLargePrice(),
                priceViewController.getPrice("Candy").getSmallPrice());

        lSodaPrice= String.valueOf(soda.getLargePrice());
        sSodaPrice= String.valueOf(soda.getSmallPrice());
        lCandyPrice= String.valueOf(candy.getLargePrice());
        sCandyPrice= String.valueOf(candy.getSmallPrice());

        lSodaLabel.setText("Large soda -- " + lSodaPrice);
        sSodaLabel.setText("Small soda -- "+ sSodaPrice);
        lCandyLabel.setText("Large candy -- "+ lCandyPrice);
        sCandyLabel.setText("Small candy -- "+ sCandyPrice);
         lSodaField.setText(lSodaPrice);
        sSodaField.setText(sSodaPrice);
        lCandyField.setText(lCandyPrice);
        sCandyField.setText(sCandyPrice);


    }


}
