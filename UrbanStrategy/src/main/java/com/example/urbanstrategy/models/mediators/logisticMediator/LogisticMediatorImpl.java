package com.example.urbanstrategy.models.mediators.logisticMediator;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.resources.Resource;
import com.example.urbanstrategy.models.resources.ResourceType;
import com.example.urbanstrategy.models.transports.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

public final class LogisticMediatorImpl implements LogisticMediator {

    private final List<Building> buildingList;
    private final List<Transport> transportList;
    private final Random randomGenerator;

    public LogisticMediatorImpl(List<Building> buildingList, List<Transport> transportList) {
        randomGenerator = new Random();
        this.buildingList = buildingList;
        this.transportList = transportList;
    }

    public void transportResources(Building sender, Resource resource, double rate) {
        final Optional<Transport> optTransport = getTransportFor(resource.getType());

        if (optTransport.isPresent()) {
            Transport transport = optTransport.get();
            List<Building> destinations = buildingList.stream()
                    .filter(building -> building.needsResource(resource.getType()))
                    .collect(Collectors.toList());


            if (destinations.size() == 0) {
                return;
            }

            int amount = (int)(resource.getAmount() * rate);
            Building destination = destinations.get(randomGenerator.nextInt(destinations.size()));

            transport.load(resource);
            transport.moveResources(destination, amount);
            transport.unload();

            transport.updateTransportationStatus(String.format(
                    "Moved %s from %s to %s (%d)",
                    resource.getName(),
                    sender.getName(),
                    destination.getName(),
                    amount
            ));

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
                return transportList.stream()
                        .filter(transport -> transport.getType() == TransportType.LORRY)
                        .findFirst();
            case COAL:
            case GRAIN:
                return transportList.stream()
                        .filter(transport -> transport.getType() == TransportType.TRAIN)
                        .findFirst();
            case FOOD:
            case DISH:
                return transportList.stream()
                        .filter(transport -> transport.getType() == TransportType.CAR)
                        .findFirst();
            case WATER:
                return transportList.stream()
                        .filter(transport -> transport.getType() == TransportType.WATER_SUPPLY)
                        .findFirst();
            case ELECTRICITY:
                return transportList.stream()
                        .filter(transport -> transport.getType() == TransportType.POWER_LINES)
                        .findFirst();
        }

        return Optional.empty();
    }

}
