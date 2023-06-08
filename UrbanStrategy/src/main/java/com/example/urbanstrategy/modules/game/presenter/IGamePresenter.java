package com.example.urbanstrategy.modules.game.presenter;

import javafx.scene.image.Image;

import java.util.List;

public interface IGamePresenter {
    int getNumberOfRows();
    int getNumberOfColumns();
    List<String> getTransportHeaders();
    String getBuildingHeader(int row, int col);
    Image getTransportImage(int atIndex);
    Image getBuildingImage(int row, int col);
}
