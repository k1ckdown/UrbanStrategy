package com.example.urbanstrategy.models.buildings.custombuilding;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.factories.BuildingFactory;
import com.example.urbanstrategy.models.factories.ProcessingMethodsFactory;
import com.example.urbanstrategy.models.factories.ResourcesFactory;
import com.example.urbanstrategy.models.processingmethods.ProcessingMethodType;
import com.example.urbanstrategy.models.processingmethods.ResourceProcessingStrategy;
import com.example.urbanstrategy.models.resources.Resource;
import com.example.urbanstrategy.models.resources.ResourceType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CustomBuildingBuilder {

    private String name;
    private Resource currentResource;
    private final ICityBuilding city;
    private final Map<Resource, List<ResourceProcessingStrategy>> processingByResource;

    public CustomBuildingBuilder(ICityBuilding city) {
        this.city = city;
        processingByResource = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addResource(ResourceType type) {
        currentResource = ResourcesFactory.getInstance().makeResource(type);
        processingByResource.put(currentResource, new ArrayList<>());
    }

    public void addResourceProcessingMethod(List<ProcessingMethodType> types) {
        types.forEach(type -> {
            processingByResource
                    .get(currentResource)
                    .add(ProcessingMethodsFactory.getInstance().makeMethod(type));
        });
    }

    public List<ProcessingMethodType> getSupportedProcessingMethods() {
        return currentResource.supportedMethods;
    }

    public Building getAssembledBuilding() {
        final Building assembledBuilding = BuildingFactory.getInstance().makeCustomBuilding(
                city,
                name,
                new HashMap<>(processingByResource)
        );

        processingByResource.clear();
        return assembledBuilding;
    }
}
