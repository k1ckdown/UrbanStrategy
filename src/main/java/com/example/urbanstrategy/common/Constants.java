package com.example.urbanstrategy.common;

public class Constants {
    public static final int MIN_AMOUNT_RES = 10;
    public static final int MAX_AMOUNT_RES = 500;
    public static final int UPDATE_SLEEP_TIME = 1000;
    public static final int MAX_BUILDING_SLEEP_TIME = 4000;
    public static final int MIN_BUILDING_SLEEP_TIME = 2000;

    public static final double RES_TRANSFER_RATE = 0.2;
    public static final double RES_PROCESS_MAX_RATE = 0.1;
    public static final double RES_PROCESS_MIN_RATE = 0.05;

    public interface TransportCapacity {
        int CAR = 250;
        int LORRY = 500;
        int POWER_LINES = 1000;
        int TRAIN = 700;
        int WATER_SUPPLY = 1000;
    }

    public interface TransportNames {
        String CAR = "Car";
        String LORRY = "Lorry";
        String POWER_LINES = "Power lines";
        String TRAIN = "Train";
        String WATER_SUPPLY = "Water supply";
    }

    public interface ResourceNames {
        String COAL = "Coal";
        String DISH = "Dish";
        String ELECTRICITY = "Electricity";
        String FOOD = "Food";
        String FURNITURE = "Furniture";
        String GRAIN = "Grain";
        String MEDICAMENTS = "Medicaments";
        String TREE = "Tree";
        String WASTE = "Waste";
        String WATER = "Water";
        String WOOD = "Wood";
    }

    public interface BuildingNames {
        String FACTORY = "Factory";
        String FARM = "Farm";
        String HOSPITAL = "Hospital";
        String HOUSE = "House";
        String MALL = "Mall";
        String MINE = "Mine";
        String POWER_PLANT = "Power plant";
        String RESTAURANT = "Restaurant";
        String SAWMILL = "Sawmill";
        String WATER_TREATMENT_PLANT = "Water treatment plant";
    }

    public interface BuildingDescriptions {
        String FACTORY = "A large industrial building where goods are manufactured on a large scale using machinery and assembly lines.";
        String FARM = "A place where crops and livestock are raised for food and other products.";
        String HOSPITAL = "A medical facility where people receive treatment for illnesses and injuries.";
        String HOUSE = "A building designed for people to live in, providing shelter and comfort.";
        String MALL = "A large building with many stores and businesses, offering a variety of goods and services.";
        String MINE = "A place where valuable minerals and ores are extracted from the earth.";
        String POWER_PLANT = "A facility that generates electricity for homes, businesses, and other buildings.";
        String RESTAURANT = "A place where food and drinks are served to customers, often with a specific cuisine or theme.";
        String SAWMILL = "A facility where logs are processed into lumber and other wood products.";
        String WATER_TREATMENT_PLANT = "A facility that cleans and purifies water for consumption and other uses.";
        String CUSTOM_BUILDING = "Custom Building";
    }
}
