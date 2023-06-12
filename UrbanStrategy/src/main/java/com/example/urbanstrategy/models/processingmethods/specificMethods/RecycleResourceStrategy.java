package com.example.urbanstrategy.models.processingmethods.specificMethods;


import com.example.urbanstrategy.models.processingmethods.ProcessingMethodType;
import com.example.urbanstrategy.models.processingmethods.ResourceProcessingStrategy;
import com.example.urbanstrategy.models.resources.Resource;

public class RecycleResourceStrategy extends ResourceProcessingStrategy {

    public RecycleResourceStrategy() {
        super(ProcessingMethodType.RECYCLE);
    }

    public void process(Resource resource, double processingRate) {
        resource.resetAmount();
    }
}
