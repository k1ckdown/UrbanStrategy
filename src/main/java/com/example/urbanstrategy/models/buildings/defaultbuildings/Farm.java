package com.example.urbanstrategy.models.buildings.defaultbuildings;


import com.example.urbanstrategy.common.Constants;
import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.processingmethods.specificmethods.TreatmentResourceStrategy;
import com.example.urbanstrategy.models.resources.specificresources.Coal;
import com.example.urbanstrategy.models.resources.specificresources.Food;
import com.example.urbanstrategy.models.resources.specificresources.Grain;
import com.example.urbanstrategy.models.resources.specificresources.Water;

import java.util.List;
import java.util.Map;

public final class Farm extends Building {

    public Farm(ICityBuilding city) {
        super(
                city,
                Constants.BuildingNames.FARM,
                Constants.BuildingDescriptions.FARM,
                Map.of(
                new Grain(), List.of(new TreatmentResourceStrategy()),
                new Water(), List.of(new ConsumeResourceStrategy()),
                new Food(), List.of(new ProduceResourceStrategy())
                )
        );
    }

}
