package com.example.urbanstrategy.modules.game.view;

public interface IGameView {
    void hideBuildingConfigurator();
    void showResourcesListView();
    void updateResourcesTitle(int atIndex, String title);
    void updateProcessingTitle(int atIndex, String title);
    void updateTransportationStatusTitle(int atIndex, String title);
}
