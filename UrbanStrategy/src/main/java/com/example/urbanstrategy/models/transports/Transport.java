package com.example.urbanstrategy.models.transports;


import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.resources.interfaces.IResourceTransported;

public abstract class Transport {

    private final String name;
    private final int capacity;
    private IResourceTransported resource;
    private String transportationStatus;

    public Transport(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void moveResources(Building destination, int amount) {
        destination.receiveResource(resource.getType(), amount);
    }

    public void load(IResourceTransported resource) {
        this.resource = resource;
    }

    public void unload() {
        resource = null;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getTransportationStatus() {
        return transportationStatus;
    }
}
