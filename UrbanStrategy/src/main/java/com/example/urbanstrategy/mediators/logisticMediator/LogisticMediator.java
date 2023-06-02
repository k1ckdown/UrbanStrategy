package com.example.urbanstrategy.mediators.logisticMediator;


import com.example.urbanstrategy.buildings.Building;
import com.example.urbanstrategy.resources.ResourceType;

public interface LogisticMediator {
    void transportResources(Building sender, ResourceType resourceType, int amount);
}
