package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
//import javafx.scene.shape.Line;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import java.lang.Math;
import javafx.scene.*;
import java.util.Stack;

import javafx.scene.input.MouseButton;




public class Board {


    private Button[][] board = new Button[9][9];
    public int width;
    public int length;
    public int difficulty;
    public Group group = new Group();

    public GridPane grid = new GridPane();
    public boolean[][] clicked = new boolean[9][9];

    public String nums = "123456789";

//    private int[][] start = new int[][]{{3, 0, 0, 0, 0, 2, 7, 0 ,0},
//        {7, 2, 0, 3, 1, 0, 0, 0 ,0},
//        {1, 0, 9, 7, 0, 0, 2, 0 ,0},
//        {4, 3, 0, 9, 0, 0, 8, 0 ,5},
//        {5, 9, 0, 0, 0, 6, 3, 0 ,1},
//        {8, 1, 2, 0, 3, 0, 0, 6 ,0},
//        {9, 0, 5, 2, 4, 0, 0, 8 ,0},
//        {6, 0, 3, 0, 8, 7, 5, 0 ,0},
//        {0, 8, 0, 6, 9, 0, 4, 0, 0}};
    // what da hell
    private int[][] start;

    public Sudoku game = new Sudoku("easy");
    public int[][] solved = game.getSolution();


    public StackPane stack1 = new StackPane();

    public Board(int width, int length, int difficulty) {
        this.width = width;
        this.length = length;
        this.difficulty = difficulty;
        for(int i=0; i<9; i++ ) {
            for(int j=0; j<9; j++) {
                clicked[i][j] = false;
            }
        }
        this.start = game.getGrid();
    }
    public void generateBoard() {
        game.printGrid();
        game.print();

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {



                board[i][j] = new Button();

                board[i][j].setPrefHeight(100);
                board[i][j].setPrefWidth(100);
                // brain dead retard its colidx first :skull:
                grid.add(board[i][j], j ,i, 1, 1);
                if(start[i][j]!=0) {
                    board[i][j].setText(String.valueOf(game.getSolution()[i][j]));
                    board[i][j].setStyle("-fx-font-size:40");
                }
                int finalJ = j;
                int finalI = i;

                board[i][j].setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if(board[finalI][finalJ].isFocused()) {
                            System.out.println(finalI + ", " + finalJ);

                            if(nums.contains(event.getText()) && ((Integer.parseInt(event.getText())) == game.getSolution()[finalI][finalJ]) && !(event.getText().equals(""))) {
                                board[finalI][finalJ].setText(event.getText());
                                board[finalI][finalJ].setStyle("-fx-font-size:40");
                                System.out.println(board[finalI][finalJ].getText());

                            } else {
                                System.out.println("wrong");
                            }


                        }


                    }

                });










            }
        group.getChildren().add(grid);



    }
    public void generateLines() {
        Line line1 = new Line();
        line1.setStrokeWidth(3);
        line1.setStartX(0);
        line1.setEndX(900);
        line1.setStartY(300);
        line1.setEndY(300);
        Line line2 = new Line();
        line2.setStartX(0);
        line2.setEndX(900);
        line2.setStartY(600);
        line2.setEndY(600);
        line2.setStrokeWidth(3);
        Line line3 = new Line();
        line3.setStartX(300);
        line3.setEndX(300);
        line3.setStartY(0);
        line3.setEndY(900);
        line3.setStrokeWidth(3);
        Line line4 = new Line();
        line4.setStartX(600);
        line4.setEndX(600);
        line4.setStartY(0);
        line4.setEndY(900);
        line4.setStrokeWidth(3);
        group.getChildren().add(line1);
        group.getChildren().add(line2);
        group.getChildren().add(line3);
        group.getChildren().add(line4);
    }




}