package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public class Food extends Resource{

    public Food(int amount) {
        super(
                amount,
                "food",
                List.of(ProcessingMethodType.CONSUME, ProcessingMethodType.PRODUCE, ProcessingMethodType.TREATMENT),
                ResourceType.FOOD
        );
    }
}
