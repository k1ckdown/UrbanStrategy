package com.example.urbanstrategy.views;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public final class TransportStackPane extends StackPane {

    private final Label nameTitleLabel = new Label();
    private final Label statusTitleLabel = new Label();

    public TransportStackPane() {
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
        nameTitleLabel.setPrefWidth(300);
        nameTitleLabel.setStyle("-fx-background-color: #799ad9; -fx-font-family: 'Futura'");
        nameTitleLabel.setTextFill(Color.BLACK);
        nameTitleLabel.setAlignment(Pos.CENTER);

        StackPane.setAlignment(nameTitleLabel, Pos.TOP_CENTER);
    }

    private void setupStatusTitleLabel() {
        getChildren().add(statusTitleLabel);

        statusTitleLabel.setPrefHeight(60);
        statusTitleLabel.setStyle("-fx-background-color: rgba(198,198,203,0.73);");
        statusTitleLabel.setTextFill(Color.BLACK);
        statusTitleLabel.setAlignment(Pos.CENTER);
        statusTitleLabel.setWrapText(true);
        statusTitleLabel.setTextAlignment(TextAlignment.CENTER);
    }

}
