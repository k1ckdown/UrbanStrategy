package com.example.urbanstrategy.views;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public final class BuildingAnchorPane extends AnchorPane {

    private final Label nameTitleLabel = new Label();
    private final Label resourcesLabel = new Label();
    private final Label processingInfoLabel = new Label();
    private final Label processingHeaderLabel = new Label();

    public BuildingAnchorPane() {
        setup();
    }

    public void setTitleBuilding(String title) {
        nameTitleLabel.setText(title);
    }

    public void setResourcesTitle(String title) {
        resourcesLabel.setText(title);
    }

    public void setProcessingTitle(String title) {
        processingInfoLabel.setText(title);
    }

    public void setup() {
        setupSuperView();
        setupNameTitleLabel();
        setupListOfResources();
        setupProcessingHeaderLabel();
        setupProcessingInfoLabel();
    }

    private void setupSuperView() {
        setMinHeight(260);
        setMinWidth(230);
        setStyle("-fx-border-width: 2; -fx-border-color: rgba(132,181,208,0.84)");
    }

    public void setupNameTitleLabel() {
        getChildren().add(nameTitleLabel);

        nameTitleLabel.setPrefHeight(30);
        nameTitleLabel.setTextFill(Color.BLACK);
        nameTitleLabel.setAlignment(Pos.CENTER);
        nameTitleLabel.setStyle("-fx-background-color: rgba(132,132,208,0.72); -fx-font-size: 19px");

        AnchorPane.setTopAnchor(nameTitleLabel, 0.0);
        AnchorPane.setLeftAnchor(nameTitleLabel, 0.0);
        AnchorPane.setRightAnchor(nameTitleLabel, 0.0);
    }

    private void setupListOfResources() {
        getChildren().add(resourcesLabel);

        resourcesLabel.setPrefHeight(90);
        resourcesLabel.setTextFill(Color.BLACK);
        resourcesLabel.setAlignment(Pos.CENTER);
        resourcesLabel.setStyle("-fx-background-color: rgba(198,198,203,0.73); -fx-font-size: 17px");

        AnchorPane.setTopAnchor(resourcesLabel, nameTitleLabel.getPrefHeight() + 15);
        AnchorPane.setLeftAnchor(resourcesLabel, 0.0);
        AnchorPane.setRightAnchor(resourcesLabel, 0.0);
    }

    private void setupProcessingHeaderLabel() {
        getChildren().add(processingHeaderLabel);

        processingHeaderLabel.setText("Processing");
        processingHeaderLabel.setTextFill(Color.BLACK);
        processingHeaderLabel.setAlignment(Pos.CENTER);
        processingHeaderLabel.setStyle("-fx-background-color: rgba(147,229,70,0.72); -fx-font-size: 15px");

        AnchorPane.setLeftAnchor(processingHeaderLabel, 0.0);
        AnchorPane.setRightAnchor(processingHeaderLabel, 0.0);
        AnchorPane.setBottomAnchor(processingHeaderLabel, 80.0);

    }

    private void setupProcessingInfoLabel() {
        getChildren().add(processingInfoLabel);

        processingInfoLabel.setPrefHeight(80);
        processingInfoLabel.setTextFill(Color.BLACK);
        processingInfoLabel.setAlignment(Pos.CENTER);
        processingInfoLabel.setStyle("-fx-background-color: rgba(198,198,203,0.73); -fx-font-size: 12px");

        AnchorPane.setLeftAnchor(processingInfoLabel, 0.0);
        AnchorPane.setRightAnchor(processingInfoLabel, 0.0);
        AnchorPane.setBottomAnchor(processingInfoLabel, 0.0);
    }

}
