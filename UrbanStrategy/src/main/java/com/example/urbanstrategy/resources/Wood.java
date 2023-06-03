package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public class Wood extends Resource {

    public Wood(int amount) {
        super(
                amount,
                "wood",
                List.of(ProcessingMethodType.CONSUME, ProcessingMethodType.PRODUCE, ProcessingMethodType.TREATMENT),
                ResourceType.WOOD
        );
    }
}
