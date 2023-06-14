package com.example.urbanstrategy.models.factories;


import com.example.urbanstrategy.models.buildings.*;
import com.example.urbanstrategy.models.buildings.custombuilding.CustomBuilding;
import com.example.urbanstrategy.models.buildings.defaultbuildings.*;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingmethods.ResourceProcessingStrategy;
import com.example.urbanstrategy.models.resources.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class BuildingFactory {

    private BuildingFactory() {

    }

    public static BuildingFactory getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final BuildingFactory INSTANCE = new BuildingFactory();
    }

    public Building makeCustomBuilding(
            ICityBuilding city,
            String name,
            Map<Resource, List<ResourceProcessingStrategy>> processingByResource
    ) {
        return new CustomBuilding(
                city,
                name,
                "Custom Building",
                processingByResource
        );
    }

    public List<Building> makeAllDefaultBuildings(ICityBuilding city) {
        List<Building> buildingList = new ArrayList<>();
        BuildingType[] buildingTypes = BuildingType.values();

        for (BuildingType type : buildingTypes) {
            buildingList.add(makeDefaultBuilding(type, city));
        }

        return buildingList;
    }

    private Building makeDefaultBuilding(
            BuildingType buildingType,
            ICityBuilding city
    ) {
        switch (buildingType) {
            case MINE:
                return new Mine(city);
            case FARM:
                return new Farm(city);
            case MALL:
                return new Mall(city);
            case HOUSE:
                return new House(city);
            case SAWMILL:
                return new Sawmill(city);
            case FACTORY:
                return new Factory(city);
            case HOSPITAL:
                return new Hospital(city);
            case RESTAURANT:
                return new Restaurant(city);
            case POWER_PLANT:
                return new PowerPlant(city);
            case WATER_TREATMENT_PLANT:
                return new WaterTreatmentPlant(city);
        }

        return null;
    }

}
