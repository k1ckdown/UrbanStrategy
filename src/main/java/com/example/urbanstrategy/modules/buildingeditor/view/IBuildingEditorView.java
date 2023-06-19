package com.example.urbanstrategy.modules.buildingeditor.view;

import com.example.urbanstrategy.modules.buildingeditor.presenter.IBuildingEditorPresenter;

public interface IBuildingEditorView {
    void setPresenter(IBuildingEditorPresenter presenter);
    void didEndCreatingBuilding();
    void didEndEditingNameBuilding();
    void didEndSelectingResource();
    void didEndSelectingProcessingMethods();
}
