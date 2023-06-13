package com.example.urbanstrategy.models.buildings.defaultbuildings;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.models.processingmethods.specificmethods.ProduceResourceStrategy;
import com.example.urbanstrategy.models.resources.specificresources.Electricity;
import com.example.urbanstrategy.models.resources.specificresources.Medicaments;
import com.example.urbanstrategy.models.resources.specificresources.Water;

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
