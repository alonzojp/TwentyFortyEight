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

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class HomeController {

    @FXML
    GridPane boardPane;
    @FXML
    Button testButton;

    int[][] gameBoard = new int[4][4];

    public void initialize() {
        spawn(3);
        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j < gameBoard.length; j++) {
                int number = gameBoard[i][j];
                Image tempImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(number + "icon.png")));
                ImageView tempImageView = new ImageView(tempImage);
                boardPane.add(tempImageView, j, i);
            }
        }
    } // end initialize

    public void refresh() {
        spawn(1);
        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j < gameBoard.length; j++) {
                int number = gameBoard[i][j];
                Image tempImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(number + "icon.png")));
                ImageView tempImageView = new ImageView(tempImage);
                boardPane.add(tempImageView, j, i);
            }
        }
    } // end refresh

    public void spawn(int spawnCount) {
        Random rng = new Random();
        int counter = 0;
        while(counter != spawnCount) {
            int randomColumn = rng.nextInt(gameBoard.length);
            int randomRow = rng.nextInt(gameBoard.length);
            if(gameBoard[randomRow][randomColumn] == 0) {
                gameBoard[randomRow][randomColumn] = 2;
                System.out.println(randomRow + ", " + randomColumn);
                counter++;
            }
        }
    } // end spawn

    public void moveLeft(ActionEvent event) {
        for(int i = 0; i < gameBoard.length; i++) {
            ArrayList<Integer> tempArrayList = new ArrayList<>();;
            for (int j = 0; j < gameBoard.length; j++) {

                if (gameBoard[i][j] != 0) {
                    tempArrayList.add(gameBoard[i][j]);
                }
                gameBoard[i][j] = 0;
            }

            System.out.println(tempArrayList);

            for (int k = 0; k < tempArrayList.size(); k++) {
                gameBoard[i][k] = tempArrayList.get(k);
            }
        }
        refresh();
    } // end moveLeft

    public void moveRight(ActionEvent event) {
        for(int i = 0; i < gameBoard.length; i++) {
            ArrayList<Integer> tempArrayList = new ArrayList<>();;
            for (int j = 0; j < gameBoard.length; j++) {

                if (gameBoard[i][j] != 0) {
                    tempArrayList.add(gameBoard[i][j]);
                }
                gameBoard[i][j] = 0;
            }

            System.out.println(tempArrayList);

            int difference = gameBoard.length - tempArrayList.size();
            for (int k = difference; k < gameBoard.length; k++) {
                gameBoard[i][k] = tempArrayList.get(0);
                tempArrayList.remove(0);
            }
        }
        refresh();
    } // end moveRight

    public void moveDown(ActionEvent event) {
        for(int i = 0; i < gameBoard.length; i++) {
            ArrayList<Integer> tempArrayList = new ArrayList<>();;
            for (int j = 0; j < gameBoard.length; j++) {

                if (gameBoard[j][i] != 0) {
                    tempArrayList.add(gameBoard[j][i]);
                }
                gameBoard[j][i] = 0;
            }

            System.out.println(tempArrayList);

            int difference = gameBoard.length - tempArrayList.size();
            for (int k = difference; k < gameBoard.length; k++) {
                gameBoard[k][i] = tempArrayList.get(0);
                tempArrayList.remove(0);
            }
        }
        refresh();
    } // end moveDown

    public void moveUp(ActionEvent event) {
        for(int i = 0; i < gameBoard.length; i++) {
            ArrayList<Integer> tempArrayList = new ArrayList<>();;
            for (int j = 0; j < gameBoard.length; j++) {

                if (gameBoard[j][i] != 0) {
                    tempArrayList.add(gameBoard[j][i]);
                }
                gameBoard[j][i] = 0;
            }

            System.out.println(tempArrayList);

            for (int k = 0; k < tempArrayList.size(); k++) {
                gameBoard[k][i] = tempArrayList.get(k);
            }
        }
        refresh();
    } // end moveUp
}
