package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;
import com.example.urbanstrategy.resources.interfaces.IResourceTransported;

import java.util.List;

public abstract class Resource implements IResourceTransported {

    private int amount;
    private final String name;

    private final ResourceType type;
    private final List<ProcessingMethodType> supportedMethods;

    public Resource(int amount, String name, List<ProcessingMethodType> supportedMethods, ResourceType type) {
        this.name = name;
        this.amount = amount;
        this.supportedMethods = supportedMethods;
        this.type = type;
    }

    public void put(int value) {
        amount += value;
    }

    public void resetAmount() {
        amount = 0;
    }

    public void decreaseAmount(double rate) {
        amount -= amount * rate;
    }

    public void increaseAmount(double rate) {
        amount += amount * rate;
    }

    public int getAmount() {
        return amount;
    }

    public ResourceType getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
