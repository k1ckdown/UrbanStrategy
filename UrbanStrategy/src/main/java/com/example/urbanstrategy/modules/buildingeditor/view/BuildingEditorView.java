package com.example.urbanstrategy.modules.buildingeditor.view;

import com.example.urbanstrategy.modules.buildingeditor.presenter.IBuildingEditorPresenter;
import com.example.urbanstrategy.viewcomponents.BuildingConfigButton;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.util.Callback;

public final class BuildingEditorView extends StackPane implements IBuildingEditorView {

    private IBuildingEditorPresenter presenter;

    private final TextField nameBuildingTextField = new TextField();
    private final ListView<String> configListView = new ListView<>();
    private final ObservableList<String> configList = configListView.getItems();
    private final BuildingConfigButton continueConfigButton = new BuildingConfigButton();
    private final BuildingConfigButton createBuildingButton = new BuildingConfigButton();

    public void setPresenter(IBuildingEditorPresenter presenter) {
        this.presenter = presenter;
        setupUI();
    }

    public void present() {
        setVisible(true);
    }

    public void didEndSelectingProcessingMethods() {
        presenter.didSelectProcessingMethods(configListView.getSelectionModel().getSelectedIndices());
        showResourcesListView();
    }

    public void didEndEditingNameBuilding() {
        presenter.didEnterNameBuilding(nameBuildingTextField.getText());
        nameBuildingTextField.setVisible(false);
        configListView.setVisible(true);
        showResourcesListView();
    }

    public void didEndSelectingResource() {
        presenter.didSelectResource(configListView.getSelectionModel().getSelectedIndex());

        createBuildingButton.setVisible(false);
        continueConfigButton.setText("Add Methods");
        StackPane.setAlignment(continueConfigButton, Pos.BOTTOM_CENTER);
        configList.setAll(presenter.getSupportedProcessingMethodsTitles());
        configListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void didEndCreatingBuilding() {
        setVisible(false);
        configListView.setVisible(false);
        nameBuildingTextField.setText("");
        nameBuildingTextField.setVisible(true);
        createBuildingButton.setVisible(false);
        continueConfigButton.setText("Continue");
        configList.clear();
        StackPane.setAlignment(continueConfigButton, Pos.BOTTOM_CENTER);
    }

    private void showResourcesListView() {
        createBuildingButton.setVisible(true);
        continueConfigButton.setText("Add Resource");
        StackPane.setAlignment(continueConfigButton, Pos.BOTTOM_RIGHT);
        configList.setAll(presenter.getResourcesItems());
        configListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    private void setupUI() {
        setupBuildingConfigStackPane();
        setupNameBuildingTextField();
        setupContinueConfigButton();
        setupCreateBuildingButton();
        setupConfigListView();
    }

    private void setupBuildingConfigStackPane() {

        setPadding(new Insets(30));
        setStyle("-fx-background-color: #212020; -fx-background-radius: 30; ");

        AnchorPane.setTopAnchor(this, 130.0);
        AnchorPane.setBottomAnchor(this, 130.0);
        AnchorPane.setLeftAnchor(this, 200.0);
        AnchorPane.setRightAnchor(this, 200.0);
    }

    private void setupContinueConfigButton() {
        getChildren().add(continueConfigButton);

        continueConfigButton.setText("Continue");
        continueConfigButton.setOnAction(actionEvent -> presenter.didTapOnContinueConfigButton());

        StackPane.setAlignment(continueConfigButton, Pos.BOTTOM_CENTER);
    }

    private void setupCreateBuildingButton() {
        getChildren().add(createBuildingButton);

        createBuildingButton.setText("Create Building");
        createBuildingButton.setVisible(false);
        createBuildingButton.setOnAction(actionEvent -> presenter.didTapOnCreateCustomBuildingButton());

        StackPane.setAlignment(createBuildingButton, Pos.BOTTOM_LEFT);
    }

    private void setupNameBuildingTextField() {
        getChildren().add(nameBuildingTextField);

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
        getChildren().add(configListView);

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
                            setStyle("-fx-background-color: #b8d01a; -fx-text-fill: black;");
                        } else {
                            setStyle("-fx-background-color: #3d3d3f; -fx-text-fill: lightgray;");
                        }
                    }
                };
            }
        });

    }
}
