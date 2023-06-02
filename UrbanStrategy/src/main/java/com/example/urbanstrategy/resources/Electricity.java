package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public class Electricity extends Resource {

    public Electricity(int amount) {
        super(
                amount,
                "electricity",
                List.of(ProcessingMethodType.CONSUME, ProcessingMethodType.PRODUCE),
                ResourceType.ELECTRICITY
        );
    }
}
