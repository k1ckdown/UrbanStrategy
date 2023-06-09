package com.example.urbanstrategy.modules.game.view;

import com.example.urbanstrategy.modules.game.presenter.IGamePresenter;
import com.example.urbanstrategy.views.BuildingAnchorPane;
import com.example.urbanstrategy.views.BuildingConfigButton;
import com.example.urbanstrategy.views.TransportStackPane;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;

import java.util.List;

public final class GameView extends AnchorPane implements IGameView {

    private IGamePresenter presenter;

    private final HBox transportBox = new HBox();
    private final Button addBuildingButton = new Button();
    private final GridPane buildingsGridPane = new GridPane();
    private final ScrollPane buildingsScrollPane = new ScrollPane();

    private final TextField nameBuildingTextField = new TextField();
    private final ListView<String> configListView = new ListView<String>();
    private final ObservableList<String> configList = configListView.getItems();
    private final StackPane buildingConfigStackPane = new StackPane();
    private final BuildingConfigButton continueConfigButton = new BuildingConfigButton();
    private final BuildingConfigButton createBuildingButton = new BuildingConfigButton();

    public GameView() {

    }

    public void setPresenter(IGamePresenter presenter) {
        this.presenter = presenter;
        setup();
    }

    public void hideBuildingConfigurator() {
        buildingConfigStackPane.setVisible(false);
    }

    public void addCustomBuildingCell(String title, int row, int col) {
        final BuildingAnchorPane cell = new BuildingAnchorPane();
        cell.setTitleBuilding(title);

        buildingsGridPane.add(cell, col, row);
    }

    public void showMethodsListView() {
        presenter.didSelectResource(configListView.getSelectionModel().getSelectedIndex());

        createBuildingButton.setVisible(false);
        continueConfigButton.setText("Add Methods");
        StackPane.setAlignment(continueConfigButton, Pos.BOTTOM_CENTER);
        configList.setAll(presenter.getSupportedProcessingMethodsTitles());
        configListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void didEndEditingNameBuilding() {
        presenter.didEnterNameBuilding(nameBuildingTextField.getText());
        nameBuildingTextField.setVisible(false);
        configListView.setVisible(true);
        showResourcesListView();
    }

    public void didEndSelectingProcessingMethods() {
        presenter.didSelectProcessingMethods(configListView.getSelectionModel().getSelectedIndices());
        showResourcesListView();
    }

    public void updateResourcesTitle(int atIndex, String title) {
        if (atIndex >= buildingsGridPane.getChildren().size()) {
            return;
        }

        final BuildingAnchorPane buildingAnchorPane = (BuildingAnchorPane) buildingsGridPane.getChildren().get(atIndex);
        buildingAnchorPane.setResourcesTitle(title);
    }

    public void updateProcessingTitle(int atIndex, String title) {
        if (atIndex >= buildingsGridPane.getChildren().size()) {
            return;
        }

        final BuildingAnchorPane buildingAnchorPane = (BuildingAnchorPane) buildingsGridPane.getChildren().get(atIndex);
        buildingAnchorPane.setProcessingTitle(title);
    }

    public void updateTransportationStatusTitle(int atIndex, String title) {
        final TransportStackPane transportStackPane = (TransportStackPane) transportBox.getChildren().get(atIndex);
        transportStackPane.setStatusTitle(title);
    }

    private void showResourcesListView() {
        createBuildingButton.setVisible(true);
        continueConfigButton.setText("Add Resource");
        StackPane.setAlignment(continueConfigButton, Pos.BOTTOM_RIGHT);
        configList.setAll(presenter.getResourcesItems());
        configListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    private void showBuildingConfigurator() {
        configListView.setVisible(false);
        nameBuildingTextField.setText("");
        nameBuildingTextField.setVisible(true);
        createBuildingButton.setVisible(false);
        buildingConfigStackPane.setVisible(true);
        continueConfigButton.setText("Continue");
        configList.clear();
        StackPane.setAlignment(continueConfigButton, Pos.BOTTOM_CENTER);
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
        setupBuildingConfigStackPane();
        setupNameBuildingTextField();
        setupContinueConfigButton();
        setupCreateBuildingButton();
        setupConfigListView();
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
                cell.setTitleBuilding(presenter.getBuildingHeader(row, col));

                buildingsGridPane.add(cell, col, row);
            }
        }
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
        addBuildingButton.setStyle("-fx-background-color: rgb(238,142,38); -fx-background-radius: 25");
        addBuildingButton.setOnAction(actionEvent -> showBuildingConfigurator());

        setRightAnchor(addBuildingButton, 40.0);
        setBottomAnchor(addBuildingButton, 50.0);
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

    private void setupContinueConfigButton() {
        buildingConfigStackPane.getChildren().add(continueConfigButton);

        continueConfigButton.setText("Continue");
        continueConfigButton.setOnAction(actionEvent -> presenter.didTapOnContinueConfigButton());

        StackPane.setAlignment(continueConfigButton, Pos.BOTTOM_CENTER);
    }

    private void setupCreateBuildingButton() {
        buildingConfigStackPane.getChildren().add(createBuildingButton);

        createBuildingButton.setText("Create Building");
        createBuildingButton.setVisible(false);
        createBuildingButton.setOnAction(actionEvent -> presenter.didTapOnCreateCustomBuildingButton());

        StackPane.setAlignment(createBuildingButton, Pos.BOTTOM_LEFT);
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

    private void setupConfigListView() {
        buildingConfigStackPane.getChildren().add(configListView);

        configListView.setMaxHeight(380);
        configListView.setMaxWidth(600);
        configListView.setOrientation(Orientation.VERTICAL);
        configListView.setStyle("-fx-background-color: #3d3d3f; -fx-background-radius: 10");
        configListView.setPadding(new Insets(10));
        configListView.setVisible(false);

        StackPane.setAlignment(configListView, Pos.TOP_CENTER);

        configListView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
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
