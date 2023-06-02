package com.example.urbanstrategy.buildings;

import com.example.urbanstrategy.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.mediators.logisticMediator.LogisticMediator;
import com.example.urbanstrategy.processingMethods.ConsumeResourceStrategy;
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
    private final LogisticMediator logisticMediator;
    private Map<Resource, List<LocalTime>> scheduleSending;
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

    private int getRandomNumber(int start, int end) {
        Random rd = new Random();
        return rd.nextInt(end - start + 1) + start;
    }

    public void simulate() {
        Thread simulate = new Thread(() -> {
            while (true) {
                try {
                    processResources();
                    Thread.sleep(getRandomNumber(3000, 6000));
                } catch (Exception error) {
                    throw new RuntimeException(error);
                }
            }
        });

        simulate.start();
    }

    public boolean needsResource(ResourceType resourceType) {
        for (Resource resource : processingByResource.keySet()) {
            if (resource.getType() == resourceType) {
                return processingByResource.get(resource).stream().anyMatch(process -> process instanceof ConsumeResourceStrategy);
            }
        }
        return false;
    }

    public void receiveResource(ResourceType resourceType, int amount) {
        Optional<Resource> sentResource = processingByResource.keySet().stream().filter(resource -> resource.getType() == resourceType).findFirst();
        sentResource.ifPresent(resource -> resource.put(amount));
    }

    private void sendResourcesIfTime() {
        for (Resource resource : scheduleSending.keySet()) {
            if (scheduleSending.get(resource).contains(city.getLocalTime())) {
                int amount = 10;
                resource.remove(amount);
                logisticMediator.transportResources(this, resource.getType(), amount);
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

    private LocalTime getRandomTime() {
        int hour = ThreadLocalRandom.current().nextInt(24);
        int minute = ThreadLocalRandom.current().nextInt(60);
        int second = ThreadLocalRandom.current().nextInt(60);
        return LocalTime.of(hour, minute, second);
    }

    private void generateResourceSendingSchedule() {
        for (Resource resource : processingByResource.keySet()) {
            if (processingByResource.get(resource).stream().anyMatch(process ->
                    process instanceof ConsumeResourceStrategy || process instanceof TreatmentResourceStrategy
            )) {

                if (!scheduleSending.containsKey(resource)) {
                    scheduleSending.put(resource, new ArrayList<>());
                }

                for (int i = 0; i < 3; i++) {
                    scheduleSending.get(resource).add(getRandomTime());
                }
            }
        }
    }
}
