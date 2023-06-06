package com.example.urbanstrategy.models.buildings.defaultBuildings;


import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.resources.specificResources.Electricity;
import com.example.urbanstrategy.models.resources.specificResources.Water;

import java.util.List;
import java.util.Map;

public final class WaterTreatmentPlant extends Building {

    public WaterTreatmentPlant(ICityBuilding city, LogisticMediator logisticMediator) {
        super(city, "water treatment plant", "", "", logisticMediator, Map.of(
                new Water(), List.of(new ProduceResourceStrategy()),
                new Electricity(), List.of(new ConsumeResourceStrategy())
        ));
    }

}
