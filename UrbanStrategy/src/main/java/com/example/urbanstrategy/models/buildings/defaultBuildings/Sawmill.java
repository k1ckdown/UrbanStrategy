package com.example.urbanstrategy.models.buildings.defaultBuildings;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingMethods.specificMethods.DestroyResourceStrategy;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.processingMethods.specificMethods.TreatmentResourceStrategy;
import com.example.urbanstrategy.models.resources.specificResources.Tree;
import com.example.urbanstrategy.models.resources.specificResources.Water;
import com.example.urbanstrategy.models.resources.specificResources.Wood;

import java.util.List;
import java.util.Map;

public final class Sawmill extends Building {

    public Sawmill(ICityBuilding city) {
        super(city, "sawmill", "", "", Map.of(
                new Tree(), List.of(new DestroyResourceStrategy(), new TreatmentResourceStrategy()),
                new Water(), List.of(new ConsumeResourceStrategy()),
                new Wood(), List.of(new ProduceResourceStrategy())
        ));
    }



}
