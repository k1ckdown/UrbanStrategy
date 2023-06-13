package com.example.urbanstrategy.models.city;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.city.interfaces.ICityController;
import com.example.urbanstrategy.models.dtos.ResourceTransferDTO;
import com.example.urbanstrategy.models.factories.BuildingFactory;
import com.example.urbanstrategy.models.factories.TransportFactory;
import com.example.urbanstrategy.models.mediators.logisticmediator.LogisticMediator;
import com.example.urbanstrategy.models.mediators.logisticmediator.LogisticMediatorImpl;
import com.example.urbanstrategy.models.resources.Resource;
import com.example.urbanstrategy.models.transports.Transport;

import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public final class City implements ICityController, ICityBuilding {

    private LocalTime localTime;
    private final List<Building> buildings;
    private final List<Transport> transports;
    private final LogisticMediator logisticMediator;
    private final ConcurrentLinkedQueue<ResourceTransferDTO> transferQueue;

    public City() {
        localTime = LocalTime.of(8, 0, 0);

        transferQueue = new ConcurrentLinkedQueue<>();
        this.buildings = BuildingFactory.getInstance().makeAllDefaultBuildings(this);
        this.transports = TransportFactory.getInstance().makeAllTransports();
        this.logisticMediator = new LogisticMediatorImpl(buildings, transports);
    }

    public void startSimulate() {
        for (Building building : buildings) {
            building.simulate();
        }

        Thread simulate = new Thread(() -> {
            while (true) {
                localTime = localTime.plusSeconds(1);
                processResourceTransfers();
            }
        });

        simulate.start();
    }

    public void addBuilding(Building building) {
        buildings.add(building);
        building.simulate();
    }

    public void transferResources(Building sender, Resource resource, double rate) {
        final ResourceTransferDTO transfer = new ResourceTransferDTO(sender, resource, rate);
        transferQueue.add(transfer);
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public List<String> getNamesTransports() {
        return transports.stream()
                .map(Transport::getName)
                .collect(Collectors.toList());
    }

    public List<String> getNamesBuildings() {
        return buildings.stream()
                .map(Building::getName)
                .collect(Collectors.toList());
    }

    public List<String> getDescriptionsBuilding() {
        return buildings.stream()
                .map(Building::getDescription)
                .collect(Collectors.toList());
    }

    public List<String> getTransportStatuses() {
        return transports.stream()
                .map(Transport::getTransportationStatus)
                .collect(Collectors.toList());
    }

    public List<String> getResourceProcessingStatuses() {
        return buildings.stream()
                .map(Building::getInfoAboutProcessing)
                .collect(Collectors.toList());
    }

    public List<String> getDescriptionsResourcesOfBuildings() {
        return buildings.stream()
                .map(Building::getInfoAboutResources)
                .collect(Collectors.toList());
    }

    private void processResourceTransfers() {
        ResourceTransferDTO transfer;
        while ((transfer = transferQueue.poll()) != null) {
            logisticMediator.transportResources(
                    transfer.getSender(),
                    transfer.getResource(),
                    transfer.getRate()
            );
        }
    }

}
