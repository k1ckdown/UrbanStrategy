package com.example.urbanstrategy.views;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public final class TransportAnchorPane extends AnchorPane {

    private final Label nameTitleLabel = new Label();
    private final Label statusTitleLabel = new Label();

    public TransportAnchorPane() {
        setup();
    }

    public void setNameTitle(String title) {
        nameTitleLabel.setText(title);
    }

    public void setStatusTitle(String title) {
        statusTitleLabel.setText(title);
    }

    private void setup() {
        setupNameTitleLabel();
        setupStatusTitleLabel();
    }

    private void setupNameTitleLabel() {
        getChildren().add(nameTitleLabel);

        nameTitleLabel.setPrefHeight(40);
        nameTitleLabel.setStyle("-fx-background-color: #799ad9; -fx-font-family: 'Futura'");
        nameTitleLabel.setTextFill(Color.BLACK);
        nameTitleLabel.setAlignment(Pos.CENTER);

        AnchorPane.setTopAnchor(nameTitleLabel, 0.0);
        AnchorPane.setLeftAnchor(nameTitleLabel, 0.0);
        AnchorPane.setRightAnchor(nameTitleLabel, 0.0);
    }

    private void setupStatusTitleLabel() {
        getChildren().add(statusTitleLabel);

        statusTitleLabel.setPrefHeight(180);
        statusTitleLabel.setStyle("-fx-background-color: #d1d3d1;");
        statusTitleLabel.setTextFill(Color.BLACK);
        statusTitleLabel.setAlignment(Pos.CENTER);
        statusTitleLabel.setWrapText(true);
        statusTitleLabel.setTextAlignment(TextAlignment.CENTER);

        AnchorPane.setTopAnchor(statusTitleLabel, nameTitleLabel.getPrefHeight());
        AnchorPane.setLeftAnchor(statusTitleLabel, 0.0);
        AnchorPane.setRightAnchor(statusTitleLabel, 0.0);
    }

}
