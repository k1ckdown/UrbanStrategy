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

    public void updateTransportationInfoTitle(int atIndex, String title) {
        final TransportAnchorPane transportAnchorPane = (TransportAnchorPane) transportBox.getChildren().get(atIndex);
        transportAnchorPane.setStatusTitle(title);
    }

    public void updateResourcesTitle(int atIndex, String title) {
        final BuildingAnchorPane buildingAnchorPane = (BuildingAnchorPane) buildingsGridPane.getChildren().get(atIndex);
        buildingAnchorPane.setResourcesTitle(title);
    }

    public void updateProcessingTitle(int atIndex, String title) {
        final BuildingAnchorPane buildingAnchorPane = (BuildingAnchorPane) buildingsGridPane.getChildren().get(atIndex);
        buildingAnchorPane.setProcessingTitle(title);
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

        for (int row = 0; row < gameController.getNumberOfRows(); row++) {
            for (int col = 0; col < gameController.getNumberOfColumns(); col++) {
                final BuildingAnchorPane cell = new BuildingAnchorPane();

                cell.setPrefHeight(280);
                cell.setPrefWidth(180);

                cell.setTitleBuilding(gameController.getBuildingTitle(row, col));
//                cell.setResourcesTitle("Waste: 3443\nFood: 3434\nWater: 34333");
//                cell.setProcessingTitle("Processing (CONSUME) ELECTRICITY (34)\nProcessing (PRODUCT) WATER (234)");

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
