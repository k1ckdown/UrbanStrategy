package com.example.urbanstrategy.models.resources.specificResources;


import com.example.urbanstrategy.models.processingMethods.ProcessingMethodType;
import com.example.urbanstrategy.models.resources.Resource;
import com.example.urbanstrategy.models.resources.ResourceType;

import java.util.List;

public final class Food extends Resource {

    public Food() {
        super(
                "Food",
                List.of(ProcessingMethodType.CONSUME, ProcessingMethodType.PRODUCE, ProcessingMethodType.TREATMENT),
                ResourceType.FOOD
        );
    }
}
