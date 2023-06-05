package com.example.urbanstrategy.UI;

import com.example.urbanstrategy.GameController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

import java.util.List;

public class GameAnchorPane extends AnchorPane {

    private GameController gameController;
    private final HBox transportBox = new HBox();
    private final GridPane buildingsGridPane = new GridPane();

    public GameAnchorPane() {

    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
        setup();
    }

    private void setup() {
        setupSuperView();
        setupBuildingsGridPane();
        setupTransportBox();
    }

    private void setupSuperView() {
        setStyle("-fx-background-color: #332f2f;");
    }

    private void setupBuildingsGridPane() {
        getChildren().add(buildingsGridPane);

        buildingsGridPane.setPadding(new Insets(10));
        buildingsGridPane.setHgap(30);
        buildingsGridPane.setVgap(30);
        buildingsGridPane.setPrefWidth(1000);
        buildingsGridPane.setPrefHeight(550);
        buildingsGridPane.setAlignment(Pos.CENTER);
        buildingsGridPane.setStyle("-fx-background-color: #413e3c;");

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 5; col++) {
                final BuildingAnchorPane cell = new BuildingAnchorPane();

                cell.setPrefHeight(280);
                cell.setPrefWidth(180);

                cell.setTitleBuilding("House");
                cell.updateResourcesTitle("Waste: 3443\nFood: 3434\nWater: 34333");
                cell.updateProcessingTitle("Processing (CONSUME) ELECTRICITY (34)\nProcessing (PRODUCT) WATER (234)");

                buildingsGridPane.add(cell, col, row);
            }
        }

        setTopAnchor(buildingsGridPane, 0.0);
        setLeftAnchor(buildingsGridPane, 0.0);
        setRightAnchor(buildingsGridPane, 0.0);
    }

    private void setupTransportBox() {
        getChildren().add(transportBox);

        transportBox.setSpacing(70);
        transportBox.setAlignment(Pos.CENTER);

        final List<String> titles = gameController.getTransportTitles();
        for (String transportTitle : titles) {
            final TransportAnchorPane transportAnchorPane = new TransportAnchorPane();

            transportAnchorPane.setNameTitle(transportTitle);
            transportAnchorPane.setStatusTitle("Status Transport");
            transportBox.setMaxHeight(Double.MAX_VALUE);
            HBox.setHgrow(transportAnchorPane, Priority.ALWAYS);

            transportBox.getChildren().add(transportAnchorPane);
        }

        setTopAnchor(transportBox, getTopAnchor(buildingsGridPane) + buildingsGridPane.getPrefHeight() + 10);
        setBottomAnchor(transportBox, 0.0);
        setLeftAnchor(transportBox, 20.0);
        setRightAnchor(transportBox, 20.0);
    }

}
