package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;
import com.example.urbanstrategy.resources.interfaces.IResourceTransported;

import java.util.List;
import java.util.Random;

public abstract class Resource implements IResourceTransported {

    public final List<ProcessingMethodType> supportedMethods;

    private int amount;
    private final String name;

    private final ResourceType type;

    public Resource(String name, List<ProcessingMethodType> supportedMethods, ResourceType type) {
        this.name = name;
        this.amount = new Random().nextInt(5000 - 1000 + 1) + 1000;
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
        amount -= (int)(amount * rate);
    }

    public void increaseAmount(double rate) {
        amount += (int)(amount * rate);
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
