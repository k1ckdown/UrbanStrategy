package com.example.urbanstrategy.modules.buildingEditor.view;

import com.example.urbanstrategy.modules.buildingEditor.presenter.IBuildingEditorPresenter;

public interface IBuildingEditorView {
    void setPresenter(IBuildingEditorPresenter presenter);
    void didEndCreatingBuilding();
    void didEndEditingNameBuilding();
    void didEndSelectingResource();
    void didEndSelectingProcessingMethods();
}
