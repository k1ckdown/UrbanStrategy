package com.example.urbanstrategy.mediators.logisticMediator;


import com.example.urbanstrategy.buildings.Building;
import com.example.urbanstrategy.resources.Resource;

public interface LogisticMediator {
    void transportResources(Building sender, Resource resource, double rate);
}
