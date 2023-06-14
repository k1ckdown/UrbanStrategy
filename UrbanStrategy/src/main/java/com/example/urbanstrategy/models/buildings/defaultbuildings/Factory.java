package com.example.urbanstrategy.models.buildings.defaultbuildings;


import com.example.urbanstrategy.common.Constants;
import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.processingmethods.specificmethods.RecycleResourceStrategy;
import com.example.urbanstrategy.models.resources.specificresources.Furniture;
import com.example.urbanstrategy.models.resources.specificresources.Waste;
import com.example.urbanstrategy.models.resources.specificresources.Wood;

import java.util.List;
import java.util.Map;

public final class Factory extends Building {

    public Factory(ICityBuilding city) {
        super(
                city,
                Constants.BuildingNames.FACTORY,
                Constants.BuildingDescriptions.FACTORY,
                Map.of(
                new Wood(), List.of(new ConsumeResourceStrategy()),
                new Waste(), List.of(new ProduceResourceStrategy(), new RecycleResourceStrategy()),
                new Furniture(), List.of(new ProduceResourceStrategy()))
        );
    }

}
