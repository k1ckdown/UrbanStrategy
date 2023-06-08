package com.example.urbanstrategy.modules.game.view;

import com.example.urbanstrategy.modules.game.presenter.IGamePresenter;
import com.example.urbanstrategy.views.BuildingAnchorPane;
import com.example.urbanstrategy.views.TransportStackPane;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;

import java.util.List;

public final class GameView extends AnchorPane implements IGameView {

    private IGamePresenter presenter;

    private final HBox transportBox = new HBox();
    private final Button createBuildingButton = new Button();
    private final GridPane buildingsGridPane = new GridPane();

    private final Button buildingConfigButton = new Button();
    private final TextField nameBuildingTextField = new TextField();
    private final ListView<String> resourcesListView = new ListView<String>();
    private final ObservableList<String> resourcesList = resourcesListView.getItems();
    private final StackPane buildingConfigStackPane = new StackPane();

    public GameView() {

    }

    public void setPresenter(IGamePresenter presenter) {
        this.presenter = presenter;
        setup();
    }

    public void hideBuildingConfigurator() {
        buildingConfigStackPane.setVisible(false);
    }

    public void showResourcesListView() {
        resourcesListView.setVisible(true);
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

    private void showBuildingConfigurator() {
        buildingConfigStackPane.setVisible(true);
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
        setupCreateBuildingButton();
        setupBuildingConfigStackPane();
        setupNameBuildingTextField();
        setupBuildingConfigButton();
        setupResourcesListView();
    }

    private void setupSuperView() {
        setStyle("-fx-background-color: #332f2f;");
    }

    private void setupBuildingsGridPane() {
        getChildren().add(buildingsGridPane);

        buildingsGridPane.setPadding(new Insets(10));
        buildingsGridPane.setHgap(20);
        buildingsGridPane.setVgap(20);
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
                cell.setPrefWidth(230);
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

        transportBox.setSpacing(30);
        transportBox.setAlignment(Pos.CENTER);

        final List<String> headers = presenter.getTransportHeaders();
        for (int q = 0; q < headers.size(); q++) {
            final TransportStackPane transportStackPane = new TransportStackPane();
            final Image transportImage = presenter.getTransportImage(q);

            transportStackPane.setNameTitle(headers.get(q));
            transportStackPane.setBackground(getBackground(transportImage));

            transportBox.getChildren().add(transportStackPane);
        }

        setTopAnchor(transportBox, getTopAnchor(buildingsGridPane) + buildingsGridPane.getPrefHeight() + 10);
        setBottomAnchor(transportBox, 10.0);
        setLeftAnchor(transportBox, 10.0);
        setRightAnchor(transportBox, 200.0);
    }

    private void setupCreateBuildingButton() {
        getChildren().add(createBuildingButton);

        createBuildingButton.setPrefWidth(120);
        createBuildingButton.setPrefHeight(120);
        createBuildingButton.setText("Create Building!");
        createBuildingButton.setWrapText(true);
        createBuildingButton.setTextAlignment(TextAlignment.CENTER);
        createBuildingButton.setFont(Font.font("Futura", FontWeight.BOLD, 18));
        createBuildingButton.setCursor(Cursor.HAND);
        createBuildingButton.setStyle("-fx-background-color: rgb(238,142,38); -fx-background-radius: 25");
        createBuildingButton.setOnAction(actionEvent -> showBuildingConfigurator());

        setRightAnchor(createBuildingButton, 40.0);
        setBottomAnchor(createBuildingButton, 50.0);
    }

    private void setupBuildingConfigStackPane() {
        getChildren().add(buildingConfigStackPane);

        buildingConfigStackPane.setPadding(new Insets(30));
        buildingConfigStackPane.setStyle("-fx-background-color: #212020; -fx-background-radius: 30; ");
        buildingConfigStackPane.setVisible(false);

        setTopAnchor(buildingConfigStackPane, 130.0);
        setBottomAnchor(buildingConfigStackPane, 130.0);
        setLeftAnchor(buildingConfigStackPane, 200.0);
        setRightAnchor(buildingConfigStackPane, 200.0);
    }

    private void setupBuildingConfigButton() {
        buildingConfigStackPane.getChildren().add(buildingConfigButton);

        buildingConfigButton.setPrefHeight(70);
        buildingConfigButton.setPrefWidth(230);
        buildingConfigButton.setTextFill(Color.BLACK);
        buildingConfigButton.setFont(Font.font("SF Mono", FontWeight.BOLD, 20));
        buildingConfigButton.setText("Continue");
        buildingConfigButton.setCursor(Cursor.HAND);
        buildingConfigButton.setStyle("-fx-background-radius: 20; -fx-background-color: #ee8e26");
        buildingConfigButton.setOnAction(actionEvent -> presenter.didTapOnBuildingConfigButton());

        StackPane.setAlignment(buildingConfigButton, Pos.BOTTOM_CENTER);

//        buildingConfigButton.setOnAction(event -> {
//            System.out.println(resourcesListView.getSelectionModel().getSelectedIndex());
//        });
    }

    private void setupNameBuildingTextField() {
        buildingConfigStackPane.getChildren().add(nameBuildingTextField);

        nameBuildingTextField.setPrefHeight(70);
        nameBuildingTextField.setMaxWidth(350);
        nameBuildingTextField.setPadding(new Insets(10));
        nameBuildingTextField.setFont(Font.font(18));
        nameBuildingTextField.setPromptText("Enter name building");
        nameBuildingTextField.setStyle(
                "-fx-background-color: #3d3d3f;" +
                        " -fx-background-radius: 20; " +
                        "-fx-text-fill: #b2adad"
        );

        StackPane.setAlignment(nameBuildingTextField, Pos.CENTER);
    }

    private void setupResourcesListView() {
        buildingConfigStackPane.getChildren().add(resourcesListView);

        resourcesList.addAll(presenter.getResourcesItems());
        resourcesListView.setMaxHeight(380);
        resourcesListView.setMaxWidth(600);
        resourcesListView.setOrientation(Orientation.VERTICAL);
        resourcesListView.setStyle("-fx-background-color: #3d3d3f; -fx-background-radius: 10");
        resourcesListView.setPadding(new Insets(10));
        resourcesListView.setVisible(false);

        StackPane.setAlignment(resourcesListView, Pos.TOP_CENTER);

        resourcesListView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        setFont(Font.font(17));

                        if (item != null) {
                            setText(item);
                        }

                        if (empty || item == null) {
                            setText(null);
                            setStyle("-fx-background-color: #3d3d3f;");
                        } else if (isSelected()) {
                            setStyle("-fx-background-color: #ee8e26; -fx-text-fill: black;");
                        } else {
                            setStyle("-fx-background-color: #3d3d3f; -fx-text-fill: lightgray;");
                        }
                    }
                };
            }
        });

    }

}
