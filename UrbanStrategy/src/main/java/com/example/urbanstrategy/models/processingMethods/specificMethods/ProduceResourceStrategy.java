package com.example.urbanstrategy.models.processingMethods.specificMethods;


import com.example.urbanstrategy.models.processingMethods.ProcessingMethodType;
import com.example.urbanstrategy.models.processingMethods.ResourceProcessingStrategy;
import com.example.urbanstrategy.models.resources.Resource;

public class ProduceResourceStrategy extends ResourceProcessingStrategy {

    public ProduceResourceStrategy() {
        super(ProcessingMethodType.PRODUCE);
    }

    public void process(Resource resource, double processingRate) {
        resource.increaseAmount(processingRate);
    }
}
