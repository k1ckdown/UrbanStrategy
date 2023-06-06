package com.example.urbanstrategy.models.processingMethods;

import com.example.urbanstrategy.models.resources.Resource;

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
