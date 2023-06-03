package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public final class Furniture extends Resource {

    public Furniture() {
        super(
                "furniture",
                List.of(ProcessingMethodType.PRODUCE, ProcessingMethodType.CONSUME),
                ResourceType.FURNITURE
        );
    }
}
