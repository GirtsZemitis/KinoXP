package com.KinoXP.model;


import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Grzegorz Goraj on 25-02-2016.
 */

public class NewMovieViewModel {

    Connection conn = LoginViewModel.conn;

    public ImageView wrapImageFromUrl(String url) {
        BufferedImage img = null;

        try {
            img = ImageIO.read(new URL(url));
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

    public ResultSet getArrayOfIndexMovieFromDb(){
        String sql = "SELECT * FROM Movie";
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                return preparedStatement.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
        }

        return null;
    }

    public ResultSet getPhotoLink(){        // returns link to poster from database basing on index
        try {
            String query = " SELECT posterPath FROM Movie";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            return preparedStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ResultSet getMovieTitle(){                       //returns movie title from database, basing on index
        String title ="";
        try {
            String query = " SELECT title,posterPath FROM Movie";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            return preparedStatement.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void createPosterPathFile(String filePath) {
        File file = new File(filePath);

    }
}
