package com.example.urbanstrategy.viewcomponents;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public final class BuildingAnchorPane extends AnchorPane {

    private boolean isSelectedDescription = false;
    private final Label nameTitleLabel = new Label();
    private final Label resourcesLabel = new Label();
    private final Label processingInfoLabel = new Label();
    private final Label processingHeaderLabel = new Label();
    private final Label descriptionLabel = new Label();
    private final Button descriptionButton = new Button();

    public BuildingAnchorPane() {
        setup();
    }

    public void setTitleBuilding(String title) {
        nameTitleLabel.setText(title);
    }

    public void setDescriptionTitle(String title) {
        descriptionLabel.setText(title);
    }

    public void setResourcesTitle(String title) {
        resourcesLabel.setText(title);
    }

    public void setProcessingTitle(String title) {
        processingInfoLabel.setText(title);
    }

    private void toggleDescriptionLabel() {
        isSelectedDescription = !isSelectedDescription;
        descriptionLabel.setVisible(isSelectedDescription);
    }

    public void setup() {
        setupSuperView();
        setupNameTitleLabel();
        setupListOfResources();
        setupProcessingHeaderLabel();
        setupProcessingInfoLabel();
        setupDescriptionLabel();
        descriptionButton();
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

        AnchorPane.setLeftAnchor(resourcesLabel, 0.0);
        AnchorPane.setRightAnchor(resourcesLabel, 0.0);
        AnchorPane.setTopAnchor(resourcesLabel, nameTitleLabel.getPrefHeight() + 15);
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

    private void setupDescriptionLabel() {
        getChildren().add(descriptionLabel);

        descriptionLabel.setVisible(false);
        descriptionLabel.setTranslateY(1);
        descriptionLabel.setPrefWidth(60);
        descriptionLabel.setPrefHeight(60);
        descriptionLabel.setWrapText(true);
        descriptionLabel.setPadding(new Insets(5));
        descriptionLabel.setTextFill(Color.valueOf("#B8D01AFF"));
        descriptionLabel.setAlignment(Pos.CENTER);
        descriptionLabel.setStyle("-fx-background-color: #212020FF; -fx-font-size: 10; -fx-background-radius: 10");

        AnchorPane.setLeftAnchor(descriptionLabel, 10.0);
        AnchorPane.setRightAnchor(descriptionLabel, 10.0);
        AnchorPane.setTopAnchor(descriptionLabel, nameTitleLabel.getPrefHeight() + 30);
    }

    private void descriptionButton() {
        getChildren().add(descriptionButton);

        descriptionButton.setText("I");
        descriptionButton.setTranslateY(1);
        descriptionButton.setMinSize(26, 2);
        descriptionButton.setStyle("-fx-background-color: rgb(184,208,26); -fx-background-radius: 13");
        descriptionButton.setOnAction(event -> toggleDescriptionLabel());

        AnchorPane.setTopAnchor(descriptionButton, 1.0);
        AnchorPane.setRightAnchor(descriptionButton, 10.0);
    }

}
