package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public class Grain extends Resource {

    public Grain(int amount) {
        super(
                amount,
                "grain",
                List.of(ProcessingMethodType.PRODUCE, ProcessingMethodType.CONSUME),
                ResourceType.GRAIN
        );
    }
}
