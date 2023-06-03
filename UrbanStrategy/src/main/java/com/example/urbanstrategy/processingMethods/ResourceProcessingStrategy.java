package com.example.urbanstrategy.processingMethods;

import com.example.urbanstrategy.resources.Resource;

public abstract class ResourceProcessingStrategy {

    private final ProcessingMethodType type;

    public ResourceProcessingStrategy(ProcessingMethodType type) {
        this.type = type;
    }

    public abstract void process(Resource resource, double processingRate);

    public ProcessingMethodType getType() {
        return type;
    }

    public String getName() {
        return type.name();
    }
}
