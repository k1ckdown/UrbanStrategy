package com.example.urbanstrategy.models.buildings.defaultBuildings;


import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.resources.specificResources.Electricity;
import com.example.urbanstrategy.models.resources.specificResources.Water;

import java.util.List;
import java.util.Map;

public final class WaterTreatmentPlant extends Building {

    public WaterTreatmentPlant(ICityBuilding city) {
        super(
                city,
                "water treatment plant",
                "A facility that cleans and purifies water for consumption and other uses.",
                Map.of(
                new Water(), List.of(new ProduceResourceStrategy()),
                new Electricity(), List.of(new ConsumeResourceStrategy()))
        );
    }

}
