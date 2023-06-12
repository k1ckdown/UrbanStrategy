package com.example.urbanstrategy.models.processingmethods.specificMethods;


import com.example.urbanstrategy.models.processingmethods.ProcessingMethodType;
import com.example.urbanstrategy.models.processingmethods.ResourceProcessingStrategy;
import com.example.urbanstrategy.models.resources.Resource;

public class ConsumeResourceStrategy extends ResourceProcessingStrategy {

    public ConsumeResourceStrategy() {
        super(ProcessingMethodType.CONSUME);
    }

    public void process(Resource resource, double processingRate) {
        resource.decreaseAmount(processingRate);
    }
}
