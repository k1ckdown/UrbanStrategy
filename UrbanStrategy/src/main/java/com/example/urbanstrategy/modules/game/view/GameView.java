package com.example.urbanstrategy.modules.game.view;

import com.example.urbanstrategy.modules.game.presenter.IGamePresenter;
import com.example.urbanstrategy.views.BuildingAnchorPane;
import com.example.urbanstrategy.views.TransportStackPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.List;

public final class GameView extends AnchorPane implements IGameView {

    private IGamePresenter presenter;
    private final HBox transportBox = new HBox();
    private final GridPane buildingsGridPane = new GridPane();

    public GameView() {

    }

    public void setPresenter(IGamePresenter presenter) {
        this.presenter = presenter;
        setup();
    }

    public void updateResourcesTitle(int atIndex, String title) {
        final BuildingAnchorPane buildingAnchorPane = (BuildingAnchorPane) buildingsGridPane.getChildren().get(atIndex);
        buildingAnchorPane.setResourcesTitle(title);
    }

    public void updateProcessingTitle(int atIndex, String title) {
        final BuildingAnchorPane buildingAnchorPane = (BuildingAnchorPane) buildingsGridPane.getChildren().get(atIndex);
        buildingAnchorPane.setProcessingTitle(title);
    }

    public void updateTransportationStatusTitle(int atIndex, String title) {
        final TransportStackPane transportStackPane = (TransportStackPane) transportBox.getChildren().get(atIndex);
        transportStackPane.setStatusTitle(title);
    }

    private Background getBackground(Image image) {
        final BackgroundSize backgroundSize = new BackgroundSize(
                100, 100,
                true, true, true, true
        );

        final BackgroundImage backgroundImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, backgroundSize
        );

        return new Background(backgroundImage);
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
        buildingsGridPane.setHgap(15);
        buildingsGridPane.setVgap(15);
        buildingsGridPane.setPrefWidth(1100);
        buildingsGridPane.setPrefHeight(580);
        buildingsGridPane.setAlignment(Pos.CENTER);
        buildingsGridPane.setStyle("-fx-background-color: #413e3c;");

        final int numberOfRows = presenter.getNumberOfRows();
        final int numberOfColumns = presenter.getNumberOfColumns();
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfColumns; col++) {
                final BuildingAnchorPane cell = new BuildingAnchorPane();
                final Image buildingImage = presenter.getBuildingImage(row, col);

                cell.setPrefHeight(270);
                cell.setPrefWidth(240);
                cell.setBackground(getBackground(buildingImage));
                cell.setTitleBuilding(presenter.getBuildingHeader(row, col));

                buildingsGridPane.add(cell, col, row);
            }
        }

        setTopAnchor(buildingsGridPane, 0.0);
        setLeftAnchor(buildingsGridPane, 0.0);
        setRightAnchor(buildingsGridPane, 0.0);
    }

    private void setupTransportBox() {
        getChildren().add(transportBox);

        transportBox.setSpacing(40);
        transportBox.setAlignment(Pos.CENTER);

        final List<String> headers = presenter.getTransportHeaders();
        for (int q = 0; q < headers.size(); q++) {
            final TransportStackPane transportStackPane = new TransportStackPane();
            final Image transportImage = presenter.getTransportImage(q);

            transportStackPane.setNameTitle(headers.get(q));
            transportStackPane.setStatusTitle("Moved coal from mine to power plant (939)");
            transportStackPane.setBackground(getBackground(transportImage));

            transportBox.getChildren().add(transportStackPane);
        }

        setTopAnchor(transportBox, getTopAnchor(buildingsGridPane) + buildingsGridPane.getPrefHeight() + 10);
        setBottomAnchor(transportBox, 0.0);
        setLeftAnchor(transportBox, 20.0);
        setRightAnchor(transportBox, 20.0);
    }

}
