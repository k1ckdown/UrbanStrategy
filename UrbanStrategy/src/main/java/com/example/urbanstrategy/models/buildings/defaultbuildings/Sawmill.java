package com.example.urbanstrategy.models.buildings.defaultbuildings;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingmethods.specificmethods.DestroyResourceStrategy;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.processingmethods.specificmethods.TreatmentResourceStrategy;
import com.example.urbanstrategy.models.resources.specificresources.Tree;
import com.example.urbanstrategy.models.resources.specificresources.Water;
import com.example.urbanstrategy.models.resources.specificresources.Wood;

import java.util.List;
import java.util.Map;

public final class Sawmill extends Building {

    public Sawmill(ICityBuilding city) {
        super(
                city,
                "sawmill",
                "A facility where logs are processed into lumber and other wood products.",
                Map.of(
                new Tree(), List.of(new DestroyResourceStrategy(), new TreatmentResourceStrategy()),
                new Water(), List.of(new ConsumeResourceStrategy()),
                new Wood(), List.of(new ProduceResourceStrategy()))
        );
    }



}
