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
import java.util.ArrayList;

/**
 * Created by quena on 25-02-2016.
 */

public class NewMovieViewModel {

    Connection conn = LoginViewModel.conn;

    public ImageView wrapImageFromUrl(String url) {
        BufferedImage img = null;
        //saved for later: "https://thehande.files.wordpress.com/2014/01/brucelee.jpg"
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

    public ArrayList<Integer> getArrayOfIndexMovieFromDb(){
        ArrayList<Integer> list = new ArrayList<>();

        String sql = "SELECT * FROM Movie WHERE indexMovie= ?";
        for(int i=1; i<50; i++) {
            try {
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, i);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int indexMovie = resultSet.getInt(1);
                    list.add(resultSet.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    public String getPhotoLink(int indexMovie){                           // returns link to poster from database basing on index
        String link ="";
        try {
            String query = " SELECT posterPath FROM Movie WHERE indexMovie=? ";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, indexMovie);
            ResultSet results = preparedStatement.executeQuery();

            if (results.next()) {
                link = results.getString(1);
            } else {
                link = "";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return link;
    }

    public String getMovieTitle(int indexMovie){                       //returns movie title from database, basing on index
        String title ="";
        try {
            String query = " SELECT title FROM Movie WHERE indexMovie=? ";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, indexMovie);
            ResultSet results = preparedStatement.executeQuery();

            if (results.next()) {
                title = results.getString(1);
            } else {
                title = "";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return title;
    }
}
