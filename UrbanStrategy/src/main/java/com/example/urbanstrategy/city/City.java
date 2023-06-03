package com.example.urbanstrategy.city;

import com.example.urbanstrategy.buildings.Building;
import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.city.interfaces.ICityController;
import com.example.urbanstrategy.factories.BuildingFactory;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediatorImpl;

import java.time.LocalTime;
import java.util.List;

public final class City implements ICityController, ICityBuilding {

    private LocalTime localTime;
    private final List<Building> buildings;

    public City() {
        localTime = LocalTime.of(8, 0, 0);

        this.buildings = BuildingFactory.getInstance().createAllBuildings(this);
    }

    public void startSimulate() {
        for (Building building : buildings) {
            building.simulate();
        }
        while (true) {
            localTime = localTime.plusSeconds(1);
        }
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
