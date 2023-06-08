package com.example.urbanstrategy.models.buildings.defaultBuildings;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.resources.specificResources.MedicalSupplies;

import java.util.List;
import java.util.Map;

public final class Hospital extends Building {

    public Hospital(ICityBuilding city) {
        super(city, "hospital", "", "", Map.of(
                new MedicalSupplies(), List.of(new ProduceResourceStrategy())
        ));
    }
}
