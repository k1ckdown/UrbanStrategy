package com.example.urbanstrategy.buildings;

import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.processingMethods.ConsumeResourceStrategy;
import com.example.urbanstrategy.processingMethods.ProduceResourceStrategy;
import com.example.urbanstrategy.processingMethods.ResourceProcessingStrategy;
import com.example.urbanstrategy.processingMethods.TreatmentResourceStrategy;
import com.example.urbanstrategy.resources.Resource;
import com.example.urbanstrategy.resources.ResourceType;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Building {
    private final String name;
    private final String imagePath;
    private final String description;

    private final ICityBuilding city;
    private final Random randomGenerator;
    private final LogisticMediator logisticMediator;
    private final Map<Resource, List<LocalTime>> scheduleSending;
    private final Map<Resource, List<ResourceProcessingStrategy>> processingByResource;

    public Building(
            ICityBuilding city,
            String name,
            String imagePath,
            String description,
            LogisticMediator logisticMediator,
            Map<Resource, List<ResourceProcessingStrategy>> processingByResource
    ) {
        this.city = city;
        this.name = name;
        this.imagePath = imagePath;
        this.description = description;
        this.logisticMediator = logisticMediator;
        this.processingByResource = processingByResource;
        scheduleSending = new HashMap<>();
        randomGenerator = new Random();
        generateResourceSendingSchedule();
    }

    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void simulate() {
        Thread simulate = new Thread(() -> {
            while (true) {
                try {
                    processResources();
                    sendResourcesIfTime();
                    Thread.sleep(getRandomNumber(3000, 6000));
                } catch (Exception error) {
                    throw new RuntimeException(error);
                }
            }
        });

        simulate.start();
    }

    private LocalTime getRandomTime() {
        int hour = ThreadLocalRandom.current().nextInt(24);
        return LocalTime.of(hour, 0, 0);
    }

    private int getRandomNumber(int start, int end) {
        return randomGenerator.nextInt(end - start + 1) + start;
    }

    public boolean needsResource(ResourceType resourceType) {
        for (Resource resource : processingByResource.keySet()) {
            if (resource.getType() == resourceType) {
                return processingByResource.get(resource)
                        .stream()
                        .anyMatch(process -> process instanceof ConsumeResourceStrategy
                                || process instanceof TreatmentResourceStrategy);
            }
        }
        return false;
    }

    public void receiveResource(ResourceType resourceType, int amount) {
        Optional<Resource> sentResource = processingByResource.keySet()
                .stream()
                .filter(resource -> resource.getType() == resourceType).findFirst();
        sentResource.ifPresent(resource -> resource.put(amount));
    }

    private void sendResourcesIfTime() {
        for (Resource resource : scheduleSending.keySet()) {
            if (scheduleSending.get(resource)
                    .stream()
                    .anyMatch(time -> time.getHour() == city.getLocalTime().getHour())) {
                double rate = 0.2;
                logisticMediator.transportResources(this, resource, rate);
            }
        }
    }

    private void processResources() {
        for (Resource resource : processingByResource.keySet()) {
            for (ResourceProcessingStrategy resourceProcessing : processingByResource.get(resource)) {
                resourceProcessing.process(resource);
                System.out.printf("Processed the %s resource from the %s building\n", resource.getName(), name);
            }
        }
        System.out.println();
    }


    private void generateResourceSendingSchedule() {
        for (Resource resource : processingByResource.keySet()) {
            if (processingByResource.get(resource).stream().anyMatch(process ->
                    process instanceof ProduceResourceStrategy
            )) {

                scheduleSending.put(resource, new ArrayList<>());

                for (int i = 0; i < 5; i++) {
                    scheduleSending.get(resource).add(getRandomTime());
                }

            }
        }
    }
}
