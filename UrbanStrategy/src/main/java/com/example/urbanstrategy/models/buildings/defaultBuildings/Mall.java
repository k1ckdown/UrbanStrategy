package com.example.urbanstrategy.models.buildings.defaultBuildings;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.resources.specificResources.Electricity;
import com.example.urbanstrategy.models.resources.specificResources.Furniture;

import java.util.List;
import java.util.Map;

public final class Mall extends Building {

    public Mall(ICityBuilding city) {
        super(city, "mall", "", Map.of(
                new Furniture(), List.of(new ConsumeResourceStrategy()),
                new Electricity(), List.of(new ConsumeResourceStrategy())
        ));
    }

}
