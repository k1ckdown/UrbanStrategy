package com.example.urbanstrategy.buildings;


import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.processingMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.processingMethods.RecycleResourceStrategy;
import com.example.urbanstrategy.resources.Coal;
import com.example.urbanstrategy.resources.Waste;

import java.util.List;
import java.util.Map;

public class Mine extends Building {

    public Mine(ICityBuilding city, LogisticMediator logisticMediator) {
        super(city, "mine", "", "", logisticMediator, Map.of(
                new Coal(), List.of(new ProduceResourceStrategy()),
                new Waste(), List.of(new RecycleResourceStrategy())
        ));
    }

}
