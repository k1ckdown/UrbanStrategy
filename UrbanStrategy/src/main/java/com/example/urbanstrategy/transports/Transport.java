package com.example.urbanstrategy.transports;


import com.example.urbanstrategy.buildings.Building;
import com.example.urbanstrategy.resources.interfaces.IResourceTransported;

public abstract class Transport {
    private final String name;
    private final int capacity;
    private IResourceTransported resource;

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

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }
}
