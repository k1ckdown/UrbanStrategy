package com.example.urbanstrategy.mediators.logisticMediator;

import com.example.urbanstrategy.buildings.Building;
import com.example.urbanstrategy.factories.TransportFactory;
import com.example.urbanstrategy.resources.ResourceType;
import com.example.urbanstrategy.transports.*;

import java.util.List;
import java.util.Optional;

public final class LogisticMediatorImpl implements LogisticMediator {

    private List<Building> buildingList;
    private final List<Transport> transportList;

    public LogisticMediatorImpl() {
        this.transportList = TransportFactory.getInstance().createAllTransport();
    }

    public void updateBuildingList(List<Building> buildingList) {
        this.buildingList = buildingList;
    }

    public void transportResources(Building sender, ResourceType resourceType, int amount) {
        final Optional<Transport> optTransport = getTransportFor(resourceType);

        if (optTransport.isPresent()) {
            Transport transport = optTransport.get();

            for (Building building : buildingList) {
                if (building.needsResource(resourceType)) {
                    transport.load(resourceType);
                    transport.moveResources(resourceType, building, amount);
                }
            }
        }

    }

    private Optional<Transport> getTransportFor(ResourceType resourceType) {
        switch (resourceType) {
            case TREE:
            case WOOD:
            case WASTE:
            case FURNITURE:
            case MEDICAL_SUPPLIES:
                return transportList.stream().filter(transport -> transport instanceof Lorry).findFirst();
            case COAL:
            case GRAIN:
                return transportList.stream().filter(transport -> transport instanceof Train).findFirst();
            case FOOD:
            case DISH:
                return transportList.stream().filter(transport -> transport instanceof Car).findFirst();
            case WATER:
                return transportList.stream().filter(transport -> transport instanceof WaterSupply).findFirst();
            case ELECTRICITY:
                return transportList.stream().filter(transport -> transport instanceof PowerLines).findFirst();
        }

        return Optional.empty();
    }

}
