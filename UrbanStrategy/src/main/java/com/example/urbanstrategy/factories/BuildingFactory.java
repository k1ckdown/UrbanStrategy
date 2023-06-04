package com.example.urbanstrategy.factories;


import com.example.urbanstrategy.buildings.*;
import com.example.urbanstrategy.buildings.customBuilding.CustomBuilding;
import com.example.urbanstrategy.buildings.defaultBuildings.*;
import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediatorImpl;
import com.example.urbanstrategy.processingMethods.ResourceProcessingStrategy;
import com.example.urbanstrategy.resources.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class BuildingFactory {

    private final LogisticMediatorImpl logisticMediator;

    private BuildingFactory() {
        logisticMediator = new LogisticMediatorImpl();
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
                "imagePath",
                "desc",
                logisticMediator,
                processingByResource
        );
    }

    public List<Building> makeAllBuildings(ICityBuilding city) {
        List<Building> buildingList = new ArrayList<>();
        BuildingType[] buildingTypes = BuildingType.values();

        for (BuildingType type : buildingTypes) {
            buildingList.add(makeDefaultBuilding(type, city));
        }

        logisticMediator.updateBuildingList(buildingList);
        return buildingList;
    }

    private Building makeDefaultBuilding(BuildingType buildingType, ICityBuilding city) {
        switch (buildingType) {
            case MINE:
                return new Mine(city, logisticMediator);
            case FARM:
                return new Farm(city, logisticMediator);
            case MALL:
                return new Mall(city, logisticMediator);
            case HOUSE:
                return new House(city, logisticMediator);
            case SAWMILL:
                return new Sawmill(city, logisticMediator);
            case FACTORY:
                return new Factory(city, logisticMediator);
            case HOSPITAL:
                return new Hospital(city, logisticMediator);
            case RESTAURANT:
                return new Restaurant(city, logisticMediator);
            case POWER_PLANT:
                return new PowerPlant(city, logisticMediator);
            case WATER_TREATMENT_PLANT:
                return new WaterTreatmentPlant(city, logisticMediator);
        }

        return null;
    }

}
