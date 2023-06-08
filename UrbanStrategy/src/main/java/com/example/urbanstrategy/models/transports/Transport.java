package com.example.urbanstrategy.models.transports;


import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.resources.interfaces.IResourceTransported;

public abstract class Transport {

    private final String name;
    private final int capacity;
    private final TransportType type;
    private String transportationStatus;
    private IResourceTransported resource;

    public Transport(String name, int capacity, TransportType type) {
        this.name = name;
        this.capacity = capacity;
        this.type = type;
    }

    public void moveResources(Building destination, int amount) {
        resource.remove(amount);
        destination.receiveResource(resource.getType(), amount);
    }

    public void load(IResourceTransported resource) {
        this.resource = resource;
    }

    public void unload() {
        resource = null;
    }

    public void updateTransportationStatus(String status) {
        transportationStatus = status;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public TransportType getType() {
        return type;
    }

    public String getTransportationStatus() {
        return transportationStatus;
    }
}
