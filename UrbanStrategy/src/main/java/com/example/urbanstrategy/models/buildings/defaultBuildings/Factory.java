package com.example.urbanstrategy.models.buildings.defaultBuildings;


import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.processingMethods.specificMethods.RecycleResourceStrategy;
import com.example.urbanstrategy.models.resources.specificResources.Furniture;
import com.example.urbanstrategy.models.resources.specificResources.Waste;
import com.example.urbanstrategy.models.resources.specificResources.Wood;

import java.util.List;
import java.util.Map;

public final class Factory extends Building {

    public Factory(ICityBuilding city) {
        super(city, "factory", "", Map.of(
                new Wood(), List.of(new ConsumeResourceStrategy()),
                new Waste(), List.of(new ProduceResourceStrategy(), new RecycleResourceStrategy()),
                new Furniture(), List.of(new ProduceResourceStrategy())
        ));
    }

}
