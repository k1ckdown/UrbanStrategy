package com.example.urbanstrategy.models.resources.specificresources;


import com.example.urbanstrategy.models.processingmethods.ProcessingMethodType;
import com.example.urbanstrategy.models.resources.Resource;
import com.example.urbanstrategy.models.resources.ResourceType;

import java.util.List;

public final class Coal extends Resource {

    public Coal() {
        super(
                "Coal",
                List.of(ProcessingMethodType.CONSUME, ProcessingMethodType.PRODUCE),
                ResourceType.COAL
        );
    }
}
