package com.example.urbanstrategy.processingMethods;


import com.example.urbanstrategy.resources.Resource;

public class ConsumeResourceStrategy extends ResourceProcessingStrategy  {

    public ConsumeResourceStrategy() {
        super(ProcessingMethodType.CONSUME);
    }

    public void process(Resource resource) {
        resource.decreaseAmount();
    }
}
