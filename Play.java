package PartA;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Play extends Application {

    final int appWidth = 1200;
    final int appHeight = 400;
    Board board = new Board();
    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        Scene scene = new Scene(board, appWidth, appHeight, Color.BLACK);
        primaryStage.setTitle("Chess Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * Launches the JavaFX application.
     * 
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
