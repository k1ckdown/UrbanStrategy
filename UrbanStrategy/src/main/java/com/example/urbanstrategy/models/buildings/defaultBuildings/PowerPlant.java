package com.example.urbanstrategy.models.buildings.defaultBuildings;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.resources.specificResources.Coal;
import com.example.urbanstrategy.models.resources.specificResources.Electricity;

import java.util.List;
import java.util.Map;

public final class PowerPlant extends Building {

    public PowerPlant(ICityBuilding city) {
        super(
                city,
                "power plant",
                "A facility that generates electricity for homes, businesses, and other buildings.",
                Map.of(
                new Electricity(), List.of(new ProduceResourceStrategy()),
                new Coal(), List.of(new ConsumeResourceStrategy()))
        );
    }

}
