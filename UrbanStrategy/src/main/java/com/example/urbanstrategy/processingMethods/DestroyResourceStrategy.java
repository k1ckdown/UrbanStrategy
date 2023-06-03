package com.example.urbanstrategy.processingMethods;

import com.example.urbanstrategy.resources.Resource;

public class DestroyResourceStrategy extends ResourceProcessingStrategy {

    public DestroyResourceStrategy() {
        super(ProcessingMethodType.DESTROY);
    }

    public void process(Resource resource, double processingRate) {
        resource.resetAmount();
    }
}
