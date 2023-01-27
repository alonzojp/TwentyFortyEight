package com.example.twentyfortyeight;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.Random;

public class HomeController {

    @FXML
    GridPane boardPane;
    @FXML
    Button testButton;

    int[][] gameBoard = new int[4][4];

    public void initialize() {
        spawn();
        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j < gameBoard.length; j++) {
                int number = gameBoard[i][j];
                Image tempImage = new Image(getClass().getResourceAsStream(number + "icon.png"));
                ImageView tempImageView = new ImageView(tempImage);
                boardPane.add(tempImageView, i, j);
            }
        }
    } // end initialize

    public void spawn() {
        Random rng = new Random();
        int counter = 0;
        while(counter != 3) {
            int randomColumn = rng.nextInt(gameBoard.length);
            int randomRow = rng.nextInt(gameBoard.length);
            if(gameBoard[randomColumn][randomRow] == 0) {
                gameBoard[randomColumn][randomRow] = 2;
                System.out.println(randomColumn + " | " + randomRow);
                counter++;
            }
        }
    }

}
