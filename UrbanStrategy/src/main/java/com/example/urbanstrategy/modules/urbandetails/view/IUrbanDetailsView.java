package com.example.urbanstrategy.modules.urbandetails.view;

import com.example.urbanstrategy.modules.buildingeditor.view.BuildingEditorView;
import com.example.urbanstrategy.modules.urbandetails.presenter.IUrbanDetailsPresenter;

public interface IUrbanDetailsView {
    void setPresenter(IUrbanDetailsPresenter presenter);
    void showBuildingEditor(BuildingEditorView view);
    void addCustomBuildingCell(String nameTitle, String descTitle, int row, int col);
    void updateResourcesTitle(int atIndex, String title);
    void updateProcessingTitle(int atIndex, String title);
    void updateTransportationStatusTitle(int atIndex, String title);
}
