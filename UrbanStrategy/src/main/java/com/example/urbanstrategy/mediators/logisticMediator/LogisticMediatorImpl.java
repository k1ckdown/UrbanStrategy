package com.example.urbanstrategy.mediators.logisticMediator;

import com.example.urbanstrategy.buildings.Building;
import com.example.urbanstrategy.factories.TransportFactory;
import com.example.urbanstrategy.resources.Resource;
import com.example.urbanstrategy.resources.ResourceType;
import com.example.urbanstrategy.transports.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public final class LogisticMediatorImpl implements LogisticMediator {

    private List<Building> buildingList;
    private final List<Transport> transportList;
    private final Random randomGenerator;

    public LogisticMediatorImpl() {
        this.transportList = TransportFactory.getInstance().createAllTransport();
        randomGenerator = new Random();
    }

    public void updateBuildingList(List<Building> buildingList) {
        this.buildingList = buildingList;
    }

    public void transportResources(Building sender, Resource resource, double rate) {
        resource.decreaseAmount(rate);
        final Optional<Transport> optTransport = getTransportFor(resource.getType());

        if (optTransport.isPresent()) {
            Transport transport = optTransport.get();
            List<Building> destinations = new ArrayList<>();

            for (Building destination : buildingList) {
                if (destination.needsResource(resource.getType())) {
                    destinations.add(destination);
                }
            }

            if (destinations.size() == 0) {
                return;
            }

            int amount = (int)(resource.getAmount() * rate);
            Building destination = destinations.get(randomGenerator.nextInt(destinations.size()));

            transport.load(resource);
            transport.moveResources(destination, amount);

            System.out.println("=============Transportation=============");
            System.out.printf(
                    "Transport %s moved %s from %s to %s (%d).\n",
                    transport.getName(),
                    resource.getName(),
                    sender.getName(),
                    destination.getName(),
                    amount
            );
            System.out.println("=============Transportation=============\n");
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
