package com.example.urbanstrategy.models.resources.specificresources;


import com.example.urbanstrategy.models.processingmethods.ProcessingMethodType;
import com.example.urbanstrategy.models.resources.Resource;
import com.example.urbanstrategy.models.resources.ResourceType;

import java.util.List;

public final class Grain extends Resource {

    public Grain() {
        super(
                "Grain",
                List.of(ProcessingMethodType.TREATMENT),
                ResourceType.GRAIN
        );
    }
}
