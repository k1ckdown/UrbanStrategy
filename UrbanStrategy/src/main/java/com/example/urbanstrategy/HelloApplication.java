package com.example.urbanstrategy;

import com.example.urbanstrategy.UI.GameAnchorPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public final class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        final GameAnchorPane gameAnchorPane = new GameAnchorPane();
        final GameController gameController = new GameController(gameAnchorPane);
        gameAnchorPane.setGameController(gameController);

        Scene scene = new Scene(gameAnchorPane, 1300, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
//        GameController gameController = new GameController(new GameAnchorPane());
//        gameController.play();
        launch();
    }
}