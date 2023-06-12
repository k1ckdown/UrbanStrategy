package com.example.urbanstrategy.modules.urbanDetails.view;

import com.example.urbanstrategy.modules.buildingEditor.view.BuildingEditorView;
import com.example.urbanstrategy.modules.urbanDetails.presenter.IUrbanDetailsPresenter;

public interface IUrbanDetailsView {
    void setPresenter(IUrbanDetailsPresenter presenter);
    void showBuildingEditor(BuildingEditorView view);
    void addCustomBuildingCell(String nameTitle, String descTitle, int row, int col);
    void updateResourcesTitle(int atIndex, String title);
    void updateProcessingTitle(int atIndex, String title);
    void updateTransportationStatusTitle(int atIndex, String title);
}
