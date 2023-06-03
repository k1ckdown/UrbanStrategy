package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public final class Electricity extends Resource {

    public Electricity() {
        super(
                "electricity",
                List.of(ProcessingMethodType.CONSUME, ProcessingMethodType.PRODUCE),
                ResourceType.ELECTRICITY
        );
    }
}
