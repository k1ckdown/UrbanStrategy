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
        setupSuperView();
        setupNameTitleLabel();
        setupStatusTitleLabel();
    }

    private void setupSuperView() {
        setMaxWidth(200);
        setStyle("-fx-border-width: 2; -fx-border-color: rgba(132,132,208,0.84)");

    }

    private void setupNameTitleLabel() {
        getChildren().add(nameTitleLabel);

        nameTitleLabel.setPrefHeight(40);
        nameTitleLabel.setPrefWidth(200);
        nameTitleLabel.setTextFill(Color.BLACK);
        nameTitleLabel.setAlignment(Pos.CENTER);
        nameTitleLabel.setStyle("-fx-background-color: #799ad9; -fx-font-family: 'Futura'; -fx-font-size: 16");

        StackPane.setAlignment(nameTitleLabel, Pos.TOP_CENTER);
    }

    private void setupStatusTitleLabel() {
        getChildren().add(statusTitleLabel);

        statusTitleLabel.setPrefHeight(60);
        nameTitleLabel.setPrefWidth(200);
        statusTitleLabel.setStyle("-fx-background-color: rgba(198,198,203,0.73);");
        statusTitleLabel.setTextFill(Color.BLACK);
        statusTitleLabel.setAlignment(Pos.CENTER);
        statusTitleLabel.setWrapText(true);
        statusTitleLabel.setTextAlignment(TextAlignment.CENTER);
    }

}
