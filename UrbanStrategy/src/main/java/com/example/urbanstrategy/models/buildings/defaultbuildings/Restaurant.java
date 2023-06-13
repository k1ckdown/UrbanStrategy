package com.example.urbanstrategy.models.buildings.defaultbuildings;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.processingmethods.specificmethods.TreatmentResourceStrategy;
import com.example.urbanstrategy.models.resources.specificresources.Dish;
import com.example.urbanstrategy.models.resources.specificresources.Food;
import com.example.urbanstrategy.models.resources.specificresources.Water;

import java.util.List;
import java.util.Map;

public final class Restaurant extends Building {

    public Restaurant(ICityBuilding city) {
        super(
                city,
                "restaurant",
                "A place where food and drinks are served to customers, often with a specific cuisine or theme.",
                Map.of(
                new Food(), List.of(new TreatmentResourceStrategy()),
                new Water(), List.of(new ConsumeResourceStrategy()),
                new Dish(), List.of(new ProduceResourceStrategy()))
        );
    }


}
