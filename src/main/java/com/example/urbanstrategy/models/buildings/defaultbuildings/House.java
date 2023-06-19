package com.example.urbanstrategy.models.buildings.defaultbuildings;

import com.example.urbanstrategy.common.Constants;
import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.resources.specificresources.*;

import java.util.List;
import java.util.Map;

public final class House extends Building {


    public House(ICityBuilding city) {
        super(
                city,
                Constants.BuildingNames.HOUSE,
                Constants.BuildingDescriptions.HOUSE,
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
