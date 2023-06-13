package com.example.urbanstrategy.models.city.interfaces;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.resources.Resource;

import java.time.LocalTime;

public interface ICityBuilding {
    LocalTime getLocalTime();
    void transferResources(Building sender, Resource resource, double rate);
}
