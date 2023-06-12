package com.example.urbanstrategy.models.buildings.defaultbuildings;


import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingmethods.specificMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingmethods.specificMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.processingmethods.specificMethods.RecycleResourceStrategy;
import com.example.urbanstrategy.models.resources.specificresources.Furniture;
import com.example.urbanstrategy.models.resources.specificresources.Waste;
import com.example.urbanstrategy.models.resources.specificresources.Wood;

import java.util.List;
import java.util.Map;

public final class Factory extends Building {

    public Factory(ICityBuilding city) {
        super(
                city,
                "factory",
                "A large industrial building where goods are manufactured on a large scale using machinery and assembly lines.",
                Map.of(
                new Wood(), List.of(new ConsumeResourceStrategy()),
                new Waste(), List.of(new ProduceResourceStrategy(), new RecycleResourceStrategy()),
                new Furniture(), List.of(new ProduceResourceStrategy()))
        );
    }

}
