package com.example.urbanstrategy.models.buildings;

import com.example.urbanstrategy.models.city.interfaces.ICityBuilding;
import com.example.urbanstrategy.models.processingmethods.ProcessingMethodType;
import com.example.urbanstrategy.models.processingmethods.ResourceProcessingStrategy;
import com.example.urbanstrategy.models.resources.Resource;
import com.example.urbanstrategy.models.resources.ResourceType;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Building {
    private final String name;
    private final String description;
    private String infoAboutResources;
    private String infoAboutProcessing;

    private final ICityBuilding city;
    private final Random randomGenerator;
    private final Map<Resource, List<LocalTime>> scheduleSending;
    private final Map<Resource, List<ResourceProcessingStrategy>> processingByResource;

    public Building(
            ICityBuilding city,
            String name,
            String description,
            Map<Resource, List<ResourceProcessingStrategy>> processingByResource
    ) {
        this.city = city;
        this.name = name;
        this.description = description;
        this.processingByResource = processingByResource;
        scheduleSending = new HashMap<>();
        randomGenerator = new Random();
        generateResourceSendingSchedule();
    }

    public void simulate() {
        Thread simulate = new Thread(() -> {
            while (true) {
                try {
                    processResources();
                    sendResourcesIfTime();
                    Thread.sleep(randomGenerator.nextInt(4000 - 2000 + 1) + 2000);
                } catch (Exception error) {
                    throw new RuntimeException(error);
                }
            }
        });

        simulate.start();
    }

    public void receiveResource(ResourceType resourceType, int amount) {
        Optional<Resource> sentResource = processingByResource.keySet()
                .stream()
                .filter(resource -> resource.getType() == resourceType).findFirst();
        sentResource.ifPresent(resource -> resource.put(amount));
    }

    public boolean needsResource(ResourceType resourceType) {
        for (Resource resource : processingByResource.keySet()) {
            if (resource.getType() == resourceType) {
                return processingByResource.get(resource)
                        .stream()
                        .anyMatch(method -> method.getType() == ProcessingMethodType.CONSUME
                                || method.getType() == ProcessingMethodType.TREATMENT
                                || method.getType() == ProcessingMethodType.RECYCLE);
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getInfoAboutProcessing() {
        return infoAboutProcessing;
    }

    public String getInfoAboutResources() {
        updateInfoAboutResources();
        return infoAboutResources;
    }

    private LocalTime getRandomTime() {
        int hour = ThreadLocalRandom.current().nextInt(24);
        return LocalTime.of(hour, 0, 0);
    }

    private void updateInfoAboutResources() {
        StringBuilder info = new StringBuilder();

        for (Resource resource : processingByResource.keySet()) {
            info.append(String.format("%s: %d\n", resource.getName(), resource.getAmount()));
        }

        infoAboutResources = info.toString();
    }

    private void sendResourcesIfTime() {
        for (Resource resource : scheduleSending.keySet()) {
            if (scheduleSending.get(resource)
                    .stream()
                    .anyMatch(time -> time.getHour() == city.getLocalTime().getHour())) {
                double rate = 0.2;
                city.transferResources(this, resource, rate);
            }
        }
    }

    private void processResources() {
        StringBuilder info = new StringBuilder();

        for (Resource resource : processingByResource.keySet()) {
            for (ResourceProcessingStrategy resourceProcessing : processingByResource.get(resource)) {
                final double rate = 0.05 + (0.1 * randomGenerator.nextDouble());
                final int oldAmount = resource.getAmount();
                resourceProcessing.process(resource, rate);

                info.append(String.format(
                        "%s - %s (%d)\n",
                        resourceProcessing.getName(),
                        resource.getName(),
                        (int) (oldAmount * rate)
                ));
            }
        }

        infoAboutProcessing = info.toString();
    }

    private void generateResourceSendingSchedule() {
        for (Resource resource : processingByResource.keySet()) {
            if (processingByResource.get(resource).stream().anyMatch(method ->
                    method.getType() == ProcessingMethodType.PRODUCE
            )) {

                scheduleSending.put(resource, new ArrayList<>());

                for (int i = 0; i < 5; i++) {
                    scheduleSending.get(resource).add(getRandomTime());
                }

            }
        }
    }
}
