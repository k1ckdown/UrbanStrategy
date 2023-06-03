package com.example.urbanstrategy.processingMethods;


import com.example.urbanstrategy.resources.Resource;

public class TreatmentResourceStrategy extends ResourceProcessingStrategy {

    public TreatmentResourceStrategy() {
        super(ProcessingMethodType.TREATMENT);
    }

    public void process(Resource resource, double processingRate) {
        resource.decreaseAmount(processingRate);
    }
}
