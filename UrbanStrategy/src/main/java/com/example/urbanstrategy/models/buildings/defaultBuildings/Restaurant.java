package com.example.urbanstrategy.models.buildings.defaultBuildings;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.processingMethods.specificMethods.TreatmentResourceStrategy;
import com.example.urbanstrategy.models.resources.specificResources.Dish;
import com.example.urbanstrategy.models.resources.specificResources.Food;
import com.example.urbanstrategy.models.resources.specificResources.Water;

import java.util.List;
import java.util.Map;

public final class Restaurant extends Building {

    public Restaurant(ICityBuilding city) {
        super(city, "restaurant", "", "", Map.of(
                new Food(), List.of(new TreatmentResourceStrategy()),
                new Water(), List.of(new ConsumeResourceStrategy()),
                new Dish(), List.of(new ProduceResourceStrategy())
        ));
    }


}
