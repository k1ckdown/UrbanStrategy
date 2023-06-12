package com.example.urbanstrategy.modules.urbanDetails.view;

import com.example.urbanstrategy.modules.buildingEditor.view.BuildingEditorView;
import com.example.urbanstrategy.modules.urbanDetails.presenter.IUrbanDetailsPresenter;
import com.example.urbanstrategy.utils.ImageProvider;
import com.example.urbanstrategy.views.BuildingAnchorPane;
import com.example.urbanstrategy.views.TransportStackPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public final class UrbanDetailsView extends AnchorPane implements IUrbanDetailsView {

    private IUrbanDetailsPresenter presenter;

    private final HBox transportBox = new HBox();
    private final Button addBuildingButton = new Button();
    private final GridPane buildingsGridPane = new GridPane();
    private final ScrollPane buildingsScrollPane = new ScrollPane();

    public void setPresenter(IUrbanDetailsPresenter presenter) {
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

    public void showBuildingEditor(BuildingEditorView view) {
        if (!getChildren().contains(view)) {
            getChildren().add(view);
        }

        view.present();
    }

    public void addCustomBuildingCell(String nameTitle, String descTitle, int row, int col) {
        final BuildingAnchorPane cell = new BuildingAnchorPane();
        final Image buildingImage = ImageProvider.getInstance().getCustomBuildingImage();

        cell.setTitleBuilding(nameTitle);
        cell.setDescriptionTitle(descTitle);
        cell.setBackground(getBackground(buildingImage));

        buildingsGridPane.add(cell, col, row);
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
        setupBuildingsScrollPane();
        setupBuildingsGridPane();
        setupTransportBox();
        setupAddBuildingButton();
    }

    private void setupSuperView() {
        setStyle("-fx-background-color: #332f2f;");
    }

    private void setupBuildingsScrollPane() {
        getChildren().add(buildingsScrollPane);

        buildingsScrollPane.setContent(buildingsGridPane);
        buildingsScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        buildingsScrollPane.setStyle("-fx-background-color: transparent; -fx-background: transparent;");

        setTopAnchor(buildingsScrollPane, 0.0);
        setLeftAnchor(buildingsScrollPane, 0.0);
        setRightAnchor(buildingsScrollPane, 0.0);
    }

    private void setupBuildingsGridPane() {
        buildingsGridPane.setPadding(new Insets(10));
        buildingsGridPane.setHgap(20);
        buildingsGridPane.setVgap(20);
        buildingsScrollPane.setPrefWidth(1100);
        buildingsScrollPane.setPrefHeight(580);
        buildingsGridPane.setAlignment(Pos.CENTER);
        buildingsGridPane.setStyle("-fx-background-color: #413e3c;");

        final int numberOfRows = presenter.getNumberOfRows();
        final int numberOfColumns = presenter.getNumberOfColumns();
        for (int row = 0; row < numberOfRows; row++) {
            for (int col = 0; col < numberOfColumns; col++) {
                final BuildingAnchorPane cell = new BuildingAnchorPane();
                final Image buildingImage = presenter.getBuildingImage(row, col);

                cell.setBackground(getBackground(buildingImage));
                cell.setDescriptionTitle(presenter.getBuildingDesc(row, col));
                cell.setTitleBuilding(presenter.getBuildingHeader(row, col));

                buildingsGridPane.add(cell, col, row);
            }
        }
    }

    private void setupTransportBox() {
        getChildren().add(transportBox);

        transportBox.setSpacing(30);
        transportBox.setAlignment(Pos.CENTER);

        for (int q = 0; q < presenter.getNumberOfTransports(); q++) {
            final TransportStackPane transportStackPane = new TransportStackPane();
            final Image transportImage = presenter.getTransportImage(q);

            transportStackPane.setNameTitle(presenter.getTransportHeader(q));
            transportStackPane.setBackground(getBackground(transportImage));

            transportBox.getChildren().add(transportStackPane);
        }

        setTopAnchor(transportBox, buildingsScrollPane.getPrefHeight() + 10);
        setBottomAnchor(transportBox, 10.0);
        setLeftAnchor(transportBox, 10.0);
        setRightAnchor(transportBox, 200.0);
    }

    private void setupAddBuildingButton() {
        getChildren().add(addBuildingButton);

        addBuildingButton.setPrefWidth(120);
        addBuildingButton.setPrefHeight(120);
        addBuildingButton.setText("Create Building!");
        addBuildingButton.setWrapText(true);
        addBuildingButton.setTextAlignment(TextAlignment.CENTER);
        addBuildingButton.setFont(Font.font("Futura", FontWeight.BOLD, 18));
        addBuildingButton.setCursor(Cursor.HAND);
        addBuildingButton.setStyle("-fx-background-color: rgb(184,208,26); -fx-background-radius: 25");
        addBuildingButton.setOnAction(actionEvent -> presenter.didTapOnAddBuildingButton());

        setRightAnchor(addBuildingButton, 40.0);
        setBottomAnchor(addBuildingButton, 50.0);
    }

}
