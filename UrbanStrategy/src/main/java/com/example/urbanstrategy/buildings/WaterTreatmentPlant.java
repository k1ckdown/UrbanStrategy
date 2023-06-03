package com.example.urbanstrategy.buildings;


import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.processingMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.processingMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.resources.Electricity;
import com.example.urbanstrategy.resources.Water;

import java.util.List;
import java.util.Map;

public class WaterTreatmentPlant extends Building {

    public WaterTreatmentPlant(ICityBuilding city, LogisticMediator logisticMediator) {
        super(city, "water treatment plant", "", "", logisticMediator, Map.of(
                new Water(), List.of(new ProduceResourceStrategy()),
                new Electricity(), List.of(new ConsumeResourceStrategy())
        ));
    }

}
