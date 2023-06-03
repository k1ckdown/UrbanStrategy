package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public class Waste extends Resource {

    public Waste(int amount) {
        super(
                amount,
                "waste",
                List.of(ProcessingMethodType.PRODUCE, ProcessingMethodType.RECYCLE),
                ResourceType.WASTE
        );
    }
}
