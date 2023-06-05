package com.example.urbanstrategy;

import com.example.urbanstrategy.UI.TransportAnchorPane;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class HelloController {

    private GameController gameController;

    public HelloController() {
//        gameController = new GameController(new HelloController());
    }

    @FXML
    private Label welcomeText;
    private HBox transportsBox;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void initialize() {
        setupTransportBox();
    }

    private void setupTransportBox() {

        for (String transportTitle : gameController.getTransportTitles()) {

            final TransportAnchorPane transportAnchorPane = new TransportAnchorPane();
            transportAnchorPane.setNameTitle(transportTitle);
            transportsBox.getChildren().add(transportAnchorPane);
        }
    }

    public void updateTransportStateTitle(int index, String title) {
        final Node transportView = transportsBox.getChildren().get(index);

        if (transportView instanceof TransportAnchorPane) {
            ((TransportAnchorPane) transportView).setStatusTitle(title);
        }
    }
}