package com.example.urbanstrategy.processingMethods;


import com.example.urbanstrategy.resources.Resource;

public class ProduceResourceStrategy extends ResourceProcessingStrategy {

    public ProduceResourceStrategy() {
        super(ProcessingMethodType.PRODUCE);
    }

    public void process(Resource resource) {
        resource.increaseAmount();
    }
}
