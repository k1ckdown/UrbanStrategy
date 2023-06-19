package com.example.urbanstrategy.models.buildings.defaultbuildings;

import com.example.urbanstrategy.common.Constants;
import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.resources.specificresources.Coal;
import com.example.urbanstrategy.models.resources.specificresources.Electricity;

import java.util.List;
import java.util.Map;

public final class PowerPlant extends Building {

    public PowerPlant(ICityBuilding city) {
        super(
                city,
                Constants.BuildingNames.POWER_PLANT,
                Constants.BuildingDescriptions.POWER_PLANT,
                Map.of(
                new Electricity(), List.of(new ProduceResourceStrategy()),
                new Coal(), List.of(new ConsumeResourceStrategy()))
        );
    }

}
