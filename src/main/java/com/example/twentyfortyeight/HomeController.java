package com.example.twentyfortyeight;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class HomeController {

    @FXML
    GridPane boardPane;

    public void initialize() {
        int[][] gameBoard = new int[6][6];
        for(int i = 0; i < gameBoard.length; i++) {
            for(int j = 0; j < gameBoard.length; j++) {
                Label tempLabel = new Label(String.valueOf(gameBoard[i][j]));
                boardPane.add(tempLabel, i, j);
            }
        }
    }

}
