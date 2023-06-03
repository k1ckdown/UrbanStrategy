package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public class Furniture extends Resource {

    public Furniture(int amount) {
        super(
                amount,
                "furniture",
                List.of(ProcessingMethodType.PRODUCE, ProcessingMethodType.CONSUME),
                ResourceType.FURNITURE
        );
    }
}
