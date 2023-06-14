package com.example.urbanstrategy.modules.urbandetails.presenter;

import javafx.scene.image.Image;

public interface IUrbanDetailsPresenter {
    void didTapOnAddBuildingButton();
    int getNumberOfRows();
    int getNumberOfColumns();
    int getNumberOfTransports();
    String getBuildingHeader(int row, int col);
    String getTransportHeader(int atIndex);
    String getBuildingDesc(int row, int col);
    Image getTransportImage(int atIndex);
    Image getBuildingImage(int row, int col);
}
