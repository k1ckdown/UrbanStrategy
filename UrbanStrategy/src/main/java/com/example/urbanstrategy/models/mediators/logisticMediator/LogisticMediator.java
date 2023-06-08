package com.example.urbanstrategy.models.mediators.logisticMediator;


import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.resources.Resource;

public interface LogisticMediator {
    void registerBuilding(Building building);
    void transportResources(Building sender, Resource resource, double rate);
}
