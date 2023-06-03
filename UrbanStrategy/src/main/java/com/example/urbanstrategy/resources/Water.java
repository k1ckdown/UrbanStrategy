package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public class Water extends Resource {

    public Water(int amount) {
        super(
                amount,
                "water",
                List.of(ProcessingMethodType.CONSUME, ProcessingMethodType.TREATMENT),
                ResourceType.WATER
        );
    }
}
