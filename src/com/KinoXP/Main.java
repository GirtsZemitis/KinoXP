package com.KinoXP;
import com.KinoXP.view.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by hartyandi on 2/24/16.
 */
public class Main extends Application{

    LoginView loginView = new LoginView();

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        loginView.start();

    }
}
