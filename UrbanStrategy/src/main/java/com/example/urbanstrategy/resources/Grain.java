package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public class Grain extends Resource {

    public Grain() {
        super(
                "grain",
                List.of(ProcessingMethodType.TREATMENT),
                ResourceType.GRAIN
        );
    }
}
