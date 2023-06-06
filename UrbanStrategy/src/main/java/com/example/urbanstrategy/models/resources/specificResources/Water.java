package com.example.urbanstrategy.models.resources.specificResources;


import com.example.urbanstrategy.models.processingMethods.ProcessingMethodType;
import com.example.urbanstrategy.models.resources.Resource;
import com.example.urbanstrategy.models.resources.ResourceType;

import java.util.List;

public final class Water extends Resource {

    public Water() {
        super(
                "water",
                List.of(ProcessingMethodType.CONSUME, ProcessingMethodType.PRODUCE),
                ResourceType.WATER
        );
    }
}
