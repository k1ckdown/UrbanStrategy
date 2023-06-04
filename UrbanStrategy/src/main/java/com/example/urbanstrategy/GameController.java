package com.example.urbanstrategy;

import com.example.urbanstrategy.buildings.customBuilding.CustomBuildingBuilder;
import com.example.urbanstrategy.city.City;
import com.example.urbanstrategy.city.interfaces.ICityController;
import com.example.urbanstrategy.processingMethods.ProcessingMethodType;
import com.example.urbanstrategy.resources.ResourceType;

public final class GameController {

    private final ICityController cityController;
    private final CustomBuildingBuilder customBuildingBuilder;

    private final ResourceType[] resourceTypes = ResourceType.values();
    private final ProcessingMethodType[] processingMethodTypes = ProcessingMethodType.values();

    public GameController() {
        final City city = new City();
        cityController = city;
        customBuildingBuilder = new CustomBuildingBuilder(city);
    }

    public void play() {
        cityController.startSimulate();
    }

    public void didAddNameBuilding(String name) {
        customBuildingBuilder.setName(name);
    }

    public void didAddResource(int atIndex) {
        customBuildingBuilder.addResource(resourceTypes[atIndex]);
    }

    public void didAddProcessingMethod(int atIndex) {
        customBuildingBuilder.addResourceProcessingMethod(processingMethodTypes[atIndex]);
    }

    public void didCreateCustomBuilding() {
        cityController.addBuilding(customBuildingBuilder.getAssembledBuilding());
    }

}
