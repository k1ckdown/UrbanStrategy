package com.example.urbanstrategy.models.processingmethods.specificmethods;

import com.example.urbanstrategy.models.processingmethods.ProcessingMethodType;
import com.example.urbanstrategy.models.processingmethods.ResourceProcessingStrategy;
import com.example.urbanstrategy.models.resources.Resource;

public class DestroyResourceStrategy extends ResourceProcessingStrategy {

    public DestroyResourceStrategy() {
        super(ProcessingMethodType.DESTROY);
    }

    public void process(Resource resource, double processingRate) {
        resource.increaseAmount(processingRate);
    }
}
