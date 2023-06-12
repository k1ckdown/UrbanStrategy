package com.example.urbanstrategy.models.dtos;

import com.example.urbanstrategy.models.buildings.Building;
import com.example.urbanstrategy.models.resources.Resource;

public final class ResourceTransferDTO {

    private final double rate;
    private final Building sender;
    private final Resource resource;

    public ResourceTransferDTO(Building sender, Resource resource, double rate) {
        this.sender = sender;
        this.resource = resource;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public Building getSender() {
        return sender;
    }

    public Resource getResource() {
        return resource;
    }
}
