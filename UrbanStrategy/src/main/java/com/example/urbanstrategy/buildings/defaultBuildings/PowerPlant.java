package com.example.urbanstrategy.buildings.defaultBuildings;

import com.example.urbanstrategy.buildings.Building;
import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.processingMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.processingMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.resources.Coal;
import com.example.urbanstrategy.resources.Electricity;

import java.util.List;
import java.util.Map;

public final class PowerPlant extends Building {

    public PowerPlant(ICityBuilding city, LogisticMediator logisticMediator) {
        super(city, "power plant", "", "", logisticMediator, Map.of(
                new Electricity(), List.of(new ProduceResourceStrategy()),
                new Coal(), List.of(new ConsumeResourceStrategy())
        ));
    }

}
