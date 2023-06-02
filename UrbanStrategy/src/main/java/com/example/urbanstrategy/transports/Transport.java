package com.example.urbanstrategy.transports;


import com.example.urbanstrategy.buildings.Building;
import com.example.urbanstrategy.resources.ResourceType;

public abstract class Transport {
    private final String name;
    private final int capacity;
    private ResourceType resource;

    public Transport(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void moveResources(ResourceType resource, Building destination, int amount) {
        destination.receiveResource(resource, amount);
    }

    public void load(ResourceType resourceType) {
        this.resource = resourceType;
    }

    public void unload() {
        resource = null;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }
}
