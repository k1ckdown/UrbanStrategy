package com.example.urbanstrategy.models.buildings.defaultbuildings;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.resources.specificresources.Electricity;
import com.example.urbanstrategy.models.resources.specificresources.Furniture;

import java.util.List;
import java.util.Map;

public final class Mall extends Building {

    public Mall(ICityBuilding city) {
        super(
                city,
                "mall",
                "A large building with many stores and businesses, offering a variety of goods and services.",
                Map.of(
                new Furniture(), List.of(new ConsumeResourceStrategy()),
                new Electricity(), List.of(new ConsumeResourceStrategy())
                )
        );
    }

}
