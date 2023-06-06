package com.example.urbanstrategy.models.city;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.city.interfaces.ICityController;
import com.example.urbanstrategy.models.factories.BuildingFactory;

import java.time.LocalTime;
import java.util.List;

public final class City implements ICityController, ICityBuilding {

    private LocalTime localTime;
    private final List<Building> buildings;

    public City() {
        localTime = LocalTime.of(8, 0, 0);

        this.buildings = BuildingFactory.getInstance().makeAllBuildings(this);
    }

    public void startSimulate() {
        for (Building building : buildings) {
            building.simulate();
        }

        Thread simulate = new Thread(() -> {
            while (true) {
                localTime = localTime.plusSeconds(1);
            }
        });

        simulate.start();
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public void removeBuilding(Building building) {
        buildings.remove(building);
    }

}
