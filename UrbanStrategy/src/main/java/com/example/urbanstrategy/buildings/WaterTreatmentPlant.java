package com.example.urbanstrategy.buildings;


import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.processingMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.processingMethods.TreatmentResourceStrategy;
import com.example.urbanstrategy.resources.Electricity;
import com.example.urbanstrategy.resources.Water;

import java.util.List;
import java.util.Map;

public class WaterTreatmentPlant extends Building {

    public WaterTreatmentPlant(ICityBuilding city, LogisticMediator logisticMediator) {
        super(city, "water treatment plant", "", "", logisticMediator, Map.of(
                new Water(10000), List.of(new TreatmentResourceStrategy()),
                new Electricity(500), List.of(new ConsumeResourceStrategy())
        ));
    }

}
