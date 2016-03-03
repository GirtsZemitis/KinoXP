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
import javafx.scene.control.ScrollPane;
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
        borderPane.setId("backgroundImage");

        //TOP
        topLayout = new Label("Movies Database");

        topLayout.setPrefSize(1280, 70);
        topLayout.setAlignment(Pos.CENTER);
        topLayout.setStyle(
                "-fx-font-family: cursive;" +
                "-fx-background-color: transparent;" +
                "-fx-font-size: 50"

        );

        topLayoutHBox = new HBox();
        topLayoutHBox.setSpacing(10);
        topLayoutHBox.getChildren().addAll(topLayout);
        borderPane.setTop(topLayoutHBox);

        //BORDER Left

        plusButton = new Button();
        plusButton.setStyle(
                "-fx-font-size: 40px;"+
                "-fx-background-radius: 78em; " +
                "-fx-min-width: 144px; " +
                "-fx-min-height: 144px; " +
                "-fx-max-width: 144px; " +
                "-fx-max-height: 144px;");
        plusButton.setId("plusButton");





        /***
         *          Greg + Mazur :
         */

        flowPane = new FlowPane();
        flowPane.setHgap(30);
        flowPane.setVgap(30);
        flowPane.setPadding(new Insets(5));
        flowPane.setMaxWidth(1500);
        flowPane.setStyle("-fx-background-color:transparent;");

        final ScrollPane scrollPane = new ScrollPane();
        scrollPane.setBorder(null);
        scrollPane.setStyle("-fx-background-color:transparent;");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);    // Horizontal scroll bar
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);    // Vertical scroll bar
        scrollPane.viewportBoundsProperty().addListener((ov, oldBounds, bounds) -> {
            flowPane.setPrefWidth(bounds.getWidth());
        });


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


            File file = new File(filePath);
            //checking if file exists
            ifFileExistsOnThisPc = file.exists();

            //
            if(ifFileExistsOnThisPc == false) {
                String url = urlString.get(i).toString();
                String title = titlesString.get(i).toString();
                System.out.println("Movie " + titlesString.get(i).toString() + " - picture doesn't exist on this Pc");
                System.out.println("Of Url: " + urlString.get(i).toString());

                imageView = newMovieViewController.getWrapImageFromUrlCtrl(urlString.get(i));

                //properly save to /res

                addMoveFormViewController.makeFileFromURL(url,title);

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
            text.setStyle("-fx-background-color:transparent;");
            text.setWrappingWidth(200);
            text.setTextAlignment(TextAlignment.CENTER);
            vBox.getChildren().add(button666);
            vBox.getChildren().add(text);
            vBox.setPadding(new Insets(0, 0, 20, 0));
            vBox.setStyle("-fx-background-color:transparent;");
            flowPane.getChildren().add(vBox);
            scrollPane.setContent(flowPane);
            scrollPane.setStyle("-fx-background-color:transparent;");


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
        borderPane.setCenter(scrollPane);

        logOut = new Button("Log Out");
        logOut.setId("button");
        logOut.setOnAction(event1 -> {
            LoginViewController loginViewController = new LoginViewController();
            loginViewController.startLoginWindow();
            primaryStage.close();
        });
        borderPane.setAlignment(logOut,Pos.CENTER);
        borderPane.setBottom(logOut);
        borderPane.setPadding(new Insets(0, 0, 30, 30));


        //SCENE
        scene = new Scene(borderPane, 900, 600);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.setMaximized(true);
        primaryStage.show();

    }




}




