package com.example.urbanstrategy.resources;


import com.example.urbanstrategy.processingMethods.ProcessingMethodType;

import java.util.List;

public class Coal extends Resource {

    public Coal(int amount) {
        super(
                amount,
                "coal",
                List.of(ProcessingMethodType.CONSUME, ProcessingMethodType.PRODUCE),
                ResourceType.COAL
        );
    }
}
