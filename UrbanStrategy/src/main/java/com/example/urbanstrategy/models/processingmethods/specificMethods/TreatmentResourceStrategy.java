package com.example.urbanstrategy.models.processingmethods.specificMethods;


import com.example.urbanstrategy.models.processingmethods.ProcessingMethodType;
import com.example.urbanstrategy.models.processingmethods.ResourceProcessingStrategy;
import com.example.urbanstrategy.models.resources.Resource;

public class TreatmentResourceStrategy extends ResourceProcessingStrategy {

    public TreatmentResourceStrategy() {
        super(ProcessingMethodType.TREATMENT);
    }

    public void process(Resource resource, double processingRate) {
        resource.decreaseAmount(processingRate);
    }
}
