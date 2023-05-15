package org.example;

import javafx.application.Application;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Stack;

public class BoardController extends Application {
    public void start(Stage stage) {
        // create board
        int WIDTH = 900;
        int LENGTH = 900;

        Board test = new Board(WIDTH, LENGTH, 1);
        test.generateBoard();
        test.generateLines();
        Group g = test.group;
        //StackPane s = test.getStackPane();

        System.out.println(g.getChildren().size());

        Scene scene = new Scene(g, WIDTH, LENGTH, Color.GRAY);
        //Scene scene1 = new Scene(s,WIDTH, LENGTH, Color.GRAY);
        stage.setScene(scene);
        //stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}