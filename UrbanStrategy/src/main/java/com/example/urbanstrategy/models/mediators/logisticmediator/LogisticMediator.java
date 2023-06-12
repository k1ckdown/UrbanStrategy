package com.example.urbanstrategy.models.mediators.logisticmediator;


import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.resources.Resource;

public interface LogisticMediator {
    void transportResources(Building sender, Resource resource, double rate);
}
