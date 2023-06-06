package com.example.urbanstrategy.models.factories;


import com.example.urbanstrategy.models.resources.*;
import com.example.urbanstrategy.models.resources.specificResources.*;

public final class ResourcesFactory {

    private ResourcesFactory() {}

    public static ResourcesFactory getInstance() {
        return Holder.INSTANCE;
    }

    private final static class Holder {
        static final ResourcesFactory INSTANCE = new ResourcesFactory();
    }

    public Resource makeResource(ResourceType type) {
        switch (type) {
            case TREE:
                return new Tree();
            case COAL:
                return new Coal();
            case WOOD:
                return new Wood();
            case FOOD:
                return new Food();
            case DISH:
                return new Dish();
            case WATER:
                return new Water();
            case WASTE:
                return new Waste();
            case GRAIN:
                return new Grain();
            case FURNITURE:
                return new Furniture();
            case ELECTRICITY:
                return new Electricity() ;
            case MEDICAL_SUPPLIES:
                return new MedicalSupplies();
        }
        return null;
    }
}
