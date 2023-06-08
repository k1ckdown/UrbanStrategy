package com.example.urbanstrategy.models.buildings.defaultBuildings;


import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.processingMethods.specificMethods.TreatmentResourceStrategy;
import com.example.urbanstrategy.models.resources.specificResources.Food;
import com.example.urbanstrategy.models.resources.specificResources.Grain;
import com.example.urbanstrategy.models.resources.specificResources.Water;

import java.util.List;
import java.util.Map;

public final class Farm extends Building {

    public Farm(ICityBuilding city) {
        super(city, "farm", "", "", Map.of(
                new Grain(), List.of(new TreatmentResourceStrategy()),
                new Water(), List.of(new ConsumeResourceStrategy()),
                new Food(), List.of(new ProduceResourceStrategy())
        ));
    }

}
