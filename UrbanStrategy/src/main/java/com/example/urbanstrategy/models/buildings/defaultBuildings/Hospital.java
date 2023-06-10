package com.example.urbanstrategy.models.buildings.defaultBuildings;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingMethods.specificMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.resources.specificResources.Electricity;
import com.example.urbanstrategy.models.resources.specificResources.Medicaments;
import com.example.urbanstrategy.models.resources.specificResources.Water;

import java.util.List;
import java.util.Map;

public final class Hospital extends Building {

    public Hospital(ICityBuilding city) {
        super(
                city,
                "hospital",
                "A medical facility where people receive treatment for illnesses and injuries.",
                Map.of(
                new Medicaments(), List.of(new ProduceResourceStrategy()),
                new Electricity(), List.of(new ConsumeResourceStrategy()),
                new Water(), List.of(new ConsumeResourceStrategy()))
        );
    }
}
