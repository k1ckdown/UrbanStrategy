package com.example.urbanstrategy.buildings.customBuilding;

import com.example.urbanstrategy.buildings.Building;
import com.example.urbanstrategy.city.City;
import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.factories.BuildingFactory;
import com.example.urbanstrategy.factories.ProcessingMethodsFactory;
import com.example.urbanstrategy.factories.ResourcesFactory;
import com.example.urbanstrategy.processingMethods.ProcessingMethodType;
import com.example.urbanstrategy.processingMethods.ResourceProcessingStrategy;
import com.example.urbanstrategy.resources.Resource;
import com.example.urbanstrategy.resources.ResourceType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CustomBuildingBuilder {

    private String name;
    private Resource currentResource;
    private final ICityBuilding city;
    private final Map<Resource, List<ResourceProcessingStrategy>> processingByResource;

    public CustomBuildingBuilder(City city) {
        this.city = city;
        processingByResource = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProcessingMethodType> getSupportedProcessingMethods() {
        return currentResource.supportedMethods;
    }

    public void addResource(ResourceType type) {
        currentResource = ResourcesFactory.getInstance().makeResource(type);
        processingByResource.put(currentResource, List.of());
    }

    public void addResourceProcessingMethod(ProcessingMethodType type) {
        processingByResource
                .get(currentResource)
                .add(ProcessingMethodsFactory.getInstance().makeMethod(type));
    }

    public Building getAssembledBuilding() {
        return BuildingFactory.getInstance().makeCustomBuilding(city, name, processingByResource);
    }
}
