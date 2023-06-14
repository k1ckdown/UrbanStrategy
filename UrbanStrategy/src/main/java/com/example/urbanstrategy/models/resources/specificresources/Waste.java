package com.example.urbanstrategy.models.resources.specificresources;


import com.example.urbanstrategy.models.processingmethods.ProcessingMethodType;
import com.example.urbanstrategy.models.resources.Resource;
import com.example.urbanstrategy.models.resources.ResourceType;

import java.util.List;

public final class Waste extends Resource {

    public Waste() {
        super(
                "Waste",
                List.of(ProcessingMethodType.PRODUCE, ProcessingMethodType.RECYCLE, ProcessingMethodType.CONSUME),
                ResourceType.WASTE
        );
    }
}
