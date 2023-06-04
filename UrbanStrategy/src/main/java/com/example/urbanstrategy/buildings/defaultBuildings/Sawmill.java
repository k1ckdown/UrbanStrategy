package com.example.urbanstrategy.buildings.defaultBuildings;

import com.example.urbanstrategy.buildings.Building;
import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.processingMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.processingMethods.DestroyResourceStrategy;
import com.example.urbanstrategy.processingMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.processingMethods.TreatmentResourceStrategy;
import com.example.urbanstrategy.resources.Tree;
import com.example.urbanstrategy.resources.Water;
import com.example.urbanstrategy.resources.Wood;

import java.util.List;
import java.util.Map;

public final class Sawmill extends Building {

    public Sawmill(ICityBuilding city, LogisticMediator logisticMediator) {
        super(city, "sawmill", "", "", logisticMediator, Map.of(
                new Tree(), List.of(new DestroyResourceStrategy(), new TreatmentResourceStrategy()),
                new Water(), List.of(new ConsumeResourceStrategy()),
                new Wood(), List.of(new ProduceResourceStrategy())
        ));
    }



}
