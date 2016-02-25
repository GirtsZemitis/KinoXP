package com.KinoXP.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by quena on 25-02-2016.
 */
public class AddMoveFormView {


        private TextField moviePosterField;
        private Scene scene;
        Connection connection= null;

        public void connectDB() {
            String DB_URL = "jdbc:mysql://localhost/northmedia";
            String USER = "root";
            String PASS = "";
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



        public void  getNewMovieView() {
            Stage stage = new Stage();
            Label label1, label2;
            label1 = new Label("NEW MOVIE");
            label2 = new Label("");
            label1.setFont(Font.font("Courier", FontWeight.BOLD, 25));
            label1.setAlignment(Pos.CENTER);
            label2.setFont(Font.font(14));
            TextField text1, text2, text3, text4, text6, text7, text8;
            TextArea textArea5;
            HBox hBox1, hBox2, hBox3, hBox4;
            hBox1 = new HBox();
            hBox2 = new HBox();
            hBox3 = new HBox();
            hBox4 = new HBox();



            VBox layout1, vbox1;
            layout1 = new VBox();
            vbox1 = new VBox(10);
            BorderPane mainLayout = new BorderPane();
            mainLayout.setPadding(new Insets(25));
            mainLayout.setCenter(layout1);
            Button buttonAdd, buttonBack, buttonAddActor;


            scene = new Scene(mainLayout, 600, 450);


            text1 = new TextField();
            text1.setPromptText("Title");
            text2 = new TextField();
            text2.setPromptText("Year");
            text3 = new TextField();
            text3.setPromptText("Duration");
            text4 = new TextField();
            text4.setPromptText("Genre");
            textArea5 = new TextArea();
            textArea5.setPromptText("Description");
            textArea5.setMaxSize(600, 200);
            text6 = new TextField();
            text6.setPromptText("Director");
            text7 = new TextField();
            text7.setPromptText("Age limit");
            text8 = new TextField();
            text8.setPromptText("Cast");

            //Gregory
            moviePosterField = new TextField();
            moviePosterField.setPromptText("Paste posters URL");
            Button posterURLButton = new Button("Add");
            posterURLButton.setOnAction(event1 -> addPosterUrl(moviePosterField.getText()));
            HBox posterHBox = new HBox();
            posterHBox.getChildren().addAll(moviePosterField, posterURLButton);
            //

            buttonAdd = new Button("Add Movie");
            buttonBack = new Button("Back");
            buttonAddActor = new Button("Add");
            buttonAddActor.setOnAction(event -> label2.setText("Actor : " + text8.getText() + " added!"));



            layout1.getChildren().addAll(label1, text1, hBox1, textArea5, hBox2, hBox4, posterHBox , hBox3);
            layout1.setSpacing(20);
            hBox1.getChildren().addAll(text2, text3, text4);
            hBox1.setSpacing(30);
            hBox2.getChildren().addAll(text6, text7);
            hBox2.setSpacing(30);
            hBox3.getChildren().addAll(buttonAdd, buttonBack);
            hBox3.setAlignment(Pos.BOTTOM_RIGHT);
            hBox4.getChildren().addAll(text8, buttonAddActor, label2);


            stage.setScene(scene);
            stage.show();

        }

        public void addPosterUrl(String posterUrl) {
            System.out.println(posterUrl);
        }

}


