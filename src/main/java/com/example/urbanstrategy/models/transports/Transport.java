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
        transportationStatus = "Waiting...";
    }

    public void unload() {
        resource = null;
    }

    public void load(IResourceTransported resource) {
        this.resource = resource;
    }

    public void moveResources(Building destination, int amount) {
        resource.remove(amount);
        destination.receiveResource(resource.getType(), amount);
    }

    public void updateTransportationStatus(String status) {
        transportationStatus = status;
    }

    public String getName() {
        return name;
    }

    public TransportType getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getTransportationStatus() {
        return transportationStatus;
    }
}
