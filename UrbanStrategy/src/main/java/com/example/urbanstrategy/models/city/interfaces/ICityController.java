package com.example.urbanstrategy.models.city.interfaces;

import com.example.urbanstrategy.models.buildings.Building;

public interface ICityController {
    void startSimulate();
    void addBuilding(Building building);
    void removeBuilding(Building building);
}
