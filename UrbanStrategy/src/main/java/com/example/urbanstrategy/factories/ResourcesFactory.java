//package com.example.urbanstrategy.factories;
//
//
//import com.example.urbanstrategy.resources.*;
//
//public class ResourcesFactory {
//
//    private ResourcesFactory() {}
//
//    public static ResourcesFactory getInstance() {
//        return Holder.INSTANCE;
//    }
//
//    private final static class Holder {
//        static final ResourcesFactory INSTANCE = new ResourcesFactory();
//    }
//
//    public Resource makeResource(ResourceType type, int amount) {
//        switch (type) {
//            case TREE:
//                return new Tree(amount);
//            case COAL:
//                return new Coal(amount);
//            case WOOD:
//                return new Wood(amount);
//            case FOOD:
//                return new Food(amount);
//            case DISH:
//                return new Dish(amount);
//            case WATER:
//                return new Water(amount);
//            case WASTE:
//                return new Waste(amount);
//            case GRAIN:
//                return new Grain(amount);
//            case FURNITURE:
//                return new Furniture(amount);
//            case ELECTRICITY:
//                return new Electricity(amount) ;
//            case MEDICAL_SUPPLIES:
//                return new MedicalSupplies(amount);
//        }
//        return null;
//    }
//}
