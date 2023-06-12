package com.example.urbanstrategy.models.buildings.custombuilding;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingmethods.ResourceProcessingStrategy;
import com.example.urbanstrategy.models.resources.Resource;

import java.util.List;
import java.util.Map;

public final class CustomBuilding extends Building {

    public CustomBuilding(
            ICityBuilding city,
            String name,
            String description,
            Map<Resource, List<ResourceProcessingStrategy>> processingByResource
    ) {
        super(city, name, description, processingByResource);
    }
}
