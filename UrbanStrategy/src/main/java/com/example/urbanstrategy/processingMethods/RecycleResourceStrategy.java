package com.example.urbanstrategy.processingMethods;


import com.example.urbanstrategy.resources.Resource;

public class RecycleResourceStrategy extends ResourceProcessingStrategy {

    public RecycleResourceStrategy() {
        super(ProcessingMethodType.RECYCLE);
    }

    public void process(Resource resource, double processingRate) {
        resource.decreaseAmount(processingRate);
    }
}
