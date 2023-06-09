package com.example.urbanstrategy.modules.game.view;

public interface IGameView {
    void hideBuildingConfigurator();
    void showMethodsListView();
    void didEndEditingNameBuilding();
    void didEndSelectingProcessingMethods();
    void addCustomBuildingCell(String title, int row, int col);
    void updateResourcesTitle(int atIndex, String title);
    void updateProcessingTitle(int atIndex, String title);
    void updateTransportationStatusTitle(int atIndex, String title);
}
