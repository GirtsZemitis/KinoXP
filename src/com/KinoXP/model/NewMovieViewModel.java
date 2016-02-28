package com.KinoXP.model;


import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by quena on 25-02-2016.
 */

public class NewMovieViewModel {

    Connection conn;

    public ImageView wrapImageFromUrl() {
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

        return imageView;
    }

    public String getActorFromDatabase(String mainActor) {
        String out = "";
        try {
            String query = " SELECT title FROM Movie WHERE mainActor=? ";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, mainActor);
            ResultSet results = preparedStatement.executeQuery();

            if (results.next()) {
                out = results.getString(1);
            } else {
                out = "";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return out;
    }
}
