package com.example.urbanstrategy.modules.game.presenter;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.utils.ImageProvider;
import com.example.urbanstrategy.models.buildings.BuildingType;
import com.example.urbanstrategy.models.buildings.customBuilding.CustomBuildingBuilder;
import com.example.urbanstrategy.models.city.City;
import com.example.urbanstrategy.models.city.interfaces.ICityController;
import com.example.urbanstrategy.models.processingMethods.ProcessingMethodType;
import com.example.urbanstrategy.models.resources.ResourceType;
import com.example.urbanstrategy.models.transports.TransportType;
import com.example.urbanstrategy.modules.game.view.IGameView;
import javafx.application.Platform;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class GamePresenter implements IGamePresenter {

    private final IGameView view;

    private final int numberOfRows;
    private int numberOfColumns;
    private int buildingConfigStage;
    private int numberOfCustomBuilding;

    private final ResourceType[] resourceTypes;
    private final BuildingType[] buildingTypes;
    private final TransportType[] transportTypes;
    private final ProcessingMethodType[] processingMethodTypes;

    private final ICityController cityController;
    private final CustomBuildingBuilder customBuildingBuilder;

    public GamePresenter(IGameView view) {
        this.view = view;

        final City city = new City();
        cityController = city;
        customBuildingBuilder = new CustomBuildingBuilder(city);

        resourceTypes = ResourceType.values();
        buildingTypes = BuildingType.values();
        transportTypes = TransportType.values();
        processingMethodTypes = ProcessingMethodType.values();

        numberOfRows = 2;
        buildingConfigStage = 0;
        numberOfCustomBuilding = 0;
        numberOfColumns = buildingTypes.length / numberOfRows;
    }

    public void play() {
        cityController.startSimulate();

        Thread playThread = new Thread(() -> {
            while (true) {

                try {
                    final List<String> resourceTitles = getAllResourceTitles();
                    final List<String> processingTitles = getAllProcessingTitles();
                    final List<String> transportStatusTitles = getAllTransportStatusTitles();

                    Platform.runLater(() -> {
                        for (int i = 0; i < resourceTitles.size(); i++) {
                            view.updateResourcesTitle(i, resourceTitles.get(i));
                            view.updateProcessingTitle(i, processingTitles.get(i));
                        }

                        for (int i = 0; i < transportStatusTitles.size(); i++) {
                            view.updateTransportationStatusTitle(i, transportStatusTitles.get(i));
                        }
                    });

                    Thread.sleep(1000);
                } catch (Exception error) {
                    throw new RuntimeException(error);
                }

            }
        });

        playThread.start();
    }

    public void didEnterNameBuilding(String name) {
        customBuildingBuilder.setName(name);
    }

    public void didSelectResource(int atIndex) {
        customBuildingBuilder.addResource(resourceTypes[atIndex]);
    }

    public void didSelectProcessingMethods(List<Integer> indexes) {
        List<ProcessingMethodType> selectedMethodTypes = new ArrayList<>();
        for (Integer index : indexes) {
            selectedMethodTypes.add(processingMethodTypes[index]);
        }

        customBuildingBuilder.addResourceProcessingMethod(selectedMethodTypes);
    }

    public void didTapOnContinueConfigButton() {
        if (buildingConfigStage == 0) {
            view.didEndEditingNameBuilding();
            buildingConfigStage += 1;
        } else if (buildingConfigStage == 1) {
            view.showMethodsListView();
            buildingConfigStage += 1;
        } else  {
            view.didEndSelectingProcessingMethods();
            buildingConfigStage = 1;
        }
    }

    public void didTapOnCreateCustomBuildingButton() {
        final Building customBuilding = customBuildingBuilder.getAssembledBuilding();
        cityController.addBuilding(customBuilding);

        buildingConfigStage = 0;
        numberOfCustomBuilding += 1;
        final int row = (numberOfCustomBuilding - 1) % numberOfRows;

        view.hideBuildingConfigurator();
        view.addCustomBuildingCell(customBuilding.getName(), row, numberOfColumns);

        if (row == numberOfRows - 1) {
            numberOfColumns += 1;
        }
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public Image getBuildingImage(int row, int col) {
        return ImageProvider.getInstance().getDefaultBuildingImage(getBuildingType(row, col));
    }

    public String getBuildingHeader(int row, int col) {
        return getBuildingType(row, col).name();
    }

    public Image getTransportImage(int atIndex) {
        return ImageProvider.getInstance().getTransportImage(transportTypes[atIndex]);
    }

    public List<String> getTransportHeaders() {
        return Arrays.stream(transportTypes)
                .map(Enum::name)
                .collect(Collectors.toList());
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

    private BuildingType getBuildingType(int row, int col) {
        return buildingTypes[row * numberOfColumns + col];
    }

    private List<String> getAllProcessingTitles() {
        return cityController.getResourceProcessingStatuses();
    }

    private List<String> getAllTransportStatusTitles() {
        return cityController.getTransportStatuses();
    }

    private List<String> getAllResourceTitles() {
        return cityController.getDescriptionsResourcesOfBuildings();
    }

}
