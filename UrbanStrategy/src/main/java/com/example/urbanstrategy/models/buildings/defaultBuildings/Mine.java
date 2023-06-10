package com.example.urbanstrategy.models.buildings.defaultBuildings;


import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.processingMethods.specificMethods.RecycleResourceStrategy;
import com.example.urbanstrategy.models.resources.specificResources.Coal;
import com.example.urbanstrategy.models.resources.specificResources.Waste;

import java.util.List;
import java.util.Map;

public final class Mine extends Building {

    public Mine(ICityBuilding city) {
        super(
                city,
                "mine",
                "A place where valuable minerals and ores are extracted from the earth.",
                Map.of(
                new Coal(), List.of(new ProduceResourceStrategy()),
                new Waste(), List.of(new RecycleResourceStrategy())
                )
        );
    }

}
