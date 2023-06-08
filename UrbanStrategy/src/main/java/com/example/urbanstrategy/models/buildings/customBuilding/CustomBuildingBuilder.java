package com.example.urbanstrategy.models.buildings.customBuilding;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.City;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.factories.BuildingFactory;
import com.example.urbanstrategy.models.factories.ProcessingMethodsFactory;
import com.example.urbanstrategy.models.factories.ResourcesFactory;
import com.example.urbanstrategy.models.processingMethods.ProcessingMethodType;
import com.example.urbanstrategy.models.processingMethods.ResourceProcessingStrategy;
import com.example.urbanstrategy.models.resources.Resource;
import com.example.urbanstrategy.models.resources.ResourceType;

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
        return BuildingFactory.getInstance().makeCustomBuilding(
                city,
                name,
                processingByResource
        );
    }
}
