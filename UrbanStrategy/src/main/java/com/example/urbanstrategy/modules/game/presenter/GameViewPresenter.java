package com.example.urbanstrategy.modules.game.presenter;

import java.util.List;

public interface GameViewPresenter {
    int getNumberOfRows();
    int getNumberOfColumns();
    List<String> getTransportTitles();
    String getBuildingTitle(int row, int col);
}
