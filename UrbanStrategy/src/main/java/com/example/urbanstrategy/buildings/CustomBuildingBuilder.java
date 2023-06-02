package com.example.urbanstrategy.buildings;//package buildings;
//
//import city.ICityBuilding;
//import factories.ResourcesFactory;
//import resources.Resource;
//import resources.ResourceType;
//import strategy.ProcessingMethodType;
//import strategy.ResourceProcessingStrategy;
//
//import java.util.List;
//import java.util.Map;
//
//public class CustomBuildingBuilder {
//
//    private String name;
//    private Map<Resource, List<ResourceProcessingStrategy>> processingByResource;
//
//    public CustomBuildingBuilder() {
//
//    }
//
//    public void addNameBuilding(String name) {
//        this.name = name;
//    }
//
//    public void addResource(ResourceType type, int amount) {
//        processingByResource.put(ResourcesFactory.getInstance().makeResource(type, amount), List.of());
//    }
//
//    public void addResourceProcessingMethod(ProcessingMethodType type, ResourceType forResource) {
//        processingByResource.get()
//    }
//}
