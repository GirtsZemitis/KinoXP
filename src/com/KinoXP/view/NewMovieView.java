package com.KinoXP.view;

import com.KinoXP.controller.AddMovieFormViewController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

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
    Stage primaryStage;
    AddMovieFormViewController addMoveFormViewController = new AddMovieFormViewController();

    //CONTROLLERS

    //


    public void start() {

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
        //plusButton.setOnAction(event -> addMovie());  //You should run AddMovieFormView
        plusButton.setOnAction(event -> {
            addMoveFormViewController.newMovieFormViewDisplay();
        });
        borderPane.setAlignment(plusButton, Pos.CENTER);
        borderPane.setLeft(plusButton);


        //Center - FlowPane
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

    public void addMovie() {//You should now run the addMoveFromView form!!

        VBox vBox = new VBox();
        vBox.setPrefSize(80, 120);
        vBox.setAlignment(Pos.CENTER);

        Label titleBtnLabel = new Label();
        titleBtnLabel.setPrefSize(80, 20);
        titleBtnLabel.setTextAlignment(TextAlignment.RIGHT);
        titleBtnLabel.setText("Ip-Man 3");

        //Image imageOk = new Image(getClass().getResourceAsStream("moviePoster.png"));
        BufferedImage img = null;
        try {
            img = ImageIO.read(new URL("https://thehande.files.wordpress.com/2014/01/brucelee.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error loading image");
        }

        WritableImage wr = null;
        if (img != null) {
            wr = new WritableImage(img.getWidth(), img.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < img.getWidth(); x++) {
                for (int y = 0; y < img.getHeight(); y++) {
                    pw.setArgb(x, y, img.getRGB(x, y));
                }
            }
        }

        ImageView imageView = new ImageView();
        imageView.setImage(wr);
        imageView.setFitHeight(100);
        imageView.setPreserveRatio(true);
        imageView.setCache(true);

        Button button = new Button();
        button.setGraphic(imageView);
        button.setPrefSize(80, 100);
        button.setPadding(new Insets(0, 0, 0, 0));

        vBox.getChildren().addAll(button, titleBtnLabel);
        flowPane.getChildren().add(vBox);
    }
}




