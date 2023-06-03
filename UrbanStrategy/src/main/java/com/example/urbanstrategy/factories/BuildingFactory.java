package com.example.urbanstrategy.factories;


import com.example.urbanstrategy.buildings.*;
import com.example.urbanstrategy.city.City;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediatorImpl;

import java.util.ArrayList;
import java.util.List;

public class BuildingFactory {

    private BuildingFactory() {}

    public static BuildingFactory getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final BuildingFactory INSTANCE = new BuildingFactory();
    }

//    public Building createCustomBuilding(
//            City city,
//            String buildingName,
//            LogisticMediatorImpl logisticMediator,
//            Map<Resource, List<ResourceProcessingStrategy>> processingByResource
//    ) {
//        return new CustomBuildingBuilder("some name", city, processingByResource);
//    }

    public List<Building> createAllBuildings(City city) {
        List<Building> buildingList = new ArrayList<>();
        BuildingType[] buildingTypes = BuildingType.values();
        final LogisticMediatorImpl logisticMediator = new LogisticMediatorImpl();

        for (BuildingType type : buildingTypes) {
            buildingList.add(createDefaultBuilding(type, city, logisticMediator));
        }

        logisticMediator.updateBuildingList(buildingList);
        return buildingList;
    }

    private Building createDefaultBuilding(BuildingType buildingType, City city, LogisticMediatorImpl logisticMediator) {
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
