package com.example.urbanstrategy.city.interfaces;

import com.example.urbanstrategy.buildings.Building;

public interface ICityController {
    void startSimulate();
    void addBuilding(Building building);
    void removeBuilding(Building building);
}
