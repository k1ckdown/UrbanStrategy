package com.example.urbanstrategy.modules.game.presenter;

import javafx.scene.image.Image;

import java.util.List;

public interface IGamePresenter {
    void didTapOnContinueConfigButton();
    void didEnterNameBuilding(String name);
    void didSelectResource(int atIndex);
    void didSelectProcessingMethods(List<Integer> indexes);
    void didTapOnCreateCustomBuildingButton();
    int getNumberOfRows();
    int getNumberOfColumns();
    List<String> getResourcesItems();
    List<String> getTransportHeaders();
    List<String> getSupportedProcessingMethodsTitles();
    String getBuildingHeader(int row, int col);
    String getBuildingDesc(int row, int col);
    Image getTransportImage(int atIndex);
    Image getBuildingImage(int row, int col);
}
