package com.example.urbanstrategy.modules.buildingeditor.presenter;

import java.util.List;

public interface IBuildingEditorPresenter {
    void didSelectResource(int atIndex);
    void didEnterNameBuilding(String name);
    void didSelectProcessingMethods(List<Integer> indexes);
    void didTapOnCreateCustomBuildingButton();
    void didTapOnContinueConfigButton();
    List<String> getResourcesItems();
    List<String> getSupportedProcessingMethodsTitles();
}
