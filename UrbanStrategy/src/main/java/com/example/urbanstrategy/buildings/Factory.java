package com.example.urbanstrategy.buildings;


import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.processingMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.processingMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.processingMethods.RecycleResourceStrategy;
import com.example.urbanstrategy.resources.Furniture;
import com.example.urbanstrategy.resources.Waste;
import com.example.urbanstrategy.resources.Wood;

import java.util.List;
import java.util.Map;

public final class Factory extends Building {

    public Factory(ICityBuilding city, LogisticMediator logisticMediator) {
        super(city, "factory", "", "", logisticMediator, Map.of(
                new Wood(), List.of(new ConsumeResourceStrategy()),
                new Waste(), List.of(new ProduceResourceStrategy(), new RecycleResourceStrategy()),
                new Furniture(), List.of(new ProduceResourceStrategy())
        ));
    }

}
