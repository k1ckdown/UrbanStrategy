package com.example.urbanstrategy.application;

import com.example.urbanstrategy.models.city.City;
import com.example.urbanstrategy.modules.urbandetails.presenter.UrbanDetailsPresenter;
import com.example.urbanstrategy.modules.urbandetails.view.UrbanDetailsView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class MainApplication extends Application {

    @Override
    public void start(Stage stage) {
        final City city = new City();
        final UrbanDetailsView urbanDetailsView = new UrbanDetailsView();
        final UrbanDetailsPresenter urbanDetailsPresenter = new UrbanDetailsPresenter(urbanDetailsView, city);

        Scene scene = new Scene(urbanDetailsView, 1300, 800);
        stage.setTitle("Urban Strategy");
        stage.setScene(scene);
        stage.show();

        urbanDetailsPresenter.play();
    }

    public static void main(String[] args) {
        launch();
    }
}