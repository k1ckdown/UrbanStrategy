package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public class Waste extends Resource {

    public Waste() {
        super(
                "waste",
                List.of(ProcessingMethodType.PRODUCE, ProcessingMethodType.RECYCLE, ProcessingMethodType.CONSUME),
                ResourceType.WASTE
        );
    }
}
