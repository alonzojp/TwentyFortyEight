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
    Button leftButton;
    @FXML
    Button rightButton;
    @FXML
    Button upButton;
    @FXML
    Button downButton;
    @FXML
    Button resetButton;
    @FXML
    Label gameLabel;

    int[][] gameBoard = new int[4][4];
    int loseCounter = 0;
    int currentSize = 0;

    public void resetBoard() {
        gameBoard = new int[4][4];
        initialize();
        leftButton.setDisable(false);
        rightButton.setDisable(false);
        upButton.setDisable(false);
        downButton.setDisable(false);
        boardPane.setDisable(false);
    }
    public void updateBoard() {
        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j < gameBoard.length; j++) {
                int number = gameBoard[i][j];
                Image tempImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(number + ".png")));
                ImageView tempImageView = new ImageView(tempImage);
                boardPane.add(tempImageView, j, i);
            }
        }
    }

    public void displayLose() {
        leftButton.setDisable(true);
        rightButton.setDisable(true);
        upButton.setDisable(true);
        downButton.setDisable(true);
        boardPane.setDisable(true);
        gameLabel.setText("Game Over!");
    }

    public void initialize() {
        gameLabel.setText("Reach TwentyFortyEight!");
        spawn(3);
        updateBoard();
    } // end initialize

    public void refresh() {
        if(loseCounter == 5) {
            displayLose();
        }
        if(currentSize != 16) {
            spawn(1);
            loseCounter = 0;
        }
        else {
            loseCounter++;
        }
        updateBoard();
        currentSize = 0;
    } // end refresh

    public void spawn(int spawnCount) {
        Random rng = new Random();
        int counter = 0;
        while(counter != spawnCount) {
            int randomColumn = rng.nextInt(gameBoard.length);
            int randomRow = rng.nextInt(gameBoard.length);
            if(gameBoard[randomRow][randomColumn] == 0) {
                int random = rng.nextInt(10);
                if(random == 0) {
                    gameBoard[randomRow][randomColumn] = 8;
                }
                else if(random == 1 || random == 2) {
                    gameBoard[randomRow][randomColumn] = 4;
                }
                else {
                    gameBoard[randomRow][randomColumn] = 2;
                }
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
                    currentSize++;
                }
                gameBoard[i][j] = 0;
            }

            if(tempArrayList.size() > 1) {
                for(int l = 0; l < tempArrayList.size() - 1; l++) {
                    if(tempArrayList.get(l) == tempArrayList.get(l+1)) {
                        tempArrayList.set(l, tempArrayList.get(l)*2);
                        tempArrayList.remove(l+1);
                    }
                }
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
                    currentSize++;
                }
                gameBoard[i][j] = 0;
            }

            if(tempArrayList.size() > 1) {
                for(int l = 0; l < tempArrayList.size() - 1; l++) {
                    if(tempArrayList.get(l) == tempArrayList.get(l+1)) {
                        tempArrayList.set(l, tempArrayList.get(l)*2);
                        tempArrayList.remove(l+1);
                    }
                }
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
                    currentSize++;
                }
                gameBoard[j][i] = 0;
            }

            if(tempArrayList.size() > 1) {
                for(int l = 0; l < tempArrayList.size() - 1; l++) {
                    if(tempArrayList.get(l) == tempArrayList.get(l+1)) {
                        tempArrayList.set(l, tempArrayList.get(l)*2);
                        tempArrayList.remove(l+1);
                    }
                }
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
                    currentSize++;
                }
                gameBoard[j][i] = 0;
            }

            if(tempArrayList.size() > 1) {
                for(int l = 0; l < tempArrayList.size() - 1; l++) {
                    if(tempArrayList.get(l) == tempArrayList.get(l+1)) {
                        tempArrayList.set(l, tempArrayList.get(l)*2);
                        tempArrayList.remove(l+1);
                    }
                }
            }

            System.out.println(tempArrayList);

            for (int k = 0; k < tempArrayList.size(); k++) {
                gameBoard[k][i] = tempArrayList.get(k);
            }
        }
        refresh();
    } // end moveUp
}
