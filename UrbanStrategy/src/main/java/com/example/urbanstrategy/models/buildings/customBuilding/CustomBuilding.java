package com.example.urbanstrategy.models.buildings.customBuilding;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.models.processingMethods.ResourceProcessingStrategy;
import com.example.urbanstrategy.models.resources.Resource;

import java.util.List;
import java.util.Map;

public final class CustomBuilding extends Building {

    public CustomBuilding(
            ICityBuilding city,
            String name,
            String imagePath,
            String description,
            LogisticMediator logisticMediator,
            Map<Resource, List<ResourceProcessingStrategy>> processingByResource
    ) {
        super(city, name, imagePath, description, logisticMediator, processingByResource);
    }
}
