package com.example.urbanstrategy.processingMethods;

import com.example.urbanstrategy.resources.Resource;

import java.util.Random;

public abstract class ResourceProcessingStrategy {

    private final ProcessingMethodType type;
    protected final double processingRate;

    public ResourceProcessingStrategy(ProcessingMethodType type) {
        this.type = type;
        this.processingRate = new Random().nextDouble();
    }

    public abstract void process(Resource resource);

    public ProcessingMethodType getType() {
        return type;
    }
}
