package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public final class Wood extends Resource {

    public Wood() {
        super(
                "wood",
                List.of(ProcessingMethodType.CONSUME, ProcessingMethodType.PRODUCE, ProcessingMethodType.TREATMENT),
                ResourceType.WOOD
        );
    }
}
