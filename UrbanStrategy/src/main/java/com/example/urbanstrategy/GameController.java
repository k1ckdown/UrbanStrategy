package com.example.urbanstrategy;

import com.example.urbanstrategy.UI.GameAnchorPane;
import com.example.urbanstrategy.buildings.BuildingType;
import com.example.urbanstrategy.buildings.customBuilding.CustomBuildingBuilder;
import com.example.urbanstrategy.city.City;
import com.example.urbanstrategy.city.interfaces.ICityController;
import com.example.urbanstrategy.processingMethods.ProcessingMethodType;
import com.example.urbanstrategy.resources.ResourceType;
import com.example.urbanstrategy.transports.TransportType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class GameController {

    private final ICityController cityController;
    private final CustomBuildingBuilder customBuildingBuilder;

    private final GameAnchorPane view;
    private final int numberOfRows = 2;

    private final ResourceType[] resourceTypes = ResourceType.values();
    private final BuildingType[] buildingTypes = BuildingType.values();
    private final TransportType[] transportTypes = TransportType.values();
    private final ProcessingMethodType[] processingMethodTypes = ProcessingMethodType.values();

    public GameController(GameAnchorPane view) {
        final City city = new City();
        cityController = city;
        customBuildingBuilder = new CustomBuildingBuilder(city);
        this.view = view;
    }

    public void play() {
        cityController.startSimulate();
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return buildingTypes.length / numberOfRows;
    }

    public void didTapOnResourceButton(int atIndex) {
        customBuildingBuilder.addResource(resourceTypes[atIndex]);
    }

    public void didTapOnProcessingMethod(int atIndex) {
        customBuildingBuilder.addResourceProcessingMethod(processingMethodTypes[atIndex]);
    }

    public void didTapOnAddNameBuildingButton(String name) {
        customBuildingBuilder.setName(name);
    }

    public void didTapOnCreateCustomBuildingButton() {
        cityController.addBuilding(customBuildingBuilder.getAssembledBuilding());
    }

    public String getBuildingTitle(int row, int col) {
        return buildingTypes[row * numberOfRows + col].name();
    }

    public List<String> getTransportTitles() {
        final List<String> titles = new ArrayList<>();

        for (TransportType type : transportTypes) {
            titles.add(type.name());
        }

        return titles;
    }

    public List<String> getSupportedProcessingMethodsTitles() {
        return customBuildingBuilder.getSupportedProcessingMethods()
                .stream()
                .map(Enum::name)
                .collect(Collectors.toList());
    }

}
