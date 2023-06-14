package com.example.urbanstrategy.models.buildings.defaultbuildings;


import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.processingmethods.specificmethods.RecycleResourceStrategy;
import com.example.urbanstrategy.models.resources.specificresources.Coal;
import com.example.urbanstrategy.models.resources.specificresources.Waste;

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
