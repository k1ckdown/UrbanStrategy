package com.example.urbanstrategy.models.city.interfaces;

import com.example.urbanstrategy.models.buildings.Building;

import java.util.List;

public interface ICityController {
    void startSimulate();
    void addBuilding(Building building);
    void removeBuilding(Building building);
    List<String> getTransportStatuses();
    List<String> getResourceProcessingStatuses();
    List<String> getDescriptionsResourcesOfBuildings();
}
