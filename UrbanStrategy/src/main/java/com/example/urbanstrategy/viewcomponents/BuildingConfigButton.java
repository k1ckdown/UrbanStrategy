package com.example.urbanstrategy.viewcomponents;

import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public final class BuildingConfigButton extends Button {

    public BuildingConfigButton() {
        setup();
    }

    private void setup() {
        setPrefHeight(70);
        setPrefWidth(230);
        setTextFill(Color.BLACK);
        setFont(Font.font("SF Mono", FontWeight.BOLD, 20));
        setCursor(Cursor.HAND);
        setStyle("-fx-background-radius: 20; -fx-background-color: #b8d01a");
    }
}
