package com.example.urbanstrategy.models.buildings.defaultBuildings;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.resources.specificResources.*;

import java.util.List;
import java.util.Map;

public final class House extends Building {


    public House(ICityBuilding city) {
        super(
                city,
                "house",
                "A building designed for people to live in, providing shelter and comfort.",
                Map.of(
                new Medicaments(), List.of(new ConsumeResourceStrategy()),
                new Electricity(), List.of(new ConsumeResourceStrategy()),
                new Water(), List.of(new ConsumeResourceStrategy()),
                new Food(), List.of(new ConsumeResourceStrategy()),
                new Waste(), List.of(new ProduceResourceStrategy()),
                new Dish(), List.of(new ConsumeResourceStrategy()))
        );
    }



}
