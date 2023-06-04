package com.example.urbanstrategy.buildings.customBuilding;

import com.example.urbanstrategy.buildings.Building;
import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.processingMethods.ResourceProcessingStrategy;
import com.example.urbanstrategy.resources.Resource;

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
