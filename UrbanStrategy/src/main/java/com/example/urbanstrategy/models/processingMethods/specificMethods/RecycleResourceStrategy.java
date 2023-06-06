package com.example.urbanstrategy.models.processingMethods.specificMethods;


import com.example.urbanstrategy.models.processingMethods.ProcessingMethodType;
import com.example.urbanstrategy.models.processingMethods.ResourceProcessingStrategy;
import com.example.urbanstrategy.models.resources.Resource;

public class RecycleResourceStrategy extends ResourceProcessingStrategy {

    public RecycleResourceStrategy() {
        super(ProcessingMethodType.RECYCLE);
    }

    public void process(Resource resource, double processingRate) {
        resource.decreaseAmount(processingRate);
    }
}
