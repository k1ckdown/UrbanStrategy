package com.example.urbanstrategy.modules.buildingEditor.presenter;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.buildings.customBuilding.CustomBuildingBuilder;
import com.example.urbanstrategy.models.processingMethods.ProcessingMethodType;
import com.example.urbanstrategy.models.resources.ResourceType;
import com.example.urbanstrategy.modules.buildingEditor.view.IBuildingEditorView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class BuildingEditorPresenter implements IBuildingEditorPresenter {

    public BuildingEditorPresenterDelegate delegate;
    private final IBuildingEditorView view;

    private int buildingConfigStage = 0;
    private final CustomBuildingBuilder customBuildingBuilder;
    private final ProcessingMethodType[] processingMethodTypes = ProcessingMethodType.values();
    private final ResourceType[] resourceTypes = ResourceType.values();

    public BuildingEditorPresenter(
            IBuildingEditorView view,
            CustomBuildingBuilder customBuildingBuilder
    ) {
        this.customBuildingBuilder = customBuildingBuilder;
        this.view = view;
        view.setPresenter(this);
    }

    public void didSelectResource(int atIndex) {
        customBuildingBuilder.addResource(resourceTypes[atIndex]);
    }

    public void didEnterNameBuilding(String name) {
        customBuildingBuilder.setName(name);
    }

    public void didSelectProcessingMethods(List<Integer> indexes) {
        List<ProcessingMethodType> selectedMethodTypes = new ArrayList<>();
        for (Integer index : indexes) {
            selectedMethodTypes.add(processingMethodTypes[index]);
        }

        customBuildingBuilder.addResourceProcessingMethod(selectedMethodTypes);
    }

    public void didTapOnCreateCustomBuildingButton() {
        buildingConfigStage = 0;
        view.didEndCreatingBuilding();

        if (delegate != null) {
            final Building customBuilding = customBuildingBuilder.getAssembledBuilding();
            delegate.addCustomBuilding(customBuilding);
        }
    }

    public void didTapOnContinueConfigButton() {
        if (buildingConfigStage == 0) {
            view.didEndEditingNameBuilding();
            buildingConfigStage += 1;
        } else if (buildingConfigStage == 1) {
            view.didEndSelectingResource();
            buildingConfigStage += 1;
        } else {
            view.didEndSelectingProcessingMethods();
            buildingConfigStage = 1;
        }
    }

    public List<String> getResourcesItems() {
        return Arrays.stream(resourceTypes)
                .map(resourceType -> resourceType.name().replace("_", " "))
                .collect(Collectors.toList());
    }

    public List<String> getSupportedProcessingMethodsTitles() {
        return customBuildingBuilder.getSupportedProcessingMethods().stream()
                .map(Enum::name)
                .collect(Collectors.toList());
    }

}
