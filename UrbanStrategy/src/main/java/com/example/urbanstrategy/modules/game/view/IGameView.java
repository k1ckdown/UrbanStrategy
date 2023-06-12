package com.example.urbanstrategy.modules.game.view;

public interface IGameView {
    void didEndCreatingBuilding();
    void didEndSelectingResource();
    void didEndEditingNameBuilding();
    void didEndSelectingProcessingMethods();
    void addCustomBuildingCell(String nameTitle, String descTitle, int row, int col);
    void updateResourcesTitle(int atIndex, String title);
    void updateProcessingTitle(int atIndex, String title);
    void updateTransportationStatusTitle(int atIndex, String title);
}
