package com.example.urbanstrategy.models.buildings.defaultbuildings;


import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.resources.specificresources.Electricity;
import com.example.urbanstrategy.models.resources.specificresources.Water;

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
