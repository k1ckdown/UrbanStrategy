package com.example.urbanstrategy.models.buildings.defaultbuildings;


import com.example.urbanstrategy.common.Constants;
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
                Constants.BuildingNames.WATER_TREATMENT_PLANT,
                Constants.BuildingDescriptions.WATER_TREATMENT_PLANT,
                Map.of(
                new Water(), List.of(new ProduceResourceStrategy()),
                new Electricity(), List.of(new ConsumeResourceStrategy()))
        );
    }

}
