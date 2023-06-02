package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;
import com.example.urbanstrategy.resources.interfaces.IResourceTransported;

import java.util.List;
import java.util.Random;

public abstract class Resource implements IResourceTransported {

    private int amount;
    private final String name;
    private final double processingRate;

    private final ResourceType type;
    private final List<ProcessingMethodType> supportedMethods;
    public Resource(int amount, String name, List<ProcessingMethodType> supportedMethods, ResourceType type) {
        this.name = name;
        this.amount = amount;
        this.processingRate = new Random().nextDouble();
        this.supportedMethods = supportedMethods;
        this.type = type;
    }

    public void put(int value) {
        amount += value;
    }

    public void remove(int value) {
        amount -= value;
    }

    public void resetAmount() {
        amount = 0;
    }

    public void decreaseAmount() {
        amount -= amount * processingRate;
    }

    public void increaseAmount() {
        amount += amount * processingRate;
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
