package com.example.urbanstrategy.application;

import com.example.urbanstrategy.modules.game.presenter.GamePresenter;
import com.example.urbanstrategy.modules.game.view.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public final class GameApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        final GameView gameAnchorPane = new GameView();
        final GamePresenter gamePresenter = new GamePresenter(gameAnchorPane);
        gameAnchorPane.setPresenter(gamePresenter);

        Scene scene = new Scene(gameAnchorPane, 1300, 800);
        stage.setTitle("Urban Strategy");
        stage.setScene(scene);
        stage.show();

        gamePresenter.play();
    }

    public static void main(String[] args) {
        launch();
    }
}